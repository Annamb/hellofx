package hotel.vinnsla;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
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

            BufferedReader br = new BufferedReader(new FileReader("src/hotel/vinnsla/hotelgogn.json"));

            TypeToken<List<Hotel>> token = new TypeToken<List<Hotel>>() {};
            List<Hotel> hotels = gson.fromJson(br, token.getType());

            return hotels;

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }




}