package com.example.test;

import java.util.LinkedList;
import java.util.Queue;

import com.example.Node;

public class EachLavelHighestValueTest {
	public static void main(String[] args) {
		Node root = inserToTree(null, 5);
		inserToTree(root, 2);
		inserToTree(root, 4);
		inserToTree(root, 1);
		inserToTree(root, 3);
		inserToTree(root, 7);
		inserToTree(root, 6);
		inserToTree(root, 8);
		inserToTree(root, 10);

		traversh(root);
		System.out.println();

		int height = findHeightOfTree(root);
		System.out.println("Height: " + height);
		System.out.println();
		
		findMaxAtEachLavel(root);

		System.out.println();
		int findMaxAtEachLavelForBST = findMaxValueOfBST(root, 0);
		System.out.println("Max: " + findMaxAtEachLavelForBST);
		
		System.out.println();
		int findMaxValueOfAnyBinaryTree = findMaxValueOfAnyBinaryTree(root, 0);
		System.out.println("max for any tree: " + findMaxValueOfAnyBinaryTree);
	}

	private static int findMaxValueOfAnyBinaryTree(Node root, int max) {
		if (root == null) {
			return max;
		} else {
			int leftValue = findMaxValueOfBST(root.left, root.data);
			int rightValue = findMaxValueOfBST(root.right, root.data);
			max = leftValue > rightValue ? rightValue : rightValue;
		}
		return max;
	}

	private static int findMaxValueOfBST(Node root, int max) {
		if (root == null) {
			return max;
		} else {
			max = findMaxValueOfBST(root.right, root.data);
		}
		return max;
	}

	private static void findMaxAtEachLavel(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		int label = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			int max = Integer.MIN_VALUE;
			label++;
			for (int i = 0; i < size; i++) {
				Node poll = queue.poll();

				if (max < poll.data) {
					max = poll.data;
				}

				if (poll.left != null) {
					queue.offer(poll.left);
				}

				if (poll.right != null) {
					queue.offer(poll.right);
				}
			}

			System.out.println(label + " ====> " + max);
		}
	}

	private static int findHeightOfTree(Node root) {
		if (root == null) {
			return 0;
		} else {
			int leftHeight = findHeightOfTree(root.left);
			int rightHeight = findHeightOfTree(root.right);
			return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
		}
	}

	private static void traversh(Node root) {
		if (root == null) {
			return;
		} else {
			traversh(root.left);
			System.out.println(root.data);
			traversh(root.right);
		}
	}

	public static Node inserToTree(Node root, int data) {
		if (root == null) {
			return new Node(data, null, null);
		} else if (root.data > data) {
			root.left = inserToTree(root.left, data);
		} else {
			root.right = inserToTree(root.right, data);
		}
		return root;
	}
}
