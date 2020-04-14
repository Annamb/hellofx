package hotel.Controllers;

import hotel.Entities.Hotel;
import hotel.Entities.HotelRegistry;
import hotel.Leitarskilyrdi;
import hotel.leit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
    @FXML
    private ComboBox<String> stjornurBox;
    @FXML
    private ComboBox<String> baerBox;
    @FXML
    private ComboBox<String> numGuestBox;
    @FXML
    private TextField leitTextField;

    HotelPageController hotelPageController;
    private Leitarskilyrdi leitarskilyrdi;
    private leit hotelleit;
    private List<Hotel> hotels;
    private boolean stjornurVal,cityVal,leitarstrengurVal,numGuestVal;
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
        hotels =  hotelRegistry.getHotelList();
        hotelListView.getItems().addAll(hotels);

        leitarskilyrdi = new Leitarskilyrdi();
        hotelleit = new leit();

        stjornurBox.getItems().removeAll(stjornurBox.getItems());
        stjornurBox.getItems().addAll("1", "2", "3", "4", "5");
        stjornurBox.getSelectionModel().select(4);
        stjornurVal=false;

        baerBox.getItems().removeAll(baerBox.getItems());
        baerBox.getItems().addAll("Reykjavik","Kopavogur");
        baerBox.getSelectionModel().select(0);
        cityVal=false;

        numGuestBox.getItems().removeAll(numGuestBox.getItems());
        numGuestBox.getItems().addAll("1","2","3","4","5","6");
        numGuestBox.getSelectionModel().select(0);
        leitarstrengurVal=true;
        numGuestVal=false;
    }

    public void stjornurBoxHandler(javafx.event.ActionEvent actionEvent) {
        Object selectedItem = stjornurBox.getValue();
        leitarskilyrdi.setStars(Integer.parseInt(selectedItem.toString()));
        stjornurVal=true;
    }

    public void baerBoxHandler(ActionEvent actionEvent) {
        Object selectedItem = baerBox.getValue();
        leitarskilyrdi.setCity(selectedItem.toString());
        cityVal=true;
    }

    public void numGuestBoxHandler(ActionEvent actionEvent) {
        Object selectedItem = numGuestBox.getValue();
        leitarskilyrdi.setNumGuest(Integer.parseInt(selectedItem.toString()));
        numGuestVal=true;
    }

    public void leitaButtonHandler(ActionEvent actionEvent) {
        String leitarstrengur = leitTextField.getText();
        System.out.println(leitarstrengur);
        if(leitarstrengur.isEmpty()){
            leitarstrengurVal=false;
        }

        leitarskilyrdi.setLeitarstrengur(leitarstrengur);

        hotels = hotelleit.leitaHotel(leitarskilyrdi,stjornurVal,cityVal,leitarstrengurVal,numGuestVal);

        hotelListView.getItems().clear();

        hotelListView.getItems().addAll(hotels);

    }
    public void hreinsaButtonHandler(ActionEvent actionEvent){
        hotels = hotelleit.leitaHotel(leitarskilyrdi,false,false,false,false);
        hotelListView.getItems().clear();
        hotelListView.getItems().addAll(hotels);
        System.out.println("leit hreinsud");
    }
}