package com.bridgelabz.dataStructure;

import java.util.NoSuchElementException;

import com.bridgelabz.util.Utility;

/**
 * A program to implement Linked List
 * @author Sunidhi Haldar
 * created 22.11.2019
 * @version 13.0.1
 * @param <G> generic type
 */

public class ImplementingLinkedList<G> {
	
	// @param head declares as the starting node of a linked list
	private Node<G> head;
	
	// @param length stores the length of the linked list
	private int length;
	
	public ImplementingLinkedList() {
		this.length = 0;
		this.head = null;
	}

	public int length() {
		return length;
	}
    
	/**
	 * isEmpty() method of the type boolean checks if the list is empty
	 * @return length is zero
	 */
	public boolean isEmpty() {
		return length == 0;
	}
	
	public G getData() {
		Node<G> current = head;
		return current.getData();
	}
	
	public String printString() {
		Node<G> current = head;
		String data = "";
		while(current != null) {
			data = data + current.data + ",";
			current = current.next;
		}
		return data;
	}
	
	// print() method is used to print the nodes of the linked list
	public void print() {
		if(head == null)
			System.out.println("List is empty!");
		else {
			// @param current is used traverse through the linked list until it reaches null 
			Node<G> current = head;
		    while (current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		    }
		System.out.println("null");
		}
	}
	
	public void print(String storingLocation) {
		Node<G> current = head;
		while(current != null) {
			Utility.writeToFile((String)current.data, storingLocation);
			current = current.next;
		}
		System.out.println("File updated");
	}
	
	/**
	 * inserAtStart() is used to insert a node at the beginning of the linked list and creates 
	 * a new node. If the list is not empty the length is incremented 
	 * @param data is the parameter to be inserted
	 */
	public boolean insertAtStart(G data) {
		Node<G> newNode = new Node<G>(data);
		if(isEmpty())
			head = newNode;
		else {
			newNode.next = head;
			head = newNode;
		}
		length++;
		return true;
	}
    
	/**
	 * insert() method is used to insert data node in the list and creates 
	 * a new node. Checks if the list is empty, if empty head points to new node and if not empty,
	 * the new node's reference is pointed by head and head points to new node and length is incremented
	 * @param data is the parameter to be inserted
	 */
	public boolean insert(G data) {
		Node<G> newNode = new Node<G>(data);
		if(isEmpty())
			head = newNode;
		else {
			Node<G> current = head;
			while (current.next != null)
				current = current.next;
			current.next = newNode;
		}
		length++;
		return true;
	}
    
	/**
	 * This method is used to insert node at the given position
	 * @param position stores the index value given by the user
	 * @param data is the parameter to be inserted
	 */
	public boolean insert(G data, int position) {
		Node<G> newNode = new Node<G>(data);
		if (isEmpty() || position == 0) {
			// this condition satisfies the insertion at beginning
			insertAtStart(data);
			return true;
		}
		else if(position > length || position < 0) {
			// the index value is out of index and not valid
			System.out.println("Insertion at position " +position+ " is not possibe \n list length" +length());
			return false;
		}
		else {
			// inserts node in between the start and the end nodes
			// @param current points to head and used for traversing through the list
			// length is incremented
			Node<G> current = head;
			for(int i = 0; i < position - 1; i++)
				current = current.next;
			newNode.next = current.next;
			current.next = newNode;
		    length++;
		    return true;
	    }
	}
    
	/**
	 * this method is used for deleting a node at the beginning of the linked list
	 * if list is empty it throws an exception
	 * if list not empty head point to the next node and length is decremented
	 */
	public G deleteAtStart() {
		Node<G> current = head;
		if(isEmpty())
			throw new NoSuchElementException("Empty list");
		else {
			head = head.next;
		    length--;
		    return current.data;
		}
	}
    
	/**
	 * this method is used for deleting a node at the end of the linked list
	 * if list is empty it throws an exception
	 * if list not empty length is decremented
	 * @param last points to the node that has to be deleted
	 * @param previousToLast points to the node previous to the last node
	 * length is decremneted successfully if list not empty 
	 */
	public G delete() {
		Node<G> current = head;
		if (isEmpty())
			throw new NoSuchElementException("Empty list");
		else if (length == 1) {
			// head points to null and length is decemneted
			head = null;
			length--;
			return current.data;
		}
		else {
			while (current.next.next != null) {
				current = current.next;
			}
			G removedData = current.next.data;
			current.next = null;
			length--;
			return removedData;
		}
	}
   
	/**
	 * this method deletes the node at the given index position
	 * @param position is the parameter whose value has to be deleted
	 * if list is not empty length is decremented
	 */
	public G delete(int position) {
		Node<G> current = head;
		if (position < 0 || position >= length())
			// position value indicates negative index and not valid
			throw new NoSuchElementException("Deletion at " + position + "is not possible");
		else if (position == 0)
			// position value indicates node at the start has to be deleted
			return deleteAtStart();
		else if(position == length - 1)
			// position value indicates node at the end has to be deleted
			return delete();
		else {
			Node<G> previous = null;
			for (int i = 0; i < position; i++) {
				previous = current;
			    current = current.next;
			}
			G removedData = current.data;
			previous.next = current.next;
			length--;
			return removedData;
		}
	}
	
	/**
	 * Takes data of generic type as input searches for the valid index position, if found
	 * then deletes the data based on index position
	 *  
	 * @param data of generic Class type as input
	 */
	
	public void deleteData(G data) {
		if(getIndex(data) < 0)
			System.out.println("Data not available");
		else
			delete(getIndex(data));
	}
	
	/**
	 * Takes data of generic type and iterates in the while loop, if data is found returns
	 * boolean value
	 * 
	 * @param data of generic Class type as input
	 * @return boolean value
	 */
	
	public boolean search(G data) {
		Node<G> current = head;
		if(isEmpty())
			return false;
		else {
		    while(current != null) {
			      if(current.data.equals(data)) {
				          System.out.println("Data is available");
				          return true;
			      }
			      current = current.next;
		    }
		}
		return false;
	}
	
	/**
	 * Takes generic data type as input and checks for index position. If index position
	 * is found then returns a positive index value else return negative value.
	 * 
	 * @param data of generic Class type as input
	 * @return index number as integer value
	 */
	
	public int getIndex(G data) {
		if(isEmpty())
			return -1;
		else {
			int dataIndexPosition = 0;
			Node<G> current = head;
			while (current != null) {
				if(current.data.equals(data)) {
					return dataIndexPosition;
				}
				dataIndexPosition++;
				current = current.next;
			}
		}
		return -1;
	}
	
	/**
	 * Takes index position as input and returns generic type data of that index
	 * 
	 * @param index position as input paramter
	 * @return <G> generic type data
	 */
	
	public G getDataFromIndex(int index) {
		int counter = 0;
		G getData = null;
		if(isEmpty())
			throw new NoSuchElementException();
		else {
			Node<G> current = head;
			while(current != null) {
				if(index == counter) 
					getData = current.data;
				counter++;
				current = current.next;
			}
		}
		return getData;
	}
	
	/**
	 * Takes data and index number as input parameter and set data at that index position
	 * 
	 * @param data as generic type input
	 * @param index position as input parameter
	 */
	
	public void setDataFrom(G data, int index) {
		G dataFromIndex = getDataFromIndex(index);
		if(isEmpty())
			throw new NoSuchElementException();
		else {
			Node<G> current = head;
			while(current.next != null) {
				if(dataFromIndex == current.data) {
					current.data = data;
				}
				current = current.next;
			}
		}
	}
	
}