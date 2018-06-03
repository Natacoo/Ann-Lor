package controller.pathfinder;

import java.util.ArrayList;

public class PathFinder {
	private int[][] map;
	private ArrayList<Path> listPath;
	private ArrayList<Node> path;

	public PathFinder(int[][] map){
		this.map = map;
		listPath = new ArrayList<Path>();
		path = null;
	}
	
	public boolean isWalk(Node n){
		if(n.getX() < 0) return false;
		if(n.getY() < 0) return false;
		
		if(n.getX() >= map.length) return false;
		if(n.getY() >= map[0].length) return false;
		
		if(inList(n)) return false;
		
		return map[n.getX()][n.getY()] == 0;
	}
	
	private boolean inList(Node n) {
		for(Node e : listPath){
			if(e.getX() == n.getX() && e.getY() == n.getY()) return true;
		}
		return false;
	}
	
	public void findPath(Node start, Node end){
		path = null;
		listPath.clear();
		listPath.add(new Path(start.getX(), start.getY(), null, 0));
		int maxLength = map.length * map[0].length;
		int index = 0;
		Path current = null;
		do{
			try{
			current = listPath.get(index);

			if(current.getX() == end.getX() && current.getY() == end.getY()) break; //
			
			if(isWalk(new Node(current.getX()+1, current.getY())))
				listPath.add(new Path(current.getX()+1, current.getY(), current, current.getValue()+1));

			if(isWalk(new Node(current.getX()-1, current.getY())))
				listPath.add(new Path(current.getX()-1, current.getY(), current, current.getValue()+1));

			if(isWalk(new Node(current.getX(), current.getY()+1)))
				listPath.add(new Path(current.getX(), current.getY()+1, current, current.getValue()+1));
			
			if(isWalk(new Node(current.getX(), current.getY()-1)))
				listPath.add(new Path(current.getX(), current.getY()-1, current, current.getValue()+1));
			
			index++;
			}catch(Exception ex){return;}
		}while(listPath.size() < maxLength);
		
		path = new ArrayList<Node>();
		Path parent = new Path(current);
		while(parent != null){
			path.add(0, new Node(parent));
			if(parent.getParent() != null)
				parent = new Path(parent.getParent());
			else
				parent = null;
		}
	}
	
	public ArrayList<Node> getPath(){
		return path;
	}
	
	
	
}
