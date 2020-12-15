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
                .map(line -> MovieDto.builder()
                        .movieId(Integer.parseInt(line.split(";")[0]))
                        .title(line.split(";")[1])
                        .year(Integer.parseInt(line.split(";")[2]))
                        .image(line.split(";")[3])
                        .build())
                .collect(Collectors.toList());
    }
}
