package controller.pathfinder;

import java.util.ArrayList;

/**
 @author Hugo GERMAIN
 @version 06/04/2018
 */

public class PathFinder {
	
	private int[][] map;
	
	private ArrayList<Path> listPath;
	private ArrayList<Node> path;
	
	/**
	 Method initialize pathFinder with a int table
	 @param map It's a table of int
	 */
	public PathFinder(int[][] map){
		this.map = map;
		listPath = new ArrayList<Path>();
		path = null;
	}
	/**
	 Method for search walk in coordinate x and y
	 @param n It's a node with coordinate x and y
	 @return Return a boolean if the coordinate is in walk or not
	 */
	public boolean isWalk(Node n){
		if(n.getX() < 0) return false;
		if(n.getY() < 0) return false;
		
		if(n.getX() >= map.length) return false;
		if(n.getY() >= map[0].length) return false;
		
		if(inList(n)) return false;
		
		return map[n.getX()][n.getY()] == 0;
	}
	
	/**
	 Verify this node in a List
	 @param n It's a node for verify
	 @return Return a boolean if the node in ArrayList
	 */
	private boolean inList(Node n) {
		for(Node e : listPath){
			if(e.getX() == n.getX() && e.getY() == n.getY()) return true;
		}
		return false;
	}
	/**
	 Search and find a Path between node start and node end
	 @param start It's a node for start path
	 @param end It's a node for end path
	 */
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
	/**
	 Method return a list node for get a Path
	 @return Return a path
	 */
	public ArrayList<Node> getPath(){
		return path;
	}
}
