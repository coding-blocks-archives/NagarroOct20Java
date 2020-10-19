package StackQueue;

import java.util.Stack;

public class StackQs {

	public static void main(String[] args) {

		// int[][] arr = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 0, 0, 0, 0 }, { 1, 1, 1, 0 } };
		// celebrityProblem(arr);

		MyStack stack = new MyStack();
		stack.push(10);
		stack.push(50);
		stack.push(40);
		stack.push(6);
		stack.push(45);
		stack.push(2);

		System.out.println(stack.min());
		System.out.println(stack.pop());
		System.out.println(stack.min());
		System.out.println(stack.peek());

	}

	public static void celebrityProblem(int[][] arr) {

		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < arr.length; i++) {
			s.push(i);
		}

		while (s.size() != 1) {

			int a = s.pop();
			int b = s.pop();

			// a doesn't know b , b cant be a celeb
			if (arr[a][b] == 0) {
				s.push(a);
			}
			// a knows b , a cant be a celeb
			else {
				s.push(b);
			}
		}

		int candidate = s.pop();

		for (int i = 0; i < arr.length; i++) {

			if (i != candidate) {

				if (arr[candidate][i] == 1 || arr[i][candidate] == 0) {
					System.out.println("No Celeb");
					return;
				}
			}
		}

		System.out.println(candidate);

	}

}
