/**
 * 
 */
package net.sourceforge.smokestack.exception;

/**
 * This is an exception that is thrown whenever some functionality isn't
 * yet implemented. 
 * 
 * @author gliptak
 */
public class NotYetImplementedException extends RuntimeException {

	/**
	 * Generated
	 */
	private static final long serialVersionUID = -5155305992604459343L;

	/**
	 * Constructor
	 */
	public NotYetImplementedException() {
	}

	/**
	 * @param message
	 */
	public NotYetImplementedException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NotYetImplementedException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NotYetImplementedException(String message, Throwable cause) {
		super(message, cause);
	}
}
