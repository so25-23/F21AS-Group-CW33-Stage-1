package checkinsystem.model;

//This class holds and processes Flight information.
public class Flight implements FlightCode {
	
	// Variables
	private String carrier;
	private String destinationAirport;
	private int flightCapacity;
	private double maxBaggageWeight;
	private double maxBaggageVolume;
	private String flightCode;
	private int passengersOnBoard;
	private double baggageWeightOnBoard;
	private double baggageVolumeOnBoard;
	private boolean isFlightExceeded; // New addition (change from design)
	private double excessBaggageFee; // New addition (change from design)
	
	/**
	 * Constructor to set up the Flight's information.
	 */
	public Flight(String carrier,
				  String destinationAirport,
				  int flightCapacity,
				  double maxBaggageWeight,
				  double maxBaggageVolume,
				  String flightCode,
				  int passengersOnBoard,
				  double baggageWeightOnBoard,
				  double baggageVolumeOnBoard,
				  boolean isFlightExceeded,
				  double excessBaggageFee) {
		
		// carrier and destinationAirport must be entered.
		if (carrier.length() == 0 || destinationAirport.length() == 0) {
			
			throw new IllegalStateException("carrier or destinationAirport cannot be left blank");
		}
		
		this.carrier = carrier;
		this.destinationAirport = destinationAirport;
		this.flightCapacity = flightCapacity;
		this.maxBaggageWeight = maxBaggageWeight;
		this.maxBaggageVolume = maxBaggageVolume;
		this.flightCode = flightCode;
		this.passengersOnBoard = passengersOnBoard;
		this.baggageWeightOnBoard = baggageWeightOnBoard;
		this.baggageVolumeOnBoard = baggageVolumeOnBoard;
		this.isFlightExceeded = isFlightExceeded;
		this.excessBaggageFee = excessBaggageFee;
	}
	
	// Methods (Getters)
	
	/**
	 * @return The Flight's carrier.
	 */
	public String getFlightCarrier() {
		return carrier;
	}
	
	/**
	 * @return The Flight's destination airport.
	 */
	public String getDestinationAirport() {
		return destinationAirport;
	}
	
	/**
	 * @return The Flight's capacity.
	 */
	public int getFlightCapacity() {
		return flightCapacity;
	}
	
	/**
	 * @return The Flight's baggage weight limit.
	 */
	public double getMaxBaggageWeight() {
		return maxBaggageWeight;
	}
	
	/**
	 * @return The Flight's baggage volume limit.
	 */
	public double getMaxBaggageVolume() {
		return maxBaggageVolume;
	}
	
	/**
	 * @return The Flight's number of passengers on board.
	 */
	public int getNumberOfPassengersOnBoard() {
		return passengersOnBoard;
	}
	
	/**
	 * @return The Flight's current baggage weight value on board.
	 */
	public double getBaggageWeightOnBoard() {
		return baggageWeightOnBoard; 
	}
	
	/**
	 * @return The Flight's current baggage volume value on board.
	 */
	public double getBaggageVolumeOnBoard() {
		return baggageVolumeOnBoard; 
	}
	
	/**
	 * Completing the interface method.
	 * @return The flight's flight code.
	 */
	public String getFlightCode() {
		return flightCode;
	}
	
	/**
	 * Determine if the Flight's capacity has been exceeded.
	 * @return The verdict; true = yes and false = no.
	 */
	public boolean isFlightCapacityExceeded() {
	
		if (passengersOnBoard > flightCapacity) {
			
			isFlightExceeded = true;
			
		} else if (passengersOnBoard <= flightCapacity) {
			
			isFlightExceeded = false;
			
		}
		return isFlightExceeded;
	}
	
	/**
	 * @return The Flight's excess baggage fee.
	 */
	public double getExcessBaggageFee() {
		return excessBaggageFee;
	}
	
	
	// Methods (Setters)
	
	/**
	 * Set a new value for the Flight's carrier.
	 * @param carrier The new carrier value.
	 */
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	
	/**
	 * Set a new value for the Flight's destination airport.
	 * @param destinationAirport The new destination airport location.
	 */
	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	
	/**
	 * Set a new value for the Flight's capacity.
	 * @param flightCapacity The new capacity value.
	 */
	public void setFlightCapacity(int flightCapacity) {
		this.flightCapacity = flightCapacity;
	}
	
	/**
	 * Set a new value for the Flight's baggage weight limit.
	 * @param maxBaggageWeight The new baggage weight limit.
	 */
	public void setMaxBaggageWeight(double maxBaggageWeight) {
		this.maxBaggageWeight = maxBaggageWeight;
	}
	
	/**
	 * Set a new value for the Flight's baggage volume limit.
	 * @param maxBaggageVolume The new baggage volume limit.
	 */
	public void setMaxBaggageVolume(double maxBaggageVolume) {
		this.maxBaggageVolume = maxBaggageVolume;
	}
	
	/**
	 * Set a new value for the Flight's current number of passengers on board.
	 * @param passengersOnBoard The new number of passengers on board.
	 */
	public void setNumberOfPassengersOnBoard(int passengersOnBoard) {
		this.passengersOnBoard = passengersOnBoard;
	}
	
	/**
	 * Set a new value for the Flight's current baggage weight on board.
	 * @param baggageWeightOnBoard The new value of baggage weight on board.
	 */
	public void setBaggageWeightOnBoard(double baggageWeightOnBoard) {
		this.baggageWeightOnBoard = baggageWeightOnBoard;
	}
	
	/**
	 * Set a new value for the Flight's current baggage volume on board.
	 * @param baggageVolumeOnBoard The new value of baggage volume on board.
	 */
	public void setBaggageVolumeOnBoard(double baggageVolumeOnBoard) {
		this.baggageVolumeOnBoard = baggageVolumeOnBoard;
	}
	
	/**
	 * Set a new value for the Passenger's excess baggage fee.
	 * @param excessBaggageFee The new excess baggage fee value.
	 */
	public void setExcessBaggageFee(double excessBaggageFee) {
		this.excessBaggageFee = excessBaggageFee;
	}
	
}
