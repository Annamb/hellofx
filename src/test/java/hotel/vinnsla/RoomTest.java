package hotel.vinnsla;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
/*
Hópur 8H
Anna Margrét Benediktsdóttir amb33@hi.is
Númi Steinn Baldursson nsb3@hi.is
*/
public class RoomTest {
    private Room room1, room2;
    Booking booking;

    @Before
    public void setUp() throws Exception {
        room1 = new Room(1, 4, false, true);
        booking = new Booking(2, "John Smith",
                "mail@person.com", "5812345", "2020-05-01", "2020-05-03");
        room2 = new Room(2, 1, true, false, booking);
    }

    @After
    public void tearDown() throws Exception {
        room1 = null;
        room2 = null;
    }

    @Test
    public void getRoomID() {
        assertEquals(1, room1.getRoomID());
        assertEquals(2, room2.getRoomID());
    }

    @Test
    public void getNumGuests() {
        assertEquals(4, room1.getNumGuests());
        assertEquals(1, room2.getNumGuests());
    }

    @Test
    public void isMinibar() {
        assertEquals(false, room1.isMinibar());
        assertEquals(true, room2.isMinibar());
    }

    @Test
    public void isWheelchairAccess() {
        assertEquals(true, room1.isWheelchairAccess());
        assertEquals(false, room2.isWheelchairAccess());
    }

    @Test
    public void getBookings() {
        List<Booking> testBooking =  new ArrayList<Booking>();
        assertEquals(testBooking, room1.getBookings());
        testBooking.add(booking);
        assertEquals(testBooking, room2.getBookings());
    }

    @Test
    public void getBookedDates() {
        List<LocalDate> bookedDates = new ArrayList<>();
        bookedDates.add(LocalDate.parse("2020-05-01"));
        bookedDates.add(LocalDate.parse("2020-05-02"));
        bookedDates.add(LocalDate.parse("2020-05-03"));
        assertThat(room2.getBookedDates(), is(bookedDates));

    }

    @Test
    public void setRoomID() {
        room1.setRoomID(100);
        room2.setRoomID(99);
        assertEquals(100, room1.getRoomID());
        assertEquals(99, room2.getRoomID());
    }

    @Test
    public void setNumGuests() {
        room1.setNumGuests(11);
        room2.setNumGuests(32);
        assertEquals(11, room1.getNumGuests());
        assertEquals(32, room2.getNumGuests());
    }

    @Test
    public void setMinibar() {
        room1.setMinibar(true);
        room2.setMinibar(true);
        assertEquals(true, room1.isMinibar());
        assertEquals(true, room2.isMinibar());
    }

    @Test
    public void setWheelchairAccess() {
        room1.setWheelchairAccess(false);
        room2.setWheelchairAccess(false);
        assertEquals(false, room1.isWheelchairAccess());
        assertEquals(false, room2.isWheelchairAccess());
    }

    @Test
    public void setBookings() {
        Booking booking1 = new Booking(room1.getRoomID(), "Random Name", "mail@random.com",
                "5558899", "2020-06-11", "2020-05-14");
        Booking booking2 = new Booking(room1.getRoomID(), "New Name", "hehe@mailinator.com",
                "5558899", "2020-08-11", "2020-08-14");
        List<Booking> testBookings = new ArrayList<>();
        testBookings.add(booking1);
        testBookings.add(booking2);
        room1.setBookings(testBookings);
        assertEquals(testBookings, room1.getBookings());
    }
}