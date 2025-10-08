package org.example.moviemanager.repository;

import org.example.moviemanager.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {
    private final List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }

    public List<Movie> getMoviesByMinRating(double minRating) {
        return movies.stream()
                .filter(movie -> movie.getRating() >= minRating)
                .collect(Collectors.toList());
    }
}
