package controller.mock;

import java.awt.Graphics;

import contract.IEntitie;
import contract.IHero;
import contract.StateHero;
import contract.TypeEntitie;

public class HeroMock implements IEntitie, IHero {

	public void setStateImage(StateHero state) {
	}

	public StateHero getState() {
		return null;
	}

	public boolean isStateSpell() {
		return false;
	}

	public void setStateSpell(boolean stateSpell) {
	}

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
		return null;
	}

}