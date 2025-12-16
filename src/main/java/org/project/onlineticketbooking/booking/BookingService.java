package org.project.onlineticketbooking.booking;

import org.project.onlineticketbooking.movie.Movie;
import org.project.onlineticketbooking.movie.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final MovieRepository movieRepository;

    public BookingService(BookingRepository bookingRepository, MovieRepository movieRepository) {
        this.bookingRepository = bookingRepository;
        this.movieRepository = movieRepository;
    }

    public Booking createBooking(BookingDTO booking) {
        Movie movie = movieRepository.findById(booking.getMovieId()).orElseThrow(() -> new RuntimeException("Movie Not Found"));
        Booking newBooking = new Booking(movie, booking.getEmail(), booking.getDate(), booking.getTime(), booking.getSeatNo());
        return bookingRepository.save(newBooking);
    }

    public Booking updateBooking(Long id, BookingDTO dto) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking Not Found"));

        booking.setEmail(dto.getEmail());
        booking.setDate(dto.getDate());
        booking.setTime(dto.getTime());
        booking.setSeatNo(dto.getSeatNo());

        if (dto.getMovieId() != null) {
            Movie movie =  movieRepository.findById(dto.getMovieId()).orElseThrow(() -> new RuntimeException("Movie Not Found"));
            booking.setMovie(movie);
        }

        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public BookingResponse getBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found!"));

        return new BookingResponse(booking);
    }

    public List<BookingResponse> getAllBookings(String email) {
        return bookingRepository.findByEmail(email).stream().map(BookingResponse::new).toList();
    }

}
