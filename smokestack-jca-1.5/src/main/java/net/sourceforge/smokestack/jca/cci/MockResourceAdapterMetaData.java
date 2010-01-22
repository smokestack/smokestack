package net.sourceforge.smokestack.jca.cci;

import javax.resource.cci.ResourceAdapterMetaData;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import net.sourceforge.smokestack.exception.NeedsMockDefinitionException;

public class MockResourceAdapterMetaData implements ResourceAdapterMetaData {
	
	public MockResourceAdapterMetaData(){
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getAdapterName()
	 */
	public String getAdapterName() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getAdapterShortDescription()
	 */
	public String getAdapterShortDescription() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getAdapterVendorName()
	 */
	public String getAdapterVendorName() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getAdapterVersion()
	 */
	public String getAdapterVersion() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getInteractionSpecsSupported()
	 */
	public String[] getInteractionSpecsSupported() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getSpecVersion()
	 */
	public String getSpecVersion() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#supportsExecuteWithInputAndOutputRecord()
	 */
	public boolean supportsExecuteWithInputAndOutputRecord() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#supportsExecuteWithInputRecordOnly()
	 */
	public boolean supportsExecuteWithInputRecordOnly() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#supportsLocalTransactionDemarcation()
	 */
	public boolean supportsLocalTransactionDemarcation() {
		throw new NeedsMockDefinitionException();
	}

	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
