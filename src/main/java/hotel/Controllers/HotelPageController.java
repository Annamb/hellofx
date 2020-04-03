package hotel.Controllers;

import hotel.Entities.Hotel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HotelPageController {
    private Hotel selectedHotel;
    @FXML
    private Label hotelNameLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Button bookButton;

    public void initData(Hotel hotel){
        this.selectedHotel = hotel;
        hotelNameLabel.setText(selectedHotel.getHotelName());
        cityLabel.setText(selectedHotel.getCity());
        emailLabel.setText(selectedHotel.getEmailadress());
        addressLabel.setText(selectedHotel.getAddress());
    }

    public void handleBookRoom(){
        System.out.println("Button pressed");
    }
    public void initialize(){

    }
}
