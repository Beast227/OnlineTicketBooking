package org.project.onlineticketbooking.booking;

public class BookingResponse {
    private Long id;
    private String email;
    private String date;
    private String time;
    private String seatNo;
    private String movieTitle;

    public BookingResponse(Booking booking) {
        this.id = booking.getId();
        this.movieTitle = booking.getMovie().getName();
        this.email = booking.getUser().getEmail();
        this.date = booking.getDate();
        this.time = booking.getTime();
        this.seatNo = booking.getSeatNo();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

}
