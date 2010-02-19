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
import com.github.smokestack.exception.NotYetImplementedException;

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
		return _executeUpdate();
	}

	public int _executeUpdate() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#getResultList()
	 */
	public List getResultList() {
		return _getResultList();
	}

	public List _getResultList() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#getSingleResult()
	 */
	public Object getSingleResult() {
		return _getSingleResult();
	}

	public Object _getSingleResult() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setFirstResult(int)
	 */
	public Query setFirstResult(int startPosition) {
		_setFirstResult(startPosition);
		this.startPosition=startPosition;
		return this;
	}

	public Query _setFirstResult(int startPosition2) {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setFlushMode(javax.persistence.FlushModeType)
	 */
	public Query setFlushMode(FlushModeType flushMode) {
		_setFlushMode(flushMode);
		this.flushMode=flushMode;
		return this;
	}

	public Query _setFlushMode(FlushModeType flushMode) {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setHint(java.lang.String, java.lang.Object)
	 */
	public Query setHint(String hintName, Object value) {
		_setHint(hintName, value);
		hints.put(hintName, value);
		return this;
	}

	public Query _setHint(String hintName, Object value) {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setMaxResults(int)
	 */
	public Query setMaxResults(int maxResult) {
		_setMaxResults(maxResult);
		this.maxResult=maxResult;
		return this;
	}

	public Query _setMaxResults(int maxResult) {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setParameter(java.lang.String, java.lang.Object)
	 */
	public Query setParameter(String name, Object value) {
		_setParameter(name, value);
		throw new NotYetImplementedException();
	}

	public Query _setParameter(String name, Object value) {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setParameter(int, java.lang.Object)
	 */
	public Query setParameter(int position, Object value) {
		_setParameter(position, value);
		return this;
	}

	public Query _setParameter(int position, Object value) {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setParameter(java.lang.String, java.util.Date, javax.persistence.TemporalType)
	 */
	public Query setParameter(String name, Date value, TemporalType temporalType) {
		_setParameter(name, value, temporalType);
		return setParameter(name, getTemporalType(value, temporalType));
	}

	public Query _setParameter(String name, Date value,
			TemporalType temporalType) {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setParameter(java.lang.String, java.util.Calendar, javax.persistence.TemporalType)
	 */
	public Query setParameter(String name, Calendar value, TemporalType temporalType) {
		_setParameter(name, value, temporalType);
		return setParameter(name, getTemporalType(value, temporalType));
	}

	public Query _setParameter(String name, Calendar value,
			TemporalType temporalType) {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setParameter(int, java.util.Date, javax.persistence.TemporalType)
	 */
	public Query setParameter(int position, Date value, TemporalType temporalType) {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.Query#setParameter(int, java.util.Calendar, javax.persistence.TemporalType)
	 */
	public Query setParameter(int position, Calendar value, TemporalType temporalType) {
		throw new NotYetImplementedException();
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
    	_getTemporalType(value, type);
        return getTemporalType(value.getTime(), type);
    }

    public Object _getTemporalType(Calendar value, TemporalType type) {
    	return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}