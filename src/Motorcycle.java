
public class Motorcycle extends Vehicle {
	
	private int cylinderVolume;

	public Motorcycle(String registrationNumber, String color, int numberOfWheels) {
		super(registrationNumber, color, numberOfWheels);
		// TODO Auto-generated constructor stub
	}
	

	
	public int getCylinderVolume() {
		return cylinderVolume;
	}


	@Override
	public String toString() {
		return "Motorcykel : " + getRegistrationNumber() + ", cylindervolym: " + getCylinderVolume();
	}
}
