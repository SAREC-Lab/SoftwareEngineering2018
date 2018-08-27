package edu.nd.se2018.examples.week1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Run this program to see the difference between the four setup and tear down
 * features provided by org.junit
 * 
 * @author Jane
 *
 */
public class SumNumbersTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After test");
	}

	@Test
	public void test() {
		System.out.println("Running test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("Running test 2");
	}

}
