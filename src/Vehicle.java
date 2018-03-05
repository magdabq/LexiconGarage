
public class Vehicle {
	private String registrationNumber;
	private String color;//TODO: ersätt med en förenklad RGB-color-wheel med 8 värden (3 bitar) per grundfärg (Red Green Blue)
	private int numberOfWheels;
	
	private final String registrationFormat = "AAA111"; //A pattern to decide what a registration nr. should be. A: letter 1: digit X: any
	
	public Vehicle(String registrationNumber, String color, int numberOfWheels) {
		this.registrationNumber = registrationNumber;
		this.color = color;
		this.numberOfWheels = numberOfWheels;
	}
	

//	public Vehicle(String registrationNumber, int numberOfWheels) {
//		this(registrationNumber, "", numberOfWheels);
//	}
//	
//	public Vehicle(int numberOfWheels) {
//		this("", "", numberOfWheels);
//	}
//	
//	public Vehicle(String color) {
//		this.color = color;
//	}
//	
//	public Vehicle() {
//	}


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
	
	public boolean acceptRegistrationNumber(String registrationNumber) {
		//use the registrationFormat variable
		for(int i=0, j=0; i<registrationFormat.length() && j<registrationNumber.length(); i++, j++) {
			
			while(registrationNumber.charAt(j)==' ') {
				j++;//jumps over any white_space
			}
			
			switch(registrationFormat.charAt(i)) {
			case 'A':
				if(!Character.isAlphabetic(registrationNumber.charAt(j))) {
					return false;
				}
				break;
			case '1':
				if(!Character.isDigit(registrationNumber.charAt(j))) {
					return false;
				}
				break;
			case 'X':
				break;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Vehicle, registration-number: " + getRegistrationNumber() + ", Nr of wheels: " + getNumberOfWheels() + ", color: " + getColor();
	}
	
}
