package com.github.smokestack.jpa;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrTokenizer;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;

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
	 * @see com.github.smokestack.jpa.MockBaseQuery#setParameter(java.lang.String, java.lang.Object)
	 */
	@Override
	public Query setParameter(String name, Object value) {
		assertThat(parameters.containsKey(name), Is.is(true));
		_setParameter(name, value);
		parameters.put(name, value);
		return this;
	}

	public Query _setParameter(String name, Object value) {
		return null;
	}

	public Map<String, Object> getMockParameters(){
		return parameters;
	}
}
