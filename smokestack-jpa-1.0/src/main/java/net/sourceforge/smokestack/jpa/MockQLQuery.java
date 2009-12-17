package net.sourceforge.smokestack.jpa;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrTokenizer;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;

import static org.hamcrest.MatcherAssert.assertThat;

public class MockQLQuery extends MockBaseQuery {

	protected String qlString;
	
	protected Map<String, Object> parameters=new HashMap<String, Object>();

	/**
	 * Constructor
	 * @param qlString JQL query
	 */
	public MockQLQuery(String qlString) {
		assertThat(qlString, IsNull.notNullValue());
		this.qlString=qlString;
		parseParameters();
	}

	/**
	 * Parse named parameters
	 */
	protected void parseParameters() {
		StrTokenizer t=new StrTokenizer(qlString);
		for (String s: (List<String>)t.getTokenList()){
			if (StringUtils.startsWith(s, ":")){
				parameters.put(StringUtils.substring(s, 1), null);
			}
		}
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.smokestack.jpa.MockBaseQuery#setParameter(java.lang.String, java.lang.Object)
	 */
	@Override
	public Query setParameter(String name, Object value) {
		assertThat(parameters.containsKey(name), Is.is(true));
		parameters.put(name, value);
		return this;
	}

	public Map<String, Object> getMockParameters(){
		return parameters;
	}
}
