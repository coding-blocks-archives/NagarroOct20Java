package LL_BT;

public class BTClient {

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		bt.takeInput();
		bt.display();

		BinaryTree bt2 = new BinaryTree();
		bt2.takeInput();

		System.out.println(bt.flipEquivalent(bt2));

	}

}