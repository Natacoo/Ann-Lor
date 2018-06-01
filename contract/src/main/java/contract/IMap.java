package contract;

import java.util.ArrayList;

public interface IMap {
	public ArrayList<IEntitie> getEntities();

	public IElement[][] getElements();

	public ArrayList<IParticule> getParticule();

	public IEntitie getHero();

	public IElement getElement(int x, int y);

	public void addParticule(IParticule particule);

	public void setScore(int score);

	public int getScore();

}
