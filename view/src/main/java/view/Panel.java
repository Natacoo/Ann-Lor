package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.*;

/**
 @author Florian FRISCHMANN
 @version 06/04/2018
 */

public class Panel extends JPanel implements Observer{
	
	public View view;
	
	/**
	 Initialize the object and set the background to black color
	 @param view It's a View
	 */
	public Panel(View view){

		view.setBackground(Color.BLACK);
		this.view = view;
		view.getModel().addObserver(this);
	}

	/**
	 @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g){
		clearComponant(g);
		for(IElement[] element : view.getModel().getMap().getElements()){
			for(IElement e : element){
				if(e != null){
					e.draw(g);
				}
			}
		}
		
		switch(view.getModel().getState()){
			case MENU : 
					view.getModel().getMenu(g);
				break;
			case GAMEOVER :
					view.getModel().getGameOver(g);
				break;
			case MAP :
					for (IParticule p : view.getModel().getMap().getParticule()){
						p.draw(g);
					}
					for(IEntitie en : view.getModel().getMap().getEntities()){
						en.draw(g);
					}
					view.getModel().getMap().getHero().draw(g);
					g.setFont(new Font(Font.DIALOG, Font.ITALIC, 25));
					GraphUtil.StringWithBorder(g, "Score : "+view.getModel().getMap().getScore(), 40, 40, Color.yellow);
				break;
		}
	}

	/**
	 Method to clear display and fill the windows with a black screen
	 @param g It's a Graphics for paintComponent
	 */
	public void clearComponant (Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, view.getWidth(), view.getHeight());
	}

	/**
	 (non-Javadoc)
	 @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable observable, Object object) {
		repaint();
	}
}
