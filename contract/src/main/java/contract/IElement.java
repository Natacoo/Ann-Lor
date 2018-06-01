package contract;

import java.awt.Graphics;
import java.awt.Image;

public interface IElement {
	public boolean getPermeability();

	public void draw(Graphics g);

	public int getX();

	public int getY();

	public TypeElement getTypeElement();

	public void setImage(Image image);

}
