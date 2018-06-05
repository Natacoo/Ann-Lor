/**
 * 
 */
package model;

import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.image.BufferedImage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author Tristan FOCA
 * @version 06/04/2018
 */
public class ParticuleTest {
	Image sprite;
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
		sprite = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB).getSubimage(0, 0, 50, 50);
	}

	/**
	 * @throws java.lang.Exception Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.Particule#Particule(int, int, java.awt.Image[], int, int)}.
	 */
	@Test
	public final void testParticule() {
		Image[] sprites = {sprite, sprite};
		assertNotNull(new Particule(1, 2, sprites, 1, 1));
	}

	/**
	 * Test method for {@link model.Particule#move()}.
	 */
	@Test
	public final void testMove() {
		Image[] sprites = {sprite, sprite};
		Particule p = new Particule(1, 2, sprites, 1, 1);
		p.move();
		p.setDirection(1);
		p.move();
		p.setDirection(3);
		p.move();
		p.setDirection(4);
		p.move();
	}

	/**
	 * Test method for {@link model.Particule#draw(java.awt.Graphics)}.
	 */
	@Test
	public final void testDraw() {
		Image[] sprites = {sprite, sprite};
		Particule p = new Particule(1, 2, sprites, 1, 1);
		BufferedImage g = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
		p.draw(g.getGraphics());
	}

	/**
	 * Test method for {@link model.Particule#isLife()}.
	 */
	@Test
	public final void testIsLife() {
		Image[] sprites = {sprite, sprite};
		Particule p = new Particule(1, 2, sprites, 1, 1);
		assertFalse(p.isLife());
		p.move();
		assertTrue(p.isLife());
	}

	/**
	 * Test method for {@link model.Particule#setDirection(int)}.
	 */
	@Test
	public final void testSetDirection() {
		Image[] sprites = {sprite, sprite};
		Particule p = new Particule(1, 2, sprites, 1, 1);
		p.setDirection(1);
	}

	/**
	 * Test method for {@link model.Particule#getX()}.
	 */
	@Test
	public final void testGetX() {
		Image[] sprites = {sprite, sprite};
		Particule p = new Particule(1, 2, sprites, 1, 1);
		assertEquals(1, p.getX());
	}

	/**
	 * Test method for {@link model.Particule#getY()}.
	 */
	@Test
	public final void testGetY() {
		Image[] sprites = {sprite, sprite};
		Particule p = new Particule(1, 2, sprites, 1, 1);
		assertEquals(1, p.getY());
	}

}
