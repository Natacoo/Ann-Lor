package model;

import java.awt.Image;

/**
@author Tristan FOCA
@version 06/04/2018
*/

public class Monster extends Entitie{

	/**
	 Initialized all characteristics of my monster
	 @param image the image of Monster
	 */
	public Monster(Image image) {
		super(image);
	}
	/**
	 Get the Bonus 
	 @return Bonus during all the game
	 */
	public int getBonus() {
		return bonus;
	}
	/**
	 Set the Bonus 
	 @param bonus it's the new Bonus
	 */
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

}
