/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Annam
 */
public class Hotel {
    private String city, hotelName, phoneNumber, emailAddress,address ;
    private double rating;
    private int stars;
    private boolean restaurant,roomService, airportPickup;
    private List<Room> hotelRooms;

    @Override
    public String toString(){
        return (this.hotelName + ", " + this.city);
    }

    /**
     * Constructor
     * @param city
     * @param hotelName
     * @param phoneNumber
     * @param emailAddress
     * @param address
     * @param rating
     * @param stars
     * @param restaurant
     * @param roomService
     * @param airportPickup
     */
    public Hotel(String city, String hotelName, String phoneNumber, String emailAddress, String address,
                 double rating, int stars, boolean restaurant, boolean roomService, boolean airportPickup) {
        this.city = city;
        this.hotelName = hotelName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.rating = rating;
        this.stars = stars;
        this.restaurant = restaurant;
        this.roomService = roomService;
        this.airportPickup = airportPickup;
        this.hotelRooms = new ArrayList<>();
    }

    /**
     * Constructer
     * @param city
     * @param hotelName
     * @param phoneNumber
     * @param emailAddress
     * @param address
     */
    public Hotel(String city, String hotelName, String phoneNumber, String emailAddress, String address) {
        this.city = city;
        this.hotelName = hotelName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.rating = 0.0;
        this.stars = 0;
        this.restaurant = false;
        this.roomService = false;
        this.airportPickup = false;
        this.hotelRooms = new ArrayList<>();
    }

    public void setHotelRooms(List<Room> hotelRooms) { this.hotelRooms = hotelRooms; }

    public List<Room> getHotelRooms(){return this.hotelRooms;}

    public void addHotelRoom(Room room){ this.hotelRooms.add(room); }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean isRestaurant() {
        return restaurant;
    }

    public void setRestaurant(boolean restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isRoomService() {
        return roomService;
    }

    public void setRoomService(boolean roomService) {
        this.roomService = roomService;
    }

    public boolean isAirportPickup() {
        return airportPickup;
    }

    public void setAirportPickup(boolean airportPickup) {
        this.airportPickup = airportPickup;
    }

    
    
    
}
