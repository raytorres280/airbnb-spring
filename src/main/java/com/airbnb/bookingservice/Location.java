package com.airbnb.bookingservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String city;
    private float avgReview;
    private int userId;

    public Location(long id, String name, String city, float avgReview, int userId) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.avgReview = avgReview;
        this.userId = userId;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getAvgReview() {
        return avgReview;
    }

    public void setAvgReview(float avgReview) {
        this.avgReview = avgReview;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
