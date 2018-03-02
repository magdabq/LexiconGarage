
public class Airplane extends Vehicle {
	
	private int numberOfEngines;
	
	public Airplane(String registrationNumber, String color, int numberOfWheels, int numberOfEngines) {
	super(registrationNumber, color, numberOfWheels);
		this.numberOfEngines = numberOfEngines;
	}

	public int getNumberOfEngines() {
		return numberOfEngines;
	}
	
	@Override
	public String toString() {
		return "Flygplan : " + getRegistrationNumber();
	}
	
}
