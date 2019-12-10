package com.bridgelabz.dataStructure;

import com.bridgelabz.util.Utility;
import com.bridgelabz.dataStructure.Queue;

/**
 * Checks for prime for given range of inputs. If number is prime then checks for anagram and if
 * both conditions satisfies then numbers are added to the queue and printed to the list
 * 
 * @author Sunidhi Haldar
 * @created: 2019-12-01   @modified:
 */

public class PrimeNumberAnagramUsingQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		
		// checks for prime and adds them to the list
		for(int i = 0; i <= 1000; i++) {
			if(Utility.isPrime(i))
				queue.enqueue(i);
		}
		
		// stores prime numbers from queue to array
		int size = queue.size();
		int[] array = new int[size];
		for(int i = 0; i < size; i++) {
			array[i] = queue.dequeue();
		}
		
		// checks for prime numbers that are anagram or not
		for(int i = 0; i < size; i++) {
			for(int j = i + 1; j < size; j++) {
				if(Utility.isAnagram(array[i], array[j]) && array[i] != 0 && array[j] != 0) {
					queue.enqueue(array[i]);
					queue.enqueue(array[j]);
				}
			}
		}
		System.out.println("Numbers that are prime and anagram are:");
		queue.print();
	}

}
