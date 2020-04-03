package hotel.Controllers;

import hotel.Entities.Hotel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HotelPageController {
    private Hotel selectedHotel;
    private BookingPageController bookingPageController;
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

    public void handleBookRoom(ActionEvent event) throws IOException {
        System.out.println("Button pressed");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/bookingPage.fxml"));
        Parent hotelListViewParent = loader.load();

        Scene hotelListViewScene = new Scene(hotelListViewParent);

        //access the controller and call a method
        bookingPageController = loader.getController();
        bookingPageController.initData(this.selectedHotel);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(hotelListViewScene);
        window.show();
    }
    public void initialize(){

    }
}
