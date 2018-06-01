package controller.mock;

import java.util.ArrayList;

import contract.IElement;
import contract.IEntitie;
import contract.IMap;
import contract.IParticule;

public class MapMock implements IMap {
	ArrayList<IEntitie> e = new ArrayList<IEntitie>();
	IElement[][] ee = new IElement[2][2];
	IEntitie h = new HeroMock();
	ArrayList<IParticule> i = new ArrayList<IParticule>();
	
	public MapMock(){
		e.add(new EntitieMock());
		i.add(new ParticuleMock());
	}
	public ArrayList<IEntitie> getEntities() {
		return e;
	}

	public IElement[][] getElements() {
		return ee;
	}

	public ArrayList<IParticule> getParticule() {
		return i;
	}

	public IEntitie getHero() {
		return h;
	}

	public IElement getElement(int x, int y) {
		if(x<0) return null;
		if(y<0) return null;
		if(x>=ee.length) return null;
		if(y>=ee[0].length) return null;
		return ee[x][y];
	}

	public void addParticule(IParticule particule) {
		
	}

	public void setScore(int score) {
	}

	public int getScore() {
		return 0;
	}

}
