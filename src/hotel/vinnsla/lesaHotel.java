package hotel.vinnsla;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import hotel.vinnsla.Hotel;


/**
 *  Lesa inn lista af Hótelum
 * @author annam
 */
public class lesaHotel {
    
    public List<Hotel> lesaHotel(){

	Gson gson = new Gson();
   
        try {

            BufferedReader br = new BufferedReader(new FileReader("src/hotel/vinnsla/hotelgogn.json"));

            TypeToken<List<Hotel>> token = new TypeToken<List<Hotel>>() {};
            List<Hotel> hotel = gson.fromJson(br, token.getType());

            return hotel;

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}