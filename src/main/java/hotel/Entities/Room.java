package hotel.Entities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    private void parseBookingObject(JSONObject booking)
    {
        //Get booking object within list
        JSONObject BookingObject = (JSONObject) booking.get("booking");

        //Get booking name
        String personName = (String) BookingObject.get("personName");
        System.out.println(personName);

        String phoneNumber = (String) BookingObject.get("phoneNumber");
        System.out.println(phoneNumber);

        String email = (String) BookingObject.get("email");
        System.out.println(email);

        String startDate = (String) BookingObject.get("startDate");
        System.out.println(startDate);

        String endDate = (String) BookingObject.get("endDate");
        System.out.println(endDate);

        String roomID =(String) BookingObject.get("roomID");
        System.out.println(roomID);

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<LocalDate> bookedDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            bookedDates.add(start);
            start = start.plusDays(1);
        }

    }
    public List<LocalDate> getBookedDates2(){
        List<LocalDate> bookedDates = new ArrayList<>();
        JSONArray allarbokanir;
        allarbokanir=lesabokanir();
        allarbokanir.forEach( bookin -> bookedDates.addAll(finnaherb( (JSONObject) bookin ) ));

        return bookedDates;
    }

    private List<LocalDate> finnaherb(JSONObject booking) {
        JSONObject BookingObject = (JSONObject) booking.get("booking");
        Long roomIDcheck = (Long) BookingObject.get("roomID");
        String startDate =(String) BookingObject.get("startDate");
        String endDate =(String) BookingObject.get("endDate");
        System.out.println(roomIDcheck);
        System.out.println(this.getRoomID() == roomIDcheck );
        List<LocalDate> booked2 = new ArrayList<>();

        if(this.getRoomID() == roomIDcheck ){
            System.out.println(this.getRoomID());
            LocalDate start = LocalDate.parse(startDate);
            LocalDate end = LocalDate.parse(endDate);
            List<LocalDate> booked = new ArrayList<>();

            while (!start.isAfter(end)) {
                booked.add(start);
                start = start.plusDays(1);
            }
            return booked;
        }
        return booked2;
    }


    public JSONArray lesabokanir(){
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("bookingData.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray BookingList = (JSONArray) obj;
            System.out.println(BookingList);
            System.out.println("Vid f-rum inn i filereader");
            return BookingList;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
