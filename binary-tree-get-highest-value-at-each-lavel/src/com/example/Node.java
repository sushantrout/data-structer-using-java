package com.example;

public class Node {
	public int data;
	public Node left;
	public Node right;

	public Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

}
