package net.sourceforge.smokestack.jca.cci.ex01;

import javax.resource.cci.Record;

public class SampleRecord implements Record {

	/**
	 * Generated
	 */
	private static final long serialVersionUID = 7561225096607764861L;

	protected String recordName;

	protected String recordShortDescription;

	public String getRecordName() {
		return recordName;
	}

	public String getRecordShortDescription() {
		return recordShortDescription;
	}

	public void setRecordName(String recordName) {
		this.recordName=recordName;
	}

	public void setRecordShortDescription(String recordShortDescription) {
		this.recordShortDescription=recordShortDescription;

	}
	
	public Object clone(){
		return this;
	}

}