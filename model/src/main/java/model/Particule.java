package model;

import java.awt.Graphics;
import java.awt.Image;

import contract.IParticule;

/**
@author Tristan FOCA
@version 06/04/2018
*/

public class Particule implements IParticule {
	
	private int life;
	private int direction;
	private Image[] image;
	private int index;
	private int x, y;
	/**
	 initialized Particle with her life, her direction, her sprite and her position
	 @param life It's a life for a particule
	 @param direction It's a direction
	 @param image It's a image
	 @param x It's a coordinate x
	 @param y It's a coordinate y
	 */
	public Particule(int life, int direction, Image[] image, int x, int y){
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.image = image;
		this.life = life;
		this.index = 0;
	}
	/**
	 move the particle
	 */
	public void move(){
		life--;
		index = (int)(Math.random()*5);
		switch(direction){
			case 1 :
				y--;
				break;
			case 2 :
				y++;
				break;
			case 3 :
				x--;
				break;
			case 4 :
				x++;
				break;
		}
		if(life == 0){
			direction = 0;
		}
	}
	/**
	 draw the image of the particle on the map
	 @param g It's a Graphics of Panel
	 */
	public void draw(Graphics g){
		g.drawImage(image[index], x*32, y*32, null);
	}
	/**
	 * @see contract.IParticule#isLife()
	 */
	public boolean isLife(){
		return life == 0;
	}
	/**
	 * @see contract.IParticule#setDirection(int)
	 */
	public void setDirection(int d){
		direction = d;
	}
	/**
	 * @see contract.IParticule#getX()
	 */
	public int getX()
	{
		return x;
	}
	/**
	 * @see contract.IParticule#getY()
	 */
	public int getY()
	{
		return y;
	}

}
