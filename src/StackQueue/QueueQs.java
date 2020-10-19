package StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueQs {

	public static void main(String[] args) {

		int[] arr = { 10, -1, -8, 6, -30, 40, 50, 60 };
		firstNegativeInteger(arr, 3);

	}

	public static void firstNegativeInteger(int[] arr, int k) {

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < k; i++) {

			if (arr[i] < 0)
				q.add(i);

		}

		for (int i = k; i < arr.length; i++) {

			// answer
			if (q.isEmpty()) {
				System.out.println(0);
			} else {
				System.out.println(arr[q.peek()]);
			}

			// window update : by removing out of window elements
			if (!q.isEmpty() && q.peek() <= i - k) {
				q.remove();
			}

			// add a new element
			if (arr[i] < 0) {
				q.add(i);
			}

		}

		// answer
		if (q.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(arr[q.peek()]);
		}

	}

}
