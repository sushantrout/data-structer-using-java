package com.example;

import java.util.Scanner;

import com.example.model.Node;

public class StackUsingLinkedList {
	public static Scanner sc = new Scanner(System.in);
	public static Node root;

	public static void main(String[] args) {

		int condition = 0;
		do {
			System.out.println("1: PUSH \t 2: POP \t 3: SHOW");
			System.out.println("Enter your choice: ");
			condition = sc.nextInt();
			switch (condition) {
			case 1: {
				push();
				break;
			}
			case 2: {
				pop();
				break;
			}
			case 3: {
				show();
				break;
			}
			case 4:
				System.exit(200);
			}
		} while (condition != 4);

	}

	private static void push() {
		System.out.println("Enter data: ");
		String data = sc.next();
		Node newNode = new Node(data, root);
		root = newNode;
	}

	private static void pop() {
		if(root != null) {
			root = root.next;			
		}
	}

	private static void show() {
		Node node = root;
		while (node != null) {
			System.out.print(node.data);
			node = node.next;
		}
		System.out.println();
	}
}
