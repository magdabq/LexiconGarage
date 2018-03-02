import java.util.ArrayList;
import java.util.Scanner;

public class GarageUI {

	Garage garage;
	Scanner scanner;
	UIScannerGuard scannerGuard = new UIScannerGuard();
	/**
	 * This is a reference list for the types (of vehicles)
	 */
	ArrayList<String> vehicleTypes;

	public static void main(String[] args) {
		
		
		GarageUI garageUI = new GarageUI();
		garageUI.garage = new Garage();

		//För att läsa från användare
		garageUI.scanner = new Scanner(System.in);

		garageUI.vehicleTypes = new ArrayList<String>();
		garageUI.vehicleTypes.add("Bil");//1:Bil, 2:Motorcykel, 3: Buss, 4: båt, 5: flygplan
		garageUI.vehicleTypes.add("Motorcykel");
		garageUI.vehicleTypes.add("Buss");
		garageUI.vehicleTypes.add("Boat");
		garageUI.vehicleTypes.add("Flygplan");

		//Meny
		int choice = 0;
		int subChoice = 0;
		do {
			//simpleClearScreen(); //behövs ej första varvet

			System.out.flush();
			System.out.println("Välkommen till Garage1 (antal fordon: " + garageUI.garage.getNrOfParkedCars() + ", kapacitet: " + garageUI.garage.getMaxCapacity() + ")\n----------------------");

			System.out.println("1: parkera ett fordon");
			System.out.println("2: avskriv ett fordon");
			System.out.println("3: Lista parkerade fordon");
			System.out.println("9: avsluta");
			
			choice = garageUI.scannerGuard.readInt("Ange en siffra: ");//garageUI.scanner.nextInt();
			//hasReadInt=true;

			switch(choice) {
			case 1:

				System.out.println("Parkera ett fordon...");
				try {
					subChoice = garageUI.chooseVehicleTypeMenu(garageUI.scannerGuard);
				} catch (NoVehicleTypeSelectedException e1) {
					System.out.println("Ingen fordonstyp angiven");
				}
				//
				try {
					garageUI.garage.parcVehicle(
							garageUI.registerVehicleMenu(garageUI.scannerGuard, subChoice)
							);
				} catch (NoVehicleSelectedException e) {
					System.out.println("Inget fordon angivet");
				}

				break;
			case 2:
				//TODO: avskriv ett fordon
				break;
			case 3:
				//ArrayList<Vehicle> list = garageUI.garage.
				break;
				
			}

		}while(choice != 9);

	}

	/**
	 * A method for retrieving a vehicle from UI - any kind of vehicle
	 * @param scanner - a reused scanner-object
	 * @return the retrieved vehicle
	 * @throws NoVehicleSelectedException
	 */
	public Vehicle registerVehicleMenu(UIScannerGuard scannerGuard, int vehicleType) throws NoVehicleSelectedException{
		//if(hasReadInt) scanner.nextLine();
		
		Vehicle tempVehicle = new Vehicle();
		//System.out.println();
		String tempRegNr = scannerGuard.readLine("Ange registreringsnummer: ");
		//System.out.println("Ange färg: ");
		String tempColor = scannerGuard.readLine("Ange färg: ");
		//hasReadInt=false;

		switch(vehicleType) {
		case 0:
			System.out.println("Skapar ny bil");
			tempVehicle = new Car(tempRegNr, tempColor);
			break;
		case 1:
			System.out.println("Skapar ny motorcykel");
			//System.out.println();
			int numberOfWheels = scannerGuard.readInt("Ange antal hjul (2 eller 3): ");
			//hasReadInt=true;
			if(numberOfWheels==2 || numberOfWheels==3) {
				tempVehicle = new Motorcycle(tempRegNr, tempColor, numberOfWheels);
			}	
			else throw new NoVehicleSelectedException();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;

		default://om ingen typ bestämts, gör bil
			tempVehicle = new Car(tempRegNr, tempColor);
			System.out.println("Skapade per default en bil...");
		}



		System.out.println("Du har angivit");
		System.out.println(tempVehicle);
		//System.out.println();
		
		//if(hasReadInt) scanner.nextLine();
		String answer = scannerGuard.readLine("Vill du använda (j/*)?");


		if(answer.equalsIgnoreCase("j")) {
			System.out.println("Ska returnera " + tempVehicle);
			return tempVehicle;
		}
		else {
			System.out.println("Inget fordon angivet");
			throw new NoVehicleSelectedException();
		}
	}

	/**
	 * Functions for defining a type of vehicle
	 * @param scanner - reused scanner object
	 * @return - the number corresponding to vehicle type in the ArrayList vehicleTypes
	 * @throws NoVehicleTypeSelectedException
	 */
	public int chooseVehicleTypeMenu(UIScannerGuard scannerGuard) throws NoVehicleTypeSelectedException{
		
		//if(hasReadInt) scanner.nextLine();
		
		
		int choice = 0;
		System.out.println("Välj typ av fordon\n");
		int count=1;
		for(String type: vehicleTypes) {
			System.out.println(count + ": " + type);
			count++;
		}
		//System.out.println();
		choice = scannerGuard.readInt("Ange en siffra: ");
		//hasReadInt=true;
		if(choice > vehicleTypes.size() || choice < 1) {
			throw new NoVehicleTypeSelectedException();
		}
		//scanner.nextLine();//måste vara så efter en nextInt om efterföljande är String
		return choice-1;
	}

	public static void simpleClearScreen() {
		System.out.println("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
	}

}
