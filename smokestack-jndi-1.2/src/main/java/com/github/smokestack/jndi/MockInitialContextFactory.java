/**
 * 
 */
package com.github.smokestack.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author gliptak
 *
 */
public class MockInitialContextFactory implements InitialContextFactory {

	protected static MockContext singleton;
	
	/* (non-Javadoc)
	 * @see javax.naming.spi.InitialContextFactory#getInitialContext(java.util.Hashtable)
	 */
	public Context getInitialContext(Hashtable environment)	throws NamingException {
		_getInitialContext(environment);
		if (singleton==null){
			singleton=new MockContext(environment);
		}
		return singleton;
	}
	
	public Context _getInitialContext(Hashtable environment)	throws NamingException {
		return null;
	}
	
	/**
	 * Release singleton
	 */
	static protected void releaseSingleton(){
		singleton=null;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
