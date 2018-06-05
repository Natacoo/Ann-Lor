/**
 * 
 */
package model.bdd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.bdd.BDD;
/**
 * @author Tristan FOCA
 *
 */
public class BDDTest {
	BDD bdd;
	/**
	 @throws java.lang.Exception It's a Exception
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
	 @throws java.lang.Exception It's a Exception
	 */
	@Before
	public void setUp() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		bdd = new BDD();
	}

	/**
	 @throws java.lang.Exception It's a Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.bdd.BDD#BDD()}.
	 */
	@Test
	public final void testBDD() {
		assertNotNull(new BDD());
	}

	/**
	 Test method for {@link model.bdd.BDD#query(java.lang.String, int[])}.
	 */
	@Test
	public final void testQueryStringIntArray() {
		int[] id = {1};
		assertNotNull(bdd.query("{call getMapID(?)}", id));
	}

	/**
	 Test method for {@link model.bdd.BDD#query(java.lang.String, int)}.
	 */
	@Test
	public final void testQueryStringInt() {
		assertNotNull(bdd.query("{call getMapID(?)}", 1));
	}

	/**
	 Test method for {@link model.bdd.BDD#query(java.lang.String)}.
	 */
	@Test
	public final void testQueryString() {
		assertNotNull(bdd.query("{call selectMapAll()}"));
	}

	/**
	 Test method for {@link model.bdd.BDD#query(java.lang.String, java.lang.String[])}.
	 */
	@Test
	public final void testQueryStringStringArray() {
		String[] id = {"1"};
		assertNotNull(bdd.query("{call getMapID(?)}", id));
	}

	/**
	 Test method for {@link model.bdd.BDD#query(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testQueryStringString() {
		assertNotNull(bdd.query("{call getMapID(?)}", "1"));
	}

}
