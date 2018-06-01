package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.*;
import controller.Controller;
import controller.mock.ModelMock;
import controller.mock.ViewMock;

public class ControllerTest {
	Controller controller;
	IModel modelMock = new ModelMock();
	IView viewMock = new ViewMock();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.controller = new Controller(viewMock, modelMock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testController() {
		assertNotNull(controller);
	}
	
	@Test
	public final void testInitPathFinder() {
		controller.initPathFinder();
	}
	
	@Test
	public final void testStartTick() {
		controller.startTick();
	}
	
	@Test
	public final void testUpdate() {
		controller.update(1);
	}
	
	@Test
	public final void testMouveBackground() {
		controller.mouveBackground();
	}
	
	@Test
	public final void testSetView() {
		controller.setView(viewMock);
	}
	
	@Test
	public final void testSetModel() {
		controller.setModel(modelMock);
	}
	
	@Test
	public final void testGetView() {
		assertNotNull(controller.getView());
	}
	
	@Test
	public final void testGetModel() {
		assertNotNull(controller.getModel());
	}
	
	@Test
	public final void testGetEntitie() {
		assertNotNull(controller.getEntitie(0, 0));
	}

	@Test
	public final void testKeyEvent(){
		controller.keyEvent(1);
	}

	@Test
	public final void testMove() {
		controller.move(1, TypeEntitie.MONSTER, controller.getEntitie(0, 0));
	}

	@Test
	public final void testAction() {
		controller.action(1);
	}


}
