package com.tech.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.tech.model.Node;

public class IterativeTRavershal {

	public static void main(String[] args) {

		IterativeTRavershal a = new IterativeTRavershal();
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
		List<Node> returnValue = new ArrayList<Node>();

		System.out.println("Preorder");
		System.out.println();
		
		returnValue = preorderApprocah(root);
		returnValue.forEach(e -> System.out.println(e.data));

		System.out.println();
		System.out.println("INOrder");
		System.out.println();
		returnValue = inorderApprocah(root);
		returnValue.forEach(e -> System.out.println(e.data));
		
	}

	private static List<Node> preorderApprocah(Node root) {
		Stack<Node> stack = new Stack<Node>();
		List<Node> preOrder = new ArrayList<>();

		if(root == null) {
			return new ArrayList<Node>();
		}
		
		Node current = root;
		stack.push(current);

		while(!stack.isEmpty()) {
				current = stack.pop();
				preOrder.add(current);
				Node right = current.right;
				if(right != null) {
					stack.push(right);
				}
				
				Node left = current.left;
				if(left != null) {
					stack.push(left);
				}
				
		}
		
		
		return preOrder;
	}

	private static List<Node> inorderApprocah(Node root) {
		Stack<Node> stack = new Stack<Node>();
		List<Node> inorderNode = new ArrayList<>();

		if(root == null) {
			return new ArrayList<Node>();
		}
		
		Node current = root;

		while((!stack.isEmpty()) || current != null) {
			while(current != null) {
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			inorderNode.add(current);
			current = current.right;
		}
		
		
		return inorderNode;
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
