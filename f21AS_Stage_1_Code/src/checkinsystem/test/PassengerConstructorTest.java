package checkinsystem.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import checkinsystem.model.Passenger;

class PassengerConstructorTest {

	// Normal test case (valid data - working as intended)
	@Test
	public void testWorkingPassengerConstructor() {
		
		// Creation of a Passenger object for testing
		Passenger testPassenger = new Passenger("David", "Smith", "ABC678", 0.0, 0.0,
				0.0, 0.0, 0.0, false, "VS 95");
		
		// Assert the expected results
		assertEquals("David", testPassenger.getFirstName());
		assertEquals("Smith", testPassenger.getLastName());
		assertEquals("ABC678", testPassenger.getBookingReference());
		assertEquals(0.0, testPassenger.getBaggageWeight());
		assertEquals(0.0, testPassenger.getBaggageLength());
		assertEquals(0.0, testPassenger.getBaggageWidth());
		assertEquals(0.0, testPassenger.getBaggageHeight());
		assertEquals(0.0, testPassenger.getBaggageVolume());
		assertEquals(false, testPassenger.getCheckedInStatus());
		assertEquals("VS 95", testPassenger.getFlightCode());
	}
	
	//TODO Additional unit tests
	
}
