/**
 * 
 */
package net.sourceforge.smokestack.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;

import net.sourceforge.smokestack.exception.NotYetImplementedException;

import static org.hamcrest.MatcherAssert.assertThat; 

/**
 * @author gliptak
 *
 */
public class MockConnection implements Connection {

	private String url;
	private Properties info;
	private List<MockStatement> mockStatements=new ArrayList<MockStatement>();
	
	public enum ConnectionState {NEW, CLOSE};
	
	protected ConnectionState mockConnectionState=ConnectionState.NEW;

	public enum TransactionState {NEW, ROLLBACK, COMMIT};

	public TransactionState mockTransactionState=TransactionState.NEW;
		
	public MockConnection(String url, Properties info) {
		this.url=url;
		this.info=info;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#clearWarnings()
	 */
	public void clearWarnings() throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#close()
	 */
	public void close() throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		mockConnectionState=ConnectionState.CLOSE;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#commit()
	 */
	public void commit() throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#createStatement()
	 */
	public Statement createStatement() throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		MockStatement st=new MockStatement(this);
		mockStatements.add(st);
		return st;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#createStatement(int, int)
	 */
	public Statement createStatement(int resultSetType, int resultSetConcurrency)
			throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#createStatement(int, int, int)
	 */
	public Statement createStatement(int resultSetType,	int resultSetConcurrency,
			int resultSetHoldability)	throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getAutoCommit()
	 */
	public boolean getAutoCommit() throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getCatalog()
	 */
	public String getCatalog() throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getHoldability()
	 */
	public int getHoldability() throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getMetaData()
	 */
	public DatabaseMetaData getMetaData() throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getTransactionIsolation()
	 */
	public int getTransactionIsolation() throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getTypeMap()
	 */
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getWarnings()
	 */
	public SQLWarning getWarnings() throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#isClosed()
	 */
	public boolean isClosed() throws SQLException {
		return mockConnectionState==ConnectionState.CLOSE;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#isReadOnly()
	 */
	public boolean isReadOnly() throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#nativeSQL(java.lang.String)
	 */
	public String nativeSQL(String sql) throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareCall(java.lang.String)
	 */
	public CallableStatement prepareCall(String sql) throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareCall(java.lang.String, int, int)
	 */
	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareCall(java.lang.String, int, int, int)
	 */
	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareStatement(java.lang.String)
	 */
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int)
	 */
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
			throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int[])
	 */
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes)
			throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareStatement(java.lang.String, java.lang.String[])
	 */
	public PreparedStatement prepareStatement(String sql, String[] columnNames)
			throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int, int)
	 */
	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int, int, int)
	 */
	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#releaseSavepoint(java.sql.Savepoint)
	 */
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#rollback()
	 */
	public void rollback() throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#rollback(java.sql.Savepoint)
	 */
	public void rollback(Savepoint savepoint) throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setAutoCommit(boolean)
	 */
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setCatalog(java.lang.String)
	 */
	public void setCatalog(String catalog) throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setHoldability(int)
	 */
	public void setHoldability(int holdability) throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setReadOnly(boolean)
	 */
	public void setReadOnly(boolean readOnly) throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setSavepoint()
	 */
	public Savepoint setSavepoint() throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setSavepoint(java.lang.String)
	 */
	public Savepoint setSavepoint(String name) throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setTransactionIsolation(int)
	 */
	public void setTransactionIsolation(int level) throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setTypeMap(java.util.Map)
	 */
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		assertThat(mockConnectionState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the info
	 */
	public Properties getInfo() {
		return info;
	}
	
	/**
	 * Validation
	 */
	public void assertMockClosed() {
		assertThat(mockConnectionState, Is.is(ConnectionState.CLOSE));
		for(MockStatement st: mockStatements){
			st.assertMockClosed();
		}
	}

	/**
	 * Validation
	 */
	public void assertMockCommit() {
		assertThat(mockTransactionState, Is.is(TransactionState.COMMIT));
	}

	/**
	 * Validation
	 */
	public void assertMockRollback() {
		assertThat(mockTransactionState, Is.is(TransactionState.ROLLBACK));
	}

	/**
	 * @return the mockStatements
	 */
	public List<MockStatement> getMockStatements() {
		return mockStatements;
	}

	/**
	 * @return the mockConnectionState
	 */
	public ConnectionState getMockConnectionState() {
		return mockConnectionState;
	}

	/**
	 * @return the mockTransactionState
	 */
	public TransactionState getMockTransactionState() {
		return mockTransactionState;
	}

}
