package checkinsystem.model;

// This class serves as the main/manager of the system.
public class CheckInApp {
	
	// Variables
	private BookingList bookingLists;
	// TODO Add GUI variable
	
	/**
	 * Constructor to set up the Booking List objects.
	 * TODO Add an Exception(s) here.  
	 */
	public CheckInApp() { 
		
		// Create an empty list of Passengers and Flights.
		bookingLists = new BookingList();
	}
	
	// Methods
	
	/**
	 * TEST METHOD ONLY
	 */
	public void execute() {
		
		// Bookings
		System.out.println("Loaded data from Bookings.csv");
		bookingLists.readBookingsTextFile("Bookings.csv");
		String bookingsData = bookingLists.getFirstReportData();
		
		// Flights
		System.out.println("Loaded data from Flights.csv");
		bookingLists.readFlightsTextFile("Flights.csv");
		String flightsData = bookingLists.getLastReportData();
		
		// Create report output
		System.out.print("Created Test.txt report");
		bookingLists.generateFinalReport("Test.txt", bookingsData, flightsData);
	}
	
	
	/**
	 * Main program method.
	 * TODO Add GUI and any other relevant methods.
	 * TODO Add Exception(s).
	 * @param arg Default main parameter (auto generated).
	 */
	public static void main (String arg[])  {
		
       	// Create a CheckInApp object with contents.  
		CheckInApp checkInApp = new CheckInApp();
		
		// Run the full program TODO THIS IS A TEST AND NOT FINAL
		checkInApp.execute();
    }

}
