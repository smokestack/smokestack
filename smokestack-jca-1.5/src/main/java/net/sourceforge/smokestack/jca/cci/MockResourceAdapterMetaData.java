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
	@Override
	public String getAdapterName() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getAdapterShortDescription()
	 */
	@Override
	public String getAdapterShortDescription() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getAdapterVendorName()
	 */
	@Override
	public String getAdapterVendorName() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getAdapterVersion()
	 */
	@Override
	public String getAdapterVersion() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getInteractionSpecsSupported()
	 */
	@Override
	public String[] getInteractionSpecsSupported() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getSpecVersion()
	 */
	@Override
	public String getSpecVersion() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#supportsExecuteWithInputAndOutputRecord()
	 */
	@Override
	public boolean supportsExecuteWithInputAndOutputRecord() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#supportsExecuteWithInputRecordOnly()
	 */
	@Override
	public boolean supportsExecuteWithInputRecordOnly() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#supportsLocalTransactionDemarcation()
	 */
	@Override
	public boolean supportsLocalTransactionDemarcation() {
		throw new NeedsMockDefinitionException();
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
