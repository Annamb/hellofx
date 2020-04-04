package hotel.Controllers;

import hotel.Entities.Hotel;
import hotel.Entities.HotelRegistry;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MainController {
    private HotelRegistry hotelRegistry;
    @FXML
    private Label hotelListLabel;
    @FXML
    private ListView<Hotel> hotelListView;
    HotelPageController hotelPageController;

    /**
     * Goes to the hotel page of the selected hotel
     * @param event
     * @throws IOException
     */
    public void handleMouseClick(MouseEvent event) throws IOException {
        Hotel clickedHotel = hotelListView.getSelectionModel().getSelectedItem();
        if (clickedHotel != null){
            System.out.println("Clicked on " + clickedHotel);


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/hotelPage.fxml"));
            Parent hotelListViewParent = loader.load();

            Scene hotelListViewScene = new Scene(hotelListViewParent);

            //access the controller and call a method
            hotelPageController = loader.getController();
            hotelPageController.initData(clickedHotel);

            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(hotelListViewScene);
            window.show();
        }

    }

    /**
     * Initialize controller, fetch list of hotels and show
     */
    public void initialize() {
        hotelRegistry = new HotelRegistry();
        hotelListLabel.setText("List of Hotels!" );
        List<Hotel> hotels =  hotelRegistry.getHotelList();
        hotelListView.getItems().addAll(hotels);
    }
}