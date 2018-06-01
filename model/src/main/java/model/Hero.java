package model;

import java.awt.Image;

import contract.*;

public class Hero extends Entitie implements IHero{
	private boolean stateSpell;
	private Image[] sprite;
	private StateHero stateHero;
	
	public Hero(Image image) {
		super(image);
		stateHero = StateHero.LEFT;
		stateSpell = true;
	}
	
	public void setSprite(Image[] s){
		sprite = s;
	}
	
	public boolean isStateSpell() {
		return stateSpell;
	}
	
	public void setStateSpell(boolean stateSpell) {
		this.stateSpell = stateSpell;
	}
	
	public void setState(StateHero stateHero){
		this.stateHero = stateHero;
	}
	
	public Image getImage(){
		return sprite[stateHero.ordinal()];
	}
	
	public void setImage(Image image){
		this.image = image;
	}
	
	public void setStateImage(StateHero s){
		setState(s);
		setImage(getImage());
	}
	
	public StateHero getState() {
		return stateHero;
	}
	
	
	
	
	
	
}
