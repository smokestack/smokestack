package net.sourceforge.smokestack.jpa;

public class MockQLQuery extends MockBaseQuery {

	protected String qlString;

	public MockQLQuery(String qlString) {
		this.qlString=qlString;
	}

}
