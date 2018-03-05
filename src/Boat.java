
public class Boat extends Vehicle {

	private int length;

	public Boat(String registrationNumber, String color, int length) {
		super(registrationNumber, color, 0);
		this.length = length;
	}
	
//	public Boat(int length) {
//		this.length = length;
//	}

	public int getLength() {
		return length;
	}
	
	@Override
	public String toString() {
		return "Båt " + getRegistrationNumber() + ", längd " + length + " m.";
	}
	
}
