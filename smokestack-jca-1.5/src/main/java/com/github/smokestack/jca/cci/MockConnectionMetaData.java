package com.github.smokestack.jca.cci;

import javax.resource.ResourceException;
import javax.resource.cci.ConnectionMetaData;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.smokestack.exception.NeedsMockDefinitionException;

public class MockConnectionMetaData implements ConnectionMetaData {

	public MockConnectionMetaData() {
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionMetaData#getEISProductName()
	 */
	public String getEISProductName() throws ResourceException {
		return _getEISProductName();
	}

	public String _getEISProductName() throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionMetaData#getEISProductVersion()
	 */
	public String getEISProductVersion() throws ResourceException {
		return _getEISProductVersion();
	}

	public String _getEISProductVersion() throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionMetaData#getUserName()
	 */
	public String getUserName() throws ResourceException {
		return _getUserName();
	}

	public String _getUserName() throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
