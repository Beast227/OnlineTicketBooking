package org.project.onlineticketbooking.movie;

public class MovieResponse {
    private String name;
    private String genre;

    public static MovieResponse from(Movie movie) {
        return new MovieResponse(movie.getName(), movie.getGenre());
    }

    public MovieResponse(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }
}
