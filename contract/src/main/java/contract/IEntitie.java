package contract;

import java.awt.Graphics;

public interface IEntitie {
	public void draw(Graphics g);

	public int getX();

	public int getY();

	public void setPosition(int x, int y);

	public boolean isMove(long tick);

	public int getBonus();

	public TypeEntitie getTypeEntitie();

}
