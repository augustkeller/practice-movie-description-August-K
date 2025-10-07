package org.example.moviemanager;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieDescriptionApplication {
    public static void main(String[] args) {
        try {
            Dotenv dotenv = Dotenv.configure()
                    .filename("app.env")
                    .load();

            String apiKey = dotenv.get("GOOGLE_API_KEY");
            System.out.println("Loaded API key: " + apiKey);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load environment variables!");
        }

        SpringApplication.run(MovieDescriptionApplication.class, args);
    }
}
