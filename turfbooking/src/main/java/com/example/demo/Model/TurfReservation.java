package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TurfReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String date;
    private String time;
    private int duration;
    private String status;  // New field for status

    // Constructors
    public TurfReservation() {
        this.status = "Pending";  // Set default status to "Pending"
    }

    public TurfReservation(String name, String date, String time, int duration) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.status = "Pending";  // Set default status to "Pending"
    }

    // Getters and Setters
    // ... (including getter and setter for 'status')

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
