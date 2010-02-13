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
		return _getConnection();
	}

	public Connection _getConnection() throws ResourceException {
		MockConnection c=new MockConnection();
		mockConnections.add(c);
		return c;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionFactory#getConnection(javax.resource.cci.ConnectionSpec)
	 */
	public Connection getConnection(ConnectionSpec connectionSpec) throws ResourceException {
		return _getConnection(connectionSpec);
	}

	public Connection _getConnection(ConnectionSpec connectionSpec) throws ResourceException {
		MockConnection c=new MockConnection(connectionSpec);
		mockConnections.add(c);
		return c;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionFactory#getMetaData()
	 */
	public ResourceAdapterMetaData getMetaData() throws ResourceException {
		return _getMetaData();
	}

	public ResourceAdapterMetaData _getMetaData() throws ResourceException {
		if (mockResourceAdapterMetaData==null){
			mockResourceAdapterMetaData=new MockResourceAdapterMetaData();			
		}
		return mockResourceAdapterMetaData;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionFactory#getRecordFactory()
	 */
	public RecordFactory getRecordFactory() throws ResourceException {
		return _getRecordFactory();
	}

	public RecordFactory _getRecordFactory() throws ResourceException {
		if (mockRecordFactory==null){
			mockRecordFactory=new MockRecordFactory();			
		}
		return mockRecordFactory;
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