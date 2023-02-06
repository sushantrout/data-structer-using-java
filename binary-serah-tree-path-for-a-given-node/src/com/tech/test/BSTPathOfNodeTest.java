package com.tech.test;

import com.tech.model.Node;

public class BSTPathOfNodeTest {
	static Node rootOfTree;

	public static void main(String[] args) {

		BSTPathOfNodeTest a = new BSTPathOfNodeTest();
		Node root = insertAllNode(a);

		findPath(root, "", 6);
	}

	private static void findPath(Node root, String path, int target) {
		if (root != null && root.getData() == target) {
			String responsePath = path+" "+root.getData();
			System.out.println(responsePath);
		} else if (root != null) {
			findPath(root.leftNode, path + root.getData() + " -> ", target);
			findPath(root.rightNode, path + root.getData() + " -> ", target);
		}
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

	private static Node insertAllNode(BSTPathOfNodeTest a) {
		Node root = null;

		root = a.insert(root, 8);
		root = a.insert(root, 3);
		root = a.insert(root, 6);
		root = a.insert(root, 10);
		root = a.insert(root, 4);
		root = a.insert(root, 0);
		root = a.insert(root, 7);
		root = a.insert(root, 1);
		root = a.insert(root, 14);
		root = a.insert(root, 13);
		return root;
	}
}
