package LL_BT_BST_HM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {

		// create
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		// put
		map.put(10, "Aman");
		map.put(25, "Neha");
		map.put(3, "Sham");

		System.out.println(map);

		// update
		map.put(1, "Rohit");
		System.out.println(map);

		// get
		System.out.println(map.get(1));
		System.out.println(map.get(0));

		// containskey
		System.out.println(map.containsKey(0));

		// remove
		map.remove(1);
		System.out.println(map);

		// print
		// 1 way
		for (int key : map.keySet()) {
			System.out.println(key + "->" + map.get(key));
		}

		// 2 way
		Set<Integer> keys = map.keySet();
		for (int key : keys) {

		}

		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6, 4 };
		longestConsecutiveSeq(arr);

		// ArrayList fxns
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);

		System.out.println(list);
		System.out.println(list.size());

	}

	public static void longestConsecutiveSeq(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

		for (int val : arr) {

			if (map.containsKey(val - 1)) {
				map.put(val, false);
			} else {
				map.put(val, true);
			}

			if (map.containsKey(val + 1)) {
				map.put(val + 1, false);
			}

		}

		int maxLength = 0;
		int starting = 0;

		for (int key : map.keySet()) {

			if (map.get(key)) {

				int count = 0;

				while (map.containsKey(key + count)) {
					count++;
				}

				if (count > maxLength) {
					maxLength = count;
					starting = key;
				}

			}
		}

		for (int i = starting; i < starting + maxLength; i++) {
			System.out.println(i);
		}

	}

}
