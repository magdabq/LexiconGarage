import java.util.ArrayList;
import java.util.Scanner;

public class GarageUI {

	Garage garage;
	Scanner scanner;
	/**
	 * This is a reference list for the types (of vehicles)
	 */
	ArrayList<String> vehicleTypes;

	public static void main(String[] args) {


		GarageUI garageUI = new GarageUI();

		garageUI.garage = new Garage();

		//F�r att l�sa fr�n anv�ndare
		garageUI.scanner = new Scanner(System.in);

		garageUI.vehicleTypes = new ArrayList<String>();
		garageUI.vehicleTypes.add("Bil");//1:Bil, 2:Motorcykel, 3: Buss, 4: b�t, 5: flygplan
		garageUI.vehicleTypes.add("Motorcykel");
		garageUI.vehicleTypes.add("Buss");
		garageUI.vehicleTypes.add("Boat");
		garageUI.vehicleTypes.add("Flygplan");


		System.out.println("V�lkommen till Garage1\n----------------------");
		//TODO: skriv ut antal fordon parkerade

		//Meny
		int choice = 0;
		int subChoice = 0;
		do {
			//simpleClearScreen(); //beh�vs ej f�rsta varvet
			System.out.flush();
			System.out.println("Huvudmeny\n---------\n\n");

			System.out.println("1: parkera ett fordon");
			System.out.println("2: avskriv ett fordon");
			System.out.println("9: avsluta");


			System.out.println("Ange en siffra: ");
			choice = garageUI.scanner.nextInt();

			switch(choice) {
			case 1:

				System.out.println("Parkera ett fordon...");
				try {
					subChoice = garageUI.chooseVehicleTypeMenu(garageUI.scanner);
				} catch (NoVehicleTypeSelectedException e1) {
					System.out.println("Ingen fordonstyp angiven");
				}

				try {
					garageUI.garage.parcVehicle(
							garageUI.registerVehicleMenu(garageUI.scanner, subChoice)
							);
				} catch (NoVehicleSelectedException e) {
					System.out.println("Inget fordon angivet");
				}

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
	public Vehicle registerVehicleMenu(Scanner scanner, int vehicleType) throws NoVehicleSelectedException{
		Vehicle tempVehicle;
		System.out.println("Ange registreringsnummer: ");
		String tempRegNr = scanner.nextLine();
		System.out.println("Ange f�rg: ");
		String tempColor = scanner.nextLine();

		switch(vehicleType) {
		case 1:
			tempVehicle = new Car(tempRegNr, tempColor);
			break;

		default://om ingen typ best�mts, g�r bil
			tempVehicle = new Car(tempRegNr, tempColor);
		}



		System.out.println("Du har angivit");
		System.out.println(tempVehicle);
		System.out.println("Vill du anv�nda (j/*)?");

		String answer = scanner.nextLine();

		if(answer.equalsIgnoreCase("j")) {
			return tempVehicle;
		}
		else {
			throw new NoVehicleSelectedException();
		}
	}

	public int chooseVehicleTypeMenu(Scanner scanner) throws NoVehicleTypeSelectedException{
		int choice = 0;
		System.out.println("V�lj typ av fordon\n");
		int count=1;
		for(String type: vehicleTypes) {
			System.out.println(count + ": " + type);
			count++;
		}
		System.out.println("Ange en siffra: ");
		choice = scanner.nextInt();
		if(choice > vehicleTypes.size() || choice < 1) {
			throw new NoVehicleTypeSelectedException();
		}
		//scanner.nextLine();//m�ste vara s� efter en nextInt om efterf�ljande �r String
		return choice;
	}

	public static void simpleClearScreen() {
		System.out.println("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
	}

}
