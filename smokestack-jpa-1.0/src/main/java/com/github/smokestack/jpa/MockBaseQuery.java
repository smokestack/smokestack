/**
 * 
 */
package com.github.smokestack.jpa;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.FlushModeType;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.smokestack.exception.NeedsMockDefinitionException;

/**
 * Common query functionality.
 * 
 * @author gliptak
 */
public abstract class MockBaseQuery implements Query {

	protected int startPosition;
	protected FlushModeType flushMode;
	protected Map<String, Object> hints=new HashMap<String, Object>();
	protected int maxResult;

	/**
	 * 
	 */
	protected MockBaseQuery() {
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#executeUpdate()
	 */
	public int executeUpdate() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#getResultList()
	 */
	public List getResultList() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#getSingleResult()
	 */
	public Object getSingleResult() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setFirstResult(int)
	 */
	public Query setFirstResult(int startPosition) {
		this.startPosition=startPosition;
		return this;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setFlushMode(javax.persistence.FlushModeType)
	 */
	public Query setFlushMode(FlushModeType flushMode) {
		this.flushMode=flushMode;
		return this;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setHint(java.lang.String, java.lang.Object)
	 */
	public Query setHint(String hintName, Object value) {
		hints.put(hintName, value);
		return this;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setMaxResults(int)
	 */
	public Query setMaxResults(int maxResult) {
		this.maxResult=maxResult;
		return this;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setParameter(java.lang.String, java.lang.Object)
	 */
	public Query setParameter(String name, Object value) {
		// TODO Auto-generated method stub
		return this;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setParameter(int, java.lang.Object)
	 */
	public Query setParameter(int position, Object value) {
		// TODO Auto-generated method stub
		return this;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setParameter(java.lang.String, java.util.Date, javax.persistence.TemporalType)
	 */
	public Query setParameter(String name, Date value, TemporalType temporalType) {
		return setParameter(name, getTemporalType(value, temporalType));
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setParameter(java.lang.String, java.util.Calendar, javax.persistence.TemporalType)
	 */
	public Query setParameter(String name, Calendar value, TemporalType temporalType) {
		return setParameter(name, getTemporalType(value, temporalType));
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setParameter(int, java.util.Date, javax.persistence.TemporalType)
	 */
	public Query setParameter(int position, Date value, TemporalType temporalType) {
		// TODO Auto-generated method stub
		return this;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setParameter(int, java.util.Calendar, javax.persistence.TemporalType)
	 */
	public Query setParameter(int position, Calendar value, TemporalType temporalType) {
		// TODO Auto-generated method stub
		return this;
	}
	
	/**
	 * Convert TemporalType
	 * @param value
	 * @param type
	 * @return
	 */
    protected Object getTemporalType(Date value, TemporalType type) {
        switch (type) {
        case DATE:
            return value;
        case TIME:
            return new Time(value.getTime());
        case TIMESTAMP:
            return new Timestamp(value.getTime());
        default:
            return null;
        }
    }

    /**
     * Convert TemporalType
     * @param value
     * @param type
     * @return
     */
    protected Object getTemporalType(Calendar value, TemporalType type) {
        return getTemporalType(value.getTime(), type);
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}