package JUnitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FirstJUnitTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Before annotation");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After annotation");
	}

	@Test
	public void test() {
		System.out.println("Test annotation");
		String a="b";
		System.out.println(a);
	}
	
	//@Test
	//public void test2() {
		//System.out.println("Test annotation");
	//}

}
