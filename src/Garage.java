import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Garage {

	private int maxCapacity;
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
		
		Car c1 = new Car("EBC124", "Blue");
		Car c2 = new Car("EDC124", "Blue");
		Car c3 = new Car("EDC125", "Red");
		Car c4 = new Car("EDC126", "Red");
		Car c5 = new Car("EDC126", "Green,");
		
		Airplane a1 = new Airplane("LDF012","Orange",4,2);
		Boat b1 = new Boat("YYY555", "white", 6);
		
		
		Motorcycle mc1 = new Motorcycle("ABC111","black", 2);
		Motorcycle mc2 = new Motorcycle("ABC222","black", 2);
		Motorcycle mc3 = new Motorcycle("ABC222","white", 2);
		
		Bus bu1 = new Bus("white", "FDB078", 4, 50);
		
		System.out.println(c2.toString());
		System.out.println(c4);
		System.out.println(b1);
		System.out.println(mc1);
		System.out.println(a1);
		System.out.println(bu1);
		
		
		garage1.parkVehicle(c1);
		garage1.parkVehicle(c2);
		garage1.parkVehicle(c3);
		garage1.parkVehicle(mc1);
		garage1.parkVehicle(mc2);
		garage1.parkVehicle(mc3);
		garage1.parkVehicle(c3);
		garage1.unParkVehicle(mc3);
		garage1.parkVehicle(b1);
		
		System.out.println(c1.getRegistrationNumber());
		
		System.out.println("Så här många platser upptagna i Garaget:  " + garage1.getNrOfParkedVehicles());
		//System.out.println(garage1.getAllParkedVehicles());
		//System.out.println(garage2.getMaxCapacity());
		System.out.println("Tomma platser i garaget " + garage1.nrOfEmptyParkingLots());
		String resultat;
		ArrayList<Vehicle> arrayResultat;
		
		int i = 4;
		
		try {
			resultat = garage1.findVehicleByRegistraitionNumber("EBC124").getRegistrationNumber();
		System.out.println("Hittade fordonet med regnr resultat " + resultat);
//			
//			arrayResultat = garage1.findVehiclesByNrOfWheels(i);
//			System.out.println();
//			System.out.println("Hittade dessa fordon med " + i + " hjul " + arrayResultat);
//			
		} catch (FoundNoVehicleExeption e) {
			System.out.println("No Vehicle found");			
		}	
		
		//Testar och skriver ut regnr på alla fordon som finns i garaget
		List<Vehicle> listaAvAllaFordon = garage1.getAllParkedVehicles();
		System.out.println("Alla fordons regnr ");
		for (Vehicle fordon : listaAvAllaFordon) {
			System.out.println(fordon);
			}
		
		//Testar och skriver ut de olika fordonstyperna som finns i garaget
		ArrayList<String> listaUnikaFordon = garage1.findAllTypesOfVehicles();
		System.out.println("Fordonstyper i Garaget:");
		for (String fordonsTyp : listaUnikaFordon) {
			
			System.out.print(" " + fordonsTyp);
		}
		
		
	}//															Här slutar mitt testblockk!!
	
	
	
	public int getMaxCapacity() {
		return maxCapacity;
	}

	public int nrOfEmptyParkingLots() {
		return maxCapacity-allParkedVehicles.size();
	}
	
	public int nrOfOccupiedParkingLots() {
		return allParkedVehicles.size();
	}

	public void parkVehicle(Vehicle newVehicle) {
		allParkedVehicles.add(newVehicle);
	}//parcVehicle
	
	public void unParkVehicle(Vehicle newVehicle) {
		allParkedVehicles.remove(newVehicle);
	}//unParcVehicle

	
	public Vehicle findVehicleByRegistraitionNumber(String registrationNumber)  throws FoundNoVehicleExeption {
		//TODO måste debugga denna metod
		for (Vehicle fordon : allParkedVehicles) {

			if (fordon.getRegistrationNumber().equals(registrationNumber)) {

				return fordon;
			}
		}
		throw new FoundNoVehicleExeption();

	} // findVehicleRegnr

	public ArrayList<Vehicle> findVehiclesByNrOfWheels(int nrOfWheels) throws FoundNoVehicleExeption {
		ArrayList<Vehicle> allParkedByNumberOfWheels = new ArrayList<Vehicle>();
		for (Vehicle fordon : allParkedVehicles) {

			if (fordon.getNumberOfWheels() == nrOfWheels) {
				allParkedByNumberOfWheels.add(fordon);

			}
		}
		if (allParkedByNumberOfWheels.isEmpty()) {
			throw new FoundNoVehicleExeption();

		} else {
			return allParkedByNumberOfWheels;
		}
	} 

	
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
	 

	public List<Vehicle> getAllParkedVehicles() {
		return  Collections.unmodifiableList(allParkedVehicles);
		//return allParkedVehicles;
	}

	public int  getNrOfParkedVehicles() {
	 int total = allParkedVehicles.size();
	 return total;
	}

	public void setCapacity(int newCapacity) {
		this.maxCapacity =  newCapacity;
	}	

}	

