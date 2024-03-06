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
	private double passengerExcessBaggageFee; // TODO Tag - Abeer addition
	
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
					 String flightCode) { 
		
		// lastName and bookingReference must be entered.
		if (lastName.length() == 0 || bookingReference.length() == 0) {
			
			throw new IllegalStateException("lastName or bookingReference cannot be left blank");
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
	 * TODO Tag - Abeer addition.
	 */
	public double getPassengerExcessBaggageFee() {
		return passengerExcessBaggageFee;
	}
	
	/**
	 * Calculate the Passenger's excess baggage fee (GUI)
	 * TODO Tag - Abeer addition
	 */
	public double caculateExcessFee() {

		double volumeFee = 0.0;
		double weightFee = 0.0;

		if (this.getBaggageVolume() > 0 && this.getBaggageVolume() < 5000) {
            volumeFee = 5.0;
        } else if (this.getBaggageVolume() >= 5000  && this.getBaggageVolume() < 10000) {
            volumeFee = 10.0;
        } else if(this.getBaggageVolume() >= 10000){
            volumeFee = 15.0;
        }

        if (this.getBaggageWeight() > 0 && this.getBaggageWeight() < 50) {
            weightFee = 5.0;
        } else if (this.getBaggageWeight() >= 50 && this.getBaggageWeight() < 100) {
            weightFee = 10.0;
        } else if(this.getBaggageWeight() >= 100){
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
	 */
	public void setBaggageWeight(double weight) {
		baggageWeight = weight;
	}
	
	/**
	 * Set a new value for the Passenger's baggage length.
	 * @param length The new length value.
	 */
	public void setBaggageLength(double length) {
		baggageLength = length;
	}
	
	/**
	 * Set a new value for the Passenger's baggage width.
	 * @param width The new width value.
	 */
	public void setBaggageWidth(double width) {
		baggageWidth = width;
	}
	
	/**
	 * Set a new value for the Passenger's baggage height.
	 * @param height The new height value.
	 * TODO Is value conversion needed? (m3)
	 */
	public void setBaggageHeight(double height) {
		baggageHeight = height;
	}
	
	/**
	 * Set a new value for the Passenger's baggage volume.
	 * @param volume The new Volume value.
	 */
	public void setBaggageVolume(double volume) {
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
	 * TODO Tag - Abeer addition.
	 */
	public void setExcessFee(double passengerExcessBaggageFee) {
		this.passengerExcessBaggageFee = passengerExcessBaggageFee;
	}
}
