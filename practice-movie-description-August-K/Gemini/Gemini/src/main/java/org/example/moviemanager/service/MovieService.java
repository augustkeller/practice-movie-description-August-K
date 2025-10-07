package org.example.moviemanager.service;

import org.example.moviemanager.model.Movie;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final Client client;

    public MovieService() {
        // Make sure GOOGLE_API_KEY is set in environment variables
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
            // Fallback description if Gemini fails
            return "Description not available due to an error.";
        }
    }

    public Movie createMovie(String title, double rating) {
        String description = generateDescription(title);
        return new Movie(title, rating, description);
    }
}
