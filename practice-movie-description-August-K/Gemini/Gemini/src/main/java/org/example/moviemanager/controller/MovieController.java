package org.example.moviemanager.controller;

import org.example.moviemanager.model.Movie;
import org.example.moviemanager.repository.MovieRepository;
import org.example.moviemanager.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private MovieService movieService;

    @PostMapping
    public Movie addMovie(
            @RequestParam("title") String title,
            @RequestParam("rating") double rating
    ) throws Exception {
        Movie movie = movieService.createMovie(title, rating);
        repository.addMovie(movie);
        return movie;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return repository.getAllMovies();
    }

    @GetMapping("/describe")
    public String describe(@RequestParam("title") String title) throws Exception {
        return movieService.generateDescription(title);
    }

    @GetMapping("/boxoffice")
    public String boxOffice(@RequestParam("title") String title) throws Exception {
        return movieService.generateBoxOffice(title);
    }

    @GetMapping("/oscars")
    public String oscars(@RequestParam("title") String title) throws Exception {
        return movieService.generateAcademyAwards(title);
    }

    @GetMapping("/filter")
    public List<Movie> getMoviesByMinRating(@RequestParam(name = "minRating") double minRating) {
        return repository.getMoviesByMinRating(minRating);
    }
}
