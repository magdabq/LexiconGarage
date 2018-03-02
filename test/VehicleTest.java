import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testCorrectRegNumberPasses() {
		Vehicle vehicle = new Vehicle(4);
		String registrationNumber = "AAA777";
		
		assertTrue(vehicle.acceptRegistrationNumber(registrationNumber));
		
	}
	
	@Test
	public void testCorrectRegNumberLowerCasePasses() {
		Vehicle vehicle = new Vehicle(4);
		String registrationNumber = "aaa777";
		
		assertTrue(vehicle.acceptRegistrationNumber(registrationNumber));
		
	}
	
	@Test
	public void testIncorrectSpelledRegNumberFails() {
		Vehicle vehicle = new Vehicle(4);
		String registrationNumber = "AA3777";
		
		assertFalse(vehicle.acceptRegistrationNumber(registrationNumber));
		
	}
	
	@Test
	public void testIncorrectSpelledRegNumberFails2() {
		Vehicle vehicle = new Vehicle(4);
		String registrationNumber = "AA37(7";
		
		assertFalse(vehicle.acceptRegistrationNumber(registrationNumber));
		
	}
	
	@Test
	public void testIncorrectTooLongRegNumberFails() {
		Vehicle vehicle = new Vehicle(4);
		String registrationNumber = "AA37776";
		
		assertFalse(vehicle.acceptRegistrationNumber(registrationNumber));
		
	}
	
	@Test
	public void testIncorrectTooShortRegNumberFails() {
		Vehicle vehicle = new Vehicle(4);
		String registrationNumber = "AA376";
		
		assertFalse(vehicle.acceptRegistrationNumber(registrationNumber));
		
	}
	
	@Test
	public void testCorrectWithSpaceRegNumberPasses() {
		Vehicle vehicle = new Vehicle(4);
		String registrationNumber = "AAC 376";
		
		assertTrue(vehicle.acceptRegistrationNumber(registrationNumber));
	}
	@Test
	public void testCorrectWithManySpaceRegNumberPasses() {
		Vehicle vehicle = new Vehicle(4);
		String registrationNumber = "A A C 3 7 6";
		
		assertTrue(vehicle.acceptRegistrationNumber(registrationNumber));
	}

}
