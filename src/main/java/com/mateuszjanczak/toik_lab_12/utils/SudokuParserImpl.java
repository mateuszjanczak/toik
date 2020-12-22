package com.mateuszjanczak.toik_lab_12.utils;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SudokuParserImpl implements SudokuParser{

    private final List<List<Integer>> sudoku;

    public SudokuParserImpl() {
        this.sudoku = new ArrayList<>();
        readCsvFile();
    }

    private void readCsvFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATH));
            String line;
            reader.readLine();
            int i = 0;
            while((line = reader.readLine()) != null) {
                sudoku.add(new ArrayList<>());
                for(int j = 0 ; j < 9; j++) {
                    int ch = Integer.parseInt(String.valueOf(line.charAt(j)));
                    sudoku.get(i).add(ch);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<List<Integer>> getSudoku() {
        return sudoku;
    }
}
