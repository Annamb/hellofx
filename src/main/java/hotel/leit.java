package hotel;

import hotel.Entities.Hotel;
import hotel.Entities.HotelRegistry;

import java.util.ArrayList;
import java.util.List;

public class leit {
    private HotelRegistry hotelRegistry;
    private List<Hotel> hotels;

    public leit() {
        hotelRegistry = new HotelRegistry();
    }

    public List<Hotel> leitaHotel(Leitarskilyrdi h,Boolean stjornur,Boolean city){
        List<Hotel> myList = new ArrayList();
        List<Hotel> hotel = hotelRegistry.getHotelList();

        for (int i = 0; i < hotel.size(); i++) {
            if(stjornur==true && city==true){
            if(hotel.get(i).getStars() == h.getStars() && hotel.get(i).getCity().equals(h.getCity())){
                myList.add(hotel.get(i));
            }}
            if(stjornur==false && city==true){
                if(hotel.get(i).getCity().equals(h.getCity())){
                    myList.add(hotel.get(i));
                }}
            if(stjornur==true && city==false){
                if(hotel.get(i).getStars() == h.getStars()){
                    myList.add(hotel.get(i));
                }}

}


        return myList;
    }
}
