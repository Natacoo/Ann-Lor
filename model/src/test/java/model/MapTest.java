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
public class MapTest {
	Image sprite;
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
		sprite = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB).getSubimage(0, 0, 50, 50);
	}

	/**
	 * @throws java.lang.Exception It's a exception
	 */
	@After
	public void tearDown() throws Exception {
	}


	/**
	 * Test method for {@link model.Map#Map()}.
	 */
	@Test
	public final void testMap() {
		assertNotNull(new Map());
	}

	/**
	 * Test method for {@link model.Map#setElement(int, int, model.Element)}.
	 */
	@Test
	public final void testSetElement() {
		Map m = new Map();
		m.setElement(0, 0, new Element(sprite, 1, 1));
	}

	/**
	 * Test method for {@link model.Map#getElements()}.
	 */
	@Test
	public final void testGetElements() {
		Map m = new Map();
		assertNotNull(m.getElements());
	}

	/**
	 * Test method for {@link model.Map#getElement(int, int)}.
	 */
	@Test
	public final void testGetElement() {
		Map m = new Map();
		m.setElement(0, 0, new Element(sprite, 1, 1));
		assertNotNull(m.getElement(0, 0));
	}

	/**
	 * Test method for {@link model.Map#getEntities()}.
	 */
	@Test
	public final void testGetEntities() {
		Map m = new Map();
		assertNotNull(m.getEntities());
	}

	/**
	 * Test method for {@link model.Map#getEntite(int)}.
	 */
	@Test
	public final void testGetEntite() {
		Map m = new Map();
		m.addEntite(new Entitie(sprite));
		assertNotNull(m.getEntite(0));
	}

	/**
	 * Test method for {@link model.Map#addEntite(model.Entitie)}.
	 */
	@Test
	public final void testAddEntite() {
		Map m = new Map();
		m.addEntite(new Entitie(sprite));
	}

	/**
	 * Test method for {@link model.Map#getHero()}.
	 */
	@Test
	public final void testGetHero() {
		Map m = new Map();
		m.setHero(new Entitie(sprite));
		assertNotNull(m.getHero());
	}

	/**
	 * Test method for {@link model.Map#setHero(contract.IEntitie)}.
	 */
	@Test
	public final void testSetHero() {
		Map m = new Map();
		m.setHero(new Entitie(sprite));
	}

	/**
	 * Test method for {@link model.Map#getParticule()}.
	 */
	@Test
	public final void testGetParticule() {
		Map m = new Map();
		Image[] sprites = {sprite, sprite};
		m.addParticule(new Particule(0, 1, sprites, 1, 2));
		assertNotNull(m.getParticule());
	}

	/**
	 * Test method for {@link model.Map#addParticule(contract.IParticule)}.
	 */
	@Test
	public final void testAddParticule() {
		Map m = new Map();
		Image[] sprites = {sprite, sprite};
		m.addParticule(new Particule(0, 1, sprites, 1, 2));
	}

	/**
	 * Test method for {@link model.Map#getScore()}.
	 */
	@Test
	public final void testSetScore() {
		Map m = new Map();
		m.setScore(50000000);
	}

	/**
	 * Test method for {@link model.Map#setScore(int)}.
	 */
	@Test
	public final void testGetScore() {
		Map m = new Map();
		assertEquals(0, m.getScore());
	}

}
