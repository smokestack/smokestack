/**
 * 
 */
package com.github.smokestack.jndi;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Hashtable;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NameClassPair;
import javax.naming.NameParser;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import com.github.smokestack.exception.NotYetImplementedException;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hamcrest.core.IsNot;
import org.omg.stub.java.rmi._Remote_Stub;

/**
 * @author gliptak
 *
 */
public class MockContext implements Context {

	public enum ContextState {NEW, CLOSE};
	
	protected ContextState mockState=ContextState.NEW;
	
	public Hashtable environment=new Hashtable();
	
	public Hashtable<String, Object> bindings=new Hashtable<String, Object>();

	public MockContext(Hashtable environment) {
		if (environment!=null){
			this.environment=(Hashtable) environment.clone();			
		}
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#addToEnvironment(java.lang.String, java.lang.Object)
	 */
	public Object addToEnvironment(String propName, Object propVal) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
        return _addToEnvironment(propName, propVal);
	}

	public Object _addToEnvironment(String propName, Object propVal) throws NamingException {
        return environment.put(propName, propVal);
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#bind(javax.naming.Name, java.lang.Object)
	 */
	public void bind(Name name, Object obj) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		_bind(name, obj);
	}

	public void _bind(Name name, Object obj) throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#bind(java.lang.String, java.lang.Object)
	 */
	public void bind(String name, Object obj) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		_bind(name, obj);
	}

	public void _bind(String name, Object obj) throws NamingException {
		rebind(name, obj);
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#close()
	 */
	public void close() throws NamingException {
		_close();
	}

	public void _close() throws NamingException {
		mockState=ContextState.CLOSE;
		MockInitialContextFactory.releaseSingleton();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#composeName(javax.naming.Name, javax.naming.Name)
	 */
	public Name composeName(Name name, Name prefix) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return _composeName(name, prefix);
	}

	public Name _composeName(Name name, Name prefix) throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#composeName(java.lang.String, java.lang.String)
	 */
	public String composeName(String name, String prefix) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return _composeName(name, prefix);
	}

	public String _composeName(String name, String prefix) throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#createSubcontext(javax.naming.Name)
	 */
	public Context createSubcontext(Name name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return _createSubcontext(name);
	}

	public Context _createSubcontext(Name name) throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#createSubcontext(java.lang.String)
	 */
	public Context createSubcontext(String name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return _createSubcontext(name);
	}

	public Context _createSubcontext(String name) throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#destroySubcontext(javax.naming.Name)
	 */
	public void destroySubcontext(Name name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		_destroySubcontext(name);
	}

	public void _destroySubcontext(Name name) throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#destroySubcontext(java.lang.String)
	 */
	public void destroySubcontext(String name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		_destroySubcontext(name);
	}

	public void _destroySubcontext(String name) throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#getEnvironment()
	 */
	public Hashtable<?, ?> getEnvironment() throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return _getEnvironment();
	}

	public Hashtable<?, ?> _getEnvironment() throws NamingException {
		return (Hashtable)environment.clone();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#getNameInNamespace()
	 */
	public String getNameInNamespace() throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return _getNameInNamespace();
	}

	public String _getNameInNamespace() throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#getNameParser(javax.naming.Name)
	 */
	public NameParser getNameParser(Name name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return _getNameParser(name);
	}

	public NameParser _getNameParser(Name name) throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#getNameParser(java.lang.String)
	 */
	public NameParser getNameParser(String name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return _getNameParser(name);
	}

	public NameParser _getNameParser(String name) throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#list(javax.naming.Name)
	 */
	public NamingEnumeration<NameClassPair> list(Name name)	throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return _list(name);
	}

	public NamingEnumeration<NameClassPair> _list(Name name)	throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#list(java.lang.String)
	 */
	public NamingEnumeration<NameClassPair> list(String name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return _list(name);
	}

	public NamingEnumeration<NameClassPair> _list(String name) throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#listBindings(javax.naming.Name)
	 */
	public NamingEnumeration<Binding> listBindings(Name name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return _listBindings(name);
	}

	public NamingEnumeration<Binding> _listBindings(Name name) throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#listBindings(java.lang.String)
	 */
	public NamingEnumeration<Binding> listBindings(String name)	throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return _listBindings(name);
	}

	public NamingEnumeration<Binding> _listBindings(String name)	throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#lookup(javax.naming.Name)
	 */
	public Object lookup(Name name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return _lookup(name);
	}

	public Object _lookup(Name name) throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#lookup(java.lang.String)
	 */
	public Object lookup(String name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return _lookup(name);
	}

	public Object _lookup(String name) throws NamingException {
		Object o=bindings.get(name);
		if (o==null){
			throw new NamingException("not bound for "+name);
		}
		return o;
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#lookupLink(javax.naming.Name)
	 */
	public Object lookupLink(Name name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return _lookupLink(name);
	}

	public Object _lookupLink(Name name) throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#lookupLink(java.lang.String)
	 */
	public Object lookupLink(String name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return _lookupLink(name);
	}

	public Object _lookupLink(String name) throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#rebind(javax.naming.Name, java.lang.Object)
	 */
	public void rebind(Name name, Object obj) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		_rebind(name, obj);
	}

	public void _rebind(Name name, Object obj) throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#rebind(java.lang.String, java.lang.Object)
	 */
	public void rebind(String name, Object obj) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		_rebind(name, obj);
	}

	public void _rebind(String name, Object obj) throws NamingException {
		bindings.put(name, obj);
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#removeFromEnvironment(java.lang.String)
	 */
	public Object removeFromEnvironment(String propName) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return _removeFromEnvironment(propName);
	}

	public Object _removeFromEnvironment(String propName) throws NamingException {
		return environment.remove(propName);
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#rename(javax.naming.Name, javax.naming.Name)
	 */
	public void rename(Name oldName, Name newName) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		_rename(oldName, newName);
	}

	public void _rename(Name oldName, Name newName) throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#rename(java.lang.String, java.lang.String)
	 */
	public void rename(String oldName, String newName) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		_rename(oldName, newName);
	}

	public void _rename(String oldName, String newName) throws NamingException {
		Object o=bindings.get(oldName);
		if (o==null){
			throw new NamingException("not bound for "+oldName);
		}
		unbind(oldName);
		rebind(newName, o);
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#unbind(javax.naming.Name)
	 */
	public void unbind(Name name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		_unbind(name);
	}

	public void _unbind(Name name) throws NamingException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#unbind(java.lang.String)
	 */
	public void unbind(String name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		_unbind(name);
	}
	
	public void _unbind(String name) throws NamingException {
		bindings.remove(name);
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
