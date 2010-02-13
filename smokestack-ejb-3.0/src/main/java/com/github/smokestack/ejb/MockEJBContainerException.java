/**
 * 
 */
package com.github.smokestack.ejb;

/**
 * Exception to ease method signature overload
 * 
 * @author gliptak
 *
 */
public class MockEJBContainerException extends RuntimeException {

	/**
	 * Generated
	 */
	private static final long serialVersionUID = 2618845219787087748L;

	/**
	 * 
	 */
	public MockEJBContainerException() {
	}

	/**
	 * @param message
	 */
	public MockEJBContainerException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public MockEJBContainerException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MockEJBContainerException(String message, Throwable cause) {
		super(message, cause);
	}
}
