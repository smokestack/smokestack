/**
 * 
 */
package net.sourceforge.smokestack.exception;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * This is an exception that is thrown whenever method needs to implemented by
 * the caller.
 * 
 * @author gliptak
 */
public class NeedsMockDefinitionException extends RuntimeException {

	/**
	 * Generated
	 */
	private static final long serialVersionUID = 5358627229792641962L;

	/**
	 * Constructor
	 */
	public NeedsMockDefinitionException() {
	}

	/**
	 * @param message
	 */
	public NeedsMockDefinitionException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NeedsMockDefinitionException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NeedsMockDefinitionException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
