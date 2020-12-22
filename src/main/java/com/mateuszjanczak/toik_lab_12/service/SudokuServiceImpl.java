package com.mateuszjanczak.toik_lab_12.service;

import com.mateuszjanczak.toik_lab_12.dto.SudokuDto;
import com.mateuszjanczak.toik_lab_12.utils.SudokuParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SudokuServiceImpl implements SudokuService {

    private final SudokuParser sudokuParser;

    public SudokuServiceImpl(SudokuParser sudokuParser) {
        this.sudokuParser = sudokuParser;
    }

    public SudokuDto verify() {
        List<List<Integer>> sudoku = sudokuParser.getSudoku();

        Integer[][] s = sudoku.stream()
                .map(l -> l.toArray(Integer[]::new))
                .toArray(Integer[][]::new);

        for (Integer[] i : s) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        ArrayList<Integer> lineIds = new ArrayList<>();
        ArrayList<Integer> columnIds = new ArrayList<>();
        ArrayList<Integer> areaIds = new ArrayList<>();

        // row checker
        for (int row = 0; row < 9; row++)
            for (int col = 0; col < 9; col++)
                for (int col2 = col + 1; col2 < 9; col2++)
                    if (s[row][col].equals(s[row][col2]))
                        lineIds.add(row + 1);

        // column checker
        for (int col = 0; col < 9; col++)
            for (int row = 0; row < 9; row++)
                for (int row2 = row + 1; row2 < 9; row2++)
                    if (s[row][col].equals(s[row2][col]))
                        columnIds.add(col + 1);

        // grid checker
        for (int row = 0; row < 9; row += 3)
            for (int col = 0; col < 9; col += 3)
                for (int pos = 0; pos < 9; pos++)
                    for (int pos2 = pos + 1; pos2 < 9; pos2++)
                        if (s[row + pos % 3][col + pos / 3].equals(s[row + pos2 % 3][col + pos2 / 3])) {
                            if (row == 0 && col == 0) {
                                areaIds.add(1);
                            } else if (row == 0 && col == 3) {
                                areaIds.add(2);
                            } else if (row == 0 && col == 6) {
                                areaIds.add(3);
                            } else if (row == 3 && col == 0) {
                                areaIds.add(4);
                            } else if (row == 3 && col == 3) {
                                areaIds.add(5);
                            } else if (row == 3 && col == 6) {
                                areaIds.add(6);
                            } else if (row == 6 && col == 0) {
                                areaIds.add(7);
                            } else if (row == 6 && col == 3) {
                                areaIds.add(8);
                            } else if (row == 6 && col == 6) {
                                areaIds.add(9);
                            }
                        }

        boolean status = !lineIds.isEmpty() || !columnIds.isEmpty() || !areaIds.isEmpty();

        return new SudokuDto(status, lineIds, columnIds, areaIds);
    }
}
