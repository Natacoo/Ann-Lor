/**
 * 
 */
package contract;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.GraphUtil;

/**
 * @author Tristan FOCA
 * @version 06/04/2018
 */
public class GraphUtilTest {

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
	}

	/**
	 * @throws java.lang.Exception It's a Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link contract.GraphUtil#StringWithBorder(java.awt.Graphics, java.lang.String, int, int)}.
	 */
	@Test
	public final void testStringWithBorderGraphicsStringIntInt() {
		BufferedImage image = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
		GraphUtil.StringWithBorder(image.getGraphics(), "Test", 50, 50);
	}

	/**
	 * Test method for {@link contract.GraphUtil#StringWithBorder(java.awt.Graphics, java.lang.String, int, int, java.awt.Color)}.
	 */
	@Test
	public final void testStringWithBorderGraphicsStringIntIntColor() {
		BufferedImage image = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
		GraphUtil.StringWithBorder(image.getGraphics(), "Test", 50, 50, Color.red);
	}

	/**
	 * Test method for {@link contract.GraphUtil#StringWithBorder(java.awt.Graphics, java.lang.String, int, int, java.awt.Color, java.awt.Color)}.
	 */
	@Test
	public final void testStringWithBorderGraphicsStringIntIntColorColor() {
		BufferedImage image = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
		GraphUtil.StringWithBorder(image.getGraphics(), "Test", 50, 50, Color.red, Color.blue);
	}

}
