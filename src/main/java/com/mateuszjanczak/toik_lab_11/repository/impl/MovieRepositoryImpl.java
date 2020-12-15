package com.mateuszjanczak.toik_lab_11.repository.impl;

import com.mateuszjanczak.toik_lab_11.repository.MovieRepository;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
    private final List<String> movieList;

    public MovieRepositoryImpl() {
        movieList = new ArrayList<>();
        this.readCsvFile();
    }

    private void readCsvFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATH));
            String line;
            reader.readLine();
            while((line = reader.readLine()) != null) {
                movieList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getMovieList() {
        return movieList;
    }
}
