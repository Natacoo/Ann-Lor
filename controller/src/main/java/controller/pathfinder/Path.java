package controller.pathfinder;

/**
 @author Hugo GERMAIN
 @version 06/04/2018
 */

public class Path extends Node{
	
	private Path parent;
	private int valeur;
	
	/**
	 Method for initialize with a Path
	 @param p It's a path
	 */
	public Path(Path p) {
		this(p.getX(), p.getY(), p.getParent(), p.getValue());
	}
	
	/**
	 Method for initialize with the coordinate x and y, the parent path and the value
	 @param x It's a coordinate x
	 @param y It's a coordinate y
	 @param p It's a parent Path
	 @param v It's a value
	 */
	public Path(int x, int y, Path p, int v){
		super(x, y);
		parent = p;
		valeur = v;
	}
	/**
	 Method return the parent of this path
	 @return It's a parent Path
	 */
	public Path getParent() {
		return parent;
	}
	/**
	 Method set Parent on this path
	 @param parent It's a parent of this path
	 */
	public void setParent(Path parent) {
		this.parent = parent;
	}
	/**
	 Method return value on this path
	 @return It's a value for this path
	 */
	public int getValue() {
		return valeur;
	}
	/**
	 Methode set a value
	 @param valeur It's a value fot this path
	 */
	public void setValue(int valeur) {
		this.valeur = valeur;
	}
	
//	
}
