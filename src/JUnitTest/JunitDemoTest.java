package JUnitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class JunitDemoTest {
	
	
	@AfterClass
	public static void tearDownAfterClass(){
		System.out.println("runs after everything");	
	}
	
	@BeforeClass
	public static void setUpBeforeClass(){
		System.out.println("Runs before everything");
	}
	
	@After
	public void tearDown(){
		System.out.println("after test");
	}
	
	@Before
	public void setUp(){
		System.out.println("Before test");
	}
	


	@Test
	public void test() {
		FirstJUnitTest first=new FirstJUnitTest();
		first.test();
		
		System.out.println("test 1");
		assertTrue(true);
		
	}
	
	@Test
	public void assertsFalse(){
		System.out.println("test 2");
		assertFalse(false);
	}
	
	@Test
	public void assertEquality(){
		System.out.println("test 3");
		assertEquals(1, 1);
	}

	public boolean alwaysFalse(){
		return false;
	}
}
