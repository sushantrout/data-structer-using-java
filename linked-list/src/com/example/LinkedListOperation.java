package com.example;

import java.util.Scanner;

public class LinkedListOperation {

	public static Scanner SCANNER = new Scanner(System.in);
	public static Node head = null;

	public static void main(String[] args) {

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
				head = delete(head);
				break;
			}
			case 5: {
				head = reversh(head);
				break;
			}
			case 6: {
				revershUsingRecurssion(head);
				break;
			}
			case 7: {
				travershNode(head);
				System.out.println();
				break;
			}
			case 8: {
				SCANNER.close();
				System.out.println("Thank you");
				System.exit(200);
			}
			}
		} while (value != 8);

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
			if (position == 1) {
				Node node = new Node(value, head);
				return node;
			} else {
				while (head.next != null) {
					if (i == position - 1) {
						Node node = new Node(value, head.next);
						head.next = node;
						break;
					}
					i++;
				}
			}
		}
		return head;
	}

	public static Node delete(Node head) {
		System.out.print("Insert position: ");
		int position = SCANNER.nextInt();
		if (position == 1) {
			Node next = head.next;
			head.next = null;
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

	public static Node reversh(Node node) {
		Node current = node;
		Node next = null;
		Node prev = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public static void revershUsingRecurssion(Node node) {
		
		Node q = node.next;
		while (q == null) {
			head = node;
			return;
		}
		revershUsingRecurssion(q);
		q.next = node;
		node.next = null;
		
	}
	
	public static void showMessage() {
		System.out.print("1 : Insert\t");
		System.out.print("2 : Insert At Position\t");
		System.out.print("3 : Delete\t");
		System.out.print("4 : Update\t");
		System.out.print("5 : Reversh\t");
		System.out.print("6 : Reversh(Recurssion)\t");
		System.out.print("7 : Show\t");
		System.out.println("8 : Exit");
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
