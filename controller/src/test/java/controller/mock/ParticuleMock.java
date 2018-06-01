package controller.mock;

import java.awt.Graphics;

import contract.IParticule;

public class ParticuleMock implements IParticule {

	public void draw(Graphics g) {}

	public int getX() {
		return 1;
	}

	public int getY() {
		return 0;
	}

	public void move() {}

	public boolean isLife() {
		return false;
	}

	public void setDirection(int direction) {
	}

}

