package org.project.onlineticketbooking.booking;

import jakarta.persistence.*;
import org.project.onlineticketbooking.movie.Movie;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String date;
    private String time;
    private String seatNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    protected Booking() {}

    public Booking(Movie movie, String email, String date, String time, String seatNo) {
        this.movie = movie;
        this.email = email;
        this.date = date;
        this.time = time;
        this.seatNo = seatNo;
    }

    public Long getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
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

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
}
