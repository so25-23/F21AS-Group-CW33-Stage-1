package checkinsystem.model;

import checkinsystem.gui.CheckInGUI;

// This class serves as the main/manager of the system.
public class CheckInApp {
	
	// Variables
	private BookingList bookingLists;
	
	/**
	 * Constructor to set up the Booking List objects. 
	 */
	public CheckInApp() { 
		
		// Create an empty list of Passengers and Flights.
		bookingLists = new BookingList();
	}
	
	// Methods
	
	/**
	 * Display the GUI.
	 */
	public void showGUI() {
		CheckInGUI gui = new CheckInGUI(bookingLists);  
        gui.setVisible(true);
    } 
	
	/**
	 * Run the check-in app. 
	 * @throws CheckInException 
	 */
	public void execute() throws CheckInException {
		
		// Bookings
		bookingLists.readBookingsTextFile("Bookings.csv");
		System.out.println("Loaded data from Bookings.csv");
		
		// Flights
		bookingLists.readFlightsTextFile("Flights.csv");
		System.out.println("Loaded data from Flights.csv");
	}
	
	/**
	 * Main program method.
	 * @param arg Default main parameter (auto generated).
	 * @throws CheckInException 
	 */
	public static void main (String arg[]) throws CheckInException  {
		
       	// Create a CheckInApp object with contents.  
		CheckInApp checkInApp = new CheckInApp();
		
		// Run the full program. 
		checkInApp.execute();
		
		// Display the GUI on start up. 
		checkInApp.showGUI();
    }
}
