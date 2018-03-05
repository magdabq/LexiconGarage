import static org.junit.Assert.*;

import org.junit.Test;

public class GaragetTest {

	@Test
	public void test() {
		Garage garageOne = new Garage();
		garageOne.parkVehicle(new Vehicle("", "", 0));
		assertTrue(garageOne.getNrOfParkedVehicles()==1);
	}

}




	