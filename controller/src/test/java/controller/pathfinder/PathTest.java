package controller.pathfinder;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PathTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testPathPath() {
		assertNotNull(new Path(new Path(0, 0, null, 0)));
	}

	@Test
	public final void testPathIntIntPathInt() {
		assertNotNull(new Path(0, 0, null, 0));
	}

	@Test
	public final void testGetParent() {
		Path p = new Path(0, 1, new Path(0, 0, null, 0), 0);
		assertNotNull(p.getParent());
	}

	@Test
	public final void testSetParent() {
		Path p = new Path(0, 1, null, 0);
		p.setParent(new Path(0, 1, null, 0));
	}

	@Test
	public final void testGetValue() {
		Path p = new Path(0, 1, null, 1);
		assertNotNull(p.getValue());
	}

	@Test
	public final void testSetValue() {
		Path p = new Path(0, 1, null, 1);
		p.setValue(4);
	}

}
