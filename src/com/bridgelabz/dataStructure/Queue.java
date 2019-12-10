package com.bridgelabz.dataStructure;

import java.util.NoSuchElementException;

/**
 * A program to implement Queue 
 * @author Sunidhi Haldar
 * @created 25.11.2019
 * @version 13.0.1
 * @param <G> is the genric user defined type
 */

public class Queue<G> {
	
	// @param front is the end at which deletion happens
	 Node<G> front;
	 
	 // @param rear is the end at which insertion happens
	 Node<G> rear;
	 
	 // @param length stores the number of elements in the queue
	 int size;
	 
	 // constructor for the Queue class which initializes front, rear and size
	 public Queue() {
		 this.front = null;
		 this.rear = null;
		 this.size = 0;
	 }
	 
	 /**
	  * when size of list is 0 it returns boolean value
	  * @return boolean value
	  */
	 
	 public boolean isEmpty() {
		 return size == 0;
	 }
	 
	 /**
	  * Returns the size of the Queue
	  * @return integer value
	  */
	 
	 public int size() {
		 return size;
	 }
	 
	 /**
	  * Node class object is created and if the list is empty, then inserted at the front and
	  * if the list is not empty , then the rear's reference points to new node. After insertion
	  * length is incremented. 
	  * 
	  * @param data of <G> type as input
	  */
	 
	 public void enqueue(G data) {
		 Node<G> newNode = new Node<G>(data);
		if(front == null)
			front = newNode;
		else 
			rear.next = newNode;
		rear = newNode;
		size++;
	 }
	 
	 /**
	  * If the list is empty throws an exception. If the list is not empty, then front's reference
	  * is pointed to next element. Length is decremented after deletion.
	  * 
	  * @return generic class type value
	  */
	 
	 public G dequeue() {
		 G dequeueData;
		 if(isEmpty())
			 throw new NoSuchElementException("Queue is empty");
		 else {
			 dequeueData = front.data;
		     front = front.next;
		     if(front == null)
	    	      rear = null;
	         size--;
	         return dequeueData;
		 }
	 }
	 
	 /**
	  * Returns first inserted data of the list
	  * @throws NoSuchElementException if the list is empty
	  * @return data of <G> type as input
	  */
	 
	 public G first() {
		 if(isEmpty())
			 throw new NoSuchElementException("Empty queue");
		 return front.data;
	 }
	 
	 /**
	  * Returns last inserted data of the list
	  * @throws NoSuchElementException if the list is empty
	  * @return data of <G> type as input
	  */
	 
	 public G last() {
		 if(isEmpty())
			 throw new NoSuchElementException("Empty queue");
		 return rear.data;
	 }
	 
	 // prints the data present in the list starting from first
	 public void print() {
		 if(isEmpty())
			 System.out.println("Empty queue");
		 else {
		        Node<G> current = front;
		        while(current != null) {
			            System.out.print(current.data+ " ---> ");
			            current = current.next;
		        }
		        System.out.println("null");
		 }
	 }
	
	 /**
	  * If list not empty, returns the value which is pointed by top
	  * @return the data of generic type
	  */
	 
	 public G peak() {
		 if(!isEmpty())
			return front.data;
		 else
			throw new NoSuchElementException();
	 }
 
}
