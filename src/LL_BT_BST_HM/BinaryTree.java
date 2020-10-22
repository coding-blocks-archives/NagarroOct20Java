package LL_BT_BST_HM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	private Node root;

	public void takeInput() {

		Scanner scn = new Scanner(System.in);

		Queue<Node> q = new LinkedList<>();

		int val = scn.nextInt();
		root = new Node(val);
		q.add(root);

		while (!q.isEmpty()) {

			Node pn = q.remove();

			int ld = scn.nextInt();
			if (ld != -1) {

				Node ln = new Node(ld);
				pn.left = ln;
				q.add(ln);
			}

			int rd = scn.nextInt();
			if (rd != -1) {

				Node rn = new Node(rd);
				pn.right = rn;
				q.add(rn);
			}

		}

	}

	public void display() {
		display(root);
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";

		if (node.left == null)
			str += ".";
		else
			str += node.left.data;

		str += " -> " + node.data + " <- ";

		if (node.right == null)
			str += ".";
		else
			str += node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = ht(node.left);
		int rh = ht(node.right);

		int level = Math.max(lh, rh);

		return level + 1;

	}

	public boolean isBalanced() {
		return isBalanced(root);
	}

	private boolean isBalanced(Node node) {

		if (node == null) {
			return true;
		}

		boolean lb = isBalanced(node.left);
		boolean rb = isBalanced(node.right);

		int bf = ht(node.left) - ht(node.right);

		if (lb && rb && (bf == -1 || bf == 0 || bf == 1)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean flipEquivalent(BinaryTree other) {
		return flipEquivalent(this.root, other.root);
	}

	private boolean flipEquivalent(Node x, Node y) {

		if (x == null && y == null) {
			return true;
		}

		if (x == null || y == null || x.data != y.data) {
			return false;
		}

		boolean flip = flipEquivalent(x.left, y.right) && flipEquivalent(x.right, y.left);

		if (flip)
			return true;

		boolean dontflip = flipEquivalent(x.left, y.left) && flipEquivalent(x.right, y.right);

		return flip || dontflip;

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lm = max(node.left);
		int rm = max(node.right);

		return Math.max(node.data, Math.max(lm, rm));
	}

	public int min() {
		return min(root);
	}

	private int min(Node node) {

		if (node == null) {
			return Integer.MAX_VALUE;
		}

		int lm = min(node.left);
		int rm = min(node.right);

		return Math.min(node.data, Math.min(lm, rm));
	}

	public boolean isBST() {
		return isBST(root);
	}

	private boolean isBST(Node node) {

		if (node == null) {
			return true;
		}

		boolean lb = isBST(node.left);
		boolean rb = isBST(node.right);

		if (node.data > max(node.left) && node.data < min(node.right) && lb && rb) {
			return true;
		} else {
			return false;
		}
	}

	private class VOPair {
		Node node;
		int vl;

		public VOPair(Node node, int vl) {
			this.node = node;
			this.vl = vl;
		}
	}

	public void verticalDisplay() {

		int max  = Integer.MIN_VALUE ;
		int min = Integer.MAX_VALUE;
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		Queue<VOPair> q = new LinkedList<>();

		VOPair sp = new VOPair(root, 0);
		q.add(sp);

		while (!q.isEmpty()) {

			// remove the pair from queue
			VOPair rp = q.remove();

			// check of entry is present in hashmap
			if (!map.containsKey(rp.vl)) {
				map.put(rp.vl, new ArrayList<>());
			}

			map.get(rp.vl).add(rp.node.data);

			if (rp.node.left != null) {

				VOPair np = new VOPair(rp.node.left, rp.vl - 1);
				q.add(np);
				
			}

			if (rp.node.right != null) {

				VOPair np = new VOPair(rp.node.right, rp.vl + 1);
				q.add(np);
				
			}
			
			max = Math.max(max, rp.vl) ;
			min = Math.min(min, rp.vl) ;

		}
		
		// way 1
		ArrayList<Integer> keys = new ArrayList<>(map.keySet()) ;
		
		Collections.sort(keys) ;
		
		for(int key : keys) {
			System.out.println(key + " -> " + map.get(key));
		}
		
		// way 2
		for(int i= min ; i <= max ; i++) {
			System.out.println(i + " : " + map.get(i));
		}
	}
}






