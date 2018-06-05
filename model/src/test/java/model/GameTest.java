package model;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.StateGame;
import contract.StateHero;

/**
 * @author Tristan FOCA
 * @version 06/04/2018
 */
public class GameTest {

	/**
	 * @throws java.lang.Exception It's a exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception It's a exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception It's a exception
	 */
	@Before
	public void setUp() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
	}

	/**
	 * @throws java.lang.Exception It's a exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.Game#Game()}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testGame() {
		assertNotNull(new Game());
	}

	/**
	 * Test method for {@link model.Game#loadMap(int)}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testLoadMap() {
		Game g = new Game();
		g.loadMap(1);
	}

	/**
	 * Test method for {@link model.Game#changed()}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testChanged() {
		Game g = new Game();
		g.changed();
	}

	/**
	 * Test method for {@link model.Game#getMap()}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testGetMap() {
		Game g = new Game();
		g.getMap();
	}

	/**
	 * Test method for {@link model.Game#getElement(int, int)}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testGetElement() {
		Game g = new Game();
		g.getElement(0, 0);
	}

	/**
	 * Test method for {@link model.Game#getMenu(java.awt.Graphics)}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testGetMenu() {
		Game g = new Game();
		BufferedImage e = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
		g.getMenu(e.getGraphics());
	}

	/**
	 * Test method for {@link model.Game#getGameOver(java.awt.Graphics)}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testGetGameOver() {
		Game g = new Game();
		BufferedImage e = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
		g.getGameOver(e.getGraphics());
	}

	/**
	 * Test method for {@link model.Game#addParticule(int, contract.StateHero, contract.IEntitie)}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testAddParticule() {
		Game g = new Game();
		BufferedImage e = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
		g.addParticule(1, StateHero.DOWN, new Hero(e.getSubimage(0, 0, 50, 50)));
		
	}

	/**
	 * Test method for {@link model.Game#getState()}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testGetState() {
		Game g = new Game();
		assertNotNull(g.getState());
	}

	/**
	 * Test method for {@link model.Game#setState(contract.StateGame)}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testSetState() {
		Game g = new Game();
		g.setState(StateGame.GAMEOVER);
	}

	/**
	 * Test method for {@link model.Game#getMaps()}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testGetMaps() {
		Game g = new Game();
		assertNotNull(g.getMaps());
	}

	/**
	 * Test method for {@link model.Game#getLevel()}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testGetLevel() {
		Game g = new Game();
		assertNotNull(g.getLevel());
	}

	/**
	 * Test method for {@link model.Game#setLevel(int)}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testSetLevel() {
		Game g = new Game();
		g.setLevel(0);
	}

	/**
	 * Test method for {@link model.Game#getCoordinateXBackground()}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testGetCoordinateXBackground() {
		Game g = new Game();
		assertEquals(0, g.getCoordinateXBackground());
	}

	/**
	 * Test method for {@link model.Game#getCoordinateYBackground()}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testGetCoordinateYBackground() {
		Game g = new Game();
		assertEquals(0, g.getCoordinateYBackground());
	}

	/**
	 * Test method for {@link model.Game#setCoordinateXBackground(int)}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testSetCoordinateXBackground() {
		Game g = new Game();
		g.setCoordinateXBackground(5);
		assertEquals(5, g.getCoordinateXBackground());
	}

	/**
	 * Test method for {@link model.Game#setCoordinateYBackground(int)}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testSetCoordinateYBackground() {
		Game g = new Game();
		g.setCoordinateYBackground(5);
		assertEquals(5, g.getCoordinateYBackground());
	}

	/**
	 * Test method for {@link model.Game#setDirectionBackground(int)}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testSetDirectionBackground() {
		Game g = new Game();
		g.setDirectionBackground(1);
		assertEquals(1, g.getDirectionBackground());
	}

	/**
	 * Test method for {@link model.Game#getDirectionBackground()}.
	 */
	@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testGetDirectionBackground() {
		Game g = new Game();
		assertEquals(7, g.getDirectionBackground());
	}

	/**
	 * Test method for {@link model.Game#playMusic(java.lang.String, boolean)}.
	 */
	/*@Test (expected = java.lang.IllegalArgumentException.class)
	public final void testPlayMusic() {
		Game g = new Game();
		g.playMusic("menu", false);
	}*/

	/**
	 * Test method for {@link model.Game#playEffect(java.lang.String)}.
	 */
	/*@Test (expected = java.lang.IllegalArgumentException.class) 
	public final void testPlayEffect() {
		Game g = new Game();
		g.playEffect("key");
	}*/
}
