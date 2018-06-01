package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.util.Observer
import java.util.Observable

import javax.swing.JPanel;

import contract.*;


public class Panel extends JPanel implements Observer{
	
	public View view;
	
	public Panel(View view) {
		
		view.setBackground(Color.BLACK);
		this.view = view;
		view.getModel().addObserver(this);
	}
	
	public void paintComponent(Graphics g) {
		clearComponant(g);
		for(IElement [] element : view.getModel().getMap().getElements()) {
			for(IElement e : element) {
				if(e != null) {
					e.draw(g);
				}
			}
		}
	
	public void clearComponant (Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0,  0, view.getWidth(), view.getHeight());
	}
	
	public void update(Observable observable, Object object) {
		repaint();
	}
	
	}
}