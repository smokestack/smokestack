/**
 * 
 */
package net.sourceforge.smokestack.jdbc;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hamcrest.core.AnyOf;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;

import net.sourceforge.smokestack.exception.NotYetImplementedException;
import net.sourceforge.smokestack.jdbc.MockConnection.AutoCommitState;
import net.sourceforge.smokestack.jdbc.MockResultSet.ResultSetState;

/**
 * @author KAHBZB
 *
 */
public class MockPreparedStatement implements PreparedStatement {

	private MockConnection connection;
	
	private List<MockResultSet> mockResultSets=new ArrayList<MockResultSet>();

	public enum PreparedStatementState {NEW, CLOSE, AUTOCLOSE};
	
	protected PreparedStatementState mockState=PreparedStatementState.NEW;

	private String sql;

	public MockPreparedStatement(MockConnection connection, String sql) {
		this.connection=connection;
		this.sql = sql;
	}
	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#addBatch()
	 */
	public void addBatch() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		assertThat("AutoCommit", connection.autoCommitState, Is.is(AutoCommitState.DISABLED));
		// TODO Assert that the statement types return update count

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#clearParameters()
	 */
	public void clearParameters() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#execute()
	 */
	public boolean execute() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#executeQuery()
	 */
	public ResultSet executeQuery() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		MockResultSet rs=new MockResultSet(sql);
		mockResultSets.add(rs);
		return rs;
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#executeUpdate()
	 */
	public int executeUpdate() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#getMetaData()
	 */
	public ResultSetMetaData getMetaData() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#getParameterMetaData()
	 */
	public ParameterMetaData getParameterMetaData() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setArray(int, java.sql.Array)
	 */
	public void setArray(int i, Array x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setAsciiStream(int, java.io.InputStream, int)
	 */
	public void setAsciiStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setBigDecimal(int, java.math.BigDecimal)
	 */
	public void setBigDecimal(int parameterIndex, BigDecimal x)
			throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setBinaryStream(int, java.io.InputStream, int)
	 */
	public void setBinaryStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setBlob(int, java.sql.Blob)
	 */
	public void setBlob(int i, Blob x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setBoolean(int, boolean)
	 */
	public void setBoolean(int parameterIndex, boolean x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setByte(int, byte)
	 */
	public void setByte(int parameterIndex, byte x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setBytes(int, byte[])
	 */
	public void setBytes(int parameterIndex, byte[] x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setCharacterStream(int, java.io.Reader, int)
	 */
	public void setCharacterStream(int parameterIndex, Reader reader, int length)
			throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setClob(int, java.sql.Clob)
	 */
	public void setClob(int i, Clob x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setDate(int, java.sql.Date)
	 */
	public void setDate(int parameterIndex, Date x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setDate(int, java.sql.Date, java.util.Calendar)
	 */
	public void setDate(int parameterIndex, Date x, Calendar cal)
			throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setDouble(int, double)
	 */
	public void setDouble(int parameterIndex, double x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setFloat(int, float)
	 */
	public void setFloat(int parameterIndex, float x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setInt(int, int)
	 */
	public void setInt(int parameterIndex, int x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setLong(int, long)
	 */
	public void setLong(int parameterIndex, long x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setNull(int, int)
	 */
	public void setNull(int parameterIndex, int sqlType) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setNull(int, int, java.lang.String)
	 */
	public void setNull(int paramIndex, int sqlType, String typeName)
			throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setObject(int, java.lang.Object)
	 */
	public void setObject(int parameterIndex, Object x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setObject(int, java.lang.Object, int)
	 */
	public void setObject(int parameterIndex, Object x, int targetSqlType)
			throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setObject(int, java.lang.Object, int, int)
	 */
	public void setObject(int parameterIndex, Object x, int targetSqlType,
			int scale) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setRef(int, java.sql.Ref)
	 */
	public void setRef(int i, Ref x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setShort(int, short)
	 */
	public void setShort(int parameterIndex, short x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setString(int, java.lang.String)
	 */
	public void setString(int parameterIndex, String x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setTime(int, java.sql.Time)
	 */
	public void setTime(int parameterIndex, Time x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setTime(int, java.sql.Time, java.util.Calendar)
	 */
	public void setTime(int parameterIndex, Time x, Calendar cal)
			throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setTimestamp(int, java.sql.Timestamp)
	 */
	public void setTimestamp(int parameterIndex, Timestamp x)
			throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setTimestamp(int, java.sql.Timestamp, java.util.Calendar)
	 */
	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal)
			throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setURL(int, java.net.URL)
	 */
	public void setURL(int parameterIndex, URL x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.PreparedStatement#setUnicodeStream(int, java.io.InputStream, int)
	 */
	public void setUnicodeStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#addBatch(java.lang.String)
	 */
	public void addBatch(String sql) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#cancel()
	 */
	public void cancel() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#clearBatch()
	 */
	public void clearBatch() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#clearWarnings()
	 */
	public void clearWarnings() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#close()
	 */
	public void close() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		this.mockState=PreparedStatementState.CLOSE;
		for(MockResultSet rs: mockResultSets){
			if(rs.mockState != ResultSetState.CLOSE){
				rs.autoClose();
			}
		}	
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#execute(java.lang.String)
	 */
	public boolean execute(String sql) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#execute(java.lang.String, int)
	 */
	public boolean execute(String sql, int autoGeneratedKeys)
			throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#execute(java.lang.String, int[])
	 */
	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#execute(java.lang.String, java.lang.String[])
	 */
	public boolean execute(String sql, String[] columnNames)
			throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#executeBatch()
	 */
	public int[] executeBatch() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		assertThat("AutoCommit", connection.autoCommitState, Is.is(AutoCommitState.DISABLED));
		return _executeBatch();
		
	}

	public int[] _executeBatch() {
		// TODO Auto-generated method stub
		return new int[]{};
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#executeQuery(java.lang.String)
	 */
	public ResultSet executeQuery(String sql) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#executeUpdate(java.lang.String)
	 */
	public int executeUpdate(String sql) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#executeUpdate(java.lang.String, int)
	 */
	public int executeUpdate(String sql, int autoGeneratedKeys)
			throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#executeUpdate(java.lang.String, int[])
	 */
	public int executeUpdate(String sql, int[] columnIndexes)
			throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#executeUpdate(java.lang.String, java.lang.String[])
	 */
	public int executeUpdate(String sql, String[] columnNames)
			throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#getConnection()
	 */
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#getFetchDirection()
	 */
	public int getFetchDirection() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#getFetchSize()
	 */
	public int getFetchSize() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#getGeneratedKeys()
	 */
	public ResultSet getGeneratedKeys() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#getMaxFieldSize()
	 */
	public int getMaxFieldSize() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#getMaxRows()
	 */
	public int getMaxRows() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#getMoreResults()
	 */
	public boolean getMoreResults() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#getMoreResults(int)
	 */
	public boolean getMoreResults(int current) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#getQueryTimeout()
	 */
	public int getQueryTimeout() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#getResultSet()
	 */
	public ResultSet getResultSet() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#getResultSetConcurrency()
	 */
	public int getResultSetConcurrency() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#getResultSetHoldability()
	 */
	public int getResultSetHoldability() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#getResultSetType()
	 */
	public int getResultSetType() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#getUpdateCount()
	 */
	public int getUpdateCount() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#getWarnings()
	 */
	public SQLWarning getWarnings() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#setCursorName(java.lang.String)
	 */
	public void setCursorName(String name) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#setEscapeProcessing(boolean)
	 */
	public void setEscapeProcessing(boolean enable) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#setFetchDirection(int)
	 */
	public void setFetchDirection(int direction) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#setFetchSize(int)
	 */
	public void setFetchSize(int rows) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#setMaxFieldSize(int)
	 */
	public void setMaxFieldSize(int max) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#setMaxRows(int)
	 */
	public void setMaxRows(int max) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}

	/* (non-Javadoc)
	 * @see java.sql.Statement#setQueryTimeout(int)
	 */
	public void setQueryTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(PreparedStatementState.CLOSE), IsNot.not(PreparedStatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();

	}
	public void assertExplicitClose() {
		assertThat(mockState, Is.is(PreparedStatementState.CLOSE));
		for(MockResultSet rs: mockResultSets){
			rs.assertExplicitClose();
		}
	}

	//CLOSE is super-state of AUTOCLOSE
	public void assertClosed() {
		assertThat(mockState, AnyOf.anyOf(Is.is(PreparedStatementState.CLOSE), Is.is(PreparedStatementState.AUTOCLOSE)));
		for(MockResultSet rs: mockResultSets){
			rs.assertClosed();
		}
	}
	
	protected void autoClose() {
		//autoclose only if the statement is not explicitly closed
		assertThat(mockState, IsNot.not(PreparedStatementState.AUTOCLOSE));
		complete();
		this.mockState=PreparedStatementState.AUTOCLOSE;
	}
	
	protected void complete() { //spec 3.0, pg 62 transactions
		assertThat(mockState, IsNot.not(PreparedStatementState.CLOSE));
		for(MockResultSet rs: mockResultSets){
			assertThat(rs.mockState,AnyOf.anyOf(Is.is(ResultSetState.CLOSE), Is.is(ResultSetState.AUTOCLOSE)));
		}
	}
}
