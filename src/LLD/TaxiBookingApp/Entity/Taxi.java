package LLD.TaxiBookingApp.Entity;

import java.util.Comparator;

public class Taxi implements Comparable<Taxi> {
    private int id;
    private char currentLocation;
    private char pickUpLocation;
    private char dropLocation;
    private int pickUpTime;
    private int dropTime;
    private int earnings;
    private long ride_mileage;


    @Override //comparing
    public int compareTo(Taxi other) {
        return this.earnings - other.getEarnings();
    }

    public Taxi(int id){
        this.id = id;
        this.currentLocation = 'A';
        this.dropTime = 0;
        this.earnings = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(char currentLocation) {
        this.currentLocation = currentLocation;
    }

    public char getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(char pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public char getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(char dropLocation) {
        this.dropLocation = dropLocation;
    }

    public int getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(int pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

    public long getRide_mileage() {
        return ride_mileage;
    }

    public void setRide_mileage(long ride_mileage) {
        this.ride_mileage = ride_mileage;
    }

    @Override
    public String toString() {
        return "Taxi[" +
                "id=" + id +
                ", currentLocation=" + currentLocation +
                ", dropTime=" + dropTime +
                ", earnings=" + earnings +
                ", ride_mileage=" + ride_mileage +
                ']';
    }
}
