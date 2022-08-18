package com.tech.test;

import com.tech.model.Node;

public class BSTTest {
	static Node rootOfTree;

	public static void main(String[] args) {

		BSTTest a = new BSTTest();
		Node root = null;

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
	}

	private static void traversh(Node root) {
		if(root == null) {
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
