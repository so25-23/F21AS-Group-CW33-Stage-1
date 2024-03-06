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
	private double flightExcessBaggageFee; // New addition (change from design)
	
	/**
	 * Constructor to set up the Flight's information.
	 * @throws CheckInException 
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
				  double flightExcessBaggageFee) throws CheckInException {
		
		// carrier and destinationAirport must be entered.
		if (carrier.length() == 0 || destinationAirport.length() == 0) {
			throw new IllegalStateException("carrier or destinationAirport cannot be left blank.");
		}
		
		// destinationAirport String must be 3 characters in length.
		if (destinationAirport.length() != 3) {
			throw new IllegalStateException("destinationAirport must be 3 characters in length; for example 'LAX'.");
		}
		
		// flightCapacity must be equal to or greater than 0.
		if (flightCapacity < 0) {
			throw new IllegalStateException("flightCapacity must be must be equal to or greater than 0.");
		}
		
		// maxBaggageWeight must be equal to or greater than 0.
		if (maxBaggageWeight < 0) {
			throw new CheckInException(maxBaggageWeight);
		}
		
		// maxBaggageVolume must be equal to or greater than 0.
		if (maxBaggageVolume < 0) {
			throw new CheckInException(maxBaggageVolume);
		}
		
		// flightCode String must be 5 characters in length (white space inclusive).
		if (flightCode.length() != 5) {
			throw new IllegalStateException("flightCode must be 5 characters in length (including white space); for example, 'AA 12'");
		}
		
		// passengersOnBoard must be equal to or greater than 0.
		if (passengersOnBoard < 0) {
			throw new IllegalStateException("passengersOnBoard must be equal to or greater than 0.");
		}
		
		// baggageWeightOnBoard must be equal to or greater than 0.
		if (baggageWeightOnBoard < 0) {
			throw new CheckInException(baggageWeightOnBoard);
		}
		
		// baggageVolumeOnBoard must be equal to or greater than 0.
		if (baggageVolumeOnBoard < 0) {
			throw new CheckInException(baggageVolumeOnBoard);
		}
		
		// flightExcessBaggageFee must be equal to or greater than 0.
		if (flightExcessBaggageFee < 0) {
			throw new CheckInException(flightExcessBaggageFee);
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
		this.flightExcessBaggageFee = flightExcessBaggageFee;
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
	 * Determine if the Flight's passenger capacity has been exceeded.
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
	public double getFlightExcessBaggageFee() {
		return flightExcessBaggageFee;
	}
	
	// Methods (Setters)
	
	/**
	 * Set a new value for the Flight's carrier.
	 * @param carrier The new carrier value.
	 */
	public void setCarrier(String carrier) {
		
		if (carrier.length() == 0) {
			throw new IllegalStateException("carrier cannot be left blank");
		}
		else
			this.carrier = carrier;
	}
	
	/**
	 * Set a new value for the Flight's destination airport.
	 * @param destinationAirport The new destination airport location.
	 */
	public void setDestinationAirport(String destinationAirport) {
		
		if (destinationAirport.length() == 0) {
			
			throw new IllegalStateException("destinationAirport cannot be left blank.");
		} else if (destinationAirport.length() != 3) {
			
			throw new IllegalStateException("destinationAirport must be 3 characters in length; for example 'LAX'.");
		}
		else
			this.destinationAirport = destinationAirport;
	}
	
	/**
	 * Set a new value for the Flight's capacity.
	 * @param flightCapacity The new capacity value. 
	 */
	public void setFlightCapacity(int flightCapacity) {
		
		if (flightCapacity < 0) {
			
			throw new IllegalStateException("flightCapacity must be must be equal to or greater than 0.");
		}
		else
			this.flightCapacity = flightCapacity;
	}
	
	/**
	 * Set a new value for the Flight's baggage weight limit.
	 * @param maxBaggageWeight The new baggage weight limit.
	 * @throws CheckInException 
	 */
	public void setMaxBaggageWeight(double maxBaggageWeight) throws CheckInException {
		
		if (maxBaggageWeight < 0) {
			
			throw new CheckInException(maxBaggageWeight);
		}
		else
			this.maxBaggageWeight = maxBaggageWeight;
	}
	
	/**
	 * Set a new value for the Flight's baggage volume limit.
	 * @param maxBaggageVolume The new baggage volume limit.
	 * @throws CheckInException 
	 */
	public void setMaxBaggageVolume(double maxBaggageVolume) throws CheckInException {
		
		if (maxBaggageVolume < 0) {
			
			throw new CheckInException(maxBaggageVolume);
		}
		else
			this.maxBaggageVolume = maxBaggageVolume;
	}
	
	/**
	 * Set a new value for the Flight's current number of passengers on board.
	 * @param passengersOnBoard The new number of passengers on board.
	 */
	public void setNumberOfPassengersOnBoard(int passengersOnBoard) {
		
		if (passengersOnBoard < 0) {
			
			throw new IllegalStateException("passengersOnBoard must be must be equal to or greater than 0.");
		}
		else
			this.passengersOnBoard = passengersOnBoard;
	}
	
	/**
	 * Set a new value for the Flight's current baggage weight on board.
	 * @param baggageWeightOnBoard The new value of baggage weight on board.
	 * @throws CheckInException 
	 */
	public void setBaggageWeightOnBoard(double baggageWeightOnBoard) throws CheckInException {
		
		if (baggageWeightOnBoard < 0) {
			
			throw new CheckInException(baggageWeightOnBoard);
		}
		else
			this.baggageWeightOnBoard = baggageWeightOnBoard;
	}
	
	/**
	 * Set a new value for the Flight's current baggage volume on board.
	 * @param baggageVolumeOnBoard The new value of baggage volume on board.
	 * @throws CheckInException 
	 */
	public void setBaggageVolumeOnBoard(double baggageVolumeOnBoard) throws CheckInException {
		
		if (baggageVolumeOnBoard < 0) {
			
			throw new CheckInException(baggageVolumeOnBoard);
		}
		else
			this.baggageVolumeOnBoard = baggageVolumeOnBoard;
	}
	
	/**
	 * Set a new value for the Flight's exceeded status.
	 * @param isFlightExceeded The new status of exceeded.
	 * TODO Tag - Abeer addition. 
	 */
	public void setFlightExceeded(boolean isFlightExceeded) {
		this.isFlightExceeded = isFlightExceeded;
	}
	
	/**
	 * Set a new value for the Flight's excess baggage fee.
	 * @param flightExcessBaggageFee The new flight excess baggage fee value.
	 * @throws CheckInException 
	 */
	public void setFlightExcessBaggageFee(double flightExcessBaggageFee) throws CheckInException {
		
		if (flightExcessBaggageFee < 0) {
			
			throw new CheckInException(flightExcessBaggageFee);
		}
		else
			this.flightExcessBaggageFee = flightExcessBaggageFee;
	}
}
