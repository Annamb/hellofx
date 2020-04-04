package hotel.Controllers;

import hotel.Entities.Hotel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 */
public class BookingPageController {
    private Hotel selectedHotel;
    @FXML
    private Label bookingTitleLabel;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;

    /**
     * Initialize selected Hotel
     * @param hotel
     */
    public void initData(Hotel hotel){
        this.selectedHotel = hotel;
        bookingTitleLabel.setText("Book room at " + selectedHotel.getHotelName() + "!");
    }

    /**
     * Go back to home screen when clicking back button
     * @param event
     */
    public void handleBackClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main.fxml"));
        Parent mainViewParent = loader.load();

        Scene mainViewScene = new Scene(mainViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainViewScene);
        window.show();
    }

    public void initialize(){
        //Set up the date pickers
        startDatePicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                // Disable all previous date cells
                if (date.isBefore(LocalDate.now()))
                {
                    this.setDisable(true);
                }
            }
        });
        startDatePicker.setEditable(false);
        endDatePicker.setDayCellFactory(startDatePicker.getDayCellFactory());
    }
}
