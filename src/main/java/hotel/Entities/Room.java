package hotel.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {

    private int roomID,numGuests, price;
    private boolean minibar, wheelchairAccess;
    private String hotelName;
    private  List<Booking> bookings;

    @Override
    public String toString(){
        return (this.hotelName + ", " + this.price + " per night " );
    }

    public Room(int roomID, String hotelName, int numGuests, boolean minibar, boolean wheelchairAccess, int price) {
        this.roomID = roomID;
        this.hotelName = hotelName;
        this.numGuests = numGuests;
        this.minibar = minibar;
        this.wheelchairAccess = wheelchairAccess;
        this.price = price;
        this.bookings = new ArrayList<>();
    }
    public Room(int roomID, String hotelName, int numGuests, boolean minibar,
                boolean wheelchairAccess, int price, List<Booking> bookings) {
        this.roomID = roomID;
        this.hotelName = hotelName;
        this.numGuests = numGuests;
        this.minibar = minibar;
        this.wheelchairAccess = wheelchairAccess;
        this.price = price;
        this.bookings = bookings;
    }
    public Room(int roomID, String hotelName, int numGuests, boolean minibar, boolean wheelchairAccess, int price, Booking booking) {
        this.roomID = roomID;
        this.hotelName = hotelName;
        this.numGuests = numGuests;
        this.minibar = minibar;
        this.wheelchairAccess = wheelchairAccess;
        this.price = price;
        this.bookings = new ArrayList<>();
        this.bookings.add(booking);
    }

    public String getHotelName() {return hotelName; }

    public void setHotelName(String hotelName) { this.hotelName = hotelName; }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRoomID() {
        return roomID;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public boolean isMinibar() {
        return minibar;
    }

    public boolean isWheelchairAccess() {
        return wheelchairAccess;
    }

    public List<Booking> getBookings() { return this.bookings; }

    /**
     * Returns list of booked dates for chosen room
     * @return
     */
    public List<LocalDate> getBookedDates(){
        List<LocalDate> bookedDates = new ArrayList<>();
        List<Booking> currBookings = this.getBookings();
        for (Booking booking: currBookings) {
            for (LocalDate bookedDate: booking.getBookedDates() ) {
                bookedDates.add(bookedDate);
            }
        }
        return bookedDates;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }

    public void setMinibar(boolean minibar) {
        this.minibar = minibar;
    }

    public void setWheelchairAccess(boolean wheelchairAccess) {
        this.wheelchairAccess = wheelchairAccess;
    }

    public void addBooking(String personName, String personEmail, String personPhone, String startDate, String endDate){
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<LocalDate> bookedDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            bookedDates.add(start);
            start = start.plusDays(1);
        }
        Booking booking = new Booking(this.roomID, personName, personEmail, personPhone, bookedDates);
        this.bookings.add(booking);
    }

    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
