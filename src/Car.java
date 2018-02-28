
public class Car extends Vehicle {
	
	private int cylinderVolume;

	public Car(String registrationNumber, String color) {
		super(registrationNumber, color, 4);
		// TODO Auto-generated constructor stub
	}

	public int getCylinderVolume() {
		return cylinderVolume;
	}

	public void setCylinderVolume(int cylinderVolume) {
		this.cylinderVolume = cylinderVolume;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", en bil med motorvolym " + getCylinderVolume();
	}
}