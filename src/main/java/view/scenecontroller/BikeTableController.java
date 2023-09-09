package view.scenecontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BikeTableController extends AbstractSceneController {

    @FXML
    private Button addBikeButton;
    @FXML
    private Button deleteBikeButton;
    @FXML
    private ChoiceBox<String> choiceBikeBox;
    @FXML
    private Tab addBikePage;
    @FXML
    private Tab deleteBikePage;
    @FXML
    private TableView<Object> bikeTable;
    @FXML
    private TextField deleteBikeNickField;
    @FXML
    private TextField deleteBikeUserField;
    @FXML
    private TextField modelNikeField;
    @FXML
    private TextField nameBikeField;
    @FXML
    private TextField nickBikeField;

    @FXML
    private void addBike() {
    }

    @FXML
    private void deleteBike() {
    }

}
