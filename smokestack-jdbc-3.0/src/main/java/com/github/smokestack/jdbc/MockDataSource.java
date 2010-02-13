/**
 * 
 */
package com.github.smokestack.jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author bbrag
 *
 */
public class MockDataSource implements DataSource {

	/**
	 * Public access to instance
	 */
    public static final MockDataSource instance = new MockDataSource();
    
	private List<MockConnection> mockConnections=new ArrayList<MockConnection>();

	private PrintWriter logWriter;

	private int loginTimeout;

	private MockDataSource() {
		super();
	}

    public static synchronized MockDataSource getInstance() {
        return instance;
    }
	
	/* (non-Javadoc)
	 * @see javax.sql.DataSource#getConnection()
	 */
	public Connection getConnection() throws SQLException {
		MockConnection c=_getConnection();
		mockConnections.add(c);
		return c;
	}

	public MockConnection _getConnection() {
		return new MockConnection();
	}

	/* (non-Javadoc)
	 * @see javax.sql.DataSource#getConnection(java.lang.String, java.lang.String)
	 */
	public Connection getConnection(String username, String password)
			throws SQLException {
		MockConnection c=_getConnection(username, password);
		mockConnections.add(c);
		return c;
	}

	public MockConnection _getConnection(String username, String password) {
		return new MockConnection();
	}

	/* (non-Javadoc)
	 * @see javax.sql.DataSource#getLogWriter()
	 */
	public PrintWriter getLogWriter() throws SQLException {
		return _getLogWriter();
	}

	public PrintWriter _getLogWriter() {
		return this.logWriter;
	}

	/* (non-Javadoc)
	 * @see javax.sql.DataSource#getLoginTimeout()
	 */
	public int getLoginTimeout() throws SQLException {
		return _getLoginTimeout();
	}

	public int _getLoginTimeout() {
		return loginTimeout;
	}

	/* (non-Javadoc)
	 * @see javax.sql.DataSource#setLogWriter(java.io.PrintWriter)
	 */
	public void setLogWriter(PrintWriter out) throws SQLException {
		_setLogWriter(out);
	}

	public void _setLogWriter(PrintWriter out) {
		this.logWriter = out;
	}

	/* (non-Javadoc)
	 * @see javax.sql.DataSource#setLoginTimeout(int)
	 */
	public void setLoginTimeout(int seconds) throws SQLException {
		_setLoginTimeout(seconds);
	}

	public void _setLoginTimeout(int seconds) {
		this.loginTimeout = seconds;
	}

	public List<MockConnection> getMockConnections() {
		return mockConnections;
	}

	public void reset() {
		mockConnections=new ArrayList<MockConnection>();
		
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
