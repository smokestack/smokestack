/**
 * 
 */
package com.github.smokestack.jpa;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import com.github.smokestack.exception.NotYetImplementedException;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author gliptak
 *
 */
public class MockPersistenceProviderImpl implements PersistenceProvider {

	private static Logger log=Logger.getLogger(MockPersistenceProviderImpl.class.getName());
	private Map<String, MockEntityManagerFactory> factories=new HashMap<String, MockEntityManagerFactory>();
	
	/* (non-Javadoc)
	 * @see javax.persistence.spi.PersistenceProvider#createContainerEntityManagerFactory(javax.persistence.spi.PersistenceUnitInfo, java.util.Map)
	 */
	public EntityManagerFactory createContainerEntityManagerFactory(
			PersistenceUnitInfo info, Map map) {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.spi.PersistenceProvider#createEntityManagerFactory(java.lang.String, java.util.Map)
	 */
	public EntityManagerFactory createEntityManagerFactory(String emName, Map map) {
		
		NodeList nodes=null;
		
		try {
			nodes=getEntityManagerConfig(emName);
		} catch (Exception e) {
			log.log(Level.INFO, "createEntityManagerFactory failed", e);
		}
		
		if (nodes==null || nodes.getLength()==0){
			return null;
		}
		
		MockEntityManagerFactory f=new MockEntityManagerFactory();
		factories.put(emName, f);
		return f;
	}
	
	protected NodeList getEntityManagerConfig(String emName) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true); // never forget this!
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(getClass().getResourceAsStream("/META-INF/persistence.xml"));

		XPathFactory xpfactory = XPathFactory.newInstance();
		XPath xpath = xpfactory.newXPath();
		xpath.setNamespaceContext(new PersistenceNamespaceContext());
		  
		XPathExpression expr = xpath.compile("/p:persistence/p:persistence-unit[@name='"+emName+"']");

		Object result = expr.evaluate(doc, XPathConstants.NODESET);

		return (NodeList) result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * Used for validation
	 */
	public Map<String, MockEntityManagerFactory> getMockEntityManagerFactories() {
		return factories;		
	}
}
