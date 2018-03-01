import java.util.Scanner;

/**
 * To offer easy use of Scanner even if nextLine is used after nextInt.
 * Should completely replace any use of any instance of java.util.Scanner
 * @author User
 *
 */
public class UIScannerGuard {

	private Scanner scanner;
	private boolean hasReadInt;
	
	public UIScannerGuard() {
		scanner = new Scanner(System.in);
		hasReadInt = false;
	}
	
	public boolean isHasReadInt() {
		return hasReadInt;
	}
	
	public Scanner getScanner() {
		return scanner;
	}
	
	
	/**
	 * Show message and prompt user for string
	 * @param message
	 * @return
	 */
	public String readLine(String message) {
		String text;
		System.out.println(message);
		
		if(hasReadInt) {
			scanner.nextLine();
		}
		
		hasReadInt = false;//reading string here
		return scanner.nextLine();
	}
	
	/**
	 * Show message and prompt user for int
	 * @param message
	 * @return
	 */
	public int readInt(String message) {
		System.out.println(message);
		hasReadInt = true;
		return scanner.nextInt();
	}
	
	
}
