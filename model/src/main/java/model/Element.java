package model;

import java.awt.Graphics;
import java.awt.Image;

import contract.IElement;
import contract.TypeElement;

public class Element {
	private Image image; 
	private int x, y;
	private boolean permeability;
	private TypeElement typeElement;
	
	public Element(Element e){
		this(e.getImage(), e.getX(), e.getY());
	}

	public Element(Image image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setImage(Image image){
		this.image = image;
	}
	
	public Image getImage(){
		return image;
	}
	
	public boolean getPermeability(){
		return permeability;
	}
	
	public void setPermeability(boolean p){
		permeability = p;
	}
	
	public TypeElement getTypeElement(){
		return typeElement;
	}
	
	public void setTypeElement(TypeElement t){
		typeElement = t;
	}
	
	public void draw(Graphics g){
		g.drawImage(image, x*32, y*32, null);

	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
}
