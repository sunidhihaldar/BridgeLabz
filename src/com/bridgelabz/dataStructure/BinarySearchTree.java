package com.bridgelabz.dataStructure;

import com.bridgelabz.util.Utility;
import com.bridgelabz.dataStructure.Tree;

/**
 * This class has a functionality of finding probability of binary tree by using
 * factorial function of Utility class and all implementation methods of tree.
 * 
 * @author Sunidhi Haldar
 * @created 2019-11-29
 * @version 13.0.1
 */
public class BinarySearchTree {

	/**
	 * takes key as input parameter and finds the probability and returns integer
	 * value as probability
	 * 
	 * @param key as input parameter
	 * @return integer value
	 */
	
	public static int numberOfPossibilitiesOfbinaryTree(int key) {
		int possiblity = Utility.factorial(2 * key) / (Utility.factorial(key + 1) * Utility.factorial(key));
		return possiblity;
	}

	public static void main(String[] args) {
		Tree binaryTree = new Tree();
		binaryTree.insertData(70);
		binaryTree.insertData(30);
		binaryTree.insertData(60);
		binaryTree.insertData(40);
		binaryTree.insertData(50);
		binaryTree.insertData(20);
		binaryTree.insertData(80);

		System.out.println("Inorder traversal of the given tree");
		binaryTree.inorderDisplay();

		System.out.println("\nDelete 20");
		binaryTree.delete(20);
		System.out.println("Inorder traversal of the modified tree");
		binaryTree.inorderDisplay();

		System.out.println("\nDelete 30");
		binaryTree.delete(30);
		System.out.println("Inorder traversal of the modified tree");
		binaryTree.inorderDisplay();

		System.out.println("\nDelete 50");
		binaryTree.delete(50);
		System.out.println("Inorder traversal of the modified tree");
		binaryTree.inorderDisplay();

		System.out.println();
		System.out.println();
		System.out.print("Number of Possibilities : ");
		System.out.println(BinarySearchTree.numberOfPossibilitiesOfbinaryTree(3));

	}

}
