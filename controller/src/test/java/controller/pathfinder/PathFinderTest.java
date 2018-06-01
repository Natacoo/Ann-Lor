package controller.pathfinder;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PathFinderTest {
	int[][] dataInt = {{0, 0, 0, 0}, {0, 1, 1, 1}, {1, 0, 0, 1}};
	Node start = new Node(0, 0);
	Node end = new Node(2, 2);
	
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
	public final void testPathFinder() {
		assertNotNull(new PathFinder(dataInt));
	}

	@Test
	public final void testIsWalk() {
		PathFinder pF = new PathFinder(dataInt);
		assertNotNull(pF.isWalk(end));
	}

	@Test
	public final void testFindPath() {
		PathFinder pF = new PathFinder(dataInt);
		pF.findPath(start, end);
	}

	@Test
	public final void testGetPath() {
		PathFinder pF = new PathFinder(dataInt);
		pF.findPath(start, end);
	}

}
