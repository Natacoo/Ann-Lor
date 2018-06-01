package contract;

import java.awt.Color;
import java.awt.Graphics;

public class GraphUtil {
	public static void StringWithBorder(Graphics g, String txt, int x, int y) {
		StringWithBorder(g, txt, x, y, Color.white, Color.black);
	}
	public static void StringWithBorder(Graphics g, String txt, int x, int y, Color txtColor) {
		StringWithBorder(g, txt, x, y, txtColor, Color.black);
	}
	public static void StringWithBorder(Graphics g, String txt, int x, int y, Color txtColor, Color borderColor) {
		g.setColor(borderColor);
		g.drawString(txt, x-1, y-1);
		g.drawString(txt, x-1, y);
		g.drawString(txt, x-1, y+1);
		g.drawString(txt, x, y-1);
		g.drawString(txt, x, y+1);
		g.drawString(txt, x+1, y-1);
		g.drawString(txt, x+1, y);
		g.drawString(txt, x+1, y+1);
		
		g.setColor(txtColor);
		g.drawString(txt, x, y);
	}
}
