import java.util.ArrayList;
import java.util.Scanner;

public class GarageUI {
	
	Garage garage;
	Scanner scanner;

	public static void main(String[] args) {
		
		
		GarageUI garageUI = new GarageUI();
		
		garageUI.garage = new Garage();
		
		//F�r att l�sa fr�n anv�ndare
		garageUI.scanner = new Scanner(System.in);
		
		ArrayList<String> vehicleTypes = new ArrayList<String>();
		vehicleTypes.add("Bil");//1:Bil, 2:Motorcykel, 3: Buss, 4: b�t, 5: flygplan
		
		
		
		System.out.println("V�lkommen till Garage1\n----------------------");
		//TODO: skriv ut antal fordon parkerade
		
		//Meny
		int choice = 0;
		int subChoice = 0;
		do {
			//simpleClearScreen(); //beh�vs ej f�rsta varvet
			System.out.flush();
			System.out.println("Huvudmeny\n---------\n\n");
			
			System.out.println("1: registrera ett fordon");
			System.out.println("9: avsluta");
			
			
			System.out.println("Ange en siffra: ");
			choice = garageUI.scanner.nextInt();
			
			switch(choice) {
			case 1:
				
				System.out.println("Parkera ett fordon...\nV�lj typ av fordon\n");
				int count=1;
				for(String type: vehicleTypes) {
					System.out.println(count + ": " + type);
					count++;
				}
				System.out.println("Ange en siffra: ");
				subChoice = garageUI.scanner.nextInt();
				garageUI.scanner.nextLine();//m�ste vara s� efter en nextInt om efterf�ljande �r String
				
				switch(subChoice) {
				case 1:
					//fordon
					try {
						garageUI.garage.parcVehicle(
								garageUI.registerVehicleMenu(garageUI.scanner)
								);
					} catch (NoVehicleSelectedException e) {
						System.out.println("Inget fordon angivet");
					}

					break;
				}
				break;
			}
			
		}while(choice != 9);
		
	}
	
	public Vehicle registerVehicleMenu(Scanner scanner) throws NoVehicleSelectedException{
		System.out.println("Ange registreringsnummer: ");
		String tempRegNr = scanner.nextLine();
		System.out.println("Ange f�rg: ");
		String tempColor = scanner.nextLine();
		
		Car tempCar = new Car(tempRegNr, tempColor);
		
		System.out.println("Du har angivit");
		System.out.println(tempCar);
		System.out.println("Vill du anv�nda (j/*)?");
		
		String answer = scanner.nextLine();
		
		if(answer.equalsIgnoreCase("j")) {
			return tempCar;
		}
		else {
			throw new NoVehicleSelectedException();
		}
	}
	
	public static void simpleClearScreen() {
		System.out.println("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
	}

}
