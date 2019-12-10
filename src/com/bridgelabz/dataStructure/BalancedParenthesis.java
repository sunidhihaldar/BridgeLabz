package com.bridgelabz.dataStructure;

import com.bridgelabz.dataStructure.Stack;

/**
 * Stack class to push open parenthesis "(" and pop closed parenthesis ")". 
 * At the end of the expression if the stack is empty the arithmetic expression is balanced.
 * Stack class methods are stack(), push(), pop(), peak(), isEmpty(), size()
 * 
 * @author Sunidhi Haldar
 * created 2019-12-25
 * @version 13.0.1
 */

public class BalancedParenthesis {
	
	/**
	 * This method checks the parenthesis and does required actions like push or pop
	 * 
	 * @param inputString to check whether the input is balanced or not
	 * @return boolean value
	 */

	public static boolean isBalanced(String inputString) {
		Stack<Character> stack = new Stack<Character>();
		if(inputString.isEmpty()) {
			System.out.println("String is epmty");
			return false;
		}
		for(int i = 0; i < inputString.length(); i++) {
			/**
			 * Push open parenthesis '(' and pop closed parenthesis ')'. At the end of the
			 * expression if the stack is empty then the arithmetic expression is balanced
			 */
			char checkCharacter = inputString.charAt(i);
			if(checkCharacter == '(')
				stack.push(inputString.charAt(i));
			else if(checkCharacter == ')')
				stack.pop();
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String input = "(5+6)*(7+8)/(4+3)(5+6)*(7+8)/(4+3)";
		String result = (isBalanced(input)) ? "Balanced" : "Not balanced";
		System.out.println("Input string is: " + input);
		System.out.println("Result: " + result);

	}

}
