package com.example;

import java.util.Scanner;
import java.util.stream.Stream;

public class StackArrayImplemntation {

	public static int top = -1;
	public static String[] stack = new String[100];
	public static Scanner sc = new Scanner(System.in);

	public static boolean isEmpty() {
		return top == -1;
	}

	public static boolean push() {
		top = top + 1;
		System.out.println("Please enter data");
		stack[top] = sc.next();
		return true;
	}

	public static String pop() {
		if (!isEmpty()) {
			top = top - 1;
			return stack[top];
		}
		return null;
	}

	public static void show() {
		Stream.of(stack).limit(top).forEach(a -> {
			System.out.print(a + "\t");
		});
	}

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
}
