/**
 * 
 */
package net.sourceforge.smokestack.jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import net.sourceforge.smokestack.exception.NotYetImplementedException;

/**
 * @author KAHBZB
 *
 */
public class MockDataSource implements DataSource {

	/**
	 * Public access to instance
	 */
    public static final MockDataSource instance = new MockDataSource();
    
	private List<MockConnection> mockConnections=new ArrayList<MockConnection>();

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
		MockConnection c=new MockConnection();
		mockConnections.add(c);
		return c;
	}

	/* (non-Javadoc)
	 * @see javax.sql.DataSource#getConnection(java.lang.String, java.lang.String)
	 */
	public Connection getConnection(String username, String password)
			throws SQLException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.sql.DataSource#getLogWriter()
	 */
	public PrintWriter getLogWriter() throws SQLException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.sql.DataSource#getLoginTimeout()
	 */
	public int getLoginTimeout() throws SQLException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.sql.DataSource#setLogWriter(java.io.PrintWriter)
	 */
	public void setLogWriter(PrintWriter out) throws SQLException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.sql.DataSource#setLoginTimeout(int)
	 */
	public void setLoginTimeout(int seconds) throws SQLException {
		throw new NotYetImplementedException();
	}

	public List<MockConnection> getMockConnections() {
		return mockConnections;
	}

	public void reset() {
		mockConnections=new ArrayList<MockConnection>();
		
	}

}
