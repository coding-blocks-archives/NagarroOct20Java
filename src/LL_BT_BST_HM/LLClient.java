package LL_BT_BST_HM;

public class LLClient {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		// list.createDummyListIntersection();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		list.addLast(70);
		list.addLast(80);
		// list.addLast(90);
		list.display();
		list.kReverse(3);
		list.display();

	}

}
