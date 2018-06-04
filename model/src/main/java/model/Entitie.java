package model;

import java.awt.Graphics;
import java.awt.Image;

import contract.IEntitie;
import contract.TypeEntitie;

/**
@author Tristan FOCA
@version 06/04/2018
*/

public class Entitie implements IEntitie{
	private int x, y;
	private TypeEntitie typeEntitie;
	protected Image image;	
	private int speed;
	protected int bonus;
	/**
	 initialized the image 
	 @param image It's a sprite for this entitie
	*/
	public Entitie(Image image){
		this.image = image;
		this.speed = 5;
		this.bonus = 500;
	}
	/**
	 set the position of the entities
	 @param x It's a coordinate x
	 @param y It's a coordinate y
	 */
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	/**
	 get the x position
	 @return Return the coordinate 
	 */
	public int getX(){
		return x;
	}
	/**
	 get the y position
	 @return Return the coordinate
	 */
	public int getY(){
		return y;
	}
	/**
	 get the type of the entitie
	 @return The type of the entitie
	 */
	public TypeEntitie getTypeEntitie(){
		return typeEntitie;
	}
	/**
	 update the entitie
	 */
	public void update(){
		
	}
	/**
	 draw the entitie on the map
	 @param g It's a Graphics for Panel
	 */
	public void draw(Graphics g){
		g.drawImage(image, x*32, y*32, null);
	}
	/**
	 set the type of an entitie
	 @param t It's a type of Entitie
	 */
	public void setTytpeEntitie(TypeEntitie t){
		typeEntitie = t;
	}
	
	/**
	 * @see contract.IEntitie#isMove(long)
	 */
	public boolean isMove(long i){
		return (i % (long)speed) == 0;
	}
	/**
	 * @see contract.IEntitie#getBonus()
	 */
	public int getBonus() {
		return bonus;
	}
	/**
	 * Method set speed for the entitie
	 * @param speed It's a number
	 */
	public void setSpeed(int speed){
		this.speed = speed;
	}
}
