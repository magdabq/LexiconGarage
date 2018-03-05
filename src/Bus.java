
public class Bus extends Vehicle {

	private int numberOfSeats;
	
	public Bus(String color, String registrationNumber, int numberOfWheels,int numberOfSeats) {
		super(registrationNumber,color, numberOfWheels); //Calls the super class contructor
		this.numberOfSeats = numberOfSeats;
	}
//	
	
	
//	public Bus(int numberOfSeats) {
//		this.numberOfSeats = numberOfSeats;
//	}
//
//	public int getNumberOfSeats() {
//		return numberOfSeats;
//	}
	
	public int getNumberOfSeats() {
		return numberOfSeats;
	}


	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	@Override
	public String toString() {
		return "Buss : " + getRegistrationNumber();
	}



	
}
