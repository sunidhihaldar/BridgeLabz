package com.bridgelabz.dataStructure;

/**
 * This program based on node consisting of data type variable and reference type variable
 * @author Sunidhi Haldar
 * @created 22.11.2019
 * @version 13.0.1
 */

public class Node<G> {
	G data;
	Node<G> next;
	
	/**
	 * Node() constructor is used to initialize the class variable during object creation
	 * @param data is passed as a parameter to constructor
	 */
	public Node(G data) {
		this.data = data;
		this.next = null;
	}
	
	public G getData() {
		return data;
	}
	
	public Node<G> getNext() {
		return next;
	}
}
