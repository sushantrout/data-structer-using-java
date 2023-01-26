package com.example;

import java.util.Scanner;

public class LinkedListOperation {

	public static Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		Node head = null;

		int value = 0;
		do {
			showMessage();
			value = insertOption();
			switch (value) {
			case 1: {
				String data = insertNodeData();
				if (head == null) {
					head = insertNode(data, head);
				} else {
					insertNode(data, head);
				}
				break;
			}
			case 2: {
				String data = insertNodeData();
				head = insertNodeAtNth(data, head);
				break;
			}
			case 3: {
				delete(head);
				break;
			}
			case 5: {
				travershNode(head);
				System.out.println();
				break;
			}
			case 6: {
				SCANNER.close();
				System.out.println("Thank you");
				System.exit(200);
			}
			}
		} while (value != 6);

	}

	public static Node insertNode(String value, Node head) {
		Node node = new Node(value, null);
		if (head == null) {
			head = node;
		} else {
			while (head.next != null) {
				head = head.next;
			}
			head.next = node;
		}
		return head;
	}

	public static Node insertNodeAtNth(String value, Node head) {
		System.out.print("Insert position: ");
		int position = SCANNER.nextInt();
		if (head == null) {
			return new Node(value, null);
		} else {
			int i = 0;
			while (head.next != null) {
				if (i == position - 1) {
					Node node = new Node(value, head.next);
					head.next = node;
					break;
				}
				i++;
			}
		}
		return head;
	}

	public static Node delete(Node head) {
		System.out.print("Insert position: ");
		int position = SCANNER.nextInt();
		if (position == 1) {
			Node next = head.next;
			head = null;
			return next;
		} else {
			Node node = head;
			for (int j = 0; j < position; j++) {
				if (node != null) {
					node = node.next;
				}
			}
			if (node != null && node.next != null) {
				node.next = node.next.next;
			}
		}
		return head;
	}

	public static void travershNode(Node head) {

		if (head == null) {
			return;
		}
		System.out.print(head.data + "\t");
		travershNode(head.next);
	}

	public static void showMessage() {
		System.out.print("1 : Insert\t");
		System.out.print("2 : Insert At Position\t");
		System.out.print("3 : Delete\t");
		System.out.print("4 : Update\t");
		System.out.print("5 : Show\t");
		System.out.println("6 : Exit");
		System.out.print("Chose option: ");
	}

	public static int insertOption() {
		int nextInt = SCANNER.nextInt();
		return nextInt;
	}

	private static String insertNodeData() {
		System.out.print("Please input data :");
		String data = SCANNER.next();
		return data;
	}
}
