
public class Airplane extends Vehicle {
	private int numberOfEngines;
	
	public Airplane(int numberOfEngines) {
		this.numberOfEngines = numberOfEngines;
	}

	public int getNumberOfEngines() {
		return numberOfEngines;
	}
	
	@Override
	public String toString() {
		return "Flygplan " + getRegistrationNumber() + ", antal motorer: " + numberOfEngines;
	}
	
}
