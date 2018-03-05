
public class Bus extends Vehicle {

	private int numberOfSeats;
	
	public Bus(String color) {
		super(color);//Calls the super class contructor
	}
	
	public Bus(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	

	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	
	@Override
	public String toString() {
		return "Buss " + getRegistrationNumber() + ", antal säten: " + numberOfSeats;
	}
	
}
