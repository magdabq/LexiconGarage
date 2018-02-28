
public class Vehicle {
	private String registrationNumber;
	private String color;//TODO: ersätt med en förenklad RGB-color-wheel med 8 värden (3 bitar) per grundfärg (Red Green Blue)
	private int numberOfWheels;
	
	public Vehicle(String registrationNumber, String color, int numberOfWheels) {
		this.registrationNumber = registrationNumber;
		this.color = color;
		this.numberOfWheels = numberOfWheels;
	}
	
	public Vehicle(String registrationNumber, int numberOfWheels) {
		this(registrationNumber, "", numberOfWheels);
	}
	
	public Vehicle(int numberOfWheels) {
		this("", "", numberOfWheels);
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}
	
	
	
	
}
