package controller.pathfinder;

public class Path extends Node{
	
	private Path parent;
	private int valeur;
	
	public Path(Path p) {
		this(p.getX(), p.getY(), p.getParent(), p.getValue());
	}
	
	public Path(int x, int y, Path p, int v){
		super(x, y);
		parent = p;
		valeur = v;
	}
	
	public Path getParent() {
		return parent;
	}
	
	public void setParent(Path parent) {
		this.parent = parent;
	}
	
	public int getValue() {
		return valeur;
	}
	
	public void setValue(int valeur) {
		this.valeur = valeur;
	}
	
}
	
