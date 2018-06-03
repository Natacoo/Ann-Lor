package model;

import java.awt.Graphics;
import java.awt.Image;

import contract.IEntitie;
import contract.TypeEntitie;

public class Entitie implements IEntitie {
	private int x, y;
	private TypeEntitie typeEntitie;
	protected Image image;	
	private int speed; 
	protected int bonus;
	
	public Entitie(Image image){
		this.image = image;
		this.speed = 5;
		this.bonus = 500;
		
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
		
	}
	
	public int getX(){
		return x;
		
	}
	
	public int getY(){
		return y;
		
	}
	
	public TypeEntitie getTypeEntitie(){
		return typeEntitie;
		
	}
	
	public void update(){
		
	}
	
	public void draw(Graphics g){
		g.drawImage(image, x*32, y*32, null);

	}
	
	public void setTytpeEntitie(TypeEntitie t){
		typeEntitie = t;
		
	}
	
	public boolean isMove(long i){
		return (i % (long)speed) == 0;

	}
	
	public int getBonus() {
		return bonus;
		
	}
	
	public void setSpeed(int speed){
		this.speed = speed;
		
	}
	
}
