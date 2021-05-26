package com.project1.test;






import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.project1.Dao.UsersDao;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

//import com.example.calculator.Calculator;

@TestMethodOrder(OrderAnnotation.class)

public class Project1Test {
	
	//private Calculator calc;
	
	//private UsersDao calc;
	
	UsersDao calc = new UsersDao();

	
	
	@Test
	@Order(1)
	public void validateUser2() {
		System.out.println("in add test");
		assertEquals(false, calc.validateUser("neethu", "yuy"), "this is the the tset 2 for validate user"); //assertEquals(expectedValue, actualValue, fail string)
	
	
	}
	
	@Test
	@Order(2)
	public void validateUser5() {
		System.out.println("in add test");
		assertEquals(true, calc.validateUser("neethu", "neethu"), "this is the the tset 5 for validate user with positive inputs"); //assertEquals(expectedValue, actualValue, fail string)
	
	
	}
	
	
	@Test
	@Order(3)
	public void validateUser1() {
		System.out.println("in add test");
		assertEquals("False", calc.validateUser("neethu", "yuy"), "this is the the test 1 for validate user"); //assertEquals(expectedValue, actualValue, fail string)
	
	
	}
	
	



	@Test
	@Order(4)
	public void validateUser3() {
		System.out.println("in add test");
		assertEquals(true, calc.validateUser("neethu", "yuy"), "this is the the tset  3 for validate user"); //assertEquals(expectedValue, actualValue, fail string)
	
	
	}
	
	
	
	@Test
	@Order(5)
	public void validateUser4() {
		System.out.println("in add test");
		assertEquals("True", calc.validateUser("neethu", "yuy"), "this is the the tset 4 for validate user"); //assertEquals(expectedValue, actualValue, fail string)
	
	
	}
	

	
	
	

}
