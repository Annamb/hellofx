package hotel.vinnsla;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
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
            BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/Data/hotelgogn.json")));
//            BufferedReader br = new BufferedReader(new FileReader(new File("/Data/hotelgogn.json")));

            TypeToken<List<Hotel>> token = new TypeToken<List<Hotel>>() {};
            List<Hotel> hotels = gson.fromJson(br, token.getType());

            return hotels;

        } finally {

        }
    }




}