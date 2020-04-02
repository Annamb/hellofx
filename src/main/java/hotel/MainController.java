package hotel;

import hotel.vinnsla.Hotel;
import hotel.vinnsla.HotelRegistry;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.List;

public class MainController {
    private HotelRegistry hotelRegistry;
    @FXML
    private Label hotelListLabel;
    @FXML
    private ListView<String> hotelListView;

    public void initialize() {
//        String javaVersion = System.getProperty("java.version");
//        String javafxVersion = System.getProperty("javafx.version");
        hotelRegistry = new HotelRegistry();
        hotelListLabel.setText("List of Hotels!" );
        List<Hotel> hotels =  hotelRegistry.getHotelList();
        for (Hotel hotel: hotels) {
//            System.out.println(hotel.getHotelName());
            hotelListView.getItems().addAll(hotel.getHotelName());
        }
    }
}