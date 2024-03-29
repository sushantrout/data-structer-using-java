package com.tech.model;

public class Node {
	public int data;
	public Node left;
	public Node right;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeftNode() {
		return left;
	}

	public void setLeftNode(Node leftNode) {
		this.left = leftNode;
	}

	public Node getRightNode() {
		return right;
	}

	public void setRightNode(Node rightNode) {
		this.right = rightNode;
	}

	public Node(int data, Node leftNode, Node rightNode) {
		super();
		this.data = data;
		this.left = leftNode;
		this.right = rightNode;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", leftNode=" + left + ", rightNode=" + right + "]";
	}

}
