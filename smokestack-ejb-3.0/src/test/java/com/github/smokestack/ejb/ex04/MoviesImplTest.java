package com.github.smokestack.ejb.ex04;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import mockit.Expectations;
import mockit.Mocked;
import com.github.smokestack.ejb.MockEJBContainer;
import com.github.smokestack.jpa.MockBaseQuery;
import com.github.smokestack.jpa.MockEntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MoviesImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetMovies() throws Exception {
        new Expectations(){
			@Mocked (methods= {"persist", "remove"})
			MockEntityManager em;
			@Mocked( methods= {"getResultList"})
			MockBaseQuery q;
       	    {
        		em.persist(any);
        		em.persist(any);
        		em.persist(any);
        		List<Movie> l1=new ArrayList<Movie>();
        		l1.add(new Movie("Quentin Tarantino", "Reservoir Dogs", 1992));
                l1.add(new Movie("Joel Coen", "Fargo", 1996));
                l1.add(new Movie("Joel Coen", "The Big Lebowski", 1998));
        		q.getResultList(); returns(l1);
        		em.remove(any);
        		em.remove(any);
        		em.remove(any);
        		List<Movie> l2=new ArrayList<Movie>();
        		q.getResultList(); returns(l2);
        	}
        };
        
        MockEJBContainer container=new MockEJBContainer();
        
        Movies movies = container.getInstance(MoviesImpl.class);

        movies.addMovie(new Movie("Quentin Tarantino", "Reservoir Dogs", 1992));
        movies.addMovie(new Movie("Joel Coen", "Fargo", 1996));
        movies.addMovie(new Movie("Joel Coen", "The Big Lebowski", 1998));

        List<Movie> list = movies.getMovies();
        assertEquals("List.size()", 3, list.size());

        for (Movie movie : list) {
            movies.deleteMovie(movie);
        }

        assertEquals("Movies.getMovies()", 0, movies.getMovies().size());
	}

}
