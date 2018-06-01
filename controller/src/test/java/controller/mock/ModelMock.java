package controller.mock;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import contract.*;

public class ModelMock extends Observable implements IModel {
	ArrayList<IMap> mP = new ArrayList<IMap>();
	int index = 0;
	public ModelMock(){
		mP.add(new MapMock());
	}
	public IMap getMap() {
		return mP.get(index);
	}

	public IElement getElement(int x, int y) {
		return getMap().getElement(x, y);
	}

	public void addObserver(Observer observer) {addObserver(observer);}

	public void changed() {}

	public StateGame getState() {
		return StateGame.MAP;
	}

	public void setState(StateGame state) {
	}

	public void getGameOver(Graphics graphic) {
	}

	public void getMenu(Graphics graphic) {
	}

	public void addParticule(int life, StateHero state, IEntitie hero) {
	}

	public void setLevel(int level) {
	}

	public int getLevel() {
		return 0;
	}

	public ArrayList<IMap> getMaps() {
		return mP;
	}

	public int getCoordinateXBackground() {
		return 0;
	}

	public int getCoordinateYBackground() {
		return 0;
	}

	public void setCoordinateXBackground(int x) {
	}

	public void setCoordinateYBackground(int y) {
	}

	public void setDirectionBackground(int direction) {
	}

	public int getDirectionBackground() {
		return 0;
	}

	public void loadMap(int id) {
	}

	public void playMusic(String name, boolean loop) {
	}

	public void playEffect(String name) {
	}

}
