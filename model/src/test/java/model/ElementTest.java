/**
 * 
 */
package model;

import static org.junit.Assert.assertNotNull;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.TypeElement;

/**
 * 
 * @author Tristan FOCA
 * @version 06/04/2018
 */
public class ElementTest {

	/**
	 * @throws java.lang.Exception Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.Element#Element(model.Element)}.
	 */
	@Test
	public final void testElementElement() {
		assertNotNull(new Element(new Element(new ImageIcon("ressource/sprite/bone.png").getImage(), 0, 0)));
	}

	/**
	 * Test method for {@link model.Element#Element(java.awt.Image, int, int)}.
	 */
	@Test
	public final void testElementImageIntInt() {
		assertNotNull(new Element(new ImageIcon("ressource/sprite/bone.png").getImage(), 0, 0));
	}

	/**
	 * Test method for {@link model.Element#getX()}.
	 */
	@Test
	public final void testGetX() {
		Element e = new Element(new ImageIcon("ressource/sprite/bone.png").getImage(), 0, 0);
		assertNotNull(e.getX());
	}

	/**
	 * Test method for {@link model.Element#getY()}.
	 */
	@Test
	public final void testGetY() {
		Element e = new Element(new ImageIcon("ressource/sprite/bone.png").getImage(), 0, 0);
		assertNotNull(e.getY());
	}

	/**
	 * Test method for {@link model.Element#setImage(java.awt.Image)}.
	 */
	@Test
	public final void testSetImage() {
		Element e = new Element(new ImageIcon("ressource/sprite/bone.png").getImage(), 0, 0);
		e.setImage(new ImageIcon("ressource/sprite/bone.png").getImage());
	}

	/**
	 * Test method for {@link model.Element#getImage()}.
	 */
	@Test
	public final void testGetImage() {
		Element e = new Element(new ImageIcon("ressource/sprite/bone.png").getImage(), 0, 0);
		assertNotNull(e.getImage());
	}

	/**
	 * Test method for {@link model.Element#getPermeability()}.
	 */
	@Test
	public final void testGetPermeability() {
		Element e = new Element(new ImageIcon("ressource/sprite/bone.png").getImage(), 0, 0);
		assertNotNull(e.getPermeability());
	}

	/**
	 * Test method for {@link model.Element#setPermeability(boolean)}.
	 */
	@Test
	public final void testSetPermeability() {
		Element e = new Element(new ImageIcon("ressource/sprite/bone.png").getImage(), 0, 0);
		e.setPermeability(false);
	}

	/**
	 * Test method for {@link model.Element#getTypeElement()}.
	 */
	@Test
	public final void testGetTypeElement() {
		Element e = new Element(new ImageIcon("ressource/sprite/bone.png").getImage(), 0, 0);
		e.setTypeElement(TypeElement.WALL);
		assertNotNull(e.getTypeElement());
	}

	/**
	 * Test method for {@link model.Element#draw(java.awt.Graphics)}.
	 */
	@Test
	public final void testDraw() {
		Element e = new Element(new ImageIcon("ressource/sprite/bone.png").getImage(), 0, 0);
		BufferedImage g = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
		e.draw(g.getGraphics());
	}

	/**
	 * Test method for {@link model.Element#setPosition(int, int)}.
	 */
	@Test
	public final void testSetPosition() {
		Element e = new Element(new ImageIcon("ressource/sprite/bone.png").getImage(), 0, 0);
		e.setPosition(1,1);
	}

}
