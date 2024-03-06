package checkinsystem.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// This class holds and processes a list of Passenger and Flight objects.
public class BookingList {
	
	// Variables
	private ArrayList<Passenger> passengerList;
	private ArrayList<Flight> flightList;
	
	/**
	 * Constructor to set up the Passenger and Flight objects.
	 */
	public BookingList() {
		passengerList = new ArrayList<Passenger>();
		flightList = new ArrayList<Flight>(); 
	}
	
	// Methods
	
	/**
     * Return the Passenger object with a specified booking reference.
     * @param bookingReference The booking reference to search.
     * @return The matching Passenger object; null if none.
     */
	public Passenger findByBookingReference(String bookingReference) {
		
		// For each item in passengerList, execute the loop body referring to the Passenger object.
		for (Passenger passenger : passengerList) {
			
			// If the booking reference match.
			if (passenger.getBookingReference().equalsIgnoreCase(bookingReference)) {
				return passenger;
			}
		}
		return null;
	}
	
	/**
     * Return the Passenger object with a specified flight code.
     * @param flightCode The flight code to search.
     * @return The matching Passenger object; null if none.
     */
	public Passenger findPassengerByFlightCode(String flightCode) {
		
		// For each item in passengerList, execute the loop body referring to the Passenger object.
		for (Passenger passenger : passengerList) {
			
			// If the flight code match.
			if (passenger.getFlightCode().equalsIgnoreCase(flightCode)) {
				return passenger;
			}
		}
		return null;
	}
	
	/**
     * Return the Flight object with a specified flight code.
     * @param flightCode The flight code to search.
     * @return The matching Flight object; null if none.
     */
	public Flight findFlightByFlightCode(String flightCode) {
		
		// For each item in flightList, execute the loop body referring to the Flight object.
		for (Flight flight : flightList) {
			
			// If the flight code match.
			if (flight.getFlightCode().equalsIgnoreCase(flightCode)) {
				return flight;
			}
		}
		return null;
	}
	
	/**
	 * Return the number of passengers who have checked-in.
	 * @return The number of passengers checked-in.
	 */
	public int getNumberOfPassengersCheckedIn() {
		
		// Local variable to hold the number of passengers.
		int numberOfPassengers = 0;
		
		// For each item in passengerList, execute the loop body referring to the Passenger object.
		for (Passenger passenger : passengerList) {
			
			// Only checked-in passengers
			if (passenger.getCheckedInStatus() == true) {
				// Increase the number of checked-in passengers by 1.
				numberOfPassengers ++;
			}
		}
		return numberOfPassengers;
	}
	
	/**
	 * Return the total baggage weight of passenger luggage.
	 * @return The total weight of passenger luggage.
	 */
	public double getTotalBaggageWeight() {
		
		// Local variable to hold the total baggage weight.
		double baggageWeight = 0;
		
		// For each item in flightList, execute the loop body referring to the Flight object.
		for (Flight flight : flightList) {
			
			// Get the flight's baggage weight and add it to the local variable.
			baggageWeight += flight.getBaggageWeightOnBoard();
		}
		return baggageWeight;
	}
	
	/**
	 * Return the total baggage volume of passenger luggage.
	 * @return The total volume of passenger luggage.
	 */
	public double getTotalBaggageVolume() {
		
		// Local variable to hold the total baggage volume.
		double baggageVolume = 0;
		
		// For each item in flightList, execute the loop body referring to the Flight object.
		for (Flight flight : flightList) {
			
			// Get the flight's baggage volume and add it to the local variable.
			baggageVolume += flight.getBaggageVolumeOnBoard();
		}
		return baggageVolume;
	}
	
	/**
	 * Return the total excess baggage fee from flights.
	 * @return The total excess baggage fee.
	 */
	public double getTotalExcessBaggageFee() {
		
		// Local variable to hold the total baggage volume.
		double excessBaggageFee = 0;
		
		// For each item in passengerList, execute the loop body referring to the Passenger object.
		for (Flight flight : flightList) {
			
			// Get the passenger's excess baggage fee and add it to the local variable.
			excessBaggageFee += flight.getFlightExcessBaggageFee();
		}
		return excessBaggageFee;
	}
	
	/**
     * Return the Flight object with a specified carrier.
     * @param carrier The carrier to search.
     * @return The matching Flight object; null if none.
     */
	public Flight findByCarrier(String carrier) {
		
		// For each item in flightList, execute the loop body referring to the Flight object.
		for (Flight flight : flightList) {
			
			// If the carrier match.
			if (flight.getFlightCarrier().equalsIgnoreCase(carrier)) {
				return flight;
			}
		}
		return null;
	}
	
	/**
	 * TODO Confirm if this can be removed before submission
	 * Determine if a Flight's capacity has been exceeded.
	 * @return The verdict; true = yes and false = no.
	 
	public boolean isFlightCapacityExceeded() {
		
		// Local variable to hold the exceeded status.
		boolean isExceeded = false;
		
		// For each item in flightList, execute the loop body referring to the Flight object.
		for (Flight flight : flightList) {
			
			if (flight.getNumberOfPassengersOnBoard() > flight.getFlightCapacity()) {
				isExceeded = true;
				
			} else if (flight.getNumberOfPassengersOnBoard() <= flight.getFlightCapacity()) {
				isExceeded = false;
			}
		}
		return isExceeded;
	}
	*/
	
	/**
     * Return the list of Passengers in the passenger list.
     * @return The list of Passengers in the list
     */
    public ArrayList<Passenger> listAllPassengers() {
        return passengerList;
    }
    
    /**
     * Return the list of Flights in the flight list.
     * @return The list of Flights in the list
     */
    public ArrayList<Flight> listAllFlights() {
        return flightList;
    }
    
    /**
	 * Read in the details of each Passenger from a text file. 
	 * @param filename The imported name of the file to read.
	 */
	public void readBookingsTextFile(String filename) {
		
		// Test for errors during execution.
		try { 
			
			// Local file variable to work with. 
			File readFile = new File(filename);
			
			// try-with-resources to ensure each resource is closed after execution (prevents resource leak).
			try (Scanner scan = new Scanner(readFile)) { // Local scanner variable for scanning file text.
				 
				// While the file has another line of text.
				while (scan.hasNextLine()) {
					
					// Local variable for storing next line of text.
					String textLine = scan.nextLine();
					
					// The line of text is not blank.
					if (textLine.length() != 0) {	
						
						// Run the method for handing each text line.
						extractBookingsTextFileLine(textLine); 
					}
				}
			} 
		}
		
		// Execute if an error occurs in the try block.
		catch (FileNotFoundException exception) { // File not found.
			
			// Print error message.
			System.out.println(filename + " could not be found!");
			
			// End with system exit.
			System.exit(0);
		}
	}
	
	/**
	 * Read in the details of each Flight from a text file.
	 * @param filename The imported name of the file to read.
	 */
	public void readFlightsTextFile(String filename) {
		
		// Test for errors during execution.
		try { 
			
			// Local file variable to work with. 
			File readFile = new File(filename);
			
			// try-with-resources to ensure each resource is closed after execution (prevents resource leak).
			try (Scanner scan = new Scanner(readFile)) { // Local scanner variable for scanning file text.
				 
				// While the file has another line of text.
				while (scan.hasNextLine()) {
					
					// Local variable for storing next line of text.
					String textLine = scan.nextLine();
					
					// The line of text is not blank.
					if (textLine.length() != 0) {	
						
						// Run the method for handing each text line.
						extractFlightsTextFileLine(textLine); 
					}
				}
			} 
		}
		
		// Execute if an error occurs in the try block.
		catch (FileNotFoundException exception) { // File not found.
			
			// Print error message
			System.out.println(filename + " could not be found!");
			
			// End with system exit
			System.exit(0);
		}
	}
	
	/**
	 * Extracts data from line in bookings file. 
	 * @param textLine Each line of text in the file to be extracted.
	 */
	private void extractBookingsTextFileLine(String textLine) {
		
		// Test for errors during execution.
		try {
			
			// Variable for holding contents of file (comma delimited format)
			String contents[] = textLine.split(",");
			
			String firstName = contents[0]; // Passenger's first name. 
			String lastName = contents[1]; // Passenger's last name.
			String bookingReference = contents[2]; // Passenger's booking reference.
			String flightCode = contents[3]; // Passenger's flight code.
			String checkedIn = contents[4]; // Passenger's checked-in status.
			
			// Gets and stores the string's boolean value.
			boolean checkedInValue = Boolean.valueOf(checkedIn);
			
			// Create a Passenger object using the details from the file. 
			Passenger passenger = new Passenger(firstName, 
					lastName, bookingReference, 0, 0, 0, 0, 0, checkedInValue, flightCode);
			
			// Add the created Passenger object to its ArrayList.
			this.addPassenger(passenger); 
		}
		
		// Execute if an error occurs in the try block (data type conversion)
		catch (NumberFormatException numberFormatException) { // String does not have the correct format (e.g. integer)
			
			// Print the associated system error message 
			System.out.println("Number conversion error found in the line '" + textLine + "' - " +
					numberFormatException.getMessage());
			
			// End with system exit
			System.exit(0);
		}
		
		// Execute if an error occurs in the try block (index is < zero or >= to the size of the array)
		catch (ArrayIndexOutOfBoundsException arrayIndexException) {
			
			// Print the associated system error message
			System.out.println("Incorrect number of items in:  '" + textLine + "' index position: " +
					arrayIndexException.getMessage());
			
			// End with system exit
			System.exit(0);
		}
	}
	
	/**
	 * Extracts data from line in flights file. 
	 * @param textLine Each line of text in the file to be extracted.
	 */
	private void extractFlightsTextFileLine(String textLine) {
		
		// Test for errors during execution.
		try {
			
			// Variable for holding contents of file (comma delimited format)
			String contents[] = textLine.split(",");
			
			String destinationAirport = contents[0]; // Flight's destination airport.
			String carrier = contents[1]; // Flight's carrier.
			String flightCapacity = contents[2]; // Flight's passenger capacity. 
			String maxBaggageWeight = contents[3]; // Flight's baggage weight limit. 
			String maxBaggageVolume = contents[4]; // Flight's baggage volume limit. 
			String flightCode = contents[5]; // Flight's flight code.
			
			// Gets and stores the string's integer value.
			int flightCapacityValue = Integer.parseInt(flightCapacity);
			
			// Gets and stores the strings' double values.
			double maxBaggageWeightValue = Double.parseDouble(maxBaggageWeight);
			double maxBaggageVolumeValue = Double.parseDouble(maxBaggageVolume);
			
			// Create a Flight object using the details from the file. 
			Flight flight = new Flight(carrier, destinationAirport, flightCapacityValue, 
					maxBaggageWeightValue, maxBaggageVolumeValue, flightCode, 
					0, 0, 0, false, 0);
		
			// Add the created Flight object to its ArrayList.
			this.addFlight(flight); 
		}
		
		// Execute if an error occurs in the try block (data type conversion)
		catch (NumberFormatException numberFormatException) { // String does not have the correct format (e.g. integer)
			
			// Print the associated system error message 
			System.out.println("Number conversion error found in the line '" + textLine + "' - " +
					numberFormatException.getMessage());
			
			// End with system exit
			System.exit(0);
		}
		
		// Execute if an error occurs in the try block (index is < zero or >= to the size of the array)
		catch (ArrayIndexOutOfBoundsException arrayIndexException) {
			
			// Print the associated system error message
			System.out.println("Incorrect number of items in:  '" + textLine + "' index position: " +
					arrayIndexException.getMessage());
			
			// End with system exit
			System.exit(0);
		}
	}
    
	/**
	 * Adds a Passenger to the ArrayList if there is not one there already
	 * with the same booking reference.
	 * @param passenger The passenger object that contains the data.
	 * @return Completes the addition of passenger to list (if true).
	 */
	public boolean addPassenger(Passenger passenger) {
		
		// Local variable to get and store the booking reference of the passenger to be added.
		String passengerBookRef = passenger.getBookingReference();
		
		// Check to see if a passenger with this booking reference number already exists.
		Passenger existsInArrayList = this.findByBookingReference(passengerBookRef);
		
		// Add the passenger if it does not exist and return true.
		if (existsInArrayList == null) {
			
			passengerList.add(passenger);
			return true;
		}
		
		// If the passenger already exists, return false. 
		return false;
	}
	
	/**
	 * Adds a Flight to the ArrayList if there is not one there already
	 * with the same flight code.
	 * @param flight The flight object that contains the data.
	 * @return Completes the addition of flight to list (if true).
	 */
	public boolean addFlight(Flight flight) {
		
		// Local variable to get and store the flight code of the flight to be added.
		String flightFlightCode = flight.getFlightCode();
		
		// Check to see if a flight with this flight code already exists.
		Flight existsInArrayList = this.findFlightByFlightCode(flightFlightCode);
		
		// Add the flight if it does not exist and return true.
		if (existsInArrayList == null) {
			
			flightList.add(flight);
			return true;
		}
		
		// If the flight already exists, return false. 
		return false;
	}
	
	/**
	 * @return The report output (Booking file data). TODO This may not be needed (need to confirm)
	 */
	public String getFirstReportData() {
		
		// Local variable to contain text strings
		String finalReport = "";
			
		return finalReport;
	}
	
	/**
	 * @return The report output (Flight file data) and structures report design. 
	 */
	public String getLastReportData() {
		
		// Local variable to contain text strings; initialised with column headers.
		String onExitReport = "Flight Code    No. of Passengers Checked-In      "
				+ "Total Passenger Baggage Weight     Total Passenger Baggage Volume     "
				+ "Total Excess Baggage Fee     Flight Capacity Exceeded?\n";
		
		// For each item in flight List, execute the loop body referring to the flight object
		for (Flight flight : flightList) {
			
			onExitReport += String.format("%-15s", flight.getFlightCode());
			onExitReport += String.format("%-6s", flight.getNumberOfPassengersOnBoard());
			onExitReport += String.format("%31s", flight.getBaggageWeightOnBoard());
			onExitReport += String.format("%35s", flight.getBaggageVolumeOnBoard());
			onExitReport += String.format("%35s", flight.getFlightExcessBaggageFee());
			onExitReport += String.format("%31s", flight.isFlightCapacityExceeded());
			onExitReport += "\n";
		}	
		return onExitReport;
	}
	
	/**
	 * Writes text to the on exit output file.
	 * @param filename The name and extension of the output file (.txt).
	 * @param bookingsData The variable holding the contents of the bookings file to be output.
	 * @param flightsData The variable holding the contents of the flights file to be output.
	 */
	public void generateFinalReport(String filename, String bookingsData, String flightsData) {
		
		// Variable for file writer object.
		FileWriter writeFile;
	 
		// Test for errors during execution.
		try {
			
			// Create a new object for the file to be written to.
			writeFile = new FileWriter(filename);
			 
			// Write a title string into the written file.
			writeFile.write("On-Exit Report\n\n"); 
			 
			// Write into the file the text in question.
			writeFile.write(bookingsData); 
			 
			// Write into the second file the text in question. 
			writeFile.write(flightsData); 
					 
			// Close the stream.
			writeFile.close();
	 }
	 
	 // Execute if an error occurs in the try block
	 catch (FileNotFoundException missingFileException) { // File not found
		 
		 // Print error message
		 System.out.println("This file: '" + filename + "' was not found.");
		 
		// End with system exit
		 System.exit(0);
	 }
	 
	 // Execute if an error occurs in the try block
	 catch (IOException iOException) { // Some sort of I/O exception has occurred
		 
		 // Print out the standard output (stack trace)
		 iOException.printStackTrace();
		 
		 // End with system exit (error occurred)
	     System.exit(1);
	 	}
	}
	
	/**
	 * Updates the Passenger object's details (GUI).
	 * @param passenger The passenger object to update.
	 * TODO Tag - Abeer addition 
	 */
	public void updatePassengerDetails(Passenger passenger) {

		// For each item in passengerList, execute the loop body referring to the Passenger object.
		for (Passenger ps : passengerList) {
			if (passenger.getBookingReference().equalsIgnoreCase(ps.getBookingReference())) { 
				ps = passenger;
				break;
			}
		}

		for (Flight flight : flightList) {
			// If the flight code match.
			if (flight.getFlightCode().equalsIgnoreCase(passenger.getFlightCode())) {

				flight.setNumberOfPassengersOnBoard(flight.getNumberOfPassengersOnBoard() + 1);
				flight.setBaggageWeightOnBoard(flight.getBaggageWeightOnBoard() + passenger.getBaggageWeight());
				flight.setBaggageVolumeOnBoard(flight.getBaggageVolumeOnBoard() + passenger.getBaggageVolume());
				flight.setFlightExcessBaggageFee(flight.getFlightExcessBaggageFee() + passenger.getPassengerExcessBaggageFee());
				flight.setFlightExceeded(flight.isFlightCapacityExceeded());

				break;
			}
		}
	}
	
}
