package checkinsystem.model;

// A exception class for handling incorrect number values according to rules.
public class CheckInException extends Exception {
	
	public CheckInException(double cIE) {
		super(cIE + " is invalid becuase it is not equal to or greater than 0.");
	}

}
