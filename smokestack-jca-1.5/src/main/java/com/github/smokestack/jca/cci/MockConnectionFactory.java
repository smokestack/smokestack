package com.github.smokestack.jca.cci;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.ConnectionSpec;
import javax.resource.cci.RecordFactory;
import javax.resource.cci.ResourceAdapterMetaData;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class MockConnectionFactory implements ConnectionFactory {

	/**
	 * Generated
	 */
	private static final long serialVersionUID = -4549014744671003973L;

	protected List<MockConnection> mockConnections=new ArrayList<MockConnection>();
	protected Reference reference=null;
	protected MockResourceAdapterMetaData mockResourceAdapterMetaData;
	protected MockRecordFactory mockRecordFactory;
	
	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionFactory#getConnection()
	 */
	public Connection getConnection() throws ResourceException {	
		MockConnection c=_getConnection();
		mockConnections.add(c);
		return c;
	}

	public MockConnection _getConnection() throws ResourceException {
		return new MockConnection();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionFactory#getConnection(javax.resource.cci.ConnectionSpec)
	 */
	public Connection getConnection(ConnectionSpec connectionSpec) throws ResourceException {	
		MockConnection c=_getConnection(connectionSpec);
		mockConnections.add(c);
		return c;
	}

	public MockConnection _getConnection(ConnectionSpec connectionSpec) throws ResourceException {
		return new MockConnection(connectionSpec);
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionFactory#getMetaData()
	 */
	public ResourceAdapterMetaData getMetaData() throws ResourceException {
		if (mockResourceAdapterMetaData==null){
			mockResourceAdapterMetaData=_getMetaData();	
		}
		return mockResourceAdapterMetaData;
	}

	public MockResourceAdapterMetaData _getMetaData() throws ResourceException {
		return new MockResourceAdapterMetaData();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionFactory#getRecordFactory()
	 */
	public RecordFactory getRecordFactory() throws ResourceException {
		if (mockRecordFactory==null){
			mockRecordFactory=_getRecordFactory();
		}
		return mockRecordFactory;
	}

	public MockRecordFactory _getRecordFactory() throws ResourceException {
		return new MockRecordFactory();
	}

	/* (non-Javadoc)
	 * @see javax.resource.Referenceable#setReference(javax.naming.Reference)
	 */
	public void setReference(Reference reference) {	
		_setReference(reference);
	}

	public void _setReference(Reference reference) {
		this.reference=reference;
	}

	/* (non-Javadoc)
	 * @see javax.naming.Referenceable#getReference()
	 */
	public Reference getReference() throws NamingException {
		return _getReference();
		
	}
	
	public Reference _getReference() throws NamingException {
		return reference;
	}
	
	public void validateMockComplete(){
		for (MockConnection c: mockConnections){
			c.validateMockComplete();
		}
	}

	public void validateMockCommit(){
		for (MockConnection c: mockConnections){
			c.validateMockCommit();
		}
	}
	
	public void validateMockRollback(){
		for (MockConnection c: mockConnections){
			c.validateMockRollback();
		}
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}