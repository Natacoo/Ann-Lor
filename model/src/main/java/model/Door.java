package model;

import java.awt.Image;

import contract.IDoor;

public class Door extends Element {
	private boolean state;
	private Image[] sprites;  
	
	public Door(Image image, int x, int y, Image[] sprites) {
		super(image, x, y);
		this.sprites = sprites;
		this.state = false;
	}
	
	public boolean isState() {
		return state;
	}
	
	public void setOpen() {
		state = true;
		setImage(sprites[1]);	
	}
}
