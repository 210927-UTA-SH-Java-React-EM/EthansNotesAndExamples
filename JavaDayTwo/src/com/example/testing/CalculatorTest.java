package com.example.testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {
	
	static Calculator calc;
	
	@BeforeClass
	public static void setupBeforeClass() throws Exception {
		System.out.println("This runs before any test once");
		calc = new Calculator();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("This runs after the entire test class is finished");
	}
	
	@Before
	public void setup() throws Exception{
		System.out.println("This runs before every test");
	}
	
	@After
	public void tearDown() throws Exception{
		System.out.println("This runs after every test");
	}
	
	@Test
	public void postitiveAdditionTest() {
		//assertEquals(String message, exepected, actual)
		assertEquals("Testing 2+2=4", 4, calc.add(2, 2));
	}
	
	@Test
	public void negativeAdditionTest() {
		assertNotEquals(4, calc.add(2, 3));
	}
	
	//If we want to ignore a test we can use @Ignore
	//@Ignore
	@Test
	public void subTest() {
		assertEquals(2, calc.sub(3, 1));
	}
	
	//If we want to check for an exception we can do the following
	@Test(expected = ArithmeticException.class)
	public void testDivideByZero() {
		calc.div(2, 0);
	}

}
