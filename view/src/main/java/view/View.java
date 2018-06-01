package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import contract.*;


public class View extends JFrame implements IView, KeyListener{
	
	private String title;
	private IController controller;
	private IModel model;
	
	
	public View(IModel model, String title) {
		this.model = model;
		addKeyListener(this);
		setTitle(title);
		setSize(1280, 640);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new Panel(this));
		setResizable(false);
		setVisible(true);
		
	}
	
	public IModel getModel() {
		return model;
	}
	
	public void setController(IController c) {
		controller = c;
	}
	
	protected IController getController() {
		return controller;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle () {
		return title;
	}
	
	public void keyTyped(KeyEvent keyEvent) {}
	
	public void keyPressed(KeyEvent keyEvent) {
		controller.keyEvent(keyEvent.getKeyCode());
	}
	
	public void keyReleased(KeyEvent keyEvent) {}
}

