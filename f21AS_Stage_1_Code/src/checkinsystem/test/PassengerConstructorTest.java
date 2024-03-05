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
	
	// Exception test case (invalid data - last name not provided).
	@Test
	public void testLastNameInvalid() {
		
		Exception lastNameException = assertThrows(IllegalStateException.class, () -> {
			
			// Last name is missing.
            new Passenger("David", "", "ABC678", 0, 0, 0, 0, 0, false, "VS 95");
        });
		
		// This test should fail here due to the expected exception.
		assertEquals("Smith", lastNameException.getMessage());
	}
	
	// Exception test case (invalid data - booking reference not provided).
	@Test
	public void testBookingReferenceInvalid() {
		
		Exception bookingReferenceException = assertThrows(IllegalStateException.class, () -> {
			
			// Booking reference is missing.
            new Passenger("David", "Smith", "", 0, 0, 0, 0, 0, false, "VS 95");
        });
		
		// This test should fail here due to the expected exception.
		assertEquals("ABC123", bookingReferenceException.getMessage());
	}
	
	// Exception test case (invalid data - last name and booking reference not provided).
	@Test
	public void testLastNameAndBookingReferenceInvalid() {
		
		Exception lastNameAndBookingReferenceException = assertThrows(IllegalStateException.class, () -> {
			
			// Last name and booking reference are missing.
            new Passenger("David", "", "", 0, 0, 0, 0, 0, false, "VS 95");
        });
		
		// This test should fail here due to the expected exception.
		assertEquals("ABC123", lastNameAndBookingReferenceException.getMessage());
	}
}
