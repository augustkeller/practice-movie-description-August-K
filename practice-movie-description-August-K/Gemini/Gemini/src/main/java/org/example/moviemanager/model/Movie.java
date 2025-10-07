package org.example.moviemanager.model;

public class Movie {
    private String title;
    private double rating;
    private String description;

    public Movie() {}

    public Movie(String title, double rating, String description) {
        this.title = title;
        this.rating = rating;
        this.description = description;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
