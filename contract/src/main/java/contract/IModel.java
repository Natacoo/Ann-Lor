package contract;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observer;

public interface IModel {
	public IMap getMap();

	public IElement getElement(int x, int y);

	public void addObserver(Observer observer);

	public void changed();

	public StateGame getState();

	public void setState(StateGame state);

	public void getGameOver(Graphics graphic);

	public void getMenu(Graphics graphic);

	public void addParticule(int life, StateHero state, IEntitie hero);

	public void setLevel(int level);

	public int getLevel();

	public ArrayList<IMap> getMaps();

	public int getCoordinateXBackground();

	public int getCoordinateYBackground();

	public void setCoordinateXBackground(int x);

	public void setCoordinateYBackground(int y);

	public void setDirectionBackground(int direction);

	public int getDirectionBackground();

	public void loadMap(int id);

//	public void playMusic(String name, boolean loop);

//	public void playEffect(String name);

}
