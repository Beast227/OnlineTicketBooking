package org.project.onlineticketbooking;

import org.junit.jupiter.api.Test;
import org.project.onlineticketbooking.booking.Booking;
import org.project.onlineticketbooking.booking.BookingRepository;
import org.project.onlineticketbooking.movie.Movie;
import org.project.onlineticketbooking.movie.MovieRepository;
import org.project.onlineticketbooking.user.Role;
import org.project.onlineticketbooking.user.User;
import org.project.onlineticketbooking.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class BookingRepositoryTest {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void findsomething() {

        User user = new User("pavin@gmail.com", "1234", "userName", Role.USER);
        userRepository.save(user);

        Movie movie = new Movie("movie1", "popaya", "action");
        movieRepository.save(movie);

        Booking booking = new Booking(movie, user, "date", "time", "opsaifh");
        bookingRepository.save(booking);

        List<Booking>  bookings = bookingRepository.findByUser_Email("pavin@gmail.com");

        assertEquals(1, bookings.size());
    }

}
