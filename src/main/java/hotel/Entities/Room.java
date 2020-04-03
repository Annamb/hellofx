package hotel.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {

    private int roomID,numGuests;
    private boolean isMinibar,isWheelchairAccess;
    private  List<Booking> bookings;

    public Room(int roomID, int numGuests, boolean isMinibar, boolean isWheelchairAccess) {
        this.roomID = roomID;
        this.numGuests = numGuests;
        this.isMinibar = isMinibar;
        this.isWheelchairAccess = isWheelchairAccess;
        this.bookings = new ArrayList<>();
    }
    public Room(int roomID, int numGuests, boolean isMinibar, boolean isWheelchairAccess, List<Booking> bookings) {
        this.roomID = roomID;
        this.numGuests = numGuests;
        this.isMinibar = isMinibar;
        this.isWheelchairAccess = isWheelchairAccess;
        this.bookings = bookings;
    }
    public Room(int roomID, int numGuests, boolean isMinibar, boolean isWheelchairAccess, Booking booking) {
        this.roomID = roomID;
        this.numGuests = numGuests;
        this.isMinibar = isMinibar;
        this.isWheelchairAccess = isWheelchairAccess;
        this.bookings = new ArrayList<>();
        this.bookings.add(booking);
    }

    public int getRoomID() {
        return roomID;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public boolean isMinibar() {
        return isMinibar;
    }

    public boolean isWheelchairAccess() {
        return isWheelchairAccess;
    }

    public List<Booking> getBookings() { return this.bookings; }

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
        isMinibar = minibar;
    }

    public void setWheelchairAccess(boolean wheelchairAccess) {
        isWheelchairAccess = wheelchairAccess;
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
