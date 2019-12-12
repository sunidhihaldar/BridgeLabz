package com.bridgelabz.dataStructure;

import java.util.EmptyStackException;

/**
 * This program implements Stack functions which is a linear data structure and it follows
 * LIFO => Last In First Out
 * 
 * @author sunidhi Haldar
 * @created 2019-11-28
 * @version 13.0.1
 * @param <G> generic type
 */

public class Stack<G> {
	Node<G> top;
	int size;
	
	/**
	 * Costructor for the Stack class which initializes top and size
	 * 
	 * @variable top is the reference type variable which points to top of the Stack
	 * @variable size stores the length of the Satck
	 */
	
	public Stack() {
		this.top = null;
		this.size = 0;
	}
	
	/**
	 * Returns the list size
	 * @return integer value
	 */
	
	public int size() {
		return size;
	}
	
	/**
	 * To check if the list is empty
	 * @return boolean value
	 */
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Node class object is created and allocated memory with data given by the user and its next
	 * pints to null. Reference variable top points to the top of the list. Length is incremented
	 * after insertion.
	 * 
	 * @param data of generic type as input data
	 */
	
	public void push(G data) {
		Node<G> newNode = new Node<G>(data);
		newNode.next = top;
		top = newNode;
		size++;
	}
	
	/**
	 * If list is empty, throws an exception. If list is not empty, then the list's top data
	 * is removed and length is decremented.
	 * 
	 * @return data of generic type
	 */
	
	public G pop() {
		if(isEmpty())
			throw new EmptyStackException();
		G removedData = top.data;
		top = top.next;
		size--;
		return removedData;
	}
	
	/**
	 * If the list is not empty, then it returns the value pointed by top.
	 * @return the data of generic type
	 */
	
	public G peek() {
		if(!isEmpty())
			return top.data;
		else
			throw new EmptyStackException();
	}

	// If list not empty, prints all the elements of the stack
	public void print() {
		if(isEmpty())
			System.out.println("Empty stack");
		else {
			Node<G> current = top;
			while(current != null) {
				System.out.println(current.data + " --> ");
				current = current.next;
			}
			System.out.println("null");
		}
	}
	
}
