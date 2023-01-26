package com.example;

import java.util.Arrays;
import java.util.List;

public class ParenthesesBalancedTest {
	static int top = -1;
	static String input = "{[]()[]}{}";
	static String[] inputStack = new String[input.length()];

	public static void main(String[] args) {
		String[] openParanthesis = { "{", "[", "(" };
		List<String> openParanthesisList = Arrays.asList(openParanthesis);
		for (int i = 0; i < input.length(); i++) {
			String substring = input.substring(i, i + 1);
			if (openParanthesisList.contains(substring)) {
				push(substring);
			} else {
				boolean valid = pop(substring);
				if(!valid) {
					System.out.println("Not valid for : " + substring);
					return;
				}
			}
		}
		if(top != -1) {
			System.out.println("Not valid");
			return;
		}
		System.out.println("Its a valid expression");
	}

	public static void push(String substring) {
		top = top + 1;
		inputStack[top] = substring;
	}

	public static boolean pop(String op) {
		if (validate(op)) {
			inputStack[top] = null;
			top = top - 1;
			return true;
		} else {
			return false;
		}
	}

	public static boolean validate(String op) {
		String topParantheses = inputStack[top];
		switch (op) {
			case ")": {
				return "(".equalsIgnoreCase(topParantheses);
			}
			case "]": {
				return "[".equalsIgnoreCase(topParantheses);
			}
			case "}": {
				return "{".equalsIgnoreCase(topParantheses);
			}
		}
		return false;
	}
}
