package com.tech.test;

import com.tech.model.Node;

public class BSTHeightOfTreeTest {
	static Node rootOfTree;

	public static void main(String[] args) {

		BSTHeightOfTreeTest a = new BSTHeightOfTreeTest();
		Node root = null;

		root = a.insert(root, 0);
		root = a.insert(root, 8);
		root = a.insert(root, 3);
		root = a.insert(root, 6);
		root = a.insert(root, 10);
		root = a.insert(root, 4);
		root = a.insert(root, 7);
		root = a.insert(root, 1);
		root = a.insert(root, 14);
		root = a.insert(root, 13);
		traversh(root);
		
		int height = findHeiht(root);
		System.out.println("Height: " + height);
	}

	private static int findHeiht(Node root) {
		if(root == null) {
			return 0;
		} else {
			int findHeiht = findHeiht(root.left);
			int findHeihtRight = findHeiht(root.right);
			return (findHeiht > findHeihtRight? findHeiht : findHeihtRight) + 1;
		}
	}

	private static void traversh(Node root) {
		if(root == null) {
			return;
		}
		traversh(root.left);
		System.out.println(root.getData());
		traversh(root.right);
	}

	public Node insert(Node node, int val) {
		if (node == null) {
			return createNewNode(val);
		}

		if (val < node.data) {
			node.left = insert(node.left, val);
		} else if ((val > node.data)) {
			node.right = insert(node.right, val);
		}

		return node;
	}

	public Node createNewNode(int k) {
		Node a = new Node(k, null, null);
		return a;
	}

}
