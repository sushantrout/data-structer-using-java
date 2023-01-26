package com.example;

import java.util.Scanner;

import com.example.model.Node;

public class DoubleLinkedListImplemntation {
	public static Scanner SCANNER = new Scanner(System.in);
	public static Node root = null;

	public static void main(String[] args) {
		int value = 0;
		do {
			showMessage();
			value = insertOption();
			switch (value) {
			case 1: {
				String data = insertNodeData();
				insertNode(data);
				break;
			}
			case 2: {
				String data = insertNodeData();
				insertNodeAtNth(data, root);
				break;
			}
			case 3: {
				root = delete(root);
				break;
			}
			case 5: {
				root = reversh(root);
				break;
			}
			case 6: {
				revershUsingRecurssion(root);
				System.out.println();
				break;
			}
			case 7: {
				travershNode(root);
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

	private static void insertNode(String data) {
		Node node = new Node(data, null, null);
		Node current = root;
		if (current == null) {
			root = node;
		} else {
			while (current.next != null) {
				current = current.next;
			}
			node.prev = current;
			current.next = node;
		}
	}

	private static void travershNode(Node head) {
		while(head != null) {
			System.out.print(head.data+"\t");
			head = head.next;
		}
	}

	private static void revershUsingRecurssion(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data+"\t");
		revershUsingRecurssion(node.next);
	}

	private static Node reversh(Node head) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Node delete(Node head) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void insertNodeAtNth(String data, Node head) {
		System.out.print("Insert position: ");
		int position = SCANNER.nextInt();
		int index = 0;
		
		while(head != null) {
			if(index == position -1) {
				break;
			}
			index ++;
			head = head.next;
		}
		
		if(head != null) {
			Node node = new Node(data, null, null);
			node.prev = head.prev;
			node.next = head;
			head.prev.next = node;
		} else {
			System.out.print("Please select a valid position");
		}
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
