package com.demo.springboot.dto;

public class MovieRequest {
    private String title;
    private Integer year;
    private String image;

    public MovieRequest() {
    }

    public MovieRequest(String title, Integer year, String image) {
        this.title = title;
        this.year = year;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
