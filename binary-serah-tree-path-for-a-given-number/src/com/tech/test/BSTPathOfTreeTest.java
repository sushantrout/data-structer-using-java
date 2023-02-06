package com.tech.test;

import com.tech.model.Node;

public class BSTPathOfTreeTest {
	static Node rootOfTree;

	public static void main(String[] args) {

		BSTPathOfTreeTest a = new BSTPathOfTreeTest();
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
		System.out.println(height);
	}

	private static int findHeiht(Node root) {
		if (root == null) {
			return 0;
		} else {
			int findHeiht = findHeiht(root.leftNode);
			int findHeihtRight = findHeiht(root.rightNode);
			return (findHeiht > findHeihtRight ? findHeiht : findHeihtRight) + 1;
		}
	}

	private static void traversh(Node root) {
		if (root == null) {
			return;
		}
		traversh(root.leftNode);
		System.out.println(root.getData());
		traversh(root.rightNode);
	}

	public Node insert(Node node, int val) {
		if (node == null) {
			return createNewNode(val);
		}

		if (val < node.data) {
			node.leftNode = insert(node.leftNode, val);
		} else if ((val > node.data)) {
			node.rightNode = insert(node.rightNode, val);
		}

		return node;
	}

	public Node createNewNode(int k) {
		Node a = new Node(k, null, null);
		return a;
	}

}
