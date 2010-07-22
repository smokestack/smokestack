package com.github.smokestack.ejb.ex04;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

@Stateful(name = "Movies")
public class MoviesMisconfigured {
    @PersistenceContext(unitName = "movie-misconfigured", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public void addMovie(Movie movie) throws Exception {
        entityManager.persist(movie);
    }

    public void deleteMovie(Movie movie) throws Exception {
        entityManager.remove(movie);
    }

    public List<Movie> getMovies() throws Exception {
        Query query = entityManager.createQuery("SELECT m from Movie as m");
        return query.getResultList();
    }
}