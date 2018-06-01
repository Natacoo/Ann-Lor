package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import contract.*;


public classe View extends JFrame implements IView, KeyListener{
	private String title;
	private IController controller;
	private IModel model;
	
	
	public View(IModel model, String title) {
		
	}
	
	public IModel getModel() {
		
	}
	
	public void setController(IController c) {
		
	}
	
	protected IController getController() {
		
	}
	
	public void setTitle(String title) {
		
	}
	
	public String getTitle () {
		
	}
	
	public void keyTyped(KeyEvent keyEvent) {}
	
	public void keyPressed(KeyEvent keyEvent) {
		
	}
	
	public void keyReleased(KeyEvent keyEvent) {}
}

