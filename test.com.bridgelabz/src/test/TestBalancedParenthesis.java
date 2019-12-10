package src.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bridgelabz.dataStructure.BalancedParenthesis;

class TestBalancedParenthesis {

 /* 	@Test
	void test() {
		fail("Not yet implemented");
	} */

	@Test
	public void test_balancedParenthesis_positiveInput() {
		assertTrue(BalancedParenthesis.isBalanced("(5+6)*(7+8)/(4+3)(5+6)*(7+8)/(4+3)"));
	}
	
	@Test
	public void test_balancedParenthesis_negativeInput_removeLastBracket() {
		assertFalse(BalancedParenthesis.isBalanced("(5+6)*(7+8)/(4+3)(5+6)*(7+8)/(4+3"));
	}
	
	@Test
	public void test_balancedParenthesis_whenEmpty() {
		assertFalse(BalancedParenthesis.isBalanced(""));
	}
	
	@Test
	public void test_balancedParenthesis_withDifferentTypeOfBracket() {
		assertTrue(BalancedParenthesis.isBalanced("(5+6)*(7+8)/(4+3)(5+6)*{7+8}/(4+3)"));
	}
	
}
