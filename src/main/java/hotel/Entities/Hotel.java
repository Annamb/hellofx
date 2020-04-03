/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.Entities;

/**
 *
 * @author Annam
 */
public class Hotel {
    private String city, hotelName,phonenumber,emailadress,address ;
    private double rating;
    private int price,stars;
    private boolean restaurant,roomService,airportpickup;
    private HotelRegistry hotelRegistry;

    @Override
    public String toString(){
        return (this.hotelName + ", " + this.city);
    }
    public Hotel(String city, String hotelName, String phonenumber, String emailadress, String address, double rating, int price, int stars, boolean restaurant, boolean roomService, boolean airportpickup) {
        hotelRegistry = new HotelRegistry();

        this.city = city;
        this.hotelName = hotelName;
        this.phonenumber = phonenumber;
        this.emailadress = emailadress;
        this.address = address;
        this.rating = rating;
        this.price = price;
        this.stars = stars;
        this.restaurant = restaurant;
        this.roomService = roomService;
        this.airportpickup = airportpickup;
    }

    public Hotel(String city, String hotelName, String phonenumber, String emailadress, String address) {
        hotelRegistry = new HotelRegistry();

        this.city = city;
        this.hotelName = hotelName;
        this.phonenumber = phonenumber;
        this.emailadress = emailadress;
        this.address = address;
        this.rating = 0.0;
        this.price = 0;
        this.stars = 0;
        this.restaurant = false;
        this.roomService = false;
        this.airportpickup = false;
    }
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmailadress() {
        return emailadress;
    }

    public void setEmailadress(String emailadress) {
        this.emailadress = emailadress;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public boolean isAirportpickup() {
        return airportpickup;
    }

    public void setAirportpickup(boolean airportpickup) {
        this.airportpickup = airportpickup;
    }

    
    
    
}
