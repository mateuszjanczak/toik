package com.mateuszjanczak.toik_lab_11.web.rest;

import com.mateuszjanczak.toik_lab_11.dto.MovieDto;
import com.mateuszjanczak.toik_lab_11.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MovieController {

    final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @CrossOrigin
    @GetMapping("/movies")
    public ResponseEntity<Map<String, List<MovieDto>>> getAllNotes(){
        return new ResponseEntity<>(movieService.getMovieList(), HttpStatus.OK);
    }
}
