package controller.mock;

import java.awt.Graphics;

import contract.IEntitie;
import contract.TypeEntitie;

public class EntitieMock implements IEntitie {

	public void draw(Graphics g) {
		
	}

	public int getX() {
		return 0;
	}

	public int getY() {
		return 0;
	}

	public void setPosition(int x, int y) {
		
	}

	public boolean isMove(long tick) {
		return true;
	}

	public int getBonus() {
		return 0;
	}

	public TypeEntitie getTypeEntitie() {
		return TypeEntitie.MONSTER;
	}

}
