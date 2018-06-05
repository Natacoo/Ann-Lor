package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import javax.imageio.ImageIO;

import contract.GraphUtil;
import contract.IElement;
import contract.IEntitie;
import contract.IMap;
import contract.IModel;
import contract.StateGame;
import contract.StateHero;
import contract.TypeElement;
import contract.TypeEntitie;
import model.bdd.BDD;
import model.manager.image.ManagerImage;

/**
@author Tristan FOCA
@version 06/04/2018
*/

public class Game extends Observable implements IModel{
	
	private int idActual;
	private ArrayList<IMap> maps;
	private ManagerImage managerImage;
	private BDD bdd;
	private StateGame State;
	private Image[] spell;
	private Image background;
	private int coordinateXBackground, coordinateYBackground, directionBackground;
//	private Sound sound, effect;
	/**
	 Initialize the object of Game class
	 * @param string It's a path
	 */
	public Game(){
		idActual = 0;
		maps = new ArrayList<IMap>();
		bdd = new BDD();
		managerImage = new ManagerImage(bdd);
		this.State = StateGame.MENU;
		initMap();
		Image[] s = {managerImage.getImagesParticules().get("fireball_1"), managerImage.getImagesParticules().get("fireball_2"), managerImage.getImagesParticules().get("fireball_3"), managerImage.getImagesParticules().get("fireball_4"), managerImage.getImagesParticules().get("fireball_5")};
		spell = s;
		try {
			background = ImageIO.read(managerImage.getRessource().get("filtre"));
		} catch (IOException e) {}
		directionBackground = 7;
	}
	
	/**
	 Initialize the multi map and entities for a selection map
	 */
	private void initMap() {
		try {
			ResultSet resultMap = bdd.query("{call selectMapAll()}");
			while(resultMap.next()){
				loadMap(resultMap.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		changed();
	}
	/**
	 * @see contract.IModel#loadMap(int)
	 */
	public void loadMap(int id) {
		try{
			Map map = new Map();
			ResultSet resultMapID = bdd.query("{call getMapID"+id+"()}");
			while(resultMapID.next()){
				int x = resultMapID.getInt("x");
				int y = resultMapID.getInt("y");
				
				if(resultMapID.getString("type").equalsIgnoreCase("WALL")){
					Element e = new Element(managerImage.getImagesElements().get(resultMapID.getInt("id")),x,y);
					e.setPermeability(true);
					e.setTypeElement(TypeElement.WALL);
					e.setPosition(x, y);
					map.setElement(x, y, e);
				}else if(resultMapID.getString("type").equalsIgnoreCase("DOOR")){
					Image[] sprites = {managerImage.getImagesElements().get(4), managerImage.getImagesElements().get(5)};
					Door e = new Door(managerImage.getImagesElements().get(resultMapID.getInt("id")),x,y, sprites);
					e.setPermeability(true);
					e.setTypeElement(TypeElement.DOOR);
					e.setPosition(x, y);
					map.setElement(x, y, e);
				}else if(resultMapID.getString("type").equalsIgnoreCase("KEY")){
					Element e = new Element(managerImage.getImagesElements().get(resultMapID.getInt("id")),x,y);
					e.setPermeability(false);
					e.setTypeElement(TypeElement.KEY);
					e.setPosition(x, y);
					map.setElement(x, y, e);
				}
			}
		
			ResultSet resultEntitiesID = bdd.query("{call getEntitieID"+id+"()}");
			while(resultEntitiesID.next()){
				int x = resultEntitiesID.getInt("x");
				int y = resultEntitiesID.getInt("y");
				if(resultEntitiesID.getString("type").equalsIgnoreCase("MONSTER")){
					Monster m = new Monster(managerImage.getImagesEntities().get(resultEntitiesID.getString("name")));
					m.setPosition(x, y);
					m.setTytpeEntitie(TypeEntitie.MONSTER);
					m.setSpeed(resultEntitiesID.getInt("vitesse"));
					m.setBonus(500);
					map.addEntite(m);
				} else if(resultEntitiesID.getString("type").equalsIgnoreCase("HERO")){
					Hero h = new Hero(managerImage.getImagesEntities().get(resultEntitiesID.getString("name")));
					h.setPosition(x, y);
					h.setTytpeEntitie(TypeEntitie.HERO); 
					Image[] i = {managerImage.getImagesEntities().get("lorann_u"), managerImage.getImagesEntities().get("lorann_b"), managerImage.getImagesEntities().get("lorann_l"), managerImage.getImagesEntities().get("lorann_r")};
					h.setSprite(i);
					h.setImage(h.getImage());
					h.setStateSpell(true);
					map.setHero(h);
				} else if(resultEntitiesID.getString("type").equalsIgnoreCase("BONUS")){
					Monster m = new Monster(managerImage.getImagesEntities().get(resultEntitiesID.getString("name")));
					m.setPosition(x, y);
					m.setTytpeEntitie(TypeEntitie.BONUS);
					m.setBonus(400);
					map.addEntite(m);
				} 
			}
			if(maps.size() < id){
				maps.add(map);
			}else{
				maps.set(id-1, map);
			}
		}catch(SQLException e){};
	}

	/**
	 Modify this state for notify observers
	 */
	public void changed(){
		setChanged();
		notifyObservers();
	}
	
	/**
	 @see contract.IModel#getMap()
	 */
	public IMap getMap(){
		return maps.get(idActual);
	}
	
	/**
	 @see contract.IModel#getElement(int, int)
	 */
	public IElement getElement(int x, int y) {
		return getMap().getElement(x, y);
	}
	/**
	 * @see contract.IModel#getMenu(java.awt.Graphics)
	 */
	public void getMenu(Graphics graphics){
		graphics.drawImage(background, coordinateXBackground, coordinateYBackground, null);
		graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 45));
		GraphUtil.StringWithBorder(graphics, "LORANN", 550, 70, Color.GREEN);
		graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		GraphUtil.StringWithBorder(graphics, "Max score : "+getMap().getScore(), 1000, 220);
		graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		GraphUtil.StringWithBorder(graphics, "[DOWN] previous level", 70, 180);
		graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 35));
		GraphUtil.StringWithBorder(graphics, "Level : "+getLevel(), 50, 220, Color.PINK);
		graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		GraphUtil.StringWithBorder(graphics, "[UP] next level", 100, 250);
		graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 35));
		GraphUtil.StringWithBorder(graphics, "[enter] Start", 480, 400, Color.CYAN);
		GraphUtil.StringWithBorder(graphics, "[escape] Exit", 480, 450, Color.CYAN);
	}
	/**
	 * @see contract.IModel#getGameOver(java.awt.Graphics)
	 */
	public void getGameOver(Graphics graphics){
		graphics.drawImage(background, coordinateXBackground, coordinateYBackground, null);
		graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 45));
		GraphUtil.StringWithBorder(graphics, "LORANN", 550, 70, Color.GREEN);
		graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 60));
		GraphUtil.StringWithBorder(graphics, "GAME OVER", 480, 200, Color.RED);
		graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 45));
		GraphUtil.StringWithBorder(graphics, "Score : ", 400, 250);
		graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 55));
		GraphUtil.StringWithBorder(graphics, ""+getMap().getScore(), 450, 310);
	}

	/**
	 * @see contract.IModel#addParticule(int, contract.StateHero, contract.IEntitie)
	 */
	public void addParticule(int life, StateHero state, IEntitie hero) {
		getMap().addParticule(new Particule(life, state.ordinal()+1, spell, hero.getX(), hero.getY()));
	}
	/**
	 * @see contract.IModel#getState()
	 */
	public StateGame getState(){
		return State;
	}
	/**
	 * @see contract.IModel#setState(contract.StateGame)
	 */
	public void setState(StateGame State){
		this.State = State;
	}
	/**
	 * @see contract.IModel#getMaps()
	 */
	public ArrayList<IMap> getMaps(){
		return maps;
	}
	/**
	 * @see contract.IModel#getLevel()
	 */
	public int getLevel(){
		return idActual;
	}
	/**
	 * @see contract.IModel#setLevel(int)
	 */
	public void setLevel(int level){
		if(maps.size() <= level){
			level = 0;
		}
		if(level == -1){
			level = maps.size()-1;
		}
		idActual = level;
	}
	/**
	 * @see contract.IModel#getCoordinateXBackground()
	 */
	public int getCoordinateXBackground() {
		return coordinateXBackground;
	}
	/**
	 * @see contract.IModel#getCoordinateYBackground()
	 */
	public int getCoordinateYBackground() {
		return coordinateYBackground;
	}
	/**
	 * @see contract.IModel#getCoordinateYBackground()
	 */

	public void setCoordinateXBackground(int x) {
		coordinateXBackground = x;
		
	}
	/**
	 * @see contract.IModel#getCoordinateYBackground()
	 */

	public void setCoordinateYBackground(int y) {
		coordinateYBackground = y;
		
	}
	/**
	 * @see contract.IModel#setDirectionBackground(int)
	 */
	public void setDirectionBackground(int direction) {
		directionBackground = direction;
	}
	/**
	 * @see contract.IModel#getDirectionBackground()
	 */
	public int getDirectionBackground() {
		return directionBackground;
	}
	/**
	 * @see contract.IModel#playMusic(java.lang.String, boolean)
	 */
/*	public void playMusic(String name, boolean loop) {
		if(sound != null){
			sound.stopMusic();
			sound = null;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {}
		}
		sound = new Sound();
		sound.setLoop(loop);
		sound.load(managerImage.getSound().get(name));
		sound.start();
	}*/
	/**
	 * @see contract.IModel#playEffect(java.lang.String)
	 */
/*	public void playEffect(String name){

		if(effect != null){
			effect.stopMusic();
			effect = null;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {}
		}
		effect = new Sound();
		effect.load(managerImage.getSound().get(name));
		effect.start();
	}*/
}
