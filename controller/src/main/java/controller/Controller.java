package controller;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import contract.IController;
import contract.IDoor;
import contract.IElement;
import contract.IEntitie;
import contract.IHero;
import contract.IModel;
import contract.IParticule;
import contract.IView;
import contract.StateGame;
import contract.StateHero;
import contract.TypeElement;
import contract.TypeEntitie;
import controller.pathfinder.Node;
import controller.pathfinder.PathFinder;

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
		int value[][] = new int[model.getMap().getElements().length][model.getMap().getElements()[0].length];
		for (int x = 0;x <value.length; x++)
		{
			for(int y = 0;y <value[0].length; y++)
			{
				if(model.getElement(x, y) == null){
					value[x][y] = 0;
				} else {
					value[x][y] = 1;
				}
			}
		}
		pathFinder = new PathFinder(value);
	}
	
	public void startTick(){
		t.start();
	}
	
	public void update(long ticks){
		if(model.getState() == StateGame.MAP) {
			try{
				for(IParticule p : model.getMap().getParticule())
				{
					if(p.getX() == model.getMap().getHero().getX() && p.getY() == model.getMap().getHero().getY()){
						model.getMap().getParticule().remove(p);
						((IHero) model.getMap().getHero()).setStateSpell(true);
					}else{
						p.move();
						IEntitie ie = getEntitie(p.getX(), p.getY());
						if(ie != null){
							if(ie.getTypeEntitie() == TypeEntitie.MONSTER){
								model.playEffect("dead_monster");
								model.getMap().setScore(model.getMap().getScore()+ie.getBonus());
								model.getMap().getEntities().remove(ie);
								model.getMap().getParticule().remove(p);
								((IHero) model.getMap().getHero()).setStateSpell(true);
							}
						}else if(!isBlocked(p.getX(), p.getY())){
						} else {
							model.getMap().getParticule().remove(p);
							((IHero) model.getMap().getHero()).setStateSpell(true);
						}
					}
					model.changed();
				}
			}catch(Exception e){};
				for(IEntitie e : model.getMap().getEntities())
				{
					if(e.isMove(ticks) && e.getTypeEntitie() == TypeEntitie.MONSTER){
						try{
							pathFinder.findPath(new Node(e.getX(), e.getY()), new Node(model.getMap().getHero().getX(), model.getMap().getHero().getY()));
							ArrayList<Node> paths = pathFinder.getPath();
							int count = 0;
							for(Node n : paths)
							{
								e.setPosition(n.getX(), n.getY());
								if (e.getX()==model.getMap().getHero().getX() && e.getY()==model.getMap().getHero().getY()) {
									model.playMusic("game_over", true);
									model.setState(StateGame.GAMEOVER);
								}
								count++;
								
								if(count == 2) break;
							}
							model.changed();
						}catch(Exception ex){};
					}
				}
		}else if(model.getState() != StateGame.MAP){
			mouveBackground();
		}
	}
	
	public void mouveBackground(){
		switch(model.getDirectionBackground()){
		case 0:
			if(model.getCoordinateXBackground() > -640)
				model.setCoordinateXBackground(model.getCoordinateXBackground()-2);
			else
				model.setDirectionBackground((int)(Math.random()*7));
			break;
		case 1:
			if(model.getCoordinateXBackground() < 0)
				model.setCoordinateXBackground(model.getCoordinateXBackground()+2);
			else
				model.setDirectionBackground((int)(Math.random()*7));
			break;
		case 2:
			if(model.getCoordinateYBackground() < 0)
				model.setCoordinateYBackground(model.getCoordinateYBackground()+2);
			else
				model.setDirectionBackground((int)(Math.random()*7));
			break;
		case 3:
			if(model.getCoordinateYBackground() > -411)
				model.setCoordinateYBackground(model.getCoordinateYBackground()-2);
			else
				model.setDirectionBackground((int)(Math.random()*7));
			break;
		case 4:
			if(model.getCoordinateXBackground() > -640)
				model.setCoordinateXBackground(model.getCoordinateXBackground()-2);
				if(model.getCoordinateYBackground() < 0)
					model.setCoordinateYBackground(model.getCoordinateYBackground()+2);
			else
				model.setDirectionBackground((int)(Math.random()*7));
			break;
		case 5:
			if(model.getCoordinateXBackground() < 0)
				model.setCoordinateXBackground(model.getCoordinateXBackground()+2);
				if(model.getCoordinateYBackground() > -411)
					model.setCoordinateYBackground(model.getCoordinateYBackground()-2);
			else
				model.setDirectionBackground((int)(Math.random()*7));
			break;
		case 6:
			if(model.getCoordinateYBackground() < 0 )
				model.setCoordinateYBackground(model.getCoordinateYBackground()+2);
				if(model.getCoordinateXBackground() < 0)
					model.setCoordinateXBackground(model.getCoordinateXBackground()+2);
			else
				model.setDirectionBackground((int)(Math.random()*7));
			break;
		case 7:
			if(model.getCoordinateYBackground() > -411)
				model.setCoordinateYBackground(model.getCoordinateYBackground()-2);
				if(model.getCoordinateXBackground() > -640)
					model.setCoordinateXBackground(model.getCoordinateXBackground()-2);
			else
				model.setDirectionBackground((int)(Math.random()*7));
			break;
	}
	model.changed();
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
		for(IEntitie e : model.getMap().getEntities()){
			if(e.getX() == x && e.getY() == y){
				return e;
			}
		}
		return null;
	}
	
	private IElement getElement(int x, int y){
		return model.getElement(x, y);
	}
	
	private boolean isBlocked(int x, int y){
		if(x<0) return true;
		if(y<0) return true;
		if(x>=model.getMap().getElements().length) return true;
		if(y>=model.getMap().getElements()[0].length) return true;
		
		if(getElement(x,y)==null) return false;
		
		return getElement(x, y).getPermeability();
	}
	
	
	public void keyEvent(int keyCode){
		switch(keyCode){
		case KeyEvent.VK_UP : case KeyEvent.VK_Z :
			move(1, TypeEntitie.HERO, null);
			break;
		case KeyEvent.VK_DOWN : case KeyEvent.VK_S :
			move(2, TypeEntitie.HERO, null);
			break;
		case KeyEvent.VK_LEFT : case KeyEvent.VK_Q :
			move(3, TypeEntitie.HERO, null);
			break;
		case KeyEvent.VK_RIGHT : case KeyEvent.VK_D :
			move(4, TypeEntitie.HERO, null);
			break;
		case KeyEvent.VK_ESCAPE :
			action(5);
			break;
		case KeyEvent.VK_SPACE :
			action(6);
			break;
		case KeyEvent.VK_ENTER :
			action(7);
			break;
		case KeyEvent.VK_R :
			model.changed();
			break;
			
		}
	}
	
	
	public void move(int action, TypeEntitie typeEntitie, IEntitie entitie){
		if(model.getState() == StateGame.MAP){
			switch(typeEntitie){
				case HERO:
						IEntitie hero = model.getMap().getHero();
						int x = hero.getX();
						int y = hero.getY();
						((IHero)hero).setStateImage(StateHero.values()[action-1]);
						switch(action)
						{
							case 1:
								checkDoor(x, y-1);
								checkBonus(x, y-1);
								checkKey(x, y-1);
								checkMonster(x, y-1);
								if(!isBlocked(x, y-1))
									hero.setPosition(x, y-1);
								break;
							case 2:
								checkDoor(x, y+1);
								checkBonus(x, y+1);
								checkKey(x, y+1);
								checkMonster(x, y+1);
								if(!isBlocked(x, y+1))
									hero.setPosition(x, y+1);
								break;
							case 3:
								checkDoor(x-1, y);
								checkBonus(x-1, y);
								checkKey(x-1, y);
								checkMonster(x-1, y);
								if(!isBlocked(x-1, y))
									hero.setPosition(x-1, y);
								break;
							case 4 :
								checkDoor(x+1, y);
								checkBonus(x+1, y);
								checkKey(x+1, y);
								checkMonster(x+1, y);
								if(!isBlocked(x+1, y))
									hero.setPosition(x+1, y);
								break;
						}
					break;
				case MONSTER:
					switch(action){
					case 1:
						if(!isBlocked(entitie.getX(), entitie.getY()-1))
							entitie.setPosition(entitie.getX(), entitie.getY()-1);
						break;
					case 2:
						if(!isBlocked(entitie.getX(), entitie.getY()+1))
							entitie.setPosition(entitie.getX(), entitie.getY()+1);
						break;
					case 3:
						if(!isBlocked(entitie.getX()-1, entitie.getY()))
							entitie.setPosition(entitie.getX()-1, entitie.getY());
						break;
					case 4 :
						if(!isBlocked(entitie.getX()+1, entitie.getY()))
							entitie.setPosition(entitie.getX()+1, entitie.getY());
						break;
						
				}
				case BONUS:
					break;
				default:
					break;
			}
			model.changed();
		}else if(model.getState() == StateGame.MENU){
			switch(action){
				case 1 :
						model.setLevel(model.getLevel()+1);
					break;
				case 2 :
						model.setLevel(model.getLevel()-1);
					break;
			}
		}
	}
	
	private void checkMonster(int x, int y) {
		IEntitie ie = getEntitie(x, y);
		if(ie != null){
			model.playMusic("game_over", true);
			model.setState(StateGame.GAMEOVER);
		}
	}
	
	private void checkKey(int x, int y) {
		try{
			IElement e = getElement(x, y);
			if(e.getTypeElement() == TypeElement.KEY){
				model.getMap().getElements()[x][y] = null;
				for(IElement[] ie : model.getMap().getElements()){
					for(IElement ee : ie){
						if(ee instanceof IDoor){
							model.playEffect("key");
							((IDoor)ee).setOpen();
						}
					}
				}
			}
		}catch(Exception ex){}
	}
	
	private void checkBonus(int x, int y) {
		try{
			for(IEntitie e : model.getMap().getEntities()){
				if(e.getX() == x && e.getY() == y && e.getTypeEntitie() == TypeEntitie.BONUS){
					model.getMap().setScore(model.getMap().getScore()+e.getBonus());
					model.getMap().getEntities().remove(e);
				}
			}
		}catch(Exception ex){};
	}
	
	private void checkDoor(int x, int y){
		IElement door = getElement(x, y);
		if(door instanceof IDoor){
			if(!((IDoor) door).isState()){
				model.playMusic("game_over", true);
				model.setState(StateGame.GAMEOVER);
				model.changed();
			}else {
				if(model.getMaps().size() > model.getLevel()+1){
					model.setLevel(model.getLevel()+1);
					initPathFinder();
				}else {
					model.playMusic("game_over", true);
					model.setState(StateGame.GAMEOVER);
				}
			}
		}
	}
	
	public void action(int action){
		if(model.getState() == StateGame.GAMEOVER){
			if(action == 7){
				model.playMusic("menu", true);
				model.setState(StateGame.MENU);
				model.loadMap(model.getLevel()+1);
				model.changed();
				return;
			}
		}else if(model.getState() == StateGame.MENU){
			if(action == 7){
				model.playMusic("introduction", true);
				initPathFinder();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {}
				model.playMusic("ingame", true);
				model.setState(StateGame.MAP);
				model.changed();
				return;
			}
			if(action == 5){
				System.exit(0);
			}
		}else if(model.getState() == StateGame.MAP){
			if(action == 6 && ((IHero)model.getMap().getHero()).isStateSpell()){
				model.playEffect("spell");
				model.addParticule(5, ((IHero) model.getMap().getHero()).getState(), model.getMap().getHero());
				IParticule ip = model.getMap().getParticule().get(model.getMap().getParticule().size()-1);
				ip.move();
				IEntitie ie = getEntitie(ip.getX(), ip.getY());
				((IHero)model.getMap().getHero()).setStateSpell(false);
				if(ie != null){
					if(ie.getTypeEntitie() == TypeEntitie.MONSTER){
						model.playEffect("dead_monster");
						model.getMap().setScore(model.getMap().getScore()+ie.getBonus());
						model.getMap().getEntities().remove(ie);
						model.getMap().getParticule().remove(ip);
						((IHero) model.getMap().getHero()).setStateSpell(true);
					}
				}
				if(isBlocked(ip.getX(), ip.getY())){
					model.getMap().getParticule().remove(ip);
					((IHero)model.getMap().getHero()).setStateSpell(true);
				}
				
				model.changed();
				
			}
		}
	}
	
	
}
