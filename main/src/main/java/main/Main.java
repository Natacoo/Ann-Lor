package main;

import contract.*;
import controller.Controller;
import model.Game;
import view.View;

public class Main 
{

    public static void main( String[] args )
    {
    	IModel game = new Game();
    	IView view = new View(game, "Lorann");
    	IController controller = new Controller(view, game);
    	view.setController(controller);
    	controller.startTick();
    }
}