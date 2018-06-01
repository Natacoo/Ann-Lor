package model;

import java.util.ArrayList;

import contract.*;

public class Map implements IMap{
	private ArrayList<IEntitie> entities;
	private Element[][] elements;
	private ArrayList<IParticule> particules;
	private int score;
	
	private IEntitie hero; 
	
	public Map(){
		entities = new ArrayList<IEntitie>();
		elements = new Element[40][20];
		particules = new ArrayList<IParticule>();
	}
	
	public void setElement(int x, int y, Element element){
		elements[x][y] = element;
	}
	
	public IElement[][] getElements(){
		return (IElement[][]) elements;
	}
	
	public IElement getElement(int x, int y){
		if(x<0) return null;
		if(y<0) return null;
		if(x>=elements.length) return null;
		if(y>=elements[0].length) return null;
		
		return (IElement) elements[x][y];
	}
	
	public ArrayList<IEntitie> getEntities(){
		return entities;
	}
	
	public IEntitie getEntite(int id){
		return entities.get(id);
	}
	
	public void addEntite(Entitie entitie){
		entities.add(entitie);
	}
	
	public IEntitie getHero(){
		return hero;
	}
	
	public void setHero(IEntitie hero){
		this.hero = hero;
	}
	
	public ArrayList<IParticule> getParticule(){
		return particules;
	}
	
	public void addParticule(IParticule particule){
		particules.add(particule);
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
}
