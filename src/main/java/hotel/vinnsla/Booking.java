package hotel.vinnsla;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private int roomId;
    private String personName, personEmail, personPhone;
    private List<LocalDate> bookedDates;

    public Booking(int roomId, String personName, String personEmail, String personPhone, List<LocalDate> bookedDates){
        this.roomId = roomId;
        this.personName = personName;
        this.personEmail = personEmail;
        this.personPhone = personPhone;
        this.bookedDates = bookedDates;
    }
    public Booking(int roomId, String personName, String personEmail, String personPhone, String startDate, String endDate){
        this.roomId = roomId;
        this.personName = personName;
        this.personEmail = personEmail;
        this.personPhone = personPhone;

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<LocalDate> bookedDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            bookedDates.add(start);
            start = start.plusDays(1);
        }

        this.bookedDates = bookedDates;
    }

    public void addBookedDates(LocalDate date) { this.bookedDates.add(date); }
    public int getRoomId() {
        return roomId;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public List<LocalDate> getBookedDates() {
        return bookedDates;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public void setBookedDates(List<LocalDate> bookedDates) {
        this.bookedDates = bookedDates;
    }
}
