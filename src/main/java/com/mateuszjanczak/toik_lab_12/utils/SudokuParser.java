package com.mateuszjanczak.toik_lab_12.utils;

import java.util.List;

public interface SudokuParser {
    String PATH = "src/main/resources/sudoku.csv";
    List<List<Integer>> getSudoku();
}
