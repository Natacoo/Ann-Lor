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

public class Game extends Observable implements IModel {
	private int idActual;
	private ArrayList<IMap> maps;
	private ManagerImage managerImage;
	private BDD bdd;
	private StateGame State;
	private Image[] spell;
	private Image background;
	private int coordinateXBackground, coordinateYBackground, directionBackground;
	private Sound sound, effect;
	
	public Game() {
		
	}
	
	public void initMap(){
		
	}
	
	public void changed(){
		setChanged();
		notifyObservers();
	}
	
	public IMap getMap(){
		return maps.get(idActual);
	}
	
	public IElement getElement(int x, int y) {
		return getMap().getElement(x, y);
	}
	
	public void getMenu(Graphics graphics) {
		
	}
	
	public void getGameOver(Graphics graphics) {
		
	}
	
	public void addParticule(int life, StateHero state, IEntitie hero) {

	}
	
	public StateGame getState(){
		return State;
	}
	
	public void setState(StateGame State){
		this.State = State;
	}
	
	
	public ArrayList<IMap> getMaps(){
		return maps;
	}
	
	public int getLevel(){
		return idActual;
	}
	
	public void setLevel(int level) {
		
	}
	
	public int getCoordinateXBackground() {
		return coordinateXBackground;

	}
	
	public int getCoordinateYBackground() {
		return coordinateYBackground;

	}
	
	public void setCoordinateXBackground(int x) {
		coordinateXBackground = x;

	}
	
	public void setCoordinateYBackground(int y) {
		coordinateYBackground = y;
		
	}
	
	public void setDirectionBackground(int direction) {
		directionBackground = direction;
	}
	
	public int getDirectionBackground() {
		return directionBackground;
	}
	
	public void playMusic(String name, boolean loop) {

	}

	public void playEffect(String name){

	}
	
}
