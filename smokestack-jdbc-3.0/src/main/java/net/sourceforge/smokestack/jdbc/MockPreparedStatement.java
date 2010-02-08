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
import net.sourceforge.smokestack.jdbc.MockStatement.StatementState;

/**
 * @author KAHBZB
 *
 */
public class MockPreparedStatement extends MockStatement implements PreparedStatement {

	private String sql;

	public MockPreparedStatement(MockConnection connection, String sql) {
		super(connection);
		this.sql = sql;
	}

	public void addBatch() throws SQLException {
		addBatch("dummy sql");
	}

	public void clearParameters() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	public boolean execute() throws SQLException {
		return execute("dummy sql");
	}

	public ResultSet executeQuery() throws SQLException {
		return executeQuery("dummy sql");
	}

	public int executeUpdate() throws SQLException {
		return executeUpdate("dummy sql");
	}

	public ResultSetMetaData getMetaData() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	public ParameterMetaData getParameterMetaData() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	public void setArray(int i, Array x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setAsciiStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setBigDecimal(int parameterIndex, BigDecimal x)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setBinaryStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setBlob(int i, Blob x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setBoolean(int parameterIndex, boolean x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setByte(int parameterIndex, byte x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setBytes(int parameterIndex, byte[] x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setCharacterStream(int parameterIndex, Reader reader, int length)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setClob(int i, Clob x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setDate(int parameterIndex, Date x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setDate(int parameterIndex, Date x, Calendar cal)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setDouble(int parameterIndex, double x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setFloat(int parameterIndex, float x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setInt(int parameterIndex, int x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setLong(int parameterIndex, long x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setNull(int parameterIndex, int sqlType) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setNull(int paramIndex, int sqlType, String typeName)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setObject(int parameterIndex, Object x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setObject(int parameterIndex, Object x, int targetSqlType)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setObject(int parameterIndex, Object x, int targetSqlType,
			int scale) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setRef(int i, Ref x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setShort(int parameterIndex, short x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setString(int parameterIndex, String x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setTime(int parameterIndex, Time x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setTime(int parameterIndex, Time x, Calendar cal)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setTimestamp(int parameterIndex, Timestamp x)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setURL(int parameterIndex, URL x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}

	public void setUnicodeStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
	}
}
