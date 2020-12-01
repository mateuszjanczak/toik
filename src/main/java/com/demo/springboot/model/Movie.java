package com.demo.springboot.model;

public class Movie {
    private Integer movieId;
    private String title;
    private Integer year;
    private String image;

    public Movie() {
    }

    public Movie(Integer movieId, String title, Integer year, String image) {
        this.movieId = movieId;
        this.title = title;
        this.year = year;
        this.image = image;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
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
