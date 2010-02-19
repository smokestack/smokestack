/**
 * 
 */
package com.github.smokestack.jca.spi;

import java.io.PrintWriter;
import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.security.auth.Subject;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.smokestack.exception.NeedsMockDefinitionException;

/**
 * @author gliptak
 *
 */
public class MockManagedConnectionFactory implements ManagedConnectionFactory {

	/**
	 * Generated
	 */
	private static final long serialVersionUID = -8203801341248772653L;
	
	protected PrintWriter printWriter;

	/* (non-Javadoc)
	 * @see javax.resource.spi.ManagedConnectionFactory#createConnectionFactory()
	 */
	public Object createConnectionFactory() throws ResourceException {
		return _createConnectionFactory();
	}

	public Object _createConnectionFactory() throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.spi.ManagedConnectionFactory#createConnectionFactory(javax.resource.spi.ConnectionManager)
	 */
	public Object createConnectionFactory(ConnectionManager connectionManager) throws ResourceException {
		return _createConnectionFactory(connectionManager);
	}

	public Object _createConnectionFactory(ConnectionManager connectionManager) throws ResourceException {
		return connectionManager.allocateConnection(this, null);
	}

	/* (non-Javadoc)
	 * @see javax.resource.spi.ManagedConnectionFactory#createManagedConnection(javax.security.auth.Subject, javax.resource.spi.ConnectionRequestInfo)
	 */
	public ManagedConnection createManagedConnection(Subject subject,
			ConnectionRequestInfo connectionRequestInfo) throws ResourceException {
		return _createManagedConnection(subject, connectionRequestInfo);
	}

	public ManagedConnection _createManagedConnection(Subject subject,
			ConnectionRequestInfo connectionRequestInfo) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.spi.ManagedConnectionFactory#getLogWriter()
	 */
	public PrintWriter getLogWriter() throws ResourceException {
		_getLogWriter();
		return printWriter;
	}

	public PrintWriter _getLogWriter() throws ResourceException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.resource.spi.ManagedConnectionFactory#matchManagedConnections(java.util.Set, javax.security.auth.Subject, javax.resource.spi.ConnectionRequestInfo)
	 */
	public ManagedConnection matchManagedConnections(Set set, Subject subject,
			ConnectionRequestInfo connectionRequestInfo) throws ResourceException {
		return _matchManagedConnections(set, subject, connectionRequestInfo);
	}

	public ManagedConnection _matchManagedConnections(Set set, Subject subject,
			ConnectionRequestInfo connectionRequestInfo) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.spi.ManagedConnectionFactory#setLogWriter(java.io.PrintWriter)
	 */
	public void setLogWriter(PrintWriter printWriter) throws ResourceException {
		_setLogWriter(printWriter);
		this.printWriter=printWriter;
	}

	public void _setLogWriter(PrintWriter printWriter) throws ResourceException {
	}

	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
