/**
 * 
 */
package net.sourceforge.smokestack.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import net.sourceforge.smokestack.exception.NotYetImplementedException;

import org.hamcrest.core.IsNull;

import static org.hamcrest.MatcherAssert.assertThat; 

/**
 * @author gliptak
 *
 */
public class MockDriver implements Driver {

	/**
	 * Public access to instance
	 */
    public static final MockDriver instance = new MockDriver();
    
    private static volatile boolean registered;

    static {
        load();
    }

	private List<MockConnection> mockConnections=new ArrayList<MockConnection>();

	private String url;

	/* (non-Javadoc)
	 * @see java.sql.Driver#acceptsURL(java.lang.String)
	 */
	public boolean acceptsURL(String url) throws SQLException {
		this.url = url;
		return _acceptsURL(url);
	}

	public boolean _acceptsURL(String url) {
		return true;
	}

	/* (non-Javadoc)
	 * @see java.sql.Driver#connect(java.lang.String, java.util.Properties)
	 */
	public Connection connect(String url, Properties info) throws SQLException {
		MockConnection c=_connect(url, info);
		mockConnections.add(c);
		return c;
	}

	public MockConnection _connect(String url, Properties info) {
		return new MockConnection(url, info);
	}

	/* (non-Javadoc)
	 * @see java.sql.Driver#getMajorVersion()
	 */
	public int getMajorVersion() {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Driver#getMinorVersion()
	 */
	public int getMinorVersion() {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Driver#getPropertyInfo(java.lang.String, java.util.Properties)
	 */
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Driver#jdbcCompliant()
	 */
	public boolean jdbcCompliant() {
		return _jdbcCompliant();
	}

    public boolean _jdbcCompliant() {
    	return true;
	}

	public static synchronized Driver load() {
        try {
            if (!registered) {
                registered = true;
                DriverManager.registerDriver(instance);
            }
        } catch (SQLException e) {
        	// TODO: is there a better way to fail?
            assertThat("not expecting an exception", e, IsNull.nullValue());
        }
        return instance;
    }

    /**
     * For use with ClassLoader based environments
     */
    public static synchronized void unload() {
        try {
            if (registered) {
                registered = false;
                DriverManager.deregisterDriver(instance);
            }
        } catch (SQLException e) {
        	// TODO: is there a better way to fail?
            assertThat("not expecting an exception", e, IsNull.nullValue());
        }
    }

	/**
	 * @return the mockConnections
	 */
	public List<MockConnection> getMockConnections() {
		return mockConnections;
	}
	
	/**
	 * Reset to original state
	 */
	public void reset(){
		instance.mockConnections=new ArrayList<MockConnection>();
	}
}
