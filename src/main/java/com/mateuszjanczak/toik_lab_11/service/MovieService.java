package com.mateuszjanczak.toik_lab_11.service;

import com.mateuszjanczak.toik_lab_11.dto.MovieDto;

import java.util.List;
import java.util.Map;

public interface MovieService {
    Map<String, List<MovieDto>> getMovieList();
}
