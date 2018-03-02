
public class Car extends Vehicle {

	private String fuelType;

	public Car(String registrationNumber, String color ) {
		super(color, registrationNumber, 4);
		this.fuelType = "";

	}
	
	
	public String getFuelType() {
		return fuelType;
	}


	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "Bil : " + getRegistrationNumber();
	}
}