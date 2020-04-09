package hotel;

import hotel.Entities.Hotel;
import hotel.Entities.HotelRegistry;
import hotel.Entities.Room;

import java.util.ArrayList;
import java.util.List;

public class leit {
    private HotelRegistry hotelRegistry;
    private List<Hotel> hotels;

    public leit() {
        hotelRegistry = new HotelRegistry();
    }

    public List<Hotel> leitaHotel(Leitarskilyrdi h, Boolean stjornur, Boolean city, Boolean leitarstrengur, Boolean numGuest){
        List<Hotel> myList = new ArrayList();
        List<Hotel> hotel = hotelRegistry.getHotelList();
        List<Room> room = new ArrayList();

        for (int i = 0; i < hotel.size(); i++) {
            if(stjornur==true && city==true && leitarstrengur==true && numGuest==false){
            if(hotel.get(i).getStars() == h.getStars()
                    && hotel.get(i).getCity().equals(h.getCity())
                    && hotel.get(i).getHotelName().contains(h.getLeitarstrengur().toString())){

                myList.add(hotel.get(i));
            }}
            if(stjornur==true && city==true && leitarstrengur==false && numGuest==false){
                if(hotel.get(i).getStars() == h.getStars()
                        && hotel.get(i).getCity().equals(h.getCity())){
                    myList.add(hotel.get(i));
                }}

            if(stjornur==false && city==true && leitarstrengur==true && numGuest==false){
                if(hotel.get(i).getCity().equals(h.getCity())
                        && hotel.get(i).getHotelName().contains(h.getLeitarstrengur().toString())){
                    myList.add(hotel.get(i));
                }}
            if(stjornur==false && city==true && leitarstrengur==false && numGuest==false){
                if(hotel.get(i).getCity().equals(h.getCity())){
                    myList.add(hotel.get(i));
                }}

            if(stjornur==true && city==false && leitarstrengur==true && numGuest==false){
                if(hotel.get(i).getStars() == h.getStars()
                        && hotel.get(i).getHotelName().contains(h.getLeitarstrengur().toString())){
                    myList.add(hotel.get(i));
                }}
            if(stjornur==true && city==false && leitarstrengur==false && numGuest==false){
                if(hotel.get(i).getStars() == h.getStars()){
                    myList.add(hotel.get(i));
                }}
            if(stjornur==false && city==false && leitarstrengur==true && numGuest==false){
                if(hotel.get(i).getHotelName().contains(h.getLeitarstrengur().toString())){
                    myList.add(hotel.get(i));
                }}

            if(stjornur==true && city==true && leitarstrengur==true && numGuest==true){
                if(hotel.get(i).getStars() == h.getStars()
                        && hotel.get(i).getCity().equals(h.getCity())
                        && hotel.get(i).getHotelName().contains(h.getLeitarstrengur().toString())){
                    room = hotel.get(i).getHotelRooms();
                    for (int j = 0; j < room.size(); j++) {
                        if(room.get(j).getNumGuests() == h.getNumGuest()){
                            myList.add(hotel.get(i));
                        }
                    }
                }}
            if(stjornur==true && city==true && leitarstrengur==false && numGuest==true){
                if(hotel.get(i).getStars() == h.getStars()
                        && hotel.get(i).getCity().equals(h.getCity())){
                    room = hotel.get(i).getHotelRooms();
                    for (int j = 0; j < room.size(); j++) {
                        if(room.get(j).getNumGuests() == h.getNumGuest()){
                            myList.add(hotel.get(i));
                        }
                    }
                }}

            if(stjornur==false && city==true && leitarstrengur==true && numGuest==true){
                if(hotel.get(i).getCity().equals(h.getCity())
                        && hotel.get(i).getHotelName().contains(h.getLeitarstrengur().toString())){
                    room = hotel.get(i).getHotelRooms();
                    for (int j = 0; j < room.size(); j++) {
                        if(room.get(j).getNumGuests() == h.getNumGuest()){
                            myList.add(hotel.get(i));
                        }
                    }
                }}
            if(stjornur==false && city==true && leitarstrengur==false && numGuest==true){
                if(hotel.get(i).getCity().equals(h.getCity())){
                    room = hotel.get(i).getHotelRooms();
                    for (int j = 0; j < room.size(); j++) {
                        if(room.get(j).getNumGuests() == h.getNumGuest()){
                            myList.add(hotel.get(i));
                        }
                    }
                }}

            if(stjornur==true && city==false && leitarstrengur==true && numGuest==true){
                if(hotel.get(i).getStars() == h.getStars()
                        && hotel.get(i).getHotelName().contains(h.getLeitarstrengur().toString())){
                    room = hotel.get(i).getHotelRooms();
                    for (int j = 0; j < room.size(); j++) {
                        if(room.get(j).getNumGuests() == h.getNumGuest()){
                            myList.add(hotel.get(i));
                        }
                    }
                }}
            if(stjornur==true && city==false && leitarstrengur==false && numGuest==true){
                if(hotel.get(i).getStars() == h.getStars()){
                    room = hotel.get(i).getHotelRooms();
                    for (int j = 0; j < room.size(); j++) {
                        if(room.get(j).getNumGuests() == h.getNumGuest()){
                            myList.add(hotel.get(i));
                        }
                    }
                }}
            if(stjornur==false && city==false && leitarstrengur==true && numGuest==true){
                if(hotel.get(i).getHotelName().contains(h.getLeitarstrengur().toString())){
                    room = hotel.get(i).getHotelRooms();
                    for (int j = 0; j < room.size(); j++) {
                        if(room.get(j).getNumGuests() == h.getNumGuest()){
                            myList.add(hotel.get(i));
                        }
                    }
                }}
            if(stjornur==false && city==false && leitarstrengur==false && numGuest==true){
                room = hotel.get(i).getHotelRooms();
                for (int j = 0; j < room.size(); j++) {
                    if(room.get(j).getNumGuests() == h.getNumGuest()){
                    myList.add(hotel.get(i));
                    }
                }
            }

        }
        return myList;
    }
}
