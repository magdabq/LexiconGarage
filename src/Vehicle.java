
public class Vehicle {
	private String registrationNumber;
	private String color;//TODO: ers�tt med en f�renklad RGB-color-wheel med 8 v�rden (3 bitar) per grundf�rg (Red Green Blue)
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
