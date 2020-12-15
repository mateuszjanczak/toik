package com.mateuszjanczak.toik_lab_11.service.impl;

import com.mateuszjanczak.toik_lab_11.dto.MovieDto;
import com.mateuszjanczak.toik_lab_11.repository.MovieRepository;
import com.mateuszjanczak.toik_lab_11.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDto> getMovieList() {
        return movieRepository.getMovieList().stream()
                .map(movie -> MovieDto.builder()
                        .movieId(movie.getMovieId())
                        .title(movie.getTitle())
                        .year(movie.getYear())
                        .image(movie.getImage())
                        .build())
                .collect(Collectors.toList());
    }
}
