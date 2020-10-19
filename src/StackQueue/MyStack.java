package StackQueue;

import java.util.Stack;

public class MyStack {

	private Stack<Integer> s = new Stack<Integer>();
	private int min;

	public void push(int val) {

		if (s.isEmpty()) {
			s.push(val);
			min = val;
		} else if (val >= min) {
			s.push(val);
		} else {
			s.push(2 * val - min);
			min = val;
		}
	}

	public int peek() {

		if (s.isEmpty()) {
			System.out.println("Stack is Empty.");
			return -1;
		} else if (s.peek() < min) {
			return min;
		} else {
			return s.peek();
		}
	}

	public int pop() {

		if (s.isEmpty()) {
			System.out.println("Stack is Empty.");
			return -1;
		} else if (s.peek() < min) {

			int rv = min;

			min = 2 * min - s.pop();

			return rv;

		} else {

			int rv = s.pop();
			return rv;

		}
	}
	
	public int min() {
		return min ;
	}

}
