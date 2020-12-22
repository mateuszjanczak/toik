package com.mateuszjanczak.toik_lab_12.dto;

import java.util.List;

public class SudokuDto {
    boolean error;
    List<Integer> lineIds;
    List<Integer> columnIds;
    List<Integer> areaIds;

    public SudokuDto() {
    }

    public SudokuDto(boolean error, List<Integer> lineIds, List<Integer> columnIds, List<Integer> areaIds) {
        this.error = error;
        this.lineIds = lineIds;
        this.columnIds = columnIds;
        this.areaIds = areaIds;
    }

    public List<Integer> getLineIds() {
        return lineIds;
    }

    public SudokuDto setLineIds(List<Integer> lineIds) {
        this.lineIds = lineIds;
        return this;
    }

    public List<Integer> getColumnIds() {
        return columnIds;
    }

    public SudokuDto setColumnIds(List<Integer> columnIds) {
        this.columnIds = columnIds;
        return this;
    }

    public List<Integer> getAreaIds() {
        return areaIds;
    }

    public SudokuDto setAreaIds(List<Integer> areaIds) {
        this.areaIds = areaIds;
        return this;
    }

    public boolean isError() {
        return error;
    }

    public SudokuDto setError(boolean error) {
        this.error = error;
        return this;
    }
}
