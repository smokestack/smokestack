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
		_getConnection();
		MockConnection c=new MockConnection();
		mockConnections.add(c);
		return c;
	}

	public MockConnection _getConnection() throws ResourceException {
		return null; 
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionFactory#getConnection(javax.resource.cci.ConnectionSpec)
	 */
	public Connection getConnection(ConnectionSpec connectionSpec) throws ResourceException {	
		_getConnection(connectionSpec);
		MockConnection c=new MockConnection(connectionSpec);
		mockConnections.add(c);
		return c;
	}

	public MockConnection _getConnection(ConnectionSpec connectionSpec) throws ResourceException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionFactory#getMetaData()
	 */
	public ResourceAdapterMetaData getMetaData() throws ResourceException {
		_getMetaData();	
		if (mockResourceAdapterMetaData==null){
			mockResourceAdapterMetaData=new MockResourceAdapterMetaData();
		}
		return mockResourceAdapterMetaData;
	}

	public MockResourceAdapterMetaData _getMetaData() throws ResourceException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionFactory#getRecordFactory()
	 */
	public RecordFactory getRecordFactory() throws ResourceException {
		_getRecordFactory();
		if (mockRecordFactory==null){
			mockRecordFactory=new MockRecordFactory();
		}
		return mockRecordFactory;
	}

	public MockRecordFactory _getRecordFactory() throws ResourceException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.resource.Referenceable#setReference(javax.naming.Reference)
	 */
	public void setReference(Reference reference) {	
		_setReference(reference);
		this.reference=reference;
	}

	public void _setReference(Reference reference) {
	}

	/* (non-Javadoc)
	 * @see javax.naming.Referenceable#getReference()
	 */
	public Reference getReference() throws NamingException {
		_getReference();
		return reference;
		
	}
	
	public Reference _getReference() throws NamingException {
		return null;
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