
public class Garage {
	
	private int maxCapacity;
	private int nextPosition =0;
	
	private Vehicle[] vehiclesInGarage = new Vehicle [100];
	
	public void parcVehicle(Vehicle newVehicle) {
	
		vehiclesInGarage [nextPosition] = newVehicle;
		nextPosition++;
	}
	
	

}
