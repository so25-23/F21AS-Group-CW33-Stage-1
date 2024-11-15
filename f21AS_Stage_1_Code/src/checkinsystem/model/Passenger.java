package checkinsystem.model;

// This class holds and processes Passenger information.
public class Passenger implements FlightCode {
	
	// Variables
	private String firstName;
	private String lastName;
	private String bookingReference;
	private double baggageWeight;
	private double baggageLength;
	private double baggageWidth;
	private double baggageHeight;
	private double baggageVolume;
	private boolean checkedIn; 
	private String flightCode;
	private double passengerExcessBaggageFee; 
	
	/**
	 * Constructor to set up the Passenger's information.
	 */
	public Passenger(String firstName, 
					 String lastName, 
					 String bookingReference, 
					 double baggageWeight,
					 double baggageLength,
					 double baggageWidth,
					 double baggageHeight,
					 double baggageVolume,
					 boolean checkedIn,
					 String flightCode,
					 double passengerExcessBaggageFee) throws CheckInException { 
		
		// lastName and bookingReference must be entered.
		if (lastName.length() == 0 || bookingReference.length() == 0) {
			throw new IllegalStateException("lastName or bookingReference cannot be left blank.");
		}
		
		// bookingReference String must be 6 characters in length.
		if (bookingReference.length() != 6) {
			throw new IllegalStateException("bookingReference must be 6 characters in length; for example 'AAA123'.");
		}
		
		// baggageWeight must be equal to or greater than 0.
		if (baggageWeight < 0) {
			throw new CheckInException(baggageWeight);
		}
		
		// baggageLength must be equal to or greater than 0.
		if (baggageLength < 0) {
			throw new CheckInException(baggageLength);
		}
		
		// baggageWidth must be equal to or greater than 0.
		if (baggageWidth < 0) {
			throw new CheckInException(baggageWidth);
		}
		
		// baggageHeight must be equal to or greater than 0.
		if (baggageHeight < 0) {
			throw new CheckInException(baggageHeight);
		}
		
		// baggageVolume must be equal to or greater than 0.
		if (baggageVolume < 0) {
			throw new CheckInException(baggageVolume);
		}
		
		// flightCode String must be 5 characters in length (white space inclusive).
		if (flightCode.length() != 5) {
			throw new IllegalStateException("flightCode must be 5 characters in length (including white space); for example, 'AA 12'");
		}
		
		// passengerExcessBaggageFee must be equal to or greater than 0.
		if (passengerExcessBaggageFee < 0) {
			throw new CheckInException(passengerExcessBaggageFee);
		}
				
		this.firstName = firstName;
		this.lastName = lastName;
		this.bookingReference = bookingReference;
		this.baggageWeight = baggageWeight;
		this.baggageLength = baggageLength;
		this.baggageWidth = baggageWidth;
		this.baggageHeight = baggageHeight;
		this.baggageVolume = baggageVolume;
		this.checkedIn = checkedIn;
		this.flightCode = flightCode; 
		this.passengerExcessBaggageFee = passengerExcessBaggageFee;
	}
	
	// Methods (Getters)
	
	/**
	 * @return The Passenger's first name.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @return The Passenger's last name.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @return The Passenger's booking reference.
	 */
	public String getBookingReference() {
		return bookingReference;
	}
	
	/**
	 * @return The Passenger's baggage weight.
	 */
	public double getBaggageWeight() {
		return baggageWeight;
	}
	
	/**
	 * @return The Passenger's baggage length.
	 */
	public double getBaggageLength() {
		return baggageLength;
	}
	
	/**
	 * @return The Passenger's baggage width.
	 */
	public double getBaggageWidth() {
		return baggageWidth;
	}
	
	/**
	 * @return The Passenger's baggage height.
	 */
	public double getBaggageHeight() {
		return baggageHeight;
	}
	
	/**
	 * @return The Passenger's baggage volume.
	 */
	public double getBaggageVolume() {
		return baggageVolume;
	}
	
	/**
	 * @return The Passenger's checked-in status (true = yes; false = no).
	 */
	public boolean getCheckedInStatus() {
		return checkedIn;
	}
	
	/**
	 * Completing the interface method.
	 * @return The passenger's flight code.
	 */
	public String getFlightCode() {
		return flightCode;
	}
	
	/**
	 * @return The Passenger's excess baggage fee.
	 */
	public double getPassengerExcessBaggageFee() {
		return passengerExcessBaggageFee;
	}
	
	/**
	 * Calculate the Passenger's excess baggage fee (GUI)
	 */
	public double caculateExcessFee() {
		
		double volumeFee = 0.0;
		double weightFee = 0.0;

		if (this.getBaggageVolume() > 63000 && this.getBaggageVolume() < 99999) { 
			
            volumeFee = 5.0;
            
		} else if (this.getBaggageVolume() >= 100000  && this.getBaggageVolume() < 149999) {   
			
            volumeFee = 10.0;
            
		} else if (this.getBaggageVolume() >= 150000) {   
			
            volumeFee = 15.0;
        }

        if (this.getBaggageWeight() > 15 && this.getBaggageWeight() < 50) {
        	
            weightFee = 5.0;
            
        } else if (this.getBaggageWeight() >= 50 && this.getBaggageWeight() < 100) {  
        	
            weightFee = 10.0;
            
        } else if (this.getBaggageWeight() >= 100) { 
        	
            weightFee = 15.0;
        }

        double excessFee = volumeFee + weightFee;
        
        this.passengerExcessBaggageFee = excessFee;
        return this.passengerExcessBaggageFee;
	}
	
	// Methods (Setters)
	
	/**
	 * Set a new value for the Passenger's baggage weight.
	 * @param weight The new weight value.
	 * @throws CheckInException 
	 */
	public void setBaggageWeight(double weight) throws CheckInException {
		
		if (weight < 0) {
			
			throw new CheckInException(weight);
		}
		else
			baggageWeight = weight;
	}
	
	/**
	 * Set a new value for the Passenger's baggage length.
	 * @param length The new length value.
	 * @throws CheckInException 
	 */
	public void setBaggageLength(double length) throws CheckInException {
		
		if (length < 0) {
			
			throw new CheckInException(length);
		}
		else
			baggageLength = length;
	}
	
	/**
	 * Set a new value for the Passenger's baggage width.
	 * @param width The new width value.
	 * @throws CheckInException 
	 */
	public void setBaggageWidth(double width) throws CheckInException {
		
		if (width < 0) {
			
			throw new CheckInException(width);
		}
		else
			baggageWidth = width;
	}
	
	/**
	 * Set a new value for the Passenger's baggage height.
	 * @param height The new height value.
	 * @throws CheckInException 
	 */
	public void setBaggageHeight(double height) throws CheckInException {
		
		if (height < 0) {
			
			throw new CheckInException(height);
		}
		else
			baggageHeight = height;
	}
	
	/**
	 * Set a new value for the Passenger's baggage volume.
	 * @param volume The new Volume value.
	 * @throws CheckInException 
	 */
	public void setBaggageVolume(double volume) throws CheckInException {
		
		if (volume < 0) {
			
			throw new CheckInException(volume);
		}
		else
			baggageVolume = volume; 
	}
	
	/**
	 * Set a new value for the Passenger's checked-in status.
	 * @param checkedIn The new checked-in value.
	 */
	public void setCheckInStatus(boolean checkedIn) {
			this.checkedIn = checkedIn;
	}
	
	/**
	 * Set a new value for the Passenger's excess baggage fee.
	 * @param passengerExcessFee The new excess baggage fee value.
	 * @throws CheckInException 
	 */
	public void setExcessFee(double passengerExcessBaggageFee) throws CheckInException {
		
		if (passengerExcessBaggageFee < 0) {
			throw new CheckInException(passengerExcessBaggageFee);
		}
		else	
			this.passengerExcessBaggageFee = passengerExcessBaggageFee;
	}
}
