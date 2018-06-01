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
		
	}
	
	private boolean inList(Node n) {
		
	}
	
	public void findPath(Node start, Node end){
		
	}
	
	public ArrayList<Node> getPath(){
		return path;
	}
	
	
	
}
