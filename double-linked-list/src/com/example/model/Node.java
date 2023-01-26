package com.example.model;

public class Node {
	public String data;
	public Node next;
	public Node prev;
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
