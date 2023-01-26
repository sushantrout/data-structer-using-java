package com.example;

public class Node {
	String data;
	Node next;
	Node prev;
	public Node(String data, Node next, Node prev) {
		super();
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	@Override
	public String toString() {
		return data;
	}
}
