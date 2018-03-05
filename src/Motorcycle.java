
public class Motorcycle extends Vehicle {

	private int cylinderVolume;

	public Motorcycle(String registrationNumber, String color, int numberOfWheels, int cylinderVolume) {
		super(registrationNumber, color, numberOfWheels);

		this.cylinderVolume = cylinderVolume;
	}

	public Motorcycle(String registrationNumber, String color, int cylinderVolume) {
		super(registrationNumber, color, 2);
	
	this.cylinderVolume = cylinderVolume;

	}


	public int getCylinderVolume() {
		return cylinderVolume;
	}


	@Override
	public String toString() {
		return "Motorcykel : " + getRegistrationNumber() + ", cylindervolym: " + getCylinderVolume();
	}

}
