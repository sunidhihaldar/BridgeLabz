package com.bridgelabz.dataStructure;

/**
 * Binary Tree is a non linear data structure without having cycle where each node can point
 * to two different nodes. It has some functions like => insert() which insert the data to
 * the tree, => delete() which deletes the data provided by user for deletion operation, 
 * => inorderDisplay() which prints the values of the list.
 * 
 * @author Sunidhi Haldar
 * @created 2019-11-29
 * @version 13.0.1
 */

public class Tree {
	Node root;
	
	// constructor to initialize the root
	public Tree() {
		this.root = null;
	}
	
	// Inner node class which bears the data and reference of two child class type.
	class Node {
		int data;
		Node leftChild;
		Node rightChild;
		
		/**
		 * constructor to initialize the class
		 * @param data as parameter which needed to be inserted.
		 */
		
		public Node(int data) {
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	
	/**
	 * If root is empty then it adds the data and marks as root, else it traverse to particular
	 * position where the data needs to be inserted and then insert at that position.
	 * 
	 * @param data as input parameter where data needs to be inserted
	 */
	
	public void insertData(int data) {
		Node newNode = new Node(data);
		if(root == null)
			root = newNode;
		else
			traverseToAdd(root,newNode);
	}
	
	/**
	 * It compares top node data with the data which is needed to be inserted if input data
	 * is greater than root data it is inserted at right branch else it will be inserted
	 * at left branch of tree. This method is recursively called until null is found.
	 * Then current points to the newly assigned node.
	 * 
	 * @param current as initial node from where traversing will start
	 * @param newNode as parameter which will be inserted
	 */
	
	public void traverseToAdd(Node current, Node newNode) {
		if(newNode.data > current.data) {
			  if(current.leftChild == null)
                     current.leftChild = newNode;
		      else
			         traverseToAdd(current.leftChild, newNode);
		}
		else if(newNode.data > current.data) {
			  if(current.rightChild == null)
                     current.rightChild = newNode;
	          else
		             traverseToAdd(current.rightChild, newNode);
	    }
	}
	
	/**
	 * Calls the function deleteAtNode() and after successful execution, data is deleted.
	 * 
	 * @param data to be deleted as input parameter
	 */
	
	public void delete(int data) {
		root = deleteAtNode(root, data);
	}
	
	/**
	 * If the root is empty it prints the data else it recursively calls the function unless
	 * it reaches null. If data is less than root data then it calls left child else it calls
	 * right child unless it read all data and find to the particular data it wants to delete.
	 * 
	 * @param root takes root node as input parameter
	 * @param data which needs to be deleted as input parameter
	 * @return Node class type data
	 */
	
	public Node deleteAtNode(Node root, int data) {
		if(root == null)
			return root;
		if(data < root.data)
			root.leftChild = deleteAtNode(root.leftChild, data);
		else if(data > root.data)
			root.rightChild = deleteAtNode(root.rightChild, data);
		else {
			if(root.leftChild == null)
               return root.rightChild;
		    else if(root.rightChild == null)
			   return root.leftChild;
		}
		return root;
	}
	
	/**
	 * It fetches the minimum value from left child and returns it.
	 * 
	 * @param root as class type reference as input parameter
	 * @return Integer value
	 */
	
	public int minimumValue(Node root) {
		int minimum = root.data;
		while(root.leftChild != null) {
			minimum = root.leftChild.data;
			root = root.leftChild;
		}
		return minimum;
	}
	
	// Calls the function inOrderRecurssion() and prints the values
	public void inorderDisplay() {
		inorderRecurssion(root);
	}
	
	/**
	 * Takes root address as input parameter and recursively calls the function unless it 
	 * finds root as null. Isf it find root as null then it prints the data.
	 * 
	 * @param root address as input parameter.
	 */
	
	public void inorderRecurssion(Node root) {
		if(root != null) {
			inorderRecurssion(root.leftChild);
			System.out.println(root.data +" ");
			inorderRecurssion(root.rightChild);
		}
	}
}
