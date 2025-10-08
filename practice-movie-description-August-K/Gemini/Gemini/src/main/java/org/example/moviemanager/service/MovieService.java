package org.example.moviemanager.service;

import org.example.moviemanager.model.Movie;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final Client client;

    public MovieService() {
        this.client = new Client();
    }

    public String generateDescription(String title) {
        try {
            GenerateContentResponse response = client.models.generateContent(
                    "gemini-2.0-flash-001",
                    "Write a short description for the movie: " + title,
                    null
            );
            return response.text();
        } catch (Exception e) {
            e.printStackTrace();
            return "Description not available due to an error.";
        }
    }

    public String generateBoxOffice(String title) {
        try {
            GenerateContentResponse response = client.models.generateContent(
                    "gemini-2.0-flash-001",
                    "How much did the movie " + title + " generate at the box office?",
                    null
            );
            return response.text();
        } catch (Exception e) {
            e.printStackTrace();
            return "Box Office not available due to an error.";
        }
    }

    public String generateAcademyAwards(String title) {
        try {
            GenerateContentResponse response = client.models.generateContent(
                    "gemini-2.0-flash-001",
                    "Which Oscars did " + title + " win at the Academy Awards?",
                    null
            );
            return response.text();
        } catch (Exception e) {
            e.printStackTrace();
            return "Academy Awards not available due to an error.";
        }
    }

    public Movie createMovie(String title, double rating) {
        String description = generateDescription(title);
        String boxOffice = generateBoxOffice(title);
        String academyAwards = generateAcademyAwards(title);
        return new Movie(title, rating, description, boxOffice, academyAwards);
    }
}
