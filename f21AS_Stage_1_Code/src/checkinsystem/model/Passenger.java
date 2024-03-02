package checkinsystem.model;

// This class holds and processes Passenger information.
public class Passenger {
	
	// Variables
	private String firstName;
	private String lastName;
	private String bookingReference;
	private double baggageWeight;
	private double baggageLength;
	private double baggageWidth;
	private double baggageHeight;
	private double baggageVolume;
	private double excessBaggageFee; // TODO I think this has to be initialised to 0.
	private boolean checkedIn; // TODO I think this has to be initialised to false.
	private String flightCode;
	
	/**
	 * Constructor to set up the Passenger's information.
	 * TODO Add an Exception(s) here. 
	 */
	public Passenger(String firstName, 
					 String lastName, 
					 String bookingReference, 
					 double baggageWeight,
					 double baggageLength,
					 double baggageWidth,
					 double baggageHeight,
					 double baggageVolume,
					 double excessBaggageFee,
					 boolean checkedIn,
					 String flightCode) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.bookingReference = bookingReference;
		this.baggageWeight = baggageWeight;
		this.baggageLength = baggageLength;
		this.baggageWidth = baggageWidth;
		this.baggageHeight = baggageHeight;
		this.baggageVolume = baggageVolume;
		this.excessBaggageFee = excessBaggageFee;
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
	 * @return The Passenger's excess baggage fee.
	 */
	public double getExcessBaggageFee() {
		return excessBaggageFee;
	}
	
	/**
	 * @return The Passenger's checked-in status (true = yes; false = no).
	 */
	public boolean getCheckedInStatus() {
		return checkedIn;
	}
	
	// TODO Add getFligthCode() method after Interface class has been set up.
	
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
	 * Set a new value for the Passenger's excess baggage fee.
	 * @param excessBaggageFee The new excess baggage fee value.
	 */
	public void setExcessBaggageFee(double excessBaggageFee) {
		this.excessBaggageFee = excessBaggageFee;
	}
	
	/**
	 * Set a new value for the Passenger's checked-in status.
	 * @param checkedIn The new checked-in value.
	 */
	public void setCheckInStatus(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	
}
