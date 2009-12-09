/**
 * 
 */
package net.sourceforge.smokestack.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;

/**
 * @author gliptak
 *
 */
public class MockInitialContextFactory implements InitialContextFactory {

	/* (non-Javadoc)
	 * @see javax.naming.spi.InitialContextFactory#getInitialContext(java.util.Hashtable)
	 */
	public Context getInitialContext(Hashtable environment)
			throws NamingException {
		return new MockContext(environment);
	}

}
