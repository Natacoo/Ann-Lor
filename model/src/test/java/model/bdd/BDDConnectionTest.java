package model.bdd;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.bdd.BDDConnection;
/**
 * 
 * @author Tristan FOCA
 * @version 06/04/2018
 */
public class BDDConnectionTest {
	BDDConnection bdd;
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
		bdd = new BDDConnection();
	}

	/**
	 * @throws java.lang.Exception It's a Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.bdd.BDDConnection#BDDConnection()}.
	 */
	@Test
	public final void testBDDConnection() {
		assertNotNull(new BDDConnection());
	}

	/**
	 * Test method for {@link model.bdd.BDDConnection#close()}.
	 */
	@Test
	public final void testClose() {
		BDDConnection bdd = new BDDConnection();
		assertTrue(bdd.close());
	}

	/**
	 * Test method for {@link model.bdd.BDDConnection#getConnection()}.
	 */
	@Test
	public final void testGetConnection() {
		BDDConnection bdd = new BDDConnection();
		assertNotNull(bdd.getConnection());
	}

}
