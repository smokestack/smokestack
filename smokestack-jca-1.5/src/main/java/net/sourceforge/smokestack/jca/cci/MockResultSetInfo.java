package net.sourceforge.smokestack.jca.cci;

import javax.resource.ResourceException;
import javax.resource.cci.ResultSetInfo;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import net.sourceforge.smokestack.exception.NeedsMockDefinitionException;

public class MockResultSetInfo implements ResultSetInfo {

	public MockResultSetInfo() {
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#deletesAreDetected(int)
	 */
	@Override
	public boolean deletesAreDetected(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#insertsAreDetected(int)
	 */
	@Override
	public boolean insertsAreDetected(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#othersDeletesAreVisible(int)
	 */
	@Override
	public boolean othersDeletesAreVisible(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#othersInsertsAreVisible(int)
	 */
	@Override
	public boolean othersInsertsAreVisible(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#othersUpdatesAreVisible(int)
	 */
	@Override
	public boolean othersUpdatesAreVisible(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#ownDeletesAreVisible(int)
	 */
	@Override
	public boolean ownDeletesAreVisible(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#ownInsertsAreVisible(int)
	 */
	@Override
	public boolean ownInsertsAreVisible(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#ownUpdatesAreVisible(int)
	 */
	@Override
	public boolean ownUpdatesAreVisible(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#supportsResultSetType(int)
	 */
	@Override
	public boolean supportsResultSetType(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#supportsResultTypeConcurrency(int, int)
	 */
	@Override
	public boolean supportsResultTypeConcurrency(int type, int concurrency) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResultSetInfo#updatesAreDetected(int)
	 */
	@Override
	public boolean updatesAreDetected(int type) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}