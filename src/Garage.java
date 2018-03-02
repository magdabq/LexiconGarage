import java.util.ArrayList;

public class Garage {

	private final int maxCapacity;
	private ArrayList<Vehicle> allParkedVehicles = new ArrayList<Vehicle>();
	
	public Garage() {
	maxCapacity = 50;	
	}
	
	public Garage(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		
	}
	
	public static void main(String[] args) {		//Härinne testar jag!!!!
		Garage garage1 = new Garage();
		Garage garage2 = new Garage(70);
		
		Car c1 = new Car("EDC123", "white");
		Car c2 = new Car("EDC124", "Blue");
		Car c3 = new Car("EDC125", "Red");
		Car c4 = new Car("EDC126", "Red");
		Motorbike mc1 = new Motorbike("ABC111","black", 2);
		Motorbike mc2 = new Motorbike("ABC222","black", 2);

		garage1.parcVehicle(c1);
		garage1.parcVehicle(c2);
		garage1.parcVehicle(c3);
		garage1.parcVehicle(mc1);
		garage1.parcVehicle(mc2);
		
		System.out.println("Så här många platser upptagna i Garaget:  " + garage1.allParkedVehicles.size());
		//System.out.println(garage1.getAllParkedVehicles());
		//System.out.println(garage2.getMaxCapacity());
		
		String resultat;
		
		try {
			resultat = garage1.findVehicleRegistraitionNumber("EDC123").getRegistrationNumber();
			System.out.println(resultat);
			resultat = "" + garage1.findVehicleNrOfWheels(2).getNumberOfWheels();
			System.out.println(resultat);
			
		} catch (FoundNoVehicleExeption e) {
			System.out.println("No car found");			
		}	
		
//		//Testar och skriver ut regnr på alla fordon som finns i garaget
//		ArrayList<Vehicle> listaAvAllaFordon = garage1.getAllParkedVehicles();
//		for (Vehicle fordon : listaAvAllaFordon) {
//			System.out.println(fordon.getRegistrationNumber());
//			}
//		
//		//Testar och skriver ut de olika fordonstyperna som finns i garaget
//		ArrayList<String> listaUnikaFordon = garage1.findAllTypesOfVehicles();
//		System.out.println("Fordonstyper i Garaget:");
//		for (String fordonsTyp : listaUnikaFordon) {
//			// TODO OBS! Ger typerna på engelska fixa?
//			System.out.print(" " + fordonsTyp);
//		}
		
		
	}//															Här slutar mitt testblockk!!
	
	
	
	public int getMaxCapacity() {
		return maxCapacity;
	}


	public void parcVehicle(Vehicle newVehicle) {
		allParkedVehicles.add(newVehicle);
	}//parcVehicle
	
	public void unParcVehicle(Vehicle newVehicle) {
		allParkedVehicles.remove(newVehicle);
	}//unParcVehicle

	
	public Vehicle findVehicleRegistraitionNumber(String registrationNumber) throws FoundNoVehicleExeption {

		for (Vehicle fordon : allParkedVehicles) {

			if (fordon.getRegistrationNumber().equals(registrationNumber)) { 	
				
				return fordon;
			}			
		}
		throw new FoundNoVehicleExeption();
		
	} //findVehicleRegnr
	

	public Vehicle findVehicleNrOfWheels(int nrOfWheels) throws FoundNoVehicleExeption {

		for (Vehicle fordon : allParkedVehicles) {

			if (fordon.getNumberOfWheels() == nrOfWheels) { 	
				
				return fordon;
			}			
		}
		throw new FoundNoVehicleExeption();
		
	} //findVehicleNrOfWheels
	
	
	// Letar igenom vehicleList och sparar namnen på de fordonsklasser den hittar i
	// allParkedTypes.
	// Returnerar nu endast listan som den är.

	public ArrayList<String> findAllTypesOfVehicles() {
		ArrayList<String> allParkedTypes = new ArrayList<String>();
		for (Vehicle fordon : allParkedVehicles) {
			if (allParkedTypes.contains(fordon.getClass().getName()))
				;
			else {
				allParkedTypes.add(fordon.getClass().getName());
			}
		}
		return allParkedTypes;
	}
	 
	

	public ArrayList<Vehicle> getAllParkedVehicles() {
		return allParkedVehicles;
	}

	public int  getNrOfParkedCars() {
	 int total = allParkedVehicles.size();
	 return total;
	}	
		
//	public ArrayList<String> listAllVehicles() {
//		ArrayList<String> allParkedVehicles = new ArrayList<String>();
//		for (Vehicle fordon : allParkingLotsInGarage) {
//			allParkedVehicles.add(fordon.getRegistrationNumber);
//		}
//}
}	

