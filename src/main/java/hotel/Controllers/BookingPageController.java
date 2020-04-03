package hotel.Controllers;

import hotel.Entities.Hotel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BookingPageController {
    private Hotel selectedHotel;
    @FXML
    private Label bookingTitleLabel;

    public void initData(Hotel hotel){
        selectedHotel = hotel;
        bookingTitleLabel.setText("Book room at " + selectedHotel.getHotelName() + "!");
    }

    public void initialize(){
    }
}
