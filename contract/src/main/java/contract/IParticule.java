package contract;

import java.awt.Graphics;

public interface IParticule {
	public void draw(Graphics g);

	public int getX();

	public int getY();

	public void move();

	public boolean isLife();

	public void setDirection(int direction);

}
