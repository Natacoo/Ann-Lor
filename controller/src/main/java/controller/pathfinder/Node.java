package controller.pathfinder;

/**
 @author Hugo GERMAIN
 @version 06/04/2018
 */

public class Node {
	private int x;
	private int y;
	/**
	 Method for initialize with a Node
	 * @param n It's a node
	 */
	public Node(Node n){
		this.x = n.getX();
		this.y = n.getY();
	}
	/**
	 Method for initialize with x and y
	 * @param x It's a coordinate x
	 * @param y It's a coordinate y
	 */
	public Node(int x, int y){
		this.x = x;
		this.y = y;
	}
	/**
	 Method return x
	 @return x It's a coordinate x
	 */
	public int getX(){
		return x;
	}
	/**
	 Method return y
	 @return y It's a coordinate y
	 */
	public int getY(){
		return y;
	}
	/**
	 Method for set coordinate x
	 @param x It's a coordinate x
	 */
	public void setX(int x){
		this.x = x;
	}
	/**
	 Method for set coordinate y
	 @param y It's a coordinate y
	 */
	public void setY(int y){
		this.y = y;
	}	
	
}
