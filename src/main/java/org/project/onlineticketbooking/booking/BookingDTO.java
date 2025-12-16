package org.project.onlineticketbooking.booking;

public class BookingDTO {

    private String movieId;
    private String email;
    private String date;
    private String time;
    private String seatNo;

    public BookingDTO(String movieId, String email, String date, String time, String seatNo) {
        this.movieId = movieId;
        this.email = email;
        this.date = date;
        this.time = time;
        this.seatNo = seatNo;
    }

    public String getMovieId() {
        return movieId;
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

}
