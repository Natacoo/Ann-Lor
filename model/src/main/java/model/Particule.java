package model;

import java.awt.Graphics;
import java.awt.Image;

import contract.IParticule;

public class Particule implements IParticule{
	private int life;
	private int direction;
	private Image[] image;
	private int index;
	private int x, y; 
	
	public Particule(int life, int direction, Image[] image, int x, int y){
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.image = image;
		this.life = life;
		this.index = 0;
	}
	
	public void move(){

	}
	
	public void draw(Graphics g){
		
	}
	
	public boolean isLife(){
		return life == 0;
	}
	
	public void setDirection(int d){
		direction = d;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
}
