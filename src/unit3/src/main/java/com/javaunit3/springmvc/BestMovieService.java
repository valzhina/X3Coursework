package com.javaunit3.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //new class defined as a Spring component and available in the Spring application context
public class BestMovieService{

    private Movie movie; //defines var movie class Movie

//    @Autowired
//    public BestMovieService(Movie movie) { // a constructor that takes a movie as a parameter
//        this.movie = movie;
//    }

    @Autowired
    public BestMovieService(@Qualifier("titanicMovie") Movie movie) {  // a constructor that inject a new movie object instead of the old one.
        this.movie = movie;
    }

    public Movie getBestMovie() { //Getter returns the movie
        return movie;
    }
}
