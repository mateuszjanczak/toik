package com.mateuszjanczak.toik_lab_12.web;

import com.mateuszjanczak.toik_lab_12.dto.SudokuDto;
import com.mateuszjanczak.toik_lab_12.service.SudokuServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SudokuController {

    private final SudokuServiceImpl sudokuService;

    public SudokuController(SudokuServiceImpl sudokuService) {
        this.sudokuService = sudokuService;
    }

    @PostMapping("/api/sudoku/verify")
    public ResponseEntity<SudokuDto> verify() {
        SudokuDto sudokuDto = sudokuService.verify();
        if(sudokuDto.isError()) {
            return new ResponseEntity<>(sudokuDto, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
