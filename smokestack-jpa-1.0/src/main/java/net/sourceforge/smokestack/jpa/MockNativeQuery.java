package net.sourceforge.smokestack.jpa;

public class MockNativeQuery extends MockBaseQuery {

	protected String sqlString;
	protected Class resultClass;
	protected String resultSetMapping;

	public MockNativeQuery(String sqlString) {
		this.sqlString=sqlString;
	}

	public MockNativeQuery(String sqlString, Class resultClass) {
		this.sqlString=sqlString;
		this.resultClass=resultClass;
	}

	public MockNativeQuery(String sqlString, String resultSetMapping) {
		this.sqlString=sqlString;
		this.resultSetMapping=resultSetMapping;
	}

}
