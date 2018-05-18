package edu.txstate.crs181.rentalcar;

/**
 * Created by ConnorS on 3/26/2018.
 */

public class Car {

    private int carId;
    private String name;
    private String brand;
    private String carColor;
    private double rentalCostPerDay;
    private String url;
    private int image;

    //Code --> Generate... --> Constructor --> Select all properties (Ctrl + click) --> Ok
    public Car(int carId, String name, String brand, String carColor, double rentalCostPerDay, String url, int image) {
        this.carId = carId;
        this.name = name;
        this.brand = brand;
        this.carColor = carColor;
        this.rentalCostPerDay = rentalCostPerDay;
        this.url = url;
        this.image = image;
    }

    //Code --> Generate... --> Getter and Setter --> Select all properties (Ctrl + click) --> Ok
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public double getRentalCostPerDay() {
        return rentalCostPerDay;
    }

    public void setRentalCostPerDay(double rentalCostPerDay) {
        this.rentalCostPerDay = rentalCostPerDay;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    //This is what will display in each row for each item that is created in the CarsListActivity.java class
    @Override
    public String toString() {
        return carId + ". " + name + ", $" + rentalCostPerDay;
    }
}