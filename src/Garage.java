import java.util.ArrayList;

public class Garage {

	private final int maxCapacity = 50;
	private ArrayList<Vehicle> allParkingLotsInGarage = new ArrayList<Vehicle>();
	
	
	
	public static void main(String[] args) {
		Garage garage1 = new Garage();

		Car c1 = new Car("EDC123", "white");
		Car c2 = new Car("EDC124", "Blue");
		Car c3 = new Car("EDC125", "Red");
		Car c4 = new Car("EDC126", "Red");
		Motorbike mc1 = new Motorbike("ABC111","black", 2);
		Motorbike mc2 = new Motorbike("ABC222","black", 2);

		garage1.parcVehicle(c1);
		garage1.parcVehicle(c2);
		garage1.parcVehicle(c3);
		
		
		String resultat;
		
		try {
			resultat = garage1.findVehicle("EDC123").getRegistrationNumber();
			System.out.println(resultat);
			resultat = garage1.findVehicle("EDC127").getRegistrationNumber();
			System.out.println(resultat);
			
		} catch (FoundNoVehicleExeption e) {
			System.out.println("No car found");			
		}	
		ArrayList<Vehicle> listaAvAllaFordon = garage1.getAllParkingLotsInGarage();
		for (Vehicle fordon : listaAvAllaFordon) {
			System.out.println(fordon.toString());
		}
		
		ArrayList<String> listaUnikaFordon = garage1.findAllTypesOfVehicles();
		for (String fordonsTyp : listaUnikaFordon) {
			System.out.println(fordonsTyp);
		}
		
		
	}
	
	
	public void parcVehicle(Vehicle newVehicle) {
		allParkingLotsInGarage.add(newVehicle);
	}//parcVehicle
	
	public void unParcVehicle(Vehicle newVehicle) {
		allParkingLotsInGarage.remove(newVehicle);
	}//unParcVehicle

	
	public Vehicle findVehicle(String registrationNumber) throws FoundNoVehicleExeption {

		for (Vehicle fordon : allParkingLotsInGarage) {

			if (fordon.getRegistrationNumber().equals(registrationNumber)) { 	
				
				return fordon;
			}			
		}
		throw new FoundNoVehicleExeption();
	} //findVehicle

	
	// Letar igenom vehicleList och sparar namnen på de fordonsklasser den hittar i
	// allParkedTypes.
	// Returnerar nu endast listan som den är.

	public ArrayList<String> findAllTypesOfVehicles() {
		ArrayList<String> allParkedTypes = new ArrayList<String>();
		for (Vehicle fordon : allParkingLotsInGarage) {
			if (allParkedTypes.contains(fordon.getClass().getName()))
				;
			else {
				allParkedTypes.add(fordon.getClass().getName());
			}
		}
		return allParkedTypes;
	}
	 
	

	public ArrayList<Vehicle> getAllParkingLotsInGarage() {
		return allParkingLotsInGarage;
	}

	public int  getNrOfParkedCars() {
	 int total = allParkingLotsInGarage.size();
	 return total;
	}	
		
//	public ArrayList<String> listAllVehicles() {
//		ArrayList<String> allParkedVehicles = new ArrayList<String>();
//		for (Vehicle fordon : allParkingLotsInGarage) {
//			allParkedVehicles.add(fordon.getRegistrationNumber);
//		}
//}
}	

