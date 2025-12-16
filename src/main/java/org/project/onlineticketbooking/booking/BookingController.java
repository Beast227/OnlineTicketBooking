package org.project.onlineticketbooking.booking;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public Booking createBooking(@RequestBody BookingDTO booking) {
        return bookingService.createBooking(booking);
    }

    @PutMapping("/update")
    public Booking updateBooking(@RequestBody BookingDTO booking, @RequestParam Long bookingId) {
        return bookingService.updateBooking(bookingId, booking);
    }

    @DeleteMapping("/delete")
    public void deleteBooking(@RequestParam Long id) {
        bookingService.deleteBooking(id);
    }

    @GetMapping("/getbyid")
    public BookingResponse getBookingById(@RequestParam Long id) {
        return bookingService.getBooking(id);
    }

    @GetMapping("/get-all-booking")
    public List<BookingResponse> getAllBookings(@RequestParam String email) {
        return bookingService.getAllBookings(email);
    }

}
