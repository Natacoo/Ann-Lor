package model;

import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.image.BufferedImage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.StateHero;
/**
 * 
 * @author Tristan FOCA
 * @version 06/04/2018
 */
public class HeroTest {
	Image sprite;

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
		sprite = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB).getSubimage(0, 0, 50, 50);
	}

	/**
	 * @throws java.lang.Exception It's a Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.Hero#Hero(java.awt.Image)}.
	 */
	@Test
	public final void testHero() {
		assertNotNull(new Hero(sprite));
	}

	/**
	 * Test method for {@link model.Hero#setSprite(java.awt.Image[])}.
	 */
	@Test
	public final void testSetSprite() {
		Hero h = new Hero(sprite);
		Image sprites[] = {sprite, sprite};
		h.setSprite(sprites);
	}

	/**
	 * Test method for {@link model.Hero#isStateSpell()}.
	 */
	@Test
	public final void testIsStateSpell() {
		Hero h = new Hero(sprite);
		assertTrue(h.isStateSpell());
	}

	/**
	 * Test method for {@link model.Hero#setStateSpell(boolean)}.
	 */
	@Test
	public final void testSetStateSpell() {
		Hero h = new Hero(sprite);
		h.setStateSpell(true);
	}

	/**
	 * Test method for {@link model.Hero#setState(contract.StateHero)}.
	 */
	@Test
	public final void testSetState() {
		Hero h = new Hero(sprite);
		Image sprites[] = {sprite, sprite};
		h.setSprite(sprites);
		h.setState(StateHero.DOWN);
	}

	/**
	 * Test method for {@link model.Hero#getImage()}.
	 */
	@Test
	public final void testGetImage() {
		Hero h = new Hero(sprite);
		Image sprites[] = {sprite, sprite};
		h.setSprite(sprites);
		h.setStateImage(StateHero.UP);
		assertNotNull(h.getImage());
	}

	/**
	 * Test method for {@link model.Hero#setImage(java.awt.Image)}.
	 */
	@Test
	public final void testSetImage() {
		Hero h = new Hero(sprite);
		h.setImage(sprite);
	}

	/**
	 * Test method for {@link model.Hero#setStateImage(contract.StateHero)}.
	 */
	@Test
	public final void testSetStateImage() {
		Hero h = new Hero(sprite);
		Image sprites[] = {sprite, sprite};
		h.setSprite(sprites);
		h.setStateImage(StateHero.DOWN);
	}

	/**
	 * Test method for {@link model.Hero#getState()}.
	 */
	@Test
	public final void testGetState() {
		Hero h = new Hero(sprite);
		assertNotNull(h.getState());
	}

}
