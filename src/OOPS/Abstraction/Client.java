package OOPS.Abstraction;

public class Client {

	public static void main(String[] args) {
		
		VehicleAC obj = new Bike() ;
		System.out.println(obj.wheels());
		obj.breaks(); 
		
	}
}
