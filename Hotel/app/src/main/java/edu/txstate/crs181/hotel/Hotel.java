package edu.txstate.crs181.hotel;

/**
 * Created by ConnorS on 4/4/2018.
 */

public class Hotel {

    private int id;
    private String name;
    private String city;
    private int starRating;

    public Hotel(int id, String name, String city, int starRating) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.starRating = starRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    @Override
    public String toString() {
        return id + ". " + name + ", " + city;
    }
}


