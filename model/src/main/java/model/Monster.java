package model;

import java.awt.Image;

public class Monster extends Entitie {
	public Monster(Image image) {
		super(image);
	}
	
	public int getBonus() {
		return bonus;
	}
	
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
}
