package com.bridgelabz.dataStructure;

import com.bridgelabz.util.Utility;
import com.bridgelabz.dataStructure.Stack;

/**
 * This program checks for primes numbers for given range of inputs. If prime number then checks
 * for anagram, if both the conditions are satisfied then added to the stack and prints the list
 * 
 * @author Sunidhi Haldar
 * created: 2019-11-30   modified:
 */

public class PrimeNumberAnagramUsingStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i <= 1000; i++) {
			if(Utility.isPrime(i))
				stack.push(i);
		}
		
		// stores prime numbers from stack to array
		int size = stack.size;
		int[] array = new int[size];
		for(int i = 0; i < size; i++) {
			array[i] = stack.pop();
		}
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				// checks if prime numbers are anagram or not
				if(Utility.isAnagram(array[i], array[j]) && array[i] != 0 && array[j] != 0) {
					stack.push(array[i]);
					stack.push(array[j]);
				}
			}
		}
		System.out.println("Numbers that are prime and anagram are:");
		stack.print();
	}

}
