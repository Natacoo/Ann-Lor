package model;

import java.util.ArrayList;

import contract.*;

/**
@author Tristan FOCA
@version 06/04/2018
*/

public class Map implements IMap{
	
	private ArrayList<IEntitie> entities;
	private Element[][] elements;
	private ArrayList<IParticule> particules;
	private int score;
	
	private IEntitie hero;
	
	/**
	 Initialized the element and the list of the entities of the particle
	 */
	public Map(){
		entities = new ArrayList<IEntitie>();
		elements = new Element[40][20];
		particules = new ArrayList<IParticule>();
	}
	
	/**
	 Set the element on his position 
	 @param x It's a coordinate x
	 @param y It's a coordinate y
	 @param element It's a element for set in coordinate x and y
	 */
	public void setElement(int x, int y, Element element){
		elements[x][y] = element;
	}
	
	/**
	 @see contract.IMap#getElements()
	 */
	public IElement[][] getElements(){
		return elements;
	}
	
	/**
	 Get an element on his position 
	 @param x It's a coordinate x
	 @param y It's a coordinate y
	 @return The element on the position 
	 */
	public IElement getElement(int x, int y){
		if(x<0) return null;
		if(y<0) return null;
		if(x>=elements.length) return null;
		if(y>=elements[0].length) return null;
		
		return elements[x][y];
	}
	
	/**
	 @see contract.IMap#getEntities()
	 */
	public ArrayList<IEntitie> getEntities(){
		return entities;
	}
	
	/**
	 Get an entitie with her ID
	 @param id It's a id of the entities
	 @return the entities
	 */
	public IEntitie getEntite(int id){
		return entities.get(id);
	}
	
	/**
	 Add an entitie on the list
	 @param entitie It's a new entitie 
	 */
	public void addEntite(Entitie entitie){
		entities.add(entitie);
	}
	
	/**
	 get the Hero 
	 @return the entitie Hero
	 */
	public IEntitie getHero(){
		return hero;
	}
	/**
	 Method for set an Hero on the map
	 @param hero It's a entitie specifically entitie
	 */
	public void setHero(IEntitie hero){
		this.hero = hero;
	}
	/**
	 @see contract.IMap#getParticule()
	 */
	public ArrayList<IParticule> getParticule(){
		return particules;
	}
	/**
	 set a particle on the list
	 @param particule It's a new particule
	 */
	public void addParticule(IParticule particule){
		particules.add(particule);
	}
	/**
	 Get the score of the game
	 @return score the present score
	 */
	public int getScore() {
		return score;
	}
	/**
	 Set the score of the game
	 @param score it's a new score
	 */
	public void setScore(int score) {
		this.score = score;
	}
}
