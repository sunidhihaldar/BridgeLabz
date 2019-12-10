package com.bridgelabz.dataStructure;

import java.util.NoSuchElementException;

/**
 * It is a linear data structure of generic Type which is used to store
 * data.This class has certain functions like size() => length of the list
 * isEmpty() => which checks whether the list is empty or not. addFront() =>
 * insert a data in the front position of list. addLast() => insert a data in
 * the last position of list. print => to get the list of data present.
 * deleteFront() => delete a data in the front position of list. deleteLast() =>
 * delete data in the last position of list.
 * 
 * @author Sunidhi Haldar
 * @created 2019-11-26
 * @version 13.0.1
 * @param <G> generic type
 */

public class Deque<G> {
	public static class Node<G> {
		G data;
		Node<G> next;
		Node<G> previous;
		
		/**
		 * Public inner class which initializes a new Node with next pointer and
		 * previous pointer and data set by the user at the time of object creation
		 *
		 * @param <G> generic type
		 */
		
		public Node(G data) {
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}
	
	Node<G> front;
	Node<G> rear;
	int size;
	
	// constructor which initializes the variables
	public Deque() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}
	
	/**
	 * when size of list is 0 it returns boolean value
	 * 
	 * @return Boolean value
	 */
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * It returns the size of the Queue.
	 * 
	 * @return Integer value
	 */
	
	public int size() {
		return size;
	}
	
	/**
	 * If the Dequeue is empty it add the node at front which is referenced by both
	 * front and rear, else it add the randomly created node at front of the list
	 * 
	 * @param data takes generic type data as input given by user.
	 */
	
	public void addFront(G data) {
		Node<G> newNode = new Node<G>(data);
		if(isEmpty())
			rear = newNode;
		else
			front.previous = newNode;
		newNode.next = front;
		front = newNode;
		size++;
	}
	
	public void addLast(G data) {
		Node<G> newNode = new Node<G>(data);
		if(isEmpty())
			front = newNode;
		else {
			rear.next = newNode;
			newNode.previous = rear;
		}
		rear = newNode;
		size++;
	}
	
	/**
	 * if Dequeue is empty it throws exception, if only one node is present it
	 * removes it else remove the first node
	 * 
	 * @return <G> value of Class type
	 * @throws NoSuchElementException if list is empty
	 */
	
	public G deleteFirst() {
		if(isEmpty())
			throw new NoSuchElementException("Empty deque");
		Node<G> temporaryNode = front;
		if(front == rear)
			rear = null;
		else
			front.next.previous = null;
		front = front.next;
		temporaryNode.next = null;
		size--;
		return temporaryNode.data;
	}
	
	public G deleteLast() {
		if(isEmpty())
			throw new NoSuchElementException("Empty deque");
		Node<G> temporaryNode = rear;
		if(front == rear)
			front = null;
		else
			rear.previous.next = null;
		rear = rear.previous;
		temporaryNode.previous = null;
		size--;
		return temporaryNode.data;
	}
	
	public void display() {
		Node<G> current = front;
		while(current != null) {
			System.out.println(current.data +" --> ");
			current = current.next;
		}
		System.out.println("null");
	}
}
