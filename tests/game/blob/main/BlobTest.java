/**
 * 
 */
package game.blob.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import android.graphics.Color;

/**
 * @author lancelot
 *
 */
public class BlobTest {
	
	Blob blob;
	Color c;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c = new Color();
		blob = new Blob("name", c);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link game.blob.main.Blob#Blob(java.lang.String, android.graphics.Color)}.
	 */
	@Test
	public void testBlob() {
		assertEquals(blob.getSleepiness(),0);
		assertEquals(blob.getDiscipline(),50);
		assertEquals(blob.getSickliness(),50);
	}

	/**
	 * Test method for {@link game.blob.main.Blob#giveMedication()}.
	 */
	@Test
	public void testGiveMedication() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game.blob.main.Blob#feedMeal()}.
	 */
	@Test
	public void testFeedMeal() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game.blob.main.Blob#feedSnack()}.
	 */
	@Test
	public void testFeedSnack() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game.blob.main.Blob#scold()}.
	 */
	@Test
	public void testScold() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game.blob.main.Blob#clean()}.
	 */
	@Test
	public void testClean() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game.blob.main.Blob#play()}.
	 */
	@Test
	public void testPlay() {
		fail("Not yet implemented");
	}

}
