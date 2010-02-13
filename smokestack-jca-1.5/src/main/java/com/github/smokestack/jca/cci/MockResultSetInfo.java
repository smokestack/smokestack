package com.github.smokestack.jca.cci;

import javax.resource.ResourceException;
import javax.resource.cci.ResultSetInfo;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.smokestack.exception.NeedsMockDefinitionException;

public class MockResultSetInfo implements ResultSetInfo {

	public MockResultSetInfo() {
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#deletesAreDetected(int)
	 */
	public boolean deletesAreDetected(int type) throws ResourceException {
		return _deletesAreDetected(type);
	}

	public boolean _deletesAreDetected(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#insertsAreDetected(int)
	 */
	public boolean insertsAreDetected(int type) throws ResourceException {
		return _insertsAreDetected(type);
	}

	public boolean _insertsAreDetected(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#othersDeletesAreVisible(int)
	 */
	public boolean othersDeletesAreVisible(int type) throws ResourceException {
		return _othersDeletesAreVisible(type);
	}

	public boolean _othersDeletesAreVisible(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#othersInsertsAreVisible(int)
	 */
	public boolean othersInsertsAreVisible(int type) throws ResourceException {
		return _othersInsertsAreVisible(type);
	}

	public boolean _othersInsertsAreVisible(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#othersUpdatesAreVisible(int)
	 */
	public boolean othersUpdatesAreVisible(int type) throws ResourceException {
		return _othersUpdatesAreVisible(type);
	}

	public boolean _othersUpdatesAreVisible(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#ownDeletesAreVisible(int)
	 */
	public boolean ownDeletesAreVisible(int type) throws ResourceException {
		return _ownDeletesAreVisible(type);
	}

	public boolean _ownDeletesAreVisible(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#ownInsertsAreVisible(int)
	 */
	public boolean ownInsertsAreVisible(int type) throws ResourceException {
		return _ownInsertsAreVisible(type);
	}

	public boolean _ownInsertsAreVisible(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#ownUpdatesAreVisible(int)
	 */
	public boolean ownUpdatesAreVisible(int type) throws ResourceException {
		return _ownUpdatesAreVisible(type);
	}

	public boolean _ownUpdatesAreVisible(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#supportsResultSetType(int)
	 */
	public boolean supportsResultSetType(int type) throws ResourceException {
		return _supportsResultSetType(type);
	}

	public boolean _supportsResultSetType(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#supportsResultTypeConcurrency(int, int)
	 */
	public boolean supportsResultTypeConcurrency(int type, int concurrency) throws ResourceException {
		return _supportsResultTypeConcurrency(type, concurrency);
	}

	public boolean _supportsResultTypeConcurrency(int type, int concurrency) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#updatesAreDetected(int)
	 */
	public boolean updatesAreDetected(int type) throws ResourceException {
		return _updatesAreDetected(type);
	}

	public boolean _updatesAreDetected(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}