package hotel.Controllers;

import hotel.Entities.Hotel;
import hotel.Entities.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.colorchooser.DefaultColorSelectionModel;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class BookingPageController {
    private Room selectedRoom;
    @FXML
    private Label bookingTitleLabel;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;

    /**
     * Initialize selected Hotel
     * @param room
     */
    public void initData(Room room){
        this.selectedRoom = room;
        bookingTitleLabel.setText("Book room at " + selectedRoom.getHotelName() + "!");
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
                this.setDisable(false);
                this.setTextFill(Color.BLACK);
                // Disable all booked dates and color red
                List<LocalDate> dates = selectedRoom.getBookedDates();
                for (LocalDate localDate: dates) {
                    if (date.equals(localDate)){
                        this.setDisable(true);
                        this.setTextFill(Color.RED);
                    }
                }
                // Disable all previous date cells and color blue
                if (date.isBefore(LocalDate.now()))
                {
                    this.setTextFill(Color.BLUE);
                    this.setDisable(true);
                }
            }
        });
        startDatePicker.setEditable(false);
//        endDatePicker.setDayCellFactory(startDatePicker.getDayCellFactory());
        endDatePicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                this.setDisable(false);
                this.setTextFill(Color.BLACK);
                LocalDate startDate = startDatePicker.getValue();
                if (startDate == null) startDate = LocalDate.now();
                LocalDate maxEndDate = LocalDate.MAX;
                // Disable all booked dates
                List<LocalDate> dates = selectedRoom.getBookedDates();
                dates.sort(Comparator.naturalOrder());

                for (LocalDate bookedDate: dates) {
                    if (date.equals(bookedDate)){
                        this.setDisable(true);
                        this.setTextFill(Color.RED);
                    }
                    if ( bookedDate.isAfter(startDate) && bookedDate.isBefore(maxEndDate)) {
                        maxEndDate = bookedDate;
                    }
                }
                // Disable all date cells before start date
                if (date.isBefore(startDate))
                {
                    this.setTextFill(Color.BLUE);
                    this.setDisable(true);
                }
                // Disable all dates between start date and  next booked date
                if (date.isAfter(maxEndDate))
                {
                    this.setTextFill(Color.RED);
                    this.setDisable(true);
                }
            }
        });
    }
}
