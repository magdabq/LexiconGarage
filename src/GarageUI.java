import java.util.ArrayList;
import java.util.Scanner;

public class GarageUI {

	Garage garage;
	Scanner scanner;
	UIScannerGuard scannerGuard = new UIScannerGuard();
	/**
	 * This is a reference list for the types (of vehicles)
	 */
	ArrayList<String> vehicleTypesLocalLang;
	/**
	 * This is corresponding to previous list
	 */
	ArrayList<Vehicle> vehicleClasses;

	public static void main(String[] args) {
		
		
		GarageUI garageUI = new GarageUI();
		garageUI.garage = null;

		//F�r att l�sa fr�n anv�ndare
		//garageUI.scanner = new Scanner(System.in);

		garageUI.vehicleTypesLocalLang = new ArrayList<String>();
		garageUI.vehicleTypesLocalLang.add("Bil");//1:Bil, 2:Motorcykel, 3: Buss, 4: b�t, 5: flygplan
		garageUI.vehicleTypesLocalLang.add("Motorcykel");
		garageUI.vehicleTypesLocalLang.add("Buss");
		garageUI.vehicleTypesLocalLang.add("B�t");
		garageUI.vehicleTypesLocalLang.add("Flygplan");
		
		
		garageUI.vehicleClasses = new ArrayList<Vehicle>();
		garageUI.vehicleClasses.add(new Car("aaa111","none"));
		garageUI.vehicleClasses.add(new Motorcycle("aaa111", "none", 2));
		garageUI.vehicleClasses.add(new Bus("","",0,0));
		garageUI.vehicleClasses.add(new Boat("","",0));
		garageUI.vehicleClasses.add(new Airplane("", "", 0, 0));
		
		
		

		//Meny
		int choice = 0;
		int subChoice = 0;
		do {
			//simpleClearScreen(); //beh�vs ej f�rsta varvet
			
			if(garageUI.garage == null) {
				System.out.print("V�lkommen till Garage1-appen. Vill du skapa ett garage (j/*)? ");
				String svar = garageUI.scannerGuard.readLine("");
				if(svar.equalsIgnoreCase("j")) {
					garageUI.garage = new Garage();
				}
				else {
					return;//avsluta
				}
				
			}
			else {

				System.out.flush();
				System.out.println("V�lkommen till Garage1 (antal fordon: " + garageUI.garage.getNrOfParkedVehicles() + ", kapacitet: " + garageUI.garage.getMaxCapacity() + ")\n----------------------");

				System.out.println("1: parkera ett fordon");
				System.out.println("2: avregistrera ett fordon");
				System.out.println("3: Lista parkerade fordon");
				System.out.println("4. Lista typer av fordon parkerade");
				System.out.println("5. S�k p� fordon");
				System.out.println("6: St�ll in garagets kapacitet");
				System.out.println("9: avsluta");
				
				choice = garageUI.scannerGuard.readInt("Ange en siffra: ");//garageUI.scanner.nextInt();
				//hasReadInt=true;

				switch(choice) {
				case 1:

					System.out.println("Parkera ett fordon...");
					try {
						//V�ljer fordonstyp
						subChoice = garageUI.chooseVehicleTypeMenu(garageUI.scannerGuard);
						
					} catch (NoVehicleTypeSelectedException e1) {
						System.out.println("Ingen fordonstyp angiven");
					}
					//
					try {
						//F�rs�k parkera/registrera
						garageUI.garage.parkVehicle(
								
								garageUI.registerVehicleMenu(garageUI.scannerGuard, subChoice)
								
								);
					} catch (NoVehicleSelectedException e) {
						System.out.println("Inget fordon angivet");
					}

					break;
				case 2:
					//TODO: avregistrera ett fordon
					
					//Skriv lista med alla fordon, numrerat
					System.out.println("Avregistrera ett fordon");
					
					garageUI.listAllVehiclesNumbered();
					
					//V�lj ett fordon och ta bort det
					try {
						garageUI.deleteVehicleByIndexMenu(garageUI.scannerGuard);
					} catch (NoVehicleSelectedException e) {
						System.out.println("Kunde inte ta bort fordon...");
					}
					
					break;
				case 3:
					//Lista alla fordon
					//ArrayList<Vehicle> list = garageUI.garage.
					garageUI.listAllVehiclesNumberedFull();
					break;
				case 4://lista typer av fordon
					garageUI.listAllTypesInGarage();
					break;
				case 5://s�k
					garageUI.searchMenu();
					
					break;
				case 6:
					garageUI.setGarageCapacity();
				}
			}

			

		}while(choice != 9);

	}

	private void searchMenu() {
		System.out.println("1: s�k p� registreringsnummer\n2: s�k p� antal hjul");
		int choice = scannerGuard.readInt("Ange en siffra: ");
		if(choice==1) {
			searchVehicleByRegistrationNumberMenu();
		}
		else if(choice==2) {
			searchVehicleByNumberOfWheelsMenu();
			
		}
		
	}

	private void setGarageCapacity() {
		int newCapacity = scannerGuard.readInt("Ange en ny kapacitet: ");
		garage.setCapacity(newCapacity);
		
	}

	private void searchVehicleByRegistrationNumberMenu() {
		String searchTerm = scannerGuard.readLine("Ange registreringsnummer: ");
		Vehicle foundVehicle;
		try {
			foundVehicle = garage.findVehicleByRegistraitionNumber(searchTerm);
			
			System.out.println("Hittade: " + foundVehicle);
		} catch (FoundNoVehicleExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void searchVehicleByNumberOfWheelsMenu() {
		int searchTerm = scannerGuard.readInt("Ange antal hjul: ");
		ArrayList<Vehicle> foundVehicles;
		try {
			foundVehicles = garage.findVehiclesByNrOfWheels(searchTerm);
			
			System.out.println("Hittade: " + foundVehicles);
		} catch (FoundNoVehicleExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void listAllTypesInGarage() {
		// TODO Auto-generated method stub
		ArrayList<String> foundTypes = garage.findAllTypesOfVehicles();
		
		ArrayList<String> allTypes = new ArrayList<String>();
		
		//assemble all types
		for(Vehicle type : vehicleClasses) {
			allTypes.add(type.getClass().getName());
		}
		
		for(String typeString : foundTypes) {
			
			if(allTypes.contains(typeString)) {
				int x = allTypes.indexOf(typeString);
				System.out.println(vehicleTypesLocalLang.get(x));
			}
		}
	}

	private void listAllVehiclesNumbered() {
		int counter =1;
		if(garage.getAllParkedVehicles().size()>0) {
			printListHeader();
		}
		
		for(Vehicle vehicle: garage.getAllParkedVehicles()) {
			String format = "%" + 5 + "d";
			System.out.printf(format+"      ", counter);
			System.out.print(centerText(vehicle.getRegistrationNumber(),12));
			System.out.printf("%30s\n", getLocalVehicleTypeName(vehicle.getClass().getName()));//TODO: g�r svensk version
			counter++;
		}
		
	}
	
	private void listAllVehiclesNumberedFull() {
		int counter =1;
		if(garage.getAllParkedVehicles().size()>0) {
			System.out.println("L�pnummer  Info");
		}
		
		for(Vehicle vehicle: garage.getAllParkedVehicles()) {
			String format = "%" + 5 + "d";
			System.out.printf(format+"      ", counter);
			System.out.println(vehicle);
			counter++;
		}
	}
	
	private void printListHeader() {
		//					11 tecken         12     
		System.out.println("L�pnummer  Reg-nummer               Typ");
	}

	/**
	 * A method for retrieving a vehicle from UI - any kind of vehicle
	 * @param scanner - a reused scanner-object
	 * @return the retrieved vehicle
	 * @throws NoVehicleSelectedException
	 */
	public Vehicle registerVehicleMenu(UIScannerGuard scannerGuard, int vehicleType) throws NoVehicleSelectedException{
		//if(hasReadInt) scanner.nextLine();
		
		Vehicle tempVehicle = new Vehicle("", "", 0);
		//System.out.println();
		String tempRegNr = scannerGuard.readLine("Ange registreringsnummer: ");
		//System.out.println("Ange f�rg: ");
		String tempColor = scannerGuard.readLine("Ange f�rg: ");
		//hasReadInt=false;

		switch(vehicleType) {
		case 0://bil
			System.out.println("Skapar ny bil");
			tempVehicle = new Car(tempRegNr, tempColor);
			break;
		case 1://motorcykel
			//System.out.println();
			int numberOfWheels = scannerGuard.readInt("Ange antal hjul (2 eller 3) p� motorcykeln: ");
			int cylinderSize = scannerGuard.readInt("Ange antal cylinderstorlek p� motorcykeln: ");
			//hasReadInt=true;
			if(numberOfWheels==2 || numberOfWheels==3) {
				tempVehicle = new Motorcycle(tempRegNr, tempColor, numberOfWheels, cylinderSize);
			}	
			else throw new NoVehicleSelectedException();
			break;
		case 2://buss
			int numberOfSeats = scannerGuard.readInt("Ange antal s�ten i bussen: ");
			if(numberOfSeats>=0) {
				tempVehicle = new Bus(tempColor, tempRegNr, 6, numberOfSeats);
			}
			else {
				throw new NoVehicleSelectedException();
			}
			break;
		case 3://b�t
			int length = scannerGuard.readInt("Ange b�tens l�ngd i antal hela meter: ");
			if(length>=0) {
				tempVehicle = new Boat(tempRegNr, tempColor, length);
			}
			else {
				throw new NoVehicleSelectedException();
			}
			break;
		case 4://flygplan
			int numberOfEngines = scannerGuard.readInt("Ange antal motorer p� flygplanet: ");
			if(numberOfEngines>=0) {
				tempVehicle = new Airplane(tempRegNr, tempColor, 3, numberOfEngines);
			}
			else {
				throw new NoVehicleSelectedException();
			}
			break;

		default://om ingen typ best�mts, g�r bil
			tempVehicle = new Car(tempRegNr, tempColor);
			System.out.println("Skapade per default en bil...");
		}



		System.out.println("Du har angivit");
		System.out.println(tempVehicle);
		//System.out.println();
		
		//if(hasReadInt) scanner.nextLine();
		String answer = scannerGuard.readLine("Vill du anv�nda (j/*)?");


		if(answer.equalsIgnoreCase("j")) {
			//System.out.println("Ska returnera " + tempVehicle);
			return tempVehicle;
		}
		else {
			//System.out.println("Inget fordon angivet");
			throw new NoVehicleSelectedException();
		}
	}
	
	/**
	 * Askes user for index (1-based) of vehicle, and deletes it
	 * @param scannerGuard
	 * @return
	 */
	public void deleteVehicleByIndexMenu(UIScannerGuard scannerGuard) throws NoVehicleSelectedException{
		int choice = 0;
		choice = scannerGuard.readInt("V�lj fordon: ");//tar in ett l�pnummer "1..."
		
		if(garage.getAllParkedVehicles().get(choice-1) != null) {
			garage.unParkVehicle(garage.getAllParkedVehicles().get(choice-1));
		}
		else {
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
		
		System.out.println("V�lj typ av fordon\n");
		int count=1;
		for(String type: vehicleTypesLocalLang) {
			
			System.out.println(count + ": " + type);
			
			count++;
			
		}
		//System.out.println();
		choice = scannerGuard.readInt("Ange en siffra: ");
		//hasReadInt=true;
		
		if(choice > vehicleTypesLocalLang.size() || choice < 1) {
			throw new NoVehicleTypeSelectedException();
		}
		
		//scanner.nextLine();//m�ste vara s� efter en nextInt om efterf�ljande �r String
		return choice-1;
	}

	public static void simpleClearScreen() {
		System.out.println("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
	}
	
	public String centerText(String text, int maxWidth) {
		if(text==null) {
			StringBuilder string = new StringBuilder();
			//G�r en tom str�ng som �r s� l�ng som maxWidth
			for(int i=0;i<maxWidth*0.75;i++) {
				string.append(' ');
			}
			return string.toString();
		}
		int length = text.length();
		StringBuilder string = new StringBuilder();
		if(length >= maxWidth) {
			return text;
		}
		else {
			int spare = length;
			int leftSpace = spare/2;
			spare = maxWidth-length-leftSpace;
			
			for(int i=0; i<leftSpace; i++) {
				string.append(" ");
			}
			
			string.append(text);
			
			for(int i=0;i<spare;i++) {
				string.append(" ");
			}
			
			return string.toString();
		}
	}
	
	/**
	 * A method to get the corresponding localized name for the english name
	 * @param englishName - the name returned by .getClass.getName()
	 * @return - The localized name
	 */
	public String getLocalVehicleTypeName(String englishName) {
		for(Vehicle vehicle: vehicleClasses) {
			if(vehicle.getClass().getName().equals(englishName)) {
				return vehicleTypesLocalLang.get(vehicleClasses.indexOf(vehicle));
			}
		}
		return "";
	}
}