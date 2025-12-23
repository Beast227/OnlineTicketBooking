package org.project.onlineticketbooking.booking;

import jakarta.persistence.*;
import org.project.onlineticketbooking.movie.Movie;
import org.project.onlineticketbooking.user.User;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email",  nullable = false)
    private User user;
    private String date;
    private String time;
    private String seatNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    protected Booking() {}

    public Booking(Movie movie, User user, String date, String time, String seatNo) {
        this.movie = movie;
        this.user = user;
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

    public User getUser() { return  user; }

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

    public void setUser(User user) { this.user = user; }

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
