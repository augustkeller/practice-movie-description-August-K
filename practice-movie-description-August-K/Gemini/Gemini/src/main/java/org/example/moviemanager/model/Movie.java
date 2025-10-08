package org.example.moviemanager.model;

public class Movie {
    private String title;
    private double rating;
    private String description;
    private String boxOffice;
    private String academyAwards;

    public Movie() {}

    public Movie(String title, double rating, String description, String boxOffice, String academyAwards) {
        this.title = title;
        this.rating = rating;
        this.description = description;
        this.boxOffice = boxOffice;
        this.academyAwards = academyAwards;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getBoxOffice() { return boxOffice; }
    public void setBoxOffice(String boxOffice) { this.boxOffice = boxOffice; }

    public String getAcademyAwards() { return academyAwards; }
    public void setAcademyAwards(String academyAwards) { this.academyAwards = academyAwards; }
}
