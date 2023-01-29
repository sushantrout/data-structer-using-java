package com.example.test;

import java.util.Arrays;
import java.util.List;

import com.example.Node;

public class BSTOperation {
	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(6, 3, 5, 4, 2, 8, 9, 7, 1, 10);
		Node root = null;
		for (Integer value : asList) {
			root = insert(root, value);
		}

		System.out.print("In O: ");
		travershInO(root);
		System.out.println();
		System.out.print("Pre O: ");
		travershPreO(root);
		System.out.println();
		System.out.print("Post O: ");
		travershPostO(root);
		
		System.out.println();
		System.out.print("Search : ");
		System.out.println(serach(root, 5));
	}

	private static void travershPostO(Node root) {
		if (root != null) {
			travershPostO(root.left);
			travershPostO(root.right);
			System.out.print(root.data);
		}
	}

	private static void travershPreO(Node root) {
		if (root != null) {
			System.out.print(root.data);
			travershPreO(root.left);
			travershPreO(root.right);
		}
	}

	private static void travershInO(Node root) {
		if (root != null) {
			travershInO(root.left);
			System.out.print(root.data);
			travershInO(root.right);
		}
	}

	private static Node insert(Node root, Integer value) {
		if (root == null) {
			root = new Node(value, null, null);
			return root;
		}

		if (root.data > value) {
			root.left = insert(root.left, value);
		} else {
			root.right = insert(root.right, value);
		}

		return root;
	}

	static boolean serach (Node root, int value) {
		if(root == null) {
			return false;
		} else if(root.data.intValue() == value) {
			return true;
		}else {
			if(root.data > value) {
				return serach(root.left, value);
			} else {
				return serach(root.right, value);
			}
		}
	}
}
