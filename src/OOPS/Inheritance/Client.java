package OOPS.Inheritance;

public class Client {

	public static void main(String[] args) {

		// case 1
		P o1 = new P();
		System.out.println(o1.d);
		System.out.println(o1.d1);

		o1.fun();
		o1.fun1();

		// case 2
		P o2 = new C();
		System.out.println(o2.d); // 10
		System.out.println(((C) o2).d); // 20
		System.out.println(o2.d1); // 100
		System.out.println(((C) o2).d2); // 200

		o2.fun(); // C Fun
		o2.fun1(); // P Fun 1
		((C) o2).fun2(); // C Fun 2

		// case 3
		// C o3 = new P() ;

		// case 4
		C o4 = new C();
		System.out.println(o4.d); // 20
		System.out.println(((P) o4).d); // 10
		System.out.println(o4.d1); // 100
		System.out.println(o4.d2); // 200
		o4.fun(); // C Fun
		o4.fun1(); // P Fun 1
		o4.fun2(); // C Fun 2

	}
}
