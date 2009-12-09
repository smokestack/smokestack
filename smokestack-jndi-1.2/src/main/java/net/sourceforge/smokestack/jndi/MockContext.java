/**
 * 
 */
package net.sourceforge.smokestack.jndi;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Hashtable;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NameClassPair;
import javax.naming.NameParser;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import net.sourceforge.smokestack.exception.NotYetImplementedException;

import org.hamcrest.core.IsNot;

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
        return environment.put(propName, propVal);
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#bind(javax.naming.Name, java.lang.Object)
	 */
	public void bind(Name name, Object obj) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#bind(java.lang.String, java.lang.Object)
	 */
	public void bind(String name, Object obj) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		rebind(name, obj);
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#close()
	 */
	public void close() throws NamingException {
		mockState=ContextState.CLOSE;
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#composeName(javax.naming.Name, javax.naming.Name)
	 */
	public Name composeName(Name name, Name prefix) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#composeName(java.lang.String, java.lang.String)
	 */
	public String composeName(String name, String prefix) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#createSubcontext(javax.naming.Name)
	 */
	public Context createSubcontext(Name name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#createSubcontext(java.lang.String)
	 */
	public Context createSubcontext(String name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#destroySubcontext(javax.naming.Name)
	 */
	public void destroySubcontext(Name name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#destroySubcontext(java.lang.String)
	 */
	public void destroySubcontext(String name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#getEnvironment()
	 */
	public Hashtable<?, ?> getEnvironment() throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return (Hashtable)environment.clone();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#getNameInNamespace()
	 */
	public String getNameInNamespace() throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#getNameParser(javax.naming.Name)
	 */
	public NameParser getNameParser(Name name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#getNameParser(java.lang.String)
	 */
	public NameParser getNameParser(String name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#list(javax.naming.Name)
	 */
	public NamingEnumeration<NameClassPair> list(Name name)	throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#list(java.lang.String)
	 */
	public NamingEnumeration<NameClassPair> list(String name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#listBindings(javax.naming.Name)
	 */
	public NamingEnumeration<Binding> listBindings(Name name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#listBindings(java.lang.String)
	 */
	public NamingEnumeration<Binding> listBindings(String name)	throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#lookup(javax.naming.Name)
	 */
	public Object lookup(Name name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#lookup(java.lang.String)
	 */
	public Object lookup(String name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
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
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#lookupLink(java.lang.String)
	 */
	public Object lookupLink(String name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#rebind(javax.naming.Name, java.lang.Object)
	 */
	public void rebind(Name name, Object obj) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#rebind(java.lang.String, java.lang.Object)
	 */
	public void rebind(String name, Object obj) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		bindings.put(name, obj);
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#removeFromEnvironment(java.lang.String)
	 */
	public Object removeFromEnvironment(String propName) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		return environment.remove(propName);
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#rename(javax.naming.Name, javax.naming.Name)
	 */
	public void rename(Name oldName, Name newName) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#rename(java.lang.String, java.lang.String)
	 */
	public void rename(String oldName, String newName) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
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
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.naming.Context#unbind(java.lang.String)
	 */
	public void unbind(String name) throws NamingException {
		assertThat("mockState", mockState, IsNot.not(ContextState.CLOSE));
		bindings.remove(name);
	}

}
