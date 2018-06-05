package main;

import contract.*;
import controller.Controller;
import model.Game;
import view.View;

/**
 @author Tristan FOCA, Hugo GERMAIN, Florian FRISCHMANN
 @version 06/04/2018
 */
public class Main 
{
	/**
	 Method for start a game
	 @param args It's table params for application
	 */
    public static void main( String[] args )
    {
    	IModel game = new Game();
    	IView view = new View(game, "Lorann");
    	IController controller = new Controller(view, game);
    	view.setController(controller);
    	controller.startTick();
    }
}
