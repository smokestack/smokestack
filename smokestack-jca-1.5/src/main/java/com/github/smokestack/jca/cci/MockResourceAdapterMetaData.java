package com.github.smokestack.jca.cci;

import javax.resource.cci.ResourceAdapterMetaData;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.smokestack.exception.NeedsMockDefinitionException;

public class MockResourceAdapterMetaData implements ResourceAdapterMetaData {
	
	public MockResourceAdapterMetaData(){
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getAdapterName()
	 */
	public String getAdapterName() {
		return _getAdapterName();
	}

	public String _getAdapterName() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getAdapterShortDescription()
	 */
	public String getAdapterShortDescription() {
		return _getAdapterShortDescription();
	}

	public String _getAdapterShortDescription() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getAdapterVendorName()
	 */
	public String getAdapterVendorName() {
		return _getAdapterVendorName();
	}

	public String _getAdapterVendorName() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getAdapterVersion()
	 */
	public String getAdapterVersion() {
		return _getAdapterVersion();
	}

	public String _getAdapterVersion() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getInteractionSpecsSupported()
	 */
	public String[] getInteractionSpecsSupported() {
		return _getInteractionSpecsSupported();
	}

	public String[] _getInteractionSpecsSupported() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getSpecVersion()
	 */
	public String getSpecVersion() {
		return _getSpecVersion();
	}

	public String _getSpecVersion() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#supportsExecuteWithInputAndOutputRecord()
	 */
	public boolean supportsExecuteWithInputAndOutputRecord() {
		return _supportsExecuteWithInputAndOutputRecord();
	}

	public boolean _supportsExecuteWithInputAndOutputRecord() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#supportsExecuteWithInputRecordOnly()
	 */
	public boolean supportsExecuteWithInputRecordOnly() {
		return _supportsExecuteWithInputRecordOnly();
	}

	public boolean _supportsExecuteWithInputRecordOnly() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#supportsLocalTransactionDemarcation()
	 */
	public boolean supportsLocalTransactionDemarcation() {
		return _supportsLocalTransactionDemarcation();
	}

	public boolean _supportsLocalTransactionDemarcation() {
		throw new NeedsMockDefinitionException();
	}

	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
