package com.github.smokestack.ejb.ex04;

import static org.junit.Assert.*;

import javax.persistence.PersistenceException;

import org.junit.Test;

import com.github.smokestack.ejb.MockEJBContainer;

public class MoviesMisconfiguredTest {

	@Test
	public void testGetMovies() {
		try {
	        MockEJBContainer container=new MockEJBContainer();     
	        MoviesMisconfigured movies = container.getInstance(MoviesMisconfigured.class);
	        fail("expected PersistenceException");
		} catch (PersistenceException pe){
			// EXPECTED PersistenceException 
		}
	}

}
