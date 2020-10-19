package OOPS.Abstraction;

public class Car implements VehicleI {

	@Override
	public int wheels() {
		return 4;
	}
	
	public int sitting() {
		return 5 ;
	}

}
