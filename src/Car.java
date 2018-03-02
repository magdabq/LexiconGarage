
public class Car extends Vehicle {
	
	private String fuelType;

	public Car(String registrationNumber, String color) {
		super(registrationNumber, color, 4);
		// TODO Auto-generated constructor stub
	}

	public String getFuelType() {
		return fuelType;
	}

	
	@Override
	public String toString() {
		return "Bil : " + getRegistrationNumber();
	}
}