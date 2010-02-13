package com.github.smokestack.jca.cci;

import javax.resource.ResourceException;
import javax.resource.cci.IndexedRecord;
import javax.resource.cci.MappedRecord;
import javax.resource.cci.RecordFactory;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.smokestack.exception.NeedsMockDefinitionException;

public class MockRecordFactory implements RecordFactory {

	public MockRecordFactory() {
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.RecordFactory#createIndexedRecord(java.lang.String)
	 */
	public IndexedRecord createIndexedRecord(String recordName) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.RecordFactory#createMappedRecord(java.lang.String)
	 */
	public MappedRecord createMappedRecord(String recordName) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
