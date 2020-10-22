package LL_BT_BST_HM;

public class BSTClient {

	public static void main(String[] args) {

		BST bst = new BST();
		bst.add(50);
		bst.add(30);
		bst.add(60);
		bst.add(20);
		bst.add(35);
		bst.add(70);
		
		bst.display();
		bst.replaceWithSumLarger();
		bst.display();
	}

}
