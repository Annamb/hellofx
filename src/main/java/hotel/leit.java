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

    public List<Hotel> leitaHotel(Leitarskilyrdi h,Boolean stjornur,Boolean city,Boolean leitarstrengur){
        List<Hotel> myList = new ArrayList();
        List<Hotel> hotel = hotelRegistry.getHotelList();

        for (int i = 0; i < hotel.size(); i++) {
            if(stjornur==true && city==true && leitarstrengur==true){
            if(hotel.get(i).getStars() == h.getStars()
                    && hotel.get(i).getCity().equals(h.getCity())
                    && hotel.get(i).getHotelName().contains(h.getLeitarstrengur().toString())){

                myList.add(hotel.get(i));
            }}
            if(stjornur==true && city==true && leitarstrengur==false){
                if(hotel.get(i).getStars() == h.getStars()
                        && hotel.get(i).getCity().equals(h.getCity())){
                    myList.add(hotel.get(i));
                }}

            if(stjornur==false && city==true && leitarstrengur==true){
                if(hotel.get(i).getCity().equals(h.getCity())
                        && hotel.get(i).getHotelName().contains(h.getLeitarstrengur().toString())){
                    myList.add(hotel.get(i));
                }}
            if(stjornur==false && city==true && leitarstrengur==false){
                if(hotel.get(i).getCity().equals(h.getCity())){
                    myList.add(hotel.get(i));
                }}

            if(stjornur==true && city==false && leitarstrengur==true){
                if(hotel.get(i).getStars() == h.getStars()
                        && hotel.get(i).getHotelName().contains(h.getLeitarstrengur().toString())){
                    myList.add(hotel.get(i));
                }}
            if(stjornur==true && city==false && leitarstrengur==false){
                if(hotel.get(i).getStars() == h.getStars()){
                    myList.add(hotel.get(i));
                }}
            if(stjornur==false && city==false && leitarstrengur==true){
                if(hotel.get(i).getHotelName().contains(h.getLeitarstrengur().toString())){
                    myList.add(hotel.get(i));
                }}

        }
        //System.out.println(hotel.get(0).getHotelName().contains(h.getLeitarstrengur()));
        //System.out.println(hotel.get(0));
        //System.out.println(h.getLeitarstrengur());
        /*if(leitarstrengur==true){
        for (int i = 0; i < hotel.size(); i++) {
            if(hotel.get(i).getHotelName().contains(h.getLeitarstrengur().toString())){
                System.out.println(hotel.get(i).getHotelName().contains(h.getLeitarstrengur()));
                myList.add(hotel.get(i));
            }
        }}*/
        return myList;
    }
}
