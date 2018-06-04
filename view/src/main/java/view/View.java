package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import contract.*;

/**
 @author Florian FRISCHMANN
 @version 14.06.16
*/

public class View extends JFrame implements IView, KeyListener{
	
	private String title;
	private IController controller;
	private IModel model;
	
	/**
	 Set the frame (title, size, default close operation, content panel, visible)
	 @param	model Get model
	 @param	title Set title
	*/
	public View(IModel model, String title){
		this.model = model;
		addKeyListener(this);
		setTitle(title);
		setSize(1280, 640);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new Panel(this));
		setResizable(false);
		setVisible(true);
		
	}
	
	/**
	 Call clearComponant method and display elements
	 @return return the model
	 */
	public IModel getModel(){
		return model;
	}

	/**
	 Call clearComponant method and display elements
	 @param	c set controller to c
	 */
	public void setController(IController c){
		controller = c;
	}

	/**
	 return the controller to the model
	 @return Return the controller
	 */
	protected IController getController(){
		return controller;
	}

	/**
	 (non-Javadoc)
	 @see java.awt.Frame#setTitle(java.lang.String)
	 */
	public void setTitle(String title){
		this.title = title;
	}
	

	/**
	 (non-Javadoc)
	 @see java.awt.Frame#getTitle()
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 (non-Javadoc)
	 @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(KeyEvent keyEvent){}
	/**
	 (non-Javadoc)
	 @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent keyEvent) {
		controller.keyEvent(keyEvent.getKeyCode());
	}
	/**
	 (non-Javadoc)
	 @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent keyEvent) {}
	
}
