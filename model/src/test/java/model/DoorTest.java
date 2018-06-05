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
public class DoorTest {
	Image sprite;
	/**
	 * @throws java.lang.Exception It's an exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception It's an exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception It's an exception
	 */
	@Before
	public void setUp() throws Exception {
		sprite = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB).getSubimage(0, 0, 50, 50);
	}

	/**
	 * @throws java.lang.Exception It's an exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.Door#Door(java.awt.Image, int, int, java.awt.Image[])}.
	 */
	@Test
	public final void testDoor() {
		Image[] image = {sprite, sprite};
		assertNotNull(new Door(sprite, 1, 1, image));
	}

	/**
	 * Test method for {@link model.Door#isState()}.
	 */
	@Test
	public final void testIsState() {
		Image[] image = {sprite, sprite};
		Door d = new Door(sprite, 1, 1, image);
		assertFalse(d.isState());
	}

	/**
	 * Test method for {@link model.Door#setOpen()}.
	 */
	@Test
	public final void testSetOpen() {
		Image[] image = {sprite, sprite};
		Door d = new Door(sprite, 1, 1, image);
		d.setOpen();
	}

}
