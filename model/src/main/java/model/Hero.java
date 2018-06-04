package model;

import java.awt.Image;

import contract.*;

/**
@author Tristan FOCA
@version 06/04/2018
*/

public class Hero extends Entitie implements IHero{

	private boolean stateSpell;
	private Image[] sprite;
	private StateHero stateHero;
	
	/**
	 Initialized all characteristics of my hero 
	 @param image the image of hero
	 */
	public Hero(Image image) {
		super(image);
		stateHero = StateHero.LEFT;
		stateSpell = true;
	}
	/**
	 Method set sprite of the Hero
	 @param s It's a table for Image
	 */
	public void setSprite(Image[] s){
		sprite = s;
	}
	/**
	 Get the state of the spell during the game useful or useless
	 @return stateSpell the state of the spell
	 */
	public boolean isStateSpell() {
		return stateSpell;
	}
	/**
	 Set the state of the spell during the game useful or useless
	 @param stateSpell it's the new state of the spell
	 */
	public void setStateSpell(boolean stateSpell) {
		this.stateSpell = stateSpell;
	}
	/**
	 Method set the state of the Hero
	 @param stateHero It's a StateHero
	 */
	public void setState(StateHero stateHero){
		this.stateHero = stateHero;
	}
	/**
	 Method return the image with the position
	 @return Return a image of sprite
	 */
	public Image getImage(){
		return sprite[stateHero.ordinal()];
	}
	/**
	 Method set an image for this hero
	 @param image It's a image
	 */
	public void setImage(Image image){
		this.image = image;
	}
	/**
	 * @see contract.IHero#setStateImage(contract.StateHero)
	 */
	public void setStateImage(StateHero s){
		setState(s);
		setImage(getImage());
	}
	/**
	 * @see contract.IHero#getState()
	 */
	public StateHero getState() {
		return stateHero;
	}

}
