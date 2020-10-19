package OOPS;

public class Client {

	public static void main(String[] args) {

		Student s3 = new Student();
		s3.name = "A";
		s3.age = 10;

		Student s4 = new Student();
		s4.name = "B";
		s4.age = 20;

		// Test2(s3, s4);

		System.out.println(s3.name + " " + s3.age);
		System.out.println(s4.name + " " + s4.age);

		String myName = "C";
		int myAge = 30;

		// Test3(s3, s4.name, s4.age, myName, myAge);

		System.out.println(s3.name + " " + s3.age);
		System.out.println(s4.name + " " + s4.age);
		System.out.println(myName + " " + myAge);

		s3.introduceYourself();
		s4.introduceYourself();

		s3.sayHi("Aman");
	
		System.out.println(s3);

	}

	public static void Test3(Student s, String name, int age, String myName, int myAge) {

		s.name = "_";
		s.age = 0;

		name = "_";
		age = 0;

		myName = "_";
		myAge = 0;

	}

	public static void Test2(Student s1, Student s2) {

		String tempn = s1.name;
		s1.name = s2.name;
		s2.name = tempn;

		s1 = new Student();

		int tempa = s1.age;
		s1.age = s2.age;
		s2.age = tempa;
	}

	public static void Test1(Student s1, Student s2) {

		Student temp = s1;
		s1 = s2;
		s2 = temp;
	}

}
