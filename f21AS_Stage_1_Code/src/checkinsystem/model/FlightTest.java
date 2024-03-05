package f21AS_Stage_1_Code.src.checkinsystem.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FlightTest {

    private Flight flight;

    @Before
    public void setUp() {

        flight = new Flight("British Airways", "LHR", 200, 1500.0, 5000.0, "BA0987", 150, 1000.0, 3500.0, false, 300.0);
    }

    @Test
    public void testGetFlightCarrier() {
        assertEquals("British Airways", flight.getFlightCarrier());
    }

    @Test
    public void testGetDestinationAirport() {
        assertEquals("LHR", flight.getDestinationAirport());
    }

    @Test
    public void testGetFlightCapacity() {
        assertEquals(200, flight.getFlightCapacity());
    }

    @Test
    public void testGetMaxBaggageWeight() {
        assertEquals(1500.0, flight.getMaxBaggageWeight(), 0.0);
    }

    @Test
    public void testGetMaxBaggageVolume() {
        assertEquals(5000.0, flight.getMaxBaggageVolume(), 0.0);
    }

    @Test
    public void testGetNumberOfPassengersOnBoard() {
        assertEquals(150, flight.getNumberOfPassengersOnBoard());
    }

    @Test
    public void testGetBaggageWeightOnBoard() {
        assertEquals(1000.0, flight.getBaggageWeightOnBoard(), 0.0);
    }

    @Test
    public void testGetBaggageVolumeOnBoard() {
        assertEquals(3500.0, flight.getBaggageVolumeOnBoard(), 0.0);
    }

    @Test
    public void testIsFlightCapacityExceeded() {
        assertFalse(flight.isFlightCapacityExceeded());
    }

    @Test
    public void testGetFlightExcessBaggageFee() {
        assertEquals(300.0, flight.getFlightExcessBaggageFee(), 0.0);
    }


    @Test
    public void testSetters() {
        flight.setCarrier("Delta");
        assertEquals("Delta", flight.getFlightCarrier());

        flight.setDestinationAirport("JFK");
        assertEquals("JFK", flight.getDestinationAirport());

        flight.setFlightCapacity(250);
        assertEquals(250, flight.getFlightCapacity());

        flight.setMaxBaggageWeight(1600.0);
        assertEquals(1600.0, flight.getMaxBaggageWeight(), 0.0);

        flight.setMaxBaggageVolume(5500.0);
        assertEquals(5500.0, flight.getMaxBaggageVolume(), 0.0);

        flight.setNumberOfPassengersOnBoard(200);
        assertEquals(200, flight.getNumberOfPassengersOnBoard());

        flight.setBaggageWeightOnBoard(1100.0);
        assertEquals(1100.0, flight.getBaggageWeightOnBoard(), 0.0);

        flight.setBaggageVolumeOnBoard(4000.0);
        assertEquals(4000.0, flight.getBaggageVolumeOnBoard(), 0.0);

        flight.setFlightExceeded(true);
        assertTrue(flight.isFlightCapacityExceeded());

        flight.setFlightExcessBaggageFee(500.0);
        assertEquals(500.0, flight.getFlightExcessBaggageFee(), 0.0);
    }


}