package org.project.onlineticketbooking.movie;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    private String movieId;
    private String name;
    private String genre;

    protected Movie() {}

    public Movie(String movieId, String name, String genre) {
        this.movieId = movieId;
        this.name = name;
        this.genre = genre;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }
}
