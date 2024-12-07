//
//package com.example.demo.Model;
//
//import jakarta.persistence.*;
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//@Entity
//@Table(name = "requests")
//public class RequestModel {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//    private LocalDate date;
//
//    private LocalTime time;
//
//    private int hours;
//
//    // Constructors, getters, and setters
//    public Request() {
//    }
//
//    public Request(String name, LocalDate date, LocalTime time, int hours) {
//        this.name = name;
//        this.date = date;
//        this.time = time;
//        this.hours = hours;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
//    public LocalTime getTime() {
//        return time;
//    }
//
//    public void setTime(LocalTime time) {
//        this.time = time;
//    }
//
//    public int getHours() {
//        return hours;
//    }
//
//    public void setHours(int hours) {
//        this.hours = hours;
//    }
//}
