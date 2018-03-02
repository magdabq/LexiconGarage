
public class Motorcycle extends Vehicle {

	public Motorcycle(String registrationNumber, String color, int numberOfWheels) {
		super(registrationNumber, color, numberOfWheels);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "Motorcykel : " + getRegistrationNumber();
	}
}
