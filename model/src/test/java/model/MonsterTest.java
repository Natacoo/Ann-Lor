package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Image;
import java.awt.image.BufferedImage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Tristan FOCA
 * @version 06/04/2018
 */
public class MonsterTest {
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
	 * Test method for {@link model.Monster#getBonus()}.
	 */
	@Test
	public final void testGetBonus() {
		Monster m = new Monster(sprite);
		assertEquals(500, m.getBonus());
	}

	/**
	 * Test method for {@link model.Monster#Monster(java.awt.Image)}.
	 */
	@Test
	public final void testMonster() {
		assertNotNull(new Monster(sprite));
	}

	/**
	 * Test method for {@link model.Monster#setBonus(int)}.
	 */
	@Test
	public final void testSetBonus() {
		Monster m = new Monster(sprite);
		m.setBonus(500000);
	}

}
