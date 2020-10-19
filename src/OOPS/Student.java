package OOPS;

public class Student {

	String name ;
	int age ;
	
	public void introduceYourself() {
		System.out.println(name + " is " + age + " years old.");
	}
	
	public void sayHi(String name) {
		System.out.println(this.name + " says hi to " + name);
	}
	
	public String toString() {
		return name + " and " + age ;
	}
}
