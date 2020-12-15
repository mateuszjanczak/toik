package com.mateuszjanczak.toik_lab_11.service;

import com.mateuszjanczak.toik_lab_11.dto.MovieDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> getMovieList();
}
