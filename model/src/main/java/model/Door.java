package model;

import java.awt.Image;

import contract.IDoor;

/**
@author Tristan FOCA
@version 06/04/2018
*/

public class Door extends Element implements IDoor{

	private boolean state;
	private Image[] sprites;
	/**
	 Initialized all characteristics of my door
	 @param image the image of door
	 @param x the position in x
	 @param y the position in y
	 @param sprites It's a table of image
	 */
	public Door(Image image, int x, int y, Image[] sprites) {
		super(image, x, y);
		this.sprites = sprites;
		this.state = false;
	}
	/**
	 Get the state of the Door during the game open or close
	 @return State the state of the Door
	 */
	public boolean isState() {
		return state;
	}
	/**
	 Set the state of the Door during the game open or close
	 */
	public void setOpen() {
		state = true;
		setImage(sprites[1]);
	}

}