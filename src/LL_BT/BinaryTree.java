package LL_BT;

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

		if(node == null) {
			return true ;
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
		return flipEquivalent(this.root, other.root) ;
	}
	
	private boolean flipEquivalent(Node x, Node y) {
		
		if(x == null && y == null) {
			return true ;
		}
		
		if(x == null ||  y == null || x.data != y.data) {
			return false ;
		}
		
		boolean flip = flipEquivalent(x.left, y.right) && flipEquivalent(x.right, y.left) ;
		
		if(flip)
			return true ;
		
		boolean dontflip = flipEquivalent(x.left, y.left) && flipEquivalent(x.right, y.right) ;
		
		return flip || dontflip ;
		
		
	}
}





