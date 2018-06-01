package controller.pathfinder;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NodeTest {

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
	public final void testNodeNode() {
		assertNotNull(new Node(new Node(1, 1)));
	}

	@Test
	public final void testNodeIntInt() {
		assertNotNull(new Node(1, 1));
	}

	@Test
	public final void testGetX() {
		Node n = new Node(1, 1);
		assertEquals(1, n.getX());
	}

	@Test
	public final void testGetY() {
		Node n = new Node(1, 1);
		assertEquals(1, n.getY());
	}

	@Test
	public final void testSetX() {
		Node n = new Node(1, 1);
		n.setX(0);
	}

	@Test
	public final void testSetx() {
		Node n = new Node(1, 1);
		n.setY(0);
	}

}
