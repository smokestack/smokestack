/**
 * 
 */
package com.github.smokestack.jdbc;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hamcrest.core.AnyOf;
import org.hamcrest.core.IsNot;

import com.github.smokestack.exception.NotYetImplementedException;

/**
 * @author bbrag
 *
 */
public class MockPreparedStatement extends MockStatement implements PreparedStatement {

	private String sql;
	private Map<Object,Object> parameters = new HashMap<Object,Object>();

	public MockPreparedStatement(MockConnection connection, String sql) {
		super(connection);
		this.sql = sql;
	}

	public void addBatch() throws SQLException {
		addBatch("dummy sql");
	}

	public void clearParameters() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_clearParameters();
		parameters.clear();
	}

	public void _clearParameters() throws SQLException {
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
		_getMetaData();
		return null; 
	}

	public ResultSetMetaData _getMetaData() {
		throw new NotYetImplementedException();
	}

	public ParameterMetaData getParameterMetaData() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_getParameterMetaData();
		return null;
	}

	public ParameterMetaData _getParameterMetaData() {
		throw new NotYetImplementedException();
	}

	public void setArray(int i, Array x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setArray(i, x);
		this.parameters.put(i, x);
	}

	public void _setArray(int i, Array x) {
	}

	public void setAsciiStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setAsciiStream(parameterIndex, x);
		this.parameters.put(parameterIndex, x);
	}

	public void _setAsciiStream(int parameterIndex, InputStream x) {
	}

	public void setBigDecimal(int parameterIndex, BigDecimal x)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setBigDecimal(parameterIndex, x);
		this.parameters.put(parameterIndex, x);
	}

	public void _setBigDecimal(int parameterIndex, BigDecimal x) {
	}

	public void setBinaryStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	public void setBlob(int i, Blob x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setBlob(i, x);
		this.parameters.put(i, x);
	}

	public void _setBlob(int i, Blob x) {
	}

	public void setBoolean(int parameterIndex, boolean x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setBoolean(parameterIndex, x);
		this.parameters.put(parameterIndex, x);
	}

	public void _setBoolean(int parameterIndex, boolean x) {
	}

	public void setByte(int parameterIndex, byte x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setByte(parameterIndex, x);
		this.parameters.put(parameterIndex, x);
	}

	public void _setByte(int parameterIndex, byte x) {
	}

	public void setBytes(int parameterIndex, byte[] x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setBytes(parameterIndex, x);
		this.parameters.put(parameterIndex, x);
	}

	public void _setBytes(int parameterIndex, byte[] x) {
	}

	public void setCharacterStream(int parameterIndex, Reader reader, int length)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	public void setClob(int i, Clob x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setClob(i, x);
		this.parameters.put(i, x);
	}

	public void _setClob(int i, Clob x) {
	}

	public void setDate(int parameterIndex, Date x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setDate(parameterIndex, x);
		this.parameters.put(parameterIndex, x);
	}

	public void _setDate(int parameterIndex, Date x) {
	}

	public void setDate(int parameterIndex, Date x, Calendar cal)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	public void setDouble(int parameterIndex, double x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setDouble(parameterIndex, x);
		this.parameters.put(parameterIndex, x);
	}

	public void _setDouble(int parameterIndex, double x) {
	}

	public void setFloat(int parameterIndex, float x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setFloat(parameterIndex, x);
		this.parameters.put(parameterIndex, x);
	}

	public void _setFloat(int parameterIndex, float x) {
	}

	public void setInt(int parameterIndex, int x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setInt(parameterIndex, x);
		this.parameters.put(parameterIndex, x);
	}

	public void _setInt(int parameterIndex, int x) {
	}

	public void setLong(int parameterIndex, long x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setLong(parameterIndex, x);
		this.parameters .put(parameterIndex, x);
	}

	public void _setLong(int parameterIndex, long x) {
	}

	public void setNull(int parameterIndex, int sqlType) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setNull(parameterIndex, sqlType);
		this.parameters.put(new Integer(parameterIndex), new Integer(sqlType));
	}

	public void _setNull(int parameterIndex, int sqlType) {
	}

	public void setNull(int paramIndex, int sqlType, String typeName)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	public void setObject(int parameterIndex, Object x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setObject(parameterIndex, x);
		this.parameters .put(new Integer(parameterIndex), x);
	}

	public void _setObject(int parameterIndex, Object x) {
	}

	public void setObject(int parameterIndex, Object x, int targetSqlType)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	public void setObject(int parameterIndex, Object x, int targetSqlType,
			int scale) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	public void setRef(int i, Ref x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setRef(i, x);
		this.parameters.put(i, x);
	}

	public void _setRef(int i, Ref x) {
	}

	public void setShort(int parameterIndex, short x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setShort(parameterIndex, x);
		this.parameters.put(parameterIndex, x);
	}

	public void _setShort(int parameterIndex, short x) {
	}

	public void setString(int parameterIndex, String x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setString(parameterIndex, x);
		this.parameters.put(parameterIndex, x);
	}

	public void _setString(int parameterIndex, String x) {
	}

	public void setTime(int parameterIndex, Time x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setTime(parameterIndex, x);
		this.parameters.put(parameterIndex, x);
	}

	public void _setTime(int parameterIndex, Time x) {
	}

	public void setTime(int parameterIndex, Time x, Calendar cal)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	public void setTimestamp(int parameterIndex, Timestamp x)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setTimestamp(parameterIndex, x);
		this.parameters.put(parameterIndex, x);
	}

	public void _setTimestamp(int parameterIndex, Timestamp x) {
	}

	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	public void setURL(int parameterIndex, URL x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		_setURL(parameterIndex, x);
		this.parameters.put(parameterIndex, x);
	}

	public void _setURL(int parameterIndex, URL x) {
	}

	public void setUnicodeStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(StatementState.CLOSE), IsNot.not(StatementState.AUTOCLOSE)));
		throw new NotYetImplementedException();
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
