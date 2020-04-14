package hotel.Controllers;

import hotel.Entities.Room;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
    @FXML
    private TextField  personNameTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private Button bookRoomButton;

    private JSONArray bookingList = new JSONArray();
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


    /**
     * Bætir booking við selectedroom en geymir ekki á milli scene
     * TODO Mögulega vista room/hotel í json skjalinu með Gson? Veit ekki hversu erfitt það er
     */
    public void bookRoomAction(){
        String personName = personNameTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String email = emailTextField.getText();
        String startDate = startDatePicker.getValue().toString();
        String endDate = endDatePicker.getValue().toString();
        this.selectedRoom.addBooking(personName, email, phoneNumber, startDate, endDate);
        System.out.println("kallad a fall");

        JSONObject BookingDetails = new JSONObject();
        BookingDetails.put("personName", personName);
        BookingDetails.put("phoneNumber", phoneNumber);
        BookingDetails.put("email",email);
        BookingDetails.put("startDate",startDate);
        BookingDetails.put("endDate",endDate);
        BookingDetails.put("roomID",this.selectedRoom.getRoomID());

        JSONObject bookingObject = new JSONObject();
        bookingObject.put("booking", BookingDetails);

        //Add employees to list
        bookingList=lesabokanir();
        bookingList.add(bookingObject);

        //Write JSON file
        try (FileWriter file = new FileWriter("bookingData.json")) {

            file.write(bookingList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setupDatePickers(){
        //Set up the date pickers
        startDatePicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                this.setDisable(false);
                this.setTextFill(Color.BLACK);
                // Disable all booked dates and color red
                List<LocalDate> dates = selectedRoom.getBookedDates2();
                for (LocalDate localDate: dates) {
                    System.out.println(localDate);
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
                List<LocalDate> dates = selectedRoom.getBookedDates2();
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

    public void initialize(){
        setupDatePickers();

        // Passar að búið sé að velja gildi
        BooleanBinding bb = new BooleanBinding() {
            {
                super.bind(personNameTextField.textProperty(),
                        phoneNumberTextField.textProperty(), emailTextField.textProperty(),
                        startDatePicker.valueProperty(), endDatePicker.valueProperty());
            }

            @Override
            protected boolean computeValue() {
                return (personNameTextField.getText().isEmpty()
                        || phoneNumberTextField.getText().isEmpty()
                        || emailTextField.getText().isEmpty()
                        || startDatePicker.getValue() == null
                        || endDatePicker.getValue() == null );
            }
        };
        bookRoomButton.disableProperty().bind(bb);

        // force the field to be numeric only
        phoneNumberTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    phoneNumberTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
    public JSONArray lesabokanir(){
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("bookingData.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray BookingList = (JSONArray) obj;
            System.out.println(BookingList);
            return BookingList;
          

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
