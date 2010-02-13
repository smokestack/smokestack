/**
 * 
 */
package com.github.smokestack.jms;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Topic;

import com.github.smokestack.exception.NotYetImplementedException;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hamcrest.collection.IsIn;
import org.hamcrest.core.AnyOf;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsInstanceOf;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author gliptak
 *
 */
public class MockMessage implements Message {

	public static final String JMSCorrelationID = "JMSCorrelationID";

	public static final String JMSDeliveryMode = "JMSDeliveryMode";

	public static final String JMSDestination = "JMSDestination";

	public static final String JMSReplyTo = "JMSReplyTo";

	public static final String JMSExpiration = "JMSExpiration";

	public static final String JMSMessageID = "JMSMessageID";

	public static final String JMSPriority = "JMSPriority";

	public static final String JMSRedelivered = "JMSRedelivered";

	public static final String JMSTimestamp = "JMSTimestamp";

	public static final String JMSType = "JMSType";
	
	protected Map<String, String> properties=new HashMap<String, String>();
	
	protected Map<String, String> headers=new HashMap<String, String>();

	protected Destination jmsDestination;

	protected Destination jmsReplyTo;
	
	/* ()(non-Javadoc)
	 * @see javax.jms.Message#acknowledge()
	 */
	public void acknowledge() throws JMSException {
		_acknowledge();
	}

	public void _acknowledge() throws JMSException {
		// TODO: should we try to go back to connection?
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#clearBody()
	 */
	public void clearBody() throws JMSException {
		_clearBody();
	}

	public void _clearBody() throws JMSException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#clearProperties()
	 */
	public void clearProperties() throws JMSException {
		_clearProperties();
	}

	public void _clearProperties() throws JMSException {
		properties.clear();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getBooleanProperty(java.lang.String)
	 */
	public boolean getBooleanProperty(String name) throws JMSException {
		return _getBooleanProperty(name);
	}

	public boolean _getBooleanProperty(String name) throws JMSException {
		return Boolean.parseBoolean(properties.get(name));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getByteProperty(java.lang.String)
	 */
	public byte getByteProperty(String name) throws JMSException {
		return _getByteProperty(name);
	}

	public byte _getByteProperty(String name) throws JMSException {
		return Byte.parseByte(properties.get(name));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getDoubleProperty(java.lang.String)
	 */
	public double getDoubleProperty(String name) throws JMSException {
		return _getDoubleProperty(name);
	}

	public double _getDoubleProperty(String name) throws JMSException {
		return Double.parseDouble(properties.get(name));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getFloatProperty(java.lang.String)
	 */
	public float getFloatProperty(String name) throws JMSException {
		return _getFloatProperty(name);
	}

	public float _getFloatProperty(String name) throws JMSException {
		return Float.parseFloat(properties.get(name));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getIntProperty(java.lang.String)
	 */
	public int getIntProperty(String name) throws JMSException {
		return _getIntProperty(name);
	}

	public int _getIntProperty(String name) throws JMSException {
		return Integer.parseInt(properties.get(name));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSCorrelationID()
	 */
	public String getJMSCorrelationID() throws JMSException {
		return _getJMSCorrelationID();
	}

	public String _getJMSCorrelationID() throws JMSException {
		if (!headers.containsKey(JMSCorrelationID)){
			throw new JMSException("no JMSCorrelationID");
		}
		return headers.get(JMSCorrelationID);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSCorrelationIDAsBytes()
	 */
	public byte[] getJMSCorrelationIDAsBytes() throws JMSException {
	    return _getJMSCorrelationIDAsBytes();
	}

	public byte[] _getJMSCorrelationIDAsBytes() throws JMSException {
		if (!headers.containsKey(JMSCorrelationID)){
			throw new JMSException("no JMSCorrelationID");
		}
		String s=headers.get(JMSCorrelationID);
	    if ((s.length() % 2) != 0){
	        throw new JMSException("JMSCorrelationID is odd length");	    	
	    }
	    final byte result[] = new byte[s.length()/2];
	    final char enc[] = s.toCharArray();
	    for (int i = 0; i < enc.length; i += 2) {
	        StringBuilder curr = new StringBuilder(2);
	        curr.append(enc[i]).append(enc[i + 1]);
	        result[i/2] = (byte) Integer.parseInt(curr.toString(), 16);
	    }
	    return result;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSDeliveryMode()
	 */
	public int getJMSDeliveryMode() throws JMSException {
		return _getJMSDeliveryMode();
	}

	public int _getJMSDeliveryMode() throws JMSException {
		if (!headers.containsKey(JMSDeliveryMode)){
			return 0;			
		}
		return Integer.parseInt(headers.get(JMSDeliveryMode));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSDestination()
	 */
	public Destination getJMSDestination() throws JMSException {
		return _getJMSDestination();
	}

	public Destination _getJMSDestination() throws JMSException {
		if(!headers.containsKey(JMSDestination)){
			throw new JMSException("no JMSDestination");			
		}
		return jmsDestination;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSExpiration()
	 */
	public long getJMSExpiration() throws JMSException {
		return _getJMSExpiration();
	}

	public long _getJMSExpiration() throws JMSException {
		if(!headers.containsKey(JMSExpiration)){
			return 0;			
		}
		return Long.parseLong(headers.get(JMSExpiration));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSMessageID()
	 */
	public String getJMSMessageID() throws JMSException {
		return _getJMSMessageID();
	}

	public String _getJMSMessageID() throws JMSException {
		if(!headers.containsKey(JMSMessageID)){
			throw new JMSException("no JMSMessageID");			
		}
		return headers.get(JMSMessageID);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSPriority()
	 */
	public int getJMSPriority() throws JMSException {
		return _getJMSPriority();
	}

	public int _getJMSPriority() throws JMSException {
		if(!headers.containsKey(JMSPriority)){
			return 0;
		}
		return Integer.parseInt(headers.get(JMSPriority));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSRedelivered()
	 */
	public boolean getJMSRedelivered() throws JMSException {
		return _getJMSRedelivered();
	}

	public boolean _getJMSRedelivered() throws JMSException {
		if(!headers.containsKey(JMSRedelivered)){
			return false;
		}
		return Boolean.parseBoolean(headers.get(JMSRedelivered));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSReplyTo()
	 */
	public Destination getJMSReplyTo() throws JMSException {
		return _getJMSReplyTo();
	}

	public Destination _getJMSReplyTo() throws JMSException {
		if(!headers.containsKey(JMSReplyTo)){
			throw new JMSException("no JMSReplyTo");			
		}
		return jmsReplyTo;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSTimestamp()
	 */
	public long getJMSTimestamp() throws JMSException {
		return _getJMSTimestamp();
	}

	public long _getJMSTimestamp() throws JMSException {
		if(!headers.containsKey(JMSTimestamp)){
			return 0;
		}
		return Long.parseLong(headers.get(JMSTimestamp));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getJMSType()
	 */
	public String getJMSType() throws JMSException {
		return _getJMSType();
	}

	public String _getJMSType() throws JMSException {
		return headers.get(JMSType);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getLongProperty(java.lang.String)
	 */
	public long getLongProperty(String name) throws JMSException {
		return _getLongProperty(name);
	}

	public long _getLongProperty(String name) throws JMSException {
		return Long.parseLong(properties.get(name));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getObjectProperty(java.lang.String)
	 */
	public Object getObjectProperty(String name) throws JMSException {
		return _getObjectProperty(name);
	}

	public Object _getObjectProperty(String name) throws JMSException {
		return properties.get(name);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getPropertyNames()
	 */
	public Enumeration getPropertyNames() throws JMSException {
		return _getPropertyNames();
	}

	public Enumeration _getPropertyNames() throws JMSException {
		return Collections.enumeration(properties.keySet());
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getShortProperty(java.lang.String)
	 */
	public short getShortProperty(String name) throws JMSException {
		return _getShortProperty(name);
	}

	public short _getShortProperty(String name) throws JMSException {
		return Short.parseShort(properties.get(name));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#getStringProperty(java.lang.String)
	 */
	public String getStringProperty(String name) throws JMSException {
		return _getStringProperty(name);
	}

	public String _getStringProperty(String name) throws JMSException {
		return properties.get(name);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#propertyExists(java.lang.String)
	 */
	public boolean propertyExists(String name) throws JMSException {
		return _propertyExists(name);
	}

	public boolean _propertyExists(String name) throws JMSException {
		return properties.containsKey(name);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setBooleanProperty(java.lang.String, boolean)
	 */
	public void setBooleanProperty(String name, boolean value) throws JMSException {
		_setBooleanProperty(name, value);
	}

	public void _setBooleanProperty(String name, boolean value) throws JMSException {
		properties.put(name, Boolean.toString(value));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setByteProperty(java.lang.String, byte)
	 */
	public void setByteProperty(String name, byte value) throws JMSException {
		_setByteProperty(name, value);
	}

	public void _setByteProperty(String name, byte value) throws JMSException {
		properties.put(name, Byte.toString(value));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setDoubleProperty(java.lang.String, double)
	 */
	public void setDoubleProperty(String name, double value) throws JMSException {
		_setDoubleProperty(name, value);
	}

	public void _setDoubleProperty(String name, double value) throws JMSException {
		properties.put(name, Double.toString(value));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setFloatProperty(java.lang.String, float)
	 */
	public void setFloatProperty(String name, float value) throws JMSException {
		_setFloatProperty(name, value);
	}

	public void _setFloatProperty(String name, float value) throws JMSException {
		properties.put(name, Float.toString(value));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setIntProperty(java.lang.String, int)
	 */
	public void setIntProperty(String name, int value) throws JMSException {
		_setIntProperty(name, value);
	}

	public void _setIntProperty(String name, int value) throws JMSException {
		properties.put(name, Integer.toString(value));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSCorrelationID(java.lang.String)
	 */
	public void setJMSCorrelationID(String correlationID) throws JMSException {
		_setJMSCorrelationID(correlationID);
	}

	public void _setJMSCorrelationID(String correlationID) throws JMSException {
		headers.put(JMSCorrelationID, correlationID);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSCorrelationIDAsBytes(byte[])
	 */
	public void setJMSCorrelationIDAsBytes(byte[] correlationID) throws JMSException {
		_setJMSCorrelationIDAsBytes(correlationID);
	}

	public void _setJMSCorrelationIDAsBytes(byte[] correlationID) throws JMSException {
		StringBuffer sb=new StringBuffer();
		for (byte b:correlationID){
		    String s=Integer.toString( ( b & 0xff ) + 0x100, 16).substring(1);
		    sb.append(s);
		}
		headers.put(JMSCorrelationID, sb.toString());
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSDeliveryMode(int)
	 */
	public void setJMSDeliveryMode(int deliveryMode) throws JMSException {
		assertThat(deliveryMode, AnyOf.anyOf(Is.is(DeliveryMode.PERSISTENT),
				Is.is(DeliveryMode.NON_PERSISTENT)));
        _setJMSDeliveryMode(deliveryMode);
	}

	public void _setJMSDeliveryMode(int deliveryMode) throws JMSException {
        headers.put(JMSDeliveryMode, Integer.toString(deliveryMode));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSDestination(javax.jms.Destination)
	 */
	public void setJMSDestination(Destination destination) throws JMSException {
		assertThat(destination, AnyOf.anyOf(IsInstanceOf.instanceOf(Topic.class),
				IsInstanceOf.instanceOf(Queue.class)));
		_setJMSDestination(destination);
	}

	public void _setJMSDestination(Destination destination) throws JMSException {
		if (destination instanceof Topic){
			headers.put(JMSDestination, ((Topic)destination).getTopicName());
		}
		if (destination instanceof Queue){
			headers.put(JMSDestination, ((Queue)destination).getQueueName());
		}
		jmsDestination=destination;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSExpiration(long)
	 */
	public void setJMSExpiration(long expiration) throws JMSException {
		_setJMSExpiration(expiration);
	}

	public void _setJMSExpiration(long expiration) throws JMSException {
		headers.put(JMSExpiration, Long.toString(expiration));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSMessageID(java.lang.String)
	 */
	public void setJMSMessageID(String id) throws JMSException {
		_setJMSMessageID(id);
	}

	public void _setJMSMessageID(String id) throws JMSException {
		headers.put(JMSMessageID, id);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSPriority(int)
	 */
	public void setJMSPriority(int priority) throws JMSException {
		_setJMSPriority(priority);		
	}

	public void _setJMSPriority(int priority) throws JMSException {
		Integer[] priorities={0,1,2,3,4,5,6,7,8,9};
		assertThat(priority, IsIn.isOneOf(priorities));
		headers.put(JMSPriority, Integer.toString(priority));		
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSRedelivered(boolean)
	 */
	public void setJMSRedelivered(boolean redelivered) throws JMSException {
		_setJMSRedelivered(redelivered);		
	}

	public void _setJMSRedelivered(boolean redelivered) throws JMSException {
		headers.put(JMSRedelivered, Boolean.toString(redelivered));		
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSReplyTo(javax.jms.Destination)
	 */
	public void setJMSReplyTo(Destination destination) throws JMSException {
		assertThat(destination, AnyOf.anyOf(IsInstanceOf.instanceOf(Topic.class),
				IsInstanceOf.instanceOf(Queue.class)));
		_setJMSReplyTo(destination);
	}

	public void _setJMSReplyTo(Destination destination) throws JMSException {
		if (destination instanceof Topic){
			headers.put(JMSReplyTo, ((Topic)destination).getTopicName());
		}
		if (destination instanceof Queue){
			headers.put(JMSReplyTo, ((Queue)destination).getQueueName());
		}
		jmsReplyTo=destination;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSTimestamp(long)
	 */
	public void setJMSTimestamp(long timestamp) throws JMSException {
		_setJMSTimestamp(timestamp);		
	}

	public void _setJMSTimestamp(long timestamp) throws JMSException {
		headers.put(JMSTimestamp, Long.toString(timestamp));		
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setJMSType(java.lang.String)
	 */
	public void setJMSType(String type) throws JMSException {
		_setJMSType(type);		
	}

	public void _setJMSType(String type) throws JMSException {
		headers.put(JMSType, type);		
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setLongProperty(java.lang.String, long)
	 */
	public void setLongProperty(String name, long value) throws JMSException {
		_setLongProperty(name, value);
	}

	public void _setLongProperty(String name, long value) throws JMSException {
		properties.put(name, Long.toString(value));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setObjectProperty(java.lang.String, java.lang.Object)
	 */
	public void setObjectProperty(String name, Object value) throws JMSException {
		// only Boolean, Byte, Short, Integer, Long, Float, Double, and String
		assertThat(value, AnyOf.anyOf(IsInstanceOf.instanceOf(Boolean.class),
				IsInstanceOf.instanceOf(Byte.class),
				IsInstanceOf.instanceOf(Short.class),
				IsInstanceOf.instanceOf(Integer.class),
				IsInstanceOf.instanceOf(Long.class),
				IsInstanceOf.instanceOf(Float.class),
				IsInstanceOf.instanceOf(Double.class),
				IsInstanceOf.instanceOf(String.class)));
		_setObjectProperty(name, value);
	}

	public void _setObjectProperty(String name, Object value) throws JMSException {
		properties.put(name, value.toString());
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setShortProperty(java.lang.String, short)
	 */
	public void setShortProperty(String name, short value) throws JMSException {
		_setShortProperty(name, value);
	}

	public void _setShortProperty(String name, short value) throws JMSException {
		properties.put(name, Short.toString(value));
	}

	/* (non-Javadoc)
	 * @see javax.jms.Message#setStringProperty(java.lang.String, java.lang.String)
	 */
	public void setStringProperty(String name, String value) throws JMSException {
		_setStringProperty(name, value);
	}

	public void _setStringProperty(String name, String value) throws JMSException {
		properties.put(name, value);
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
