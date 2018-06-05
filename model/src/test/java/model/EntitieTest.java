package model;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.TypeEntitie;

/**
 * @author Tristan FOCA
 * @version 06/04/2018
 */
public class EntitieTest {

	/**
	 * @throws java.lang.Exception It's a Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception It's a Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception It's a Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception It's a Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.Entitie#Entitie(java.awt.Image)}.
	 */
	@Test
	public final void testEntitie() {
		assertNotNull(new Entitie(new ImageIcon("ressource/sprite/bone.png").getImage()));
	}

	/**
	 * Test method for {@link model.Entitie#setPosition(int, int)}.
	 */
	@Test
	public final void testSetPosition() {
		Entitie e = new Entitie(new ImageIcon("ressource/sprite/bone.png").getImage());
		e.setPosition(1,1);
	}

	/**
	 * Test method for {@link model.Entitie#getX()}.
	 */
	@Test
	public final void testGetX() {
		Entitie e = new Entitie(new ImageIcon("ressource/sprite/bone.png").getImage());
		assertNotNull(e.getX());
	}

	/**
	 * Test method for {@link model.Entitie#getY()}.
	 */
	@Test
	public final void testGetY() {
		Entitie e = new Entitie(new ImageIcon("ressource/sprite/bone.png").getImage());
		assertNotNull(e.getY());
	}

	/**
	 * Test method for {@link model.Entitie#getTypeEntitie()}.
	 */
	@Test
	public final void testGetTypeEntitie() {
		Entitie e = new Entitie(new ImageIcon("ressource/sprite/bone.png").getImage());
		e.setTytpeEntitie(TypeEntitie.MONSTER);
		assertNotNull(e.getTypeEntitie());
	}

	/**
	 * Test method for {@link model.Entitie#update()}.
	 */
	@Test
	public final void testUpdate() {
		Entitie e = new Entitie(new ImageIcon("ressource/sprite/bone.png").getImage());
		e.update();
	}

	/**
	 * Test method for {@link model.Entitie#draw(java.awt.Graphics)}.
	 */
	@Test
	public final void testDraw() {
		Entitie e = new Entitie(new ImageIcon("ressource/sprite/bone.png").getImage());
		BufferedImage g = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
		e.draw(g.getGraphics());
	}

	/**
	 * Test method for {@link model.Entitie#setTytpeEntitie(contract.TypeEntitie)}.
	 */
	@Test
	public final void testSetTytpeEntitie() {
		Entitie e = new Entitie(new ImageIcon("ressource/sprite/bone.png").getImage());
		e.setTytpeEntitie(TypeEntitie.MONSTER);
	}

	/**
	 * Test method for {@link model.Entitie#isMove(long)}.
	 */
	@Test
	public final void testIsMove() {
		Entitie e = new Entitie(new ImageIcon("ressource/sprite/bone.png").getImage());
		assertFalse(e.isMove(2));
	}

	/**
	 * Test method for {@link model.Entitie#getBonus()}.
	 */
	@Test
	public final void testGetBonus() {
		Entitie e = new Entitie(new ImageIcon("ressource/sprite/bone.png").getImage());
		assertEquals(500, e.getBonus());
	}

	/**
	 * Test method for {@link model.Entitie#setSpeed(int)}.
	 */
	@Test
	public final void testSetSpeed() {
		Entitie e = new Entitie(new ImageIcon("ressource/sprite/bone.png").getImage());
		e.setSpeed(5);
	}
}
