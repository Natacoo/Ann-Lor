package model;

import java.awt.Graphics;
import java.awt.Image;

import contract.IElement;
import contract.TypeElement;

/**
 @author Tristan FOCA
 @version 06/04/2018
*/

public class Element implements IElement {
	private Image image;
	private int x, y;
	private boolean permeability;
	private TypeElement typeElement;
	
	public Element(Element e){
		this(e.getImage(), e.getX(), e.getY());
	}
	/**
	 initialized the image and the position
	 @param image It's a sprite for this Element
	 @param x It's coordinate x
	 @param y It's coordinate y
	*/
	public Element(Image image, int x, int y){
		this.image = image;
		this.x = x;
		this.y = y;
	}
	
	/**
	 get the position of an element x
	 @return Return the coordinate x
	 */
	public int getX() {
		return x;
	}
	/**
	 get the position of an element y
	 @return Return the coordinate y
	 */
	public int getY() {
		return y;
	}
	/**
	 set the Image of an element on the map
	 @param image It's a Image for set a sprite
	 */
	public void setImage(Image image){
		this.image = image;
	}
	/**
	 get the image of an element
	 @return Return a image
	 */
	public Image getImage(){
		return image;
	}
	/**
	 (non-Javadoc)
	 @see contract.IElement#getPermeability()
	 */
	public boolean getPermeability(){
		return permeability;
	}
	/**
	 Method set the permeability for this element
	 @param p It's a boolean
	 */
	public void setPermeability(boolean p){
		permeability = p;
	}
	/**
	 get the Type of the element
	 @return the type of the element
	 */
	public TypeElement getTypeElement(){
		return typeElement;
	}
	/**
	 Method set a type element
	 @param t It's a TypeElement
	 */
	public void setTypeElement(TypeElement t){
		typeElement = t;
	}
	/**
	 draw the image on the map
	 @param g It's a Graphics of Panel
	 */
	public void draw(Graphics g){
		g.drawImage(image, x*32, y*32, null);
	}
	/**
	 Method set the position Element
	 * @param x It's a coordinate x
	 * @param y It's a coordinate y
	 */
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
}
