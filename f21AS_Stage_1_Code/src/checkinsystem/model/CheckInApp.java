package checkinsystem.model;

import checkinsystem.gui.CheckInGUI;

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
	 * Display the GUI.
	 * TODO Tag - Abeer addition
	 */
	public void showGUI() {
		CheckInGUI gui = new CheckInGUI(bookingLists); 
        gui.setVisible(true);
    } 
	
	/**
	 * TODO TEST METHOD (WORK IN PROGRESS) 
	 */
	public void execute() {
		
		// Bookings
		bookingLists.readBookingsTextFile("Bookings.csv");
		System.out.println("Loaded data from Bookings.csv");
		//String bookingsData = bookingLists.getFirstReportData();
		
		// Flights
		bookingLists.readFlightsTextFile("Flights.csv");
		System.out.println("Loaded data from Flights.csv");
		//String flightsData = bookingLists.getLastReportData();
			
		// Create report output
		//System.out.print("Created On-Exit Report.txt report");
		//bookingLists.generateFinalReport("On-Exit Report.txt", bookingsData, flightsData);
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
		
		// Display the GUI on start up. TODO Tag - Abeer addition (remove?)
		checkInApp.showGUI();
    }

}
