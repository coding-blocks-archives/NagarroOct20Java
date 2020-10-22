package LL_BT_BST_HM;

public class BST {

	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	private Node root;

	public void add(int item) {
		root = add(root, item);
	}

	private Node add(Node node, int item) {

		if (node == null) {
			Node nn = new Node(item);
			return nn;
		}

		if (item <= node.data) {
			node.left = add(node.left, item);
		} else {
			node.right = add(node.right, item);
		}

		return node;

	}

	public void display() {
		System.out.println("-----------------");
		display(root);
		System.out.println("-----------------");
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

	public void replaceWithSumLarger() {
		replaceWithSumLarger(root, new int[1]);
	}

	private void replaceWithSumLarger(Node node, int[] sum) {

		if (node == null)
			return;

		replaceWithSumLarger(node.right, sum);

		int temp = node.data;
		node.data = sum[0];
		sum[0] += temp;

		replaceWithSumLarger(node.left, sum);

	}

}
