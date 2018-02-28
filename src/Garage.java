
public class Garage {

	private int maxCapacity;
	private int nextPosition = 0;

	private Vehicle[] vehiclesInGarage = new Vehicle[100];

	public void parcVehicle(Vehicle newVehicle) {

		vehiclesInGarage[nextPosition] = newVehicle;
		nextPosition++;
	}

	public Vehicle findVehicle(String registrationNumber) {

		for (int i = 0; i < nextPosition; i++) {

			if (vehiclesInGarage[i].getRegistrationNumber().equals(registrationNumber)) {
				return vehiclesInGarage[i];
			}

		}

		return null;
	}
	
	
	
//	public String getTypesInGarage(Vehicle vehiclesInGarage) {
//		
//	private String carType = 0;
//	private String boatType = 0;
//	
//	for (int i = 0; i < nextPosition; i++) {
//	
//	
//	}
}

