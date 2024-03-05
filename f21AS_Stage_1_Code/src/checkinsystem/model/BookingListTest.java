package f21AS_Stage_1_Code.src.checkinsystem.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BookingListTest {

    private BookingList bookingList;
    private Passenger passenger1;
    private Passenger passenger2;
    private Flight flight1;
    private Flight flight2;

    @Before
    public void setUp() {
        bookingList = new BookingList();
        passenger1 = new Passenger("John", "Doe", "BR123", 30.5, 55.0, 35.0, 20.0, 38500.0, true, "FC123");
        passenger2 = new Passenger("Jane", "Doe", "BR456", 25.0, 45.0, 25.0, 15.0, 16875.0, false, "FC456");
        flight1 = new Flight("American Airlines", "JFK", 200, 2000.0, 8000.0, "FC123", 150, 1500.0, 6000.0, false, 100.0);
        flight2 = new Flight("Delta", "LAX", 150, 1500.0, 6000.0, "FC456", 120, 1200.0, 5000.0, false, 200.0);
        bookingList.addPassenger(passenger1);
        bookingList.addPassenger(passenger2);
        bookingList.addFlight(flight1);
        bookingList.addFlight(flight2);
    }

    @Test
    public void testFindByBookingReference() {
        assertEquals(passenger1, bookingList.findByBookingReference("BR123"));
        assertNull(bookingList.findByBookingReference("Nonexistent"));
    }

    @Test
    public void testFindPassengerByFlightCode() {
        assertEquals(passenger1, bookingList.findPassengerByFlightCode("FC123"));
        assertNull(bookingList.findPassengerByFlightCode("Nonexistent"));
    }

    @Test
    public void testFindFlightByFlightCode() {
        assertEquals(flight1, bookingList.findFlightByFlightCode("FC123"));
        assertNull(bookingList.findFlightByFlightCode("Nonexistent"));
    }

    @Test
    public void testGetNumberOfPassengersCheckedIn() {
        assertEquals(1, bookingList.getNumberOfPassengersCheckedIn());
    }

    @Test
    public void testGetTotalBaggageWeight() {
        assertEquals(2700.0, bookingList.getTotalBaggageWeight(), 0.0);
    }

    @Test
    public void testGetTotalBaggageVolume() {
        assertEquals(11000.0, bookingList.getTotalBaggageVolume(), 0.0);
    }

    @Test
    public void testGetTotalExcessBaggageFee() {
        assertEquals(300.0, bookingList.getTotalExcessBaggageFee(), 0.0);
    }

    @Test
    public void testFindByCarrier() {
        assertEquals(flight1, bookingList.findByCarrier("American Airlines"));
        assertNull(bookingList.findByCarrier("Nonexistent"));
    }


    @Test
    public void testAddDuplicatePassengerAndFlight() {
        assertFalse(bookingList.addPassenger(passenger1)); // 已存在
        assertFalse(bookingList.addFlight(flight1)); // 已存在
    }


    @Test
    public void testListAllPassengersAndFlights() {
        assertTrue(bookingList.listAllPassengers().contains(passenger1));
        assertTrue(bookingList.listAllFlights().contains(flight1));
    }


}