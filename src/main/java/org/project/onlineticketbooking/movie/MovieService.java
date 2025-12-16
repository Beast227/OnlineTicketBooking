package org.project.onlineticketbooking.movie;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(MovieResponse movieResponse) {
        Movie movie = new Movie(UUID.randomUUID().toString(), movieResponse.getName(), movieResponse.getGenre());
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<MovieResponse> getMovie(String movieId) {
        return movieRepository.findById(movieId).map(MovieResponse::from);
    }

    public void deleteMovie(String movieId) {
        movieRepository.deleteById(movieId);
    }
}
