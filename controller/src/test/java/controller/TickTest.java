package controller;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TickTest {

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
	public final void testTick() {
		Controller i = null;
		assertNotNull(new Tick(i));
	}

	@Test
	public final void testRun() {
		Controller i = null;
		Tick t = new Tick(i);
		t.run();
	}

}
