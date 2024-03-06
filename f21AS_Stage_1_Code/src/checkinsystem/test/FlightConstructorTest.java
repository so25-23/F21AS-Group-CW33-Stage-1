package checkinsystem.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import checkinsystem.model.CheckInException;
import checkinsystem.model.Flight;
import checkinsystem.model.Passenger;

public class FlightConstructorTest {
	
	// Normal test case (valid data - working as intended)
	@Test
	public void testWorkingFlightConstructor() throws CheckInException {
		
		// Creation of a Flight object for testing
		Flight testFlight = new Flight("Ryanair", "OKO", 150, 40000.0, 8000000.0, 
				"FR 23", 0, 0.0, 0.0, false, 0.0);
		
		// Assert the expected results
		assertEquals("Ryanair", testFlight.getFlightCarrier());
		assertEquals("OKO", testFlight.getDestinationAirport());
		assertEquals(150, testFlight.getFlightCapacity());
		assertEquals(40000.0, testFlight.getMaxBaggageWeight());
		assertEquals(8000000.0, testFlight.getMaxBaggageVolume());
		assertEquals("FR 23", testFlight.getFlightCode());
		assertEquals(0, testFlight.getNumberOfPassengersOnBoard());
		assertEquals(0.0, testFlight.getBaggageWeightOnBoard());
		assertEquals(0.0, testFlight.getBaggageVolumeOnBoard());
		assertEquals(false, testFlight.isFlightCapacityExceeded());
		assertEquals(0.0, testFlight.getFlightExcessBaggageFee());
	}
	
	// Exception test case (invalid data - carrier not provided).
	@Test
	public void testCarrierInvalid() {
		
		Exception carrierException = assertThrows(IllegalStateException.class, () -> {
			
			// Carrier is missing.
			new Flight("", "OKO", 150, 40000.0, 8000000.0, 
					"FR 23", 0, 0.0, 0.0, false, 0.0);
        });
		
		// The expected exception should throw.
		assertTrue(true, carrierException.getMessage());
	}
	
	// Exception test case (invalid data - destination airport not provided).
	@Test
	public void testDestinationirportInvalid() {
		
		Exception destinationAirportException = assertThrows(IllegalStateException.class, () -> {
			
			// Destination airport is missing.
			new Flight("Ryanair", "", 150, 40000.0, 8000000.0, 
					"FR 23", 0, 0.0, 0.0, false, 0.0);
        });
		
		// The expected exception should throw.
		assertTrue(true, destinationAirportException.getMessage());
	}
	
	// Exception test case (invalid data - destination airport is not 3 characters in length).
	@Test
	public void testDestinationAirportLengthInvalid() {
		
		Exception destinationAirportLengthException = assertThrows(IllegalStateException.class, () -> {
			
			// Destination airport is not 3 characters in length.
			new Flight("Ryanair", "LA", 150, 40000.0, 8000000.0, 
					"FR 23", 0, 0.0, 0.0, false, 0.0);
        });
		
		// The expected exception should throw.
		assertTrue(true, destinationAirportLengthException.getMessage());
	}
	
	// Exception test case (invalid data - flight capacity value is less than 0).
	@Test
	public void testFlightCapacityInvalid() {
		
		Exception flightCapacityException = assertThrows(IllegalStateException.class, () -> {
			
			// Flight capacity is invalid.
			new Flight("Ryanair", "OKO", -150, 40000.0, 8000000.0, 
					"FR 23", 0, 0.0, 0.0, false, 0.0);
        });
		
		// The expected exception should throw.
		assertTrue(true, flightCapacityException.getMessage());
	}
	
	// Exception test case (invalid data - max baggage weight value is less than 0).
	@Test
	public void testMaxBaggageWeightInvalid() {
		
		Exception maxBaggageWeightException = assertThrows(CheckInException.class, () -> {
			
			// Max baggage weight value is invalid.
			new Flight("Ryanair", "OKO", 150, -40000.0, 8000000.0, 
					"FR 23", 0, 0.0, 0.0, false, 0.0);
		});
		
		// The expected exception should throw.
		assertTrue(true, maxBaggageWeightException.getMessage());
	}
	
	// Exception test case (invalid data - max baggage volume value is less than 0).
	@Test
	public void testMaxBaggageVolumeInvalid() {
		
		Exception maxBaggageVolumeException = assertThrows(CheckInException.class, () -> {
			
			// Max baggage volume value is invalid.
			new Flight("Ryanair", "OKO", 150, 40000.0, -8000000.0, 
					"FR 23", 0, 0.0, 0.0, false, 0.0);
		});
		
		// The expected exception should throw.
		assertTrue(true, maxBaggageVolumeException.getMessage());
	}
	
	// Exception test case (invalid data - flight code String is not 5 characters in length (white space inclusive)).
	@Test
	public void testFlightCodeInvalid() {
		
		Exception flightCodeException = assertThrows(IllegalStateException.class, () -> {
			
			// Flight code value is invalid.
			new Flight("Ryanair", "OKO", 150, 40000.0, 8000000.0, 
					"FR 23789", 0, 0.0, 0.0, false, 0.0);
		});
		
		// The expected exception should throw.
		assertTrue(true, flightCodeException.getMessage());
	}	
	
	// Exception test case (invalid data - passengers on board value is less than 0)).
	@Test
	public void testPassengersOnBoardInvalid() {
		
		Exception passengersOnBoardException = assertThrows(IllegalStateException.class, () -> {
			
			// Passengers on board value is invalid.
			new Flight("Ryanair", "OKO", 150, 40000.0, 8000000.0, 
					"FR 23", -80, 0.0, 0.0, false, 0.0);
		});
		
		// The expected exception should throw.
		assertTrue(true, passengersOnBoardException.getMessage());
	}	
	
	// Exception test case (invalid data - baggage weight on board value is less than 0).
	@Test
	public void testBaggageWeightOnBoardInvalid() {
		
		Exception baggageWeightOnBoardException = assertThrows(CheckInException.class, () -> {
			
			// Baggage weight on board value is invalid.
			new Flight("Ryanair", "OKO", 150, 40000.0, 8000000.0, 
					"FR 23", 0, -450, 0.0, false, 0.0);
		});
		
		// The expected exception should throw.
		assertTrue(true, baggageWeightOnBoardException.getMessage());
	}
	
	// Exception test case (invalid data - baggage volume on board value is less than 0).
	@Test
	public void testBaggageVolumeOnBoardInvalid() {
		
		Exception baggageVolumeOnBoardException = assertThrows(CheckInException.class, () -> {
			
			// Baggage volume on board value is invalid.
			new Flight("Ryanair", "OKO", 150, 40000.0, 8000000.0, 
					"FR 23", 0, 450, -10000000.0, false, 0.0);
		});
		
		// The expected exception should throw.
		assertTrue(true, baggageVolumeOnBoardException.getMessage());
	}
	
	// Exception test case (invalid data - flight excess baggage fee value is less than 0).
	@Test
	public void testFlightExcessBaggageFeeInvalid() {
		
		Exception flightExcessBaggageFee = assertThrows(CheckInException.class, () -> {
			
			// Flight excess baggage fee value is invalid.
			new Flight("Ryanair", "OKO", 150, 40000.0, 8000000.0, 
					"FR 23", 0, 450, 10000000.0, false, -45.0);
		});
		
		// The expected exception should throw.
		assertTrue(true, flightExcessBaggageFee.getMessage());
	}
}
