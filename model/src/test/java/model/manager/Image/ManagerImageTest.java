package model.manager.Image;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.bdd.BDD;
import model.manager.image.ManagerImage;
/**
 * 
 * @author Tristan FOCA
 * @version 06/04/2018
 */
public class ManagerImageTest {
	ManagerImage mI;
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
		Class.forName("com.mysql.jdbc.Driver");
		 mI = new ManagerImage(new BDD());
	}

	/**
	 * @throws java.lang.Exception It's a Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.manager.image.ManagerImage#ManagerImage(model.bdd.BDD, String)}.
	 */
	@Test
	public final void testManagerImage() {
		assertNotNull(mI);
	}

	/**
	 * Test method for {@link model.manager.image.ManagerImage#getImagesElements()}.
	 */
	@Test
	public final void testGetImagesElements() {
		assertNotNull(mI.getImagesElements());
	}

	/**
	 * Test method for {@link model.manager.image.ManagerImage#getImagesEntities()}.
	 */
	@Test
	public final void testGetImagesEntities() {
		assertNotNull(mI.getImagesEntities());
	}

	/**
	 * Test method for {@link model.manager.image.ManagerImage#getImagesParticules()}.
	 */
	@Test
	public final void testGetImagesParticules() {
		assertNotNull(mI.getImagesParticules());
	}

	/**
	 * Test method for {@link model.manager.image.ManagerImage#getRessource()}.
	 */
	@Test
	public final void testGetRessource() {
		assertNotNull(mI.getRessource());
	}

	/**
	 * Test method for {@link model.manager.image.ManagerImage#getSound()}.
	 */
	/*@Test
	public final void testGetSound() {
		assertNotNull(mI.getSound());
	}*/

}
