package hotel.Controllers;

import hotel.Entities.Hotel;
import hotel.Entities.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

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
    private Label phoneNumberLabel;
    @FXML
    private Button bookButton;
    @FXML
    private TableColumn<Room, String> numGuestsColumn;
    @FXML
    private TableColumn<Room, String>  priceColumn;
    @FXML
    private TableColumn<Room, Boolean> minibarColumn;
    @FXML
    private TableColumn<Room, Boolean> wheelchairAccessColumn;
    @FXML
    private TableView<Room> tableView;

    /**
     * Initialize hotel data when going to specific hotel screen
     * @param hotel
     */
    public void initData(Hotel hotel){
        this.selectedHotel = hotel;
        hotelNameLabel.setText(selectedHotel.getHotelName());
        cityLabel.setText(selectedHotel.getCity());
        emailLabel.setText(selectedHotel.getEmailAddress());
        addressLabel.setText(selectedHotel.getAddress());
        phoneNumberLabel.setText(selectedHotel.getPhoneNumber());

        //set up the columns in the table
        numGuestsColumn.setCellValueFactory(new PropertyValueFactory<>("numGuests"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        minibarColumn.setCellValueFactory(new PropertyValueFactory<>("minibar"));
        // Birtir niðurstöður í töflu sem 'Yes' eða 'No' í stað True eða false
        minibarColumn.setCellFactory(col -> new TableCell<Room, Boolean>() {
            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty) ;
                setText(empty ? null : item.booleanValue() ? "Yes" : "No" );
            }
        });
        wheelchairAccessColumn.setCellValueFactory(new PropertyValueFactory<>("wheelchairAccess"));
        wheelchairAccessColumn.setCellFactory(minibarColumn.getCellFactory()); // Birtir 'yes' eða 'no'
        List<Room> rooms = selectedHotel.getHotelRooms();

        ObservableList<Room> roomsObservableList = FXCollections.observableArrayList(rooms);
        tableView.setItems(roomsObservableList);
    }

    /**
     * Makes sure user clicked on room before he goes to booking
     */
    public void userClickedOnTable(){
        Room selectedRoom = tableView.getSelectionModel().getSelectedItem();
        if(selectedRoom != null) this.bookButton.setDisable(false);
    }

    /**
     * Go to the booking screen
     * @param event
     * @throws IOException
     */
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

    /**
     * Go back to hotel list screen
     * @param event
     * @throws IOException
     */
    public void handleBackClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main.fxml"));
        Parent mainViewParent = loader.load();
        Scene mainViewScene = new Scene(mainViewParent);

        //access the controller and call a method
//        mainController = loader.getController();

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainViewScene);
        window.show();
    }
    public void initialize(){

    }
}
