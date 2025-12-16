package org.project.onlineticketbooking.movie;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/create")
    public Movie createMovie(@RequestBody MovieResponse movieResponse) {
        return movieService.createMovie(movieResponse);
    }

    @PutMapping("/update")
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

    @GetMapping("/data")
    public Optional<MovieResponse> getMovie(@RequestParam("movieId") String movieId) {
        return movieService.getMovie(movieId);
    }

    @DeleteMapping("/delete")
    public void deleteMovie(@RequestParam("movieId") String movieId) {
        movieService.deleteMovie(movieId);
    }
}
