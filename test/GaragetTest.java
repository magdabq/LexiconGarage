import static org.junit.Assert.*;

import org.junit.Test;

public class GaragetTest {

	@Test
	public void test() {
		Garage garageOne = new Garage();
		garageOne.parkVehicle(new Vehicle());
		assertTrue(garageOne.getNrOfParkedVehicles()==1);
	}

}




	