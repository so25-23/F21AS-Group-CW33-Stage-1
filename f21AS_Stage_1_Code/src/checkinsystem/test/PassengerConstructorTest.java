package checkinsystem.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import checkinsystem.model.CheckInException;
import checkinsystem.model.Passenger;

class PassengerConstructorTest {

	// Normal test case (valid data - working as intended)
	@Test
	public void testWorkingPassengerConstructor() throws CheckInException {
		
		// Creation of a Passenger object for testing
		Passenger testPassenger = new Passenger("David", "Smith", "ABC678", 0.0, 0.0,
				0.0, 0.0, 0.0, false, "VS 95", 0.0);
	
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
		assertEquals(0.0, testPassenger.getPassengerExcessBaggageFee());
	}
	
	// Exception test case (invalid data - last name not provided).
	@Test
	public void testLastNameInvalid() {
		
		Exception lastNameException = assertThrows(IllegalStateException.class, () -> {
			
			// Last name is missing.
            new Passenger("David", "", "ABC678", 0, 0, 0, 0, 0, false, "VS 95", 0.0);
        });
		
		// The expected exception should throw.
		assertTrue(true, lastNameException.getMessage());
	}
	
	// Exception test case (invalid data - booking reference not provided).
	@Test
	public void testBookingReferenceInvalid() {
		
		Exception bookingReferenceException = assertThrows(IllegalStateException.class, () -> {
			
			// Booking reference is missing.
            new Passenger("David", "Smith", "", 0, 0, 0, 0, 0, false, "VS 95", 0.0);
        });
		
		// The expected exception should throw.
		assertTrue(true, bookingReferenceException.getMessage());
	}
	
	// Exception test case (invalid data - last name and booking reference not provided).
	@Test
	public void testLastNameAndBookingReferenceInvalid() {
		
		Exception lastNameAndBookingReferenceException = assertThrows(IllegalStateException.class, () -> {
			
			// Last name and booking reference are missing.
            new Passenger("David", "", "", 0, 0, 0, 0, 0, false, "VS 95", 0.0);
        });
		
		// The expected exception should throw.
		assertTrue(true, lastNameAndBookingReferenceException.getMessage());
	}
	
	// Exception test case (invalid data - baggage weight value is less than 0).
	@Test
	public void testBaggageWeightInvalid() {
		
		Exception baggageWeightException = assertThrows(CheckInException.class, () -> {
			
			// Baggage weight value is invalid.
			 new Passenger("David", "Smith", "ABC678", -1, 0, 0, 0, 0, false, "VS 95", 0.0);
		});
		
		// The expected exception should throw.
		assertTrue(true, baggageWeightException.getMessage());
	}
	
	// TODO Unit tests for remaining baggage fields
	
	// Exception test case (invalid data - baggage length value is less than 0).
	@Test
	public void testBaggageLengthInvalid() {
		
		Exception baggageLengthException = assertThrows(CheckInException.class, () -> {
			
			// Baggage length value is invalid.
			 new Passenger("David", "Smith", "ABC678", 0, -50, 0, 0, 0, false, "VS 95", 0.0);
		});
		
		// The expected exception should throw.
		assertTrue(true, baggageLengthException.getMessage());
	}
	
	// Exception test case (invalid data - baggage width value is less than 0).
	@Test
	public void testBaggageWidthInvalid() {
		
		Exception baggageWidthException = assertThrows(CheckInException.class, () -> {
			
			// Baggage width value is invalid.
			 new Passenger("David", "Smith", "ABC678", 0, 0, -150, 0, 0, false, "VS 95", 0.0);
		});
		
		// The expected exception should throw.
		assertTrue(true, baggageWidthException.getMessage());
	}
	
	// Exception test case (invalid data - baggage height value is less than 0).
	@Test
	public void testBaggageHeightInvalid() {
		
		Exception baggageHeightException = assertThrows(CheckInException.class, () -> {
			
			// Baggage height value is invalid.
			 new Passenger("David", "Smith", "ABC678", 0, 0, 0, -200, 0, false, "VS 95", 0.0);
		});
		
		// The expected exception should throw.
		assertTrue(true, baggageHeightException.getMessage());
	}
	
	// Exception test case (invalid data - baggage volume value is less than 0).
	@Test
	public void testBaggageVolumeInvalid() {
		
		Exception baggageVolumeException = assertThrows(CheckInException.class, () -> {
			
			// Baggage volume value is invalid.
			 new Passenger("David", "Smith", "ABC678", 0, 0, 0, 0, -125.69, false, "VS 95", 0.0);
		});
		
		// The expected exception should throw.
		assertTrue(true, baggageVolumeException.getMessage());
	}	
		
	// Exception test case (invalid data - flight code String is not 5 characters in length (white space inclusive)).
	@Test
	public void testFlightCodeInvalid() {
		
		Exception flightCodeException = assertThrows(IllegalStateException.class, () -> {
			
			// Flight code value is invalid.
			 new Passenger("David", "Smith", "ABC678", 0, 0, 0, 0, 0, false, "AA3", 0.0);
		});
		
		// The expected exception should throw.
		assertTrue(true, flightCodeException.getMessage());
	}	
	
	// Exception test case (invalid data - passenger excess baggage fee value is less than 0).
	@Test
	public void testPassengerExcessBaggageFeeInvalid() {
		
		Exception passengerExcessBaggageFee = assertThrows(CheckInException.class, () -> {
			
			// Passenger excess baggage fee value is invalid.
			 new Passenger("David", "Smith", "ABC678", 0, 0, 0, 0, 0, false, "VS 95", -800.45);
		});
		
		// The expected exception should throw.
		assertTrue(true, passengerExcessBaggageFee.getMessage());
	}
}
