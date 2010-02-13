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
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.github.smokestack.exception.NeedsMockDefinitionException;

import org.hamcrest.core.AnyOf;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;

/**
 * @author gliptak
 *
 */
public class MockResultSet implements ResultSet {

	public enum ResultSetState {NEW, CLOSE, AUTOCLOSE};
	
	protected ResultSetState mockState=ResultSetState.NEW;

	private String sql;
	
	private MockStatement parent;

	private int fetchDirection;

	private int fetchSize;

	private int concurrency;

	private Map<Object,Object> rsValues = new HashMap<Object,Object>();

	public MockResultSet(String sql) {
		this.sql=sql;
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#absolute(int)
	 */
	public boolean absolute(int row) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _absolute(row);
	}

	public boolean _absolute(int row) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#afterLast()
	 */
	public void afterLast() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_afterLast();
	}

	public void _afterLast() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#beforeFirst()
	 */
	public void beforeFirst() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_beforeFirst();
	}

	public void _beforeFirst() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#cancelRowUpdates()
	 */
	public void cancelRowUpdates() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_cancelRowUpdates();
	}

	public void _cancelRowUpdates() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#clearWarnings()
	 */
	public void clearWarnings() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_clearWarnings();
	}

	public void _clearWarnings() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#close()
	 */
	public void close() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_close();
		mockState=ResultSetState.CLOSE;
		parent.complete();
	}

	public void _close() {
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#deleteRow()
	 */
	public void deleteRow() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_deleteRow();
	}

	public void _deleteRow() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#findColumn(java.lang.String)
	 */
	public int findColumn(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _findColumn(columnName);
	}

	public int _findColumn(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#first()
	 */
	public boolean first() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _first();
	}

	public boolean _first() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getArray(int)
	 */
	public Array getArray(int i) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getArray(i);
	}

	public Array _getArray(int i) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getArray(java.lang.String)
	 */
	public Array getArray(String colName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getArray(colName);
	}

	public Array _getArray(String colName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getAsciiStream(int)
	 */
	public InputStream getAsciiStream(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getAsciiStream(columnIndex);
	}

	public InputStream _getAsciiStream(int columnIndex) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getAsciiStream(java.lang.String)
	 */
	public InputStream getAsciiStream(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getAsciiStream(columnName);
	}

	public InputStream _getAsciiStream(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getBigDecimal(int)
	 */
	public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getBigDecimal(columnIndex);
	}

	public BigDecimal _getBigDecimal(int columnIndex) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getBigDecimal(java.lang.String)
	 */
	public BigDecimal getBigDecimal(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getBigDecimal(columnName);
	}

	public BigDecimal _getBigDecimal(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getBigDecimal(int, int)
	 */
	public BigDecimal getBigDecimal(int columnIndex, int scale)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getBigDecimal(columnIndex, scale);
	}

	public BigDecimal _getBigDecimal(int columnIndex, int scale) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getBigDecimal(java.lang.String, int)
	 */
	public BigDecimal getBigDecimal(String columnName, int scale)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getBigDecimal(columnName, scale);	
	}

	public BigDecimal _getBigDecimal(String columnName, int scale) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getBinaryStream(int)
	 */
	public InputStream getBinaryStream(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getBinaryStream(columnIndex);
	}

	public InputStream _getBinaryStream(int columnIndex) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getBinaryStream(java.lang.String)
	 */
	public InputStream getBinaryStream(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getBinaryStream(columnName);	
	}

	public InputStream _getBinaryStream(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getBlob(int)
	 */
	public Blob getBlob(int i) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getBlob(i);	
	}

	public Blob _getBlob(int i) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getBlob(java.lang.String)
	 */
	public Blob getBlob(String colName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getBlob(colName);	
	}

	public Blob _getBlob(String colName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getBoolean(int)
	 */
	public boolean getBoolean(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getBoolean(columnIndex);	
	}

	public boolean _getBoolean(int columnIndex) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getBoolean(java.lang.String)
	 */
	public boolean getBoolean(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getBoolean(columnName);	
	}

	public boolean _getBoolean(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getByte(int)
	 */
	public byte getByte(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getByte(columnIndex);	
	}

	public byte _getByte(int columnIndex) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getByte(java.lang.String)
	 */
	public byte getByte(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getByte(columnName);	
	}

	public byte _getByte(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getBytes(int)
	 */
	public byte[] getBytes(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getBytes(columnIndex);	
	}

	public byte[] _getBytes(int columnIndex) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getBytes(java.lang.String)
	 */
	public byte[] getBytes(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getBytes(columnName);	
	}

	public byte[] _getBytes(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getCharacterStream(int)
	 */
	public Reader getCharacterStream(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getCharacterStream(columnIndex);	
	}

	public Reader _getCharacterStream(int columnIndex) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getCharacterStream(java.lang.String)
	 */
	public Reader getCharacterStream(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getCharacterStream(columnName);	
	}

	public Reader _getCharacterStream(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getClob(int)
	 */
	public Clob getClob(int i) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getClob(i);	
	}

	public Clob _getClob(int i) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getClob(java.lang.String)
	 */
	public Clob getClob(String colName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getClob(colName);	
	}

	public Clob _getClob(String colName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getConcurrency()
	 */
	public int getConcurrency() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getConcurrency();
	}

	public int _getConcurrency() {
		return concurrency;	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getCursorName()
	 */
	public String getCursorName() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getCursorName();	
	}

	public String _getCursorName() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getDate(int)
	 */
	public Date getDate(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getDate(columnIndex);	
	}

	public Date _getDate(int columnIndex) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getDate(java.lang.String)
	 */
	public Date getDate(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getDate(columnName);	
	}

	public Date _getDate(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getDate(int, java.util.Calendar)
	 */
	public Date getDate(int columnIndex, Calendar cal) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getDate(columnIndex, cal);
	}

	public Date _getDate(int columnIndex, Calendar cal) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getDate(java.lang.String, java.util.Calendar)
	 */
	public Date getDate(String columnName, Calendar cal) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getDate(columnName, cal);
	}

	public Date _getDate(String columnName, Calendar cal) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getDouble(int)
	 */
	public double getDouble(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getDouble(columnIndex);
	}

	public double _getDouble(int columnIndex) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getDouble(java.lang.String)
	 */
	public double getDouble(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getDouble(columnName);
	}

	public double _getDouble(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getFetchDirection()
	 */
	public int getFetchDirection() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getFetchDirection();
	}

	public int _getFetchDirection() {
		return fetchDirection;
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getFetchSize()
	 */
	public int getFetchSize() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getFetchSize();
	}

	public int _getFetchSize() {
		return fetchSize;
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getFloat(int)
	 */
	public float getFloat(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getFloat(columnIndex);
	}

	public float _getFloat(int columnIndex) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getFloat(java.lang.String)
	 */
	public float getFloat(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getFloat(columnName);
	}

	public float _getFloat(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getInt(int)
	 */
	public int getInt(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getInt(columnIndex);
	}

	public int _getInt(int columnIndex) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getInt(java.lang.String)
	 */
	public int getInt(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getInt(columnName);
	}

	public int _getInt(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getLong(int)
	 */
	public long getLong(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getLong(columnIndex);
	}

	public long _getLong(int i) {
		throw new NeedsMockDefinitionException();	
	}
	
	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getLong(java.lang.String)
	 */
	public long getLong(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getLong(columnName);
	}

	public long _getLong(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getMetaData()
	 */
	public ResultSetMetaData getMetaData() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getMetaData();
	}

	public ResultSetMetaData _getMetaData() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getObject(int)
	 */
	public Object getObject(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getObject(columnIndex);
	}

	public Object _getObject(int columnIndex) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getObject(java.lang.String)
	 */
	public Object getObject(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getObject(columnName);
	}

	public Object _getObject(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getObject(int, java.util.Map)
	 */
	public Object getObject(int i, Map<String, Class<?>> map)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getObject(i, map);
	}

	public Object _getObject(int i, Map<String, Class<?>> map) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getObject(java.lang.String, java.util.Map)
	 */
	public Object getObject(String colName, Map<String, Class<?>> map)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getObject(colName, map);
	}

	public Object _getObject(String colName, Map<String, Class<?>> map) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getRef(int)
	 */
	public Ref getRef(int i) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getRef(i);
	}

	public Ref _getRef(int i) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getRef(java.lang.String)
	 */
	public Ref getRef(String colName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getRef(colName);
	}

	public Ref _getRef(String colName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getRow()
	 */
	public int getRow() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getRow();
	}

	public int _getRow() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getShort(int)
	 */
	public short getShort(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getShort(columnIndex);
	}

	public short _getShort(int columnIndex) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getShort(java.lang.String)
	 */
	public short getShort(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getShort(columnName);
	}

	public short _getShort(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getStatement()
	 */
	public Statement getStatement() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getStatement();
	}

	public Statement _getStatement() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getString(int)
	 */
	public String getString(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getString(columnIndex);
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getString(int)
	 */
	public String _getString(int columnIndex) throws SQLException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getString(java.lang.String)
	 */
	public String getString(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getString(columnName);
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getString(int)
	 */
	public String _getString(String columnName) throws SQLException {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getTime(int)
	 */
	public Time getTime(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getTime(columnIndex);
	}

	public Time _getTime(int columnIndex) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getTime(java.lang.String)
	 */
	public Time getTime(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getTime(columnName);
	}

	public Time _getTime(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getTime(int, java.util.Calendar)
	 */
	public Time getTime(int columnIndex, Calendar cal) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getTime(columnIndex, cal);
	}

	public Time _getTime(int columnIndex, Calendar cal) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getTime(java.lang.String, java.util.Calendar)
	 */
	public Time getTime(String columnName, Calendar cal) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getTime(columnName, cal);
	}

	public Time _getTime(String columnName, Calendar cal) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getTimestamp(int)
	 */
	public Timestamp getTimestamp(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getTimestamp(columnIndex);
	}

	public Timestamp _getTimestamp(int columnIndex) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getTimestamp(java.lang.String)
	 */
	public Timestamp getTimestamp(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getTimestamp(columnName);
	}

	public Timestamp _getTimestamp(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getTimestamp(int, java.util.Calendar)
	 */
	public Timestamp getTimestamp(int columnIndex, Calendar cal)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getTimestamp(columnIndex, cal);
	}

	public Timestamp _getTimestamp(int columnIndex, Calendar cal) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getTimestamp(java.lang.String, java.util.Calendar)
	 */
	public Timestamp getTimestamp(String columnName, Calendar cal)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getTimestamp(columnName, cal);
	}

	public Timestamp _getTimestamp(String columnName, Calendar cal) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getType()
	 */
	public int getType() throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getType();
	}

	public int _getType() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getURL(int)
	 */
	public URL getURL(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getURL(columnIndex);
	}

	public URL _getURL(int columnIndex) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getURL(java.lang.String)
	 */
	public URL getURL(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getURL(columnName);
	}

	public URL _getURL(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getUnicodeStream(int)
	 */
	public InputStream getUnicodeStream(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getUnicodeStream(columnIndex);
	}

	public InputStream _getUnicodeStream(int columnIndex) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getUnicodeStream(java.lang.String)
	 */
	public InputStream getUnicodeStream(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getUnicodeStream(columnName);
	}

	public InputStream _getUnicodeStream(String columnName) {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#getWarnings()
	 */
	public SQLWarning getWarnings() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _getWarnings();
	}

	public SQLWarning _getWarnings() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#insertRow()
	 */
	public void insertRow() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_insertRow();
	}

	public void _insertRow() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#isAfterLast()
	 */
	public boolean isAfterLast() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _isAfterLast();
	}

	public boolean _isAfterLast() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#isBeforeFirst()
	 */
	public boolean isBeforeFirst() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _isBeforeFirst();
	}

	public boolean _isBeforeFirst() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#isFirst()
	 */
	public boolean isFirst() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _isFirst();
	}

	public boolean _isFirst() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#isLast()
	 */
	public boolean isLast() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _isLast();
	}

	public boolean _isLast() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#last()
	 */
	public boolean last() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _last();
	}

	public boolean _last() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#moveToCurrentRow()
	 */
	public void moveToCurrentRow() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_moveToCurrentRow();
	}

	public void _moveToCurrentRow() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#moveToInsertRow()
	 */
	public void moveToInsertRow() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_moveToInsertRow();
	}

	public void _moveToInsertRow() {
		throw new NeedsMockDefinitionException();	
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#next()
	 */
	public boolean next() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		boolean b = _next();
		if(!b){ //all rows have been retrived pg. 62 3.0 spec
			parent.complete();
		}
		return b;
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#next()
	 */
	public boolean _next() throws SQLException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#previous()
	 */
	public boolean previous() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _previous();
	}

	public boolean _previous() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#refreshRow()
	 */
	public void refreshRow() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_refreshRow();
	}

	public void _refreshRow() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#relative(int)
	 */
	public boolean relative(int rows) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _relative(rows);
	}

	public boolean _relative(int rows) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#rowDeleted()
	 */
	public boolean rowDeleted() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _rowDeleted();
	}

	public boolean _rowDeleted() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#rowInserted()
	 */
	public boolean rowInserted() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _rowInserted();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#rowUpdated()
	 */
	public boolean _rowInserted() {
		throw new NeedsMockDefinitionException();
	}

	public boolean rowUpdated() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _rowUpdated();
	}

	public boolean _rowUpdated() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#setFetchDirection(int)
	 */
	public void setFetchDirection(int direction) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_setFetchDirection(direction);
	}

	public void _setFetchDirection(int direction) {
		this.fetchDirection = direction;
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#setFetchSize(int)
	 */
	public void setFetchSize(int rows) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_setFetchSize(rows);
	}

	public void _setFetchSize(int rows) {
		this.fetchSize = rows;
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateArray(int, java.sql.Array)
	 */
	public void updateArray(int columnIndex, Array x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateArray(columnIndex, x);
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateArray(java.lang.String, java.sql.Array)
	 */
	public void _updateArray(int columnIndex, Array x) {
		throw new NeedsMockDefinitionException();
	}

	public void updateArray(String columnName, Array x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateArray(columnName, x);
	}

	public void _updateArray(String columnName, Array x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateAsciiStream(int, java.io.InputStream, int)
	 */
	public void updateAsciiStream(int columnIndex, InputStream x, int length)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateAsciiStream(columnIndex, x, length);
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateAsciiStream(java.lang.String, java.io.InputStream, int)
	 */
	public void _updateAsciiStream(int columnIndex, InputStream x, int length) {
		throw new NeedsMockDefinitionException();
	}

	public void updateAsciiStream(String columnName, InputStream x, int length)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateAsciiStream(columnName, x, length);
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateBigDecimal(int, java.math.BigDecimal)
	 */
	public void _updateAsciiStream(String columnName, InputStream x, int length) {
		throw new NeedsMockDefinitionException();
	}

	public void updateBigDecimal(int columnIndex, BigDecimal x)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateBigDecimal(columnIndex, x);
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateBigDecimal(java.lang.String, java.math.BigDecimal)
	 */
	public void _updateBigDecimal(int columnIndex, BigDecimal x) {
		throw new NeedsMockDefinitionException();
	}

	public void updateBigDecimal(String columnName, BigDecimal x)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateBigDecimal(columnName, x);
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateBinaryStream(int, java.io.InputStream, int)
	 */
	public void _updateBigDecimal(String columnName, BigDecimal x) {
		throw new NeedsMockDefinitionException();
	}

	public void updateBinaryStream(int columnIndex, InputStream x, int length)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateBinaryStream(columnIndex, x, length);
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateBinaryStream(java.lang.String, java.io.InputStream, int)
	 */
	public void _updateBinaryStream(int columnIndex, InputStream x, int length) {
		throw new NeedsMockDefinitionException();
	}

	public void updateBinaryStream(String columnName, InputStream x, int length)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateBinaryStream(columnName, x, length);
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateBlob(int, java.sql.Blob)
	 */
	public void _updateBinaryStream(String columnName, InputStream x,
			int length) {
		throw new NeedsMockDefinitionException();
	}

	public void updateBlob(int columnIndex, Blob x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateBlob(columnIndex, x);
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateBlob(java.lang.String, java.sql.Blob)
	 */
	public void _updateBlob(int columnIndex, Blob x) {
		throw new NeedsMockDefinitionException();
	}

	public void updateBlob(String columnName, Blob x) throws SQLException {
		// TODO Auto-generated method stub
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateBlob(columnName, x);
	}

	public void _updateBlob(String columnName, Blob x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateBoolean(int, boolean)
	 */
	public void updateBoolean(int columnIndex, boolean x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateBoolean(columnIndex, x);
	}

	public void _updateBoolean(int columnIndex, boolean x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateBoolean(java.lang.String, boolean)
	 */
	public void updateBoolean(String columnName, boolean x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateBoolean(columnName, x);
	}

	public void _updateBoolean(String columnName, boolean x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateByte(int, byte)
	 */
	public void updateByte(int columnIndex, byte x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateByte(columnIndex, x);
	}

	public void _updateByte(int columnIndex, byte x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateByte(java.lang.String, byte)
	 */
	public void updateByte(String columnName, byte x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateByte(columnName, x);
	}

	public void _updateByte(String columnName, byte x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateBytes(int, byte[])
	 */
	public void updateBytes(int columnIndex, byte[] x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateBytes(columnIndex, x);
	}

	public void _updateBytes(int columnIndex, byte[] x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateBytes(java.lang.String, byte[])
	 */
	public void updateBytes(String columnName, byte[] x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateBytes(columnName, x);
	}

	public void _updateBytes(String columnName, byte[] x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateCharacterStream(int, java.io.Reader, int)
	 */
	public void updateCharacterStream(int columnIndex, Reader x, int length)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateCharacterStream(columnIndex, x, length);		
	}

	public void _updateCharacterStream(int columnIndex, Reader x, int length) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateCharacterStream(java.lang.String, java.io.Reader, int)
	 */
	public void updateCharacterStream(String columnName, Reader reader,
			int length) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateCharacterStream(columnName, reader, length);
	}

	public void _updateCharacterStream(String columnName, Reader reader,
			int length) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateClob(int, java.sql.Clob)
	 */
	public void updateClob(int columnIndex, Clob x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateClob(columnIndex, x);
	}

	public void _updateClob(int columnIndex, Clob x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateClob(java.lang.String, java.sql.Clob)
	 */
	public void updateClob(String columnName, Clob x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateClob(columnName, x);
	}

	public void _updateClob(String columnName, Clob x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateDate(int, java.sql.Date)
	 */
	public void updateDate(int columnIndex, Date x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateDate(columnIndex, x);
	}

	public void _updateDate(int columnIndex, Date x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateDate(java.lang.String, java.sql.Date)
	 */
	public void updateDate(String columnName, Date x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateDate(columnName, x);
	}

	public void _updateDate(String columnName, Date x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateDouble(int, double)
	 */
	public void updateDouble(int columnIndex, double x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateDouble(columnIndex, x);
	}

	public void _updateDouble(int columnIndex, double x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateDouble(java.lang.String, double)
	 */
	public void updateDouble(String columnName, double x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateDouble(columnName, x);
	}

	public void _updateDouble(String columnName, double x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateFloat(int, float)
	 */
	public void updateFloat(int columnIndex, float x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateFloat(columnIndex, x);
	}

	public void _updateFloat(int columnIndex, float x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateFloat(java.lang.String, float)
	 */
	public void updateFloat(String columnName, float x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateFloat(columnName, x);
	}

	public void _updateFloat(String columnName, float x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateInt(int, int)
	 */
	public void updateInt(int columnIndex, int x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateInt(columnIndex, x);
	}

	public void _updateInt(int columnIndex, int x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateInt(java.lang.String, int)
	 */
	public void updateInt(String columnName, int x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateInt(columnName, x);
	}

	public void _updateInt(String columnName, int x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateLong(int, long)
	 */
	public void updateLong(int columnIndex, long x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateLong(columnIndex, x);
	}

	public void _updateLong(int columnIndex, long x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateLong(java.lang.String, long)
	 */
	public void updateLong(String columnName, long x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateLong(columnName, x);
	}

	public void _updateLong(String columnName, long x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateNull(int)
	 */
	public void updateNull(int columnIndex) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateNull(columnIndex); 
	}

	public void _updateNull(int columnIndex) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateNull(java.lang.String)
	 */
	public void updateNull(String columnName) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateNull(columnName);
	}

	public void _updateNull(String columnName) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateObject(int, java.lang.Object)
	 */
	public void updateObject(int columnIndex, Object x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateObject(columnIndex, x);
	}

	public void _updateObject(int columnIndex, Object x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateObject(java.lang.String, java.lang.Object)
	 */
	public void updateObject(String columnName, Object x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateObject(columnName, x);
	}

	public void _updateObject(String columnName, Object x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateObject(int, java.lang.Object, int)
	 */
	public void updateObject(int columnIndex, Object x, int scale)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateObject(columnIndex, x, scale);
	}

	public void _updateObject(int columnIndex, Object x, int scale) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateObject(java.lang.String, java.lang.Object, int)
	 */
	public void updateObject(String columnName, Object x, int scale)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateObject(columnName, x, scale);
	}

	public void _updateObject(String columnName, Object x, int scale) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateRef(int, java.sql.Ref)
	 */
	public void updateRef(int columnIndex, Ref x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateRef(columnIndex, x);
	}

	public void _updateRef(int columnIndex, Ref x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateRef(java.lang.String, java.sql.Ref)
	 */
	public void updateRef(String columnName, Ref x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateRef(columnName, x);
	}

	public void _updateRef(String columnName, Ref x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateRow()
	 */
	public void updateRow() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateRow();
	}

	public void _updateRow() {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateShort(int, short)
	 */
	public void updateShort(int columnIndex, short x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateShort(columnIndex, x);
	}

	public void _updateShort(int columnIndex, short x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateShort(java.lang.String, short)
	 */
	public void updateShort(String columnName, short x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateShort(columnName, x);
	}

	public void _updateShort(String columnName, short x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateString(int, java.lang.String)
	 */
	public void updateString(int columnIndex, String x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateString(columnIndex, x);
	}

	public void _updateString(int columnIndex, String x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateString(java.lang.String, java.lang.String)
	 */
	public void updateString(String columnName, String x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateString(columnName, x);
	}

	public void _updateString(String columnName, String x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateTime(int, java.sql.Time)
	 */
	public void updateTime(int columnIndex, Time x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateTime(columnIndex, x);
	}

	public void _updateTime(int columnIndex, Time x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateTime(java.lang.String, java.sql.Time)
	 */
	public void updateTime(String columnName, Time x) throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateTime(columnName, x);
	}

	public void _updateTime(String columnName, Time x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateTimestamp(int, java.sql.Timestamp)
	 */
	public void updateTimestamp(int columnIndex, Timestamp x)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateTimestamp(columnIndex, x);
	}

	public void _updateTimestamp(int columnIndex, Timestamp x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#updateTimestamp(java.lang.String, java.sql.Timestamp)
	 */
	public void updateTimestamp(String columnName, Timestamp x)
			throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		_updateTimestamp(columnName, x);
	}

	public void _updateTimestamp(String columnName, Timestamp x) {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see java.sql.ResultSet#wasNull()
	 */
	public boolean wasNull() throws SQLException {
		assertThat(mockState, AnyOf.anyOf(IsNot.not(ResultSetState.CLOSE), IsNot.not(ResultSetState.AUTOCLOSE)));
		return _wasNull(); 
	}

	public boolean _wasNull() {
		throw new NeedsMockDefinitionException();
	}

	protected void autoClose() {
		if(mockState != ResultSetState.CLOSE){
			this.mockState=ResultSetState.AUTOCLOSE;
		}
	}

	public void assertClosed() {
		assertThat(mockState, AnyOf.anyOf(Is.is(ResultSetState.CLOSE), Is.is(ResultSetState.AUTOCLOSE)));
	}

	public void assertExplicitClose() {
		assertThat(mockState, Is.is(ResultSetState.CLOSE));
	}

	public void setParent(MockStatement mockStatement) {
		this.parent = mockStatement;
		
	}
}
