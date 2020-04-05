package hotel.Entities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



/**
 * Hotel registry functions
 * @author annam, nsb
 */
public class HotelRegistry {

    public HotelRegistry(){}
    
    public List<Hotel> getHotelList(){
	    Gson gson = new Gson();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/Data/hotelData.json")));
//            BufferedReader br = new BufferedReader(new FileReader(new File("/Data/hotelData.json")));

            TypeToken<List<Hotel>> token = new TypeToken<List<Hotel>>() {};
            List<Hotel> hotels = gson.fromJson(br, token.getType());

            BufferedReader bla = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/Data/roomData.json")));
//            BufferedReader br = new BufferedReader(new FileReader(new File("/Data/hotelData.json")));

            TypeToken<List<Room>> token2 = new TypeToken<List<Room>>() {};
            List<Room> rooms = gson.fromJson(bla, token2.getType());
            for (Hotel hotel: hotels) {
                hotel.setHotelRooms(new ArrayList<>());
            }

            //Adding rooms to hotels
            for (Room room: rooms) {
                room.setBookings(new ArrayList<>());
                for (Hotel hotel: hotels) {
                    if(hotel.getHotelName().equals(room.getHotelName())){
                        hotel.addHotelRoom(room);
                    }
                }
            }
            rooms.get(0).addBooking("Name Name", "mail@blala.com", "112233", "2020-05-01", "2020-05-03");



            return hotels;

        } finally {

        }
    }
}