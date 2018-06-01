package controller;

import java.awt.event.KeyEvent;

public class Controller implements IController{
	private IView view;
	private IModel model;
	private Thread t;
	private PathFinder pathFinder;

	public Controller(IView view, IModel model){
		this.view = view;
		this.model = model;
		t = new Thread(new Tick(this));
		model.playMusic("menu", true);
	}
	
	public void initPathFinder() {
		
	}
	
	public void startTick(){
		t.start();
	}
	
	public void update(){
		
	}
	
	public void mouveBackground(){
		
	}
	
	public void setView(IView v){
		view = v;
	}
	
	public void setModel(IModel m){  
		model = m;
	}
	
	public IView getView() {
		return view;
	}
	
	public IModel getModel() {
		return model;
	}
	
	public IEntitie getEntitie(int x, int y){
		
	}
	
	private IElement getElement(int x, int y){
		return model.getElement(x, y);
	}
	
	private boolean isBlocked(int x, int y){
		
	}
	
	public void keyEvent(){
		
	}
	
	public void keyEvent(int keyCode){
		
	}
	
	public void move(int action, TypeEntitie typeEntitie, IEntitie entitie){
		
	}
	
	private void checkMonster(int x, int y) {
		
	}
	
	private void checkKey(int x, int y) {
		
	}
	
	private void checkBonus(int x, int y) {
		
	}
	
	private void checkDoor(int x, int y){
		
	}
	
	public void action(int action){
		
	}
	
	
}
