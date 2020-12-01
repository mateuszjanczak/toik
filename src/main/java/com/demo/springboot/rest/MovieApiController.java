package com.demo.springboot.rest;

import com.demo.springboot.dto.MovieRequest;
import com.demo.springboot.exception.EmptyDtoException;
import com.demo.springboot.exception.MovieNotFoundException;
import com.demo.springboot.model.Movie;
import com.demo.springboot.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class MovieApiController {

    private final MovieService movieService;

    public MovieApiController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        final List<Movie> movies = movieService.findAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @PostMapping("/movies")
    public ResponseEntity<Void> createMovie(@RequestBody MovieRequest movieRequest) throws URISyntaxException {
        Movie movie;
        try {
            movie = movieService.create(movieRequest);
        } catch (EmptyDtoException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.created(new URI("/movies/" + movie.getMovieId())).build();
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Void> editMovie(@RequestBody MovieRequest movieRequest, @PathVariable int id) throws URISyntaxException {
        Movie movie;
        try {
            movie = movieService.update(movieRequest, id);
        } catch (MovieNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.created(new URI("/movies/" + movie.getMovieId())).build();
    }

    @DeleteMapping(value = "/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id){
        try {
            movieService.delete(id);
        } catch (MovieNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
