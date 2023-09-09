package view.scenecontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ShoeTableController extends AbstractSceneController {

    @FXML
    private Button addShoeButton;
    @FXML
    private Button deleteShoeButton;
    @FXML
    private ChoiceBox<String> choiceShoeBox;
    @FXML
    private Tab addShoePage;
    @FXML
    private Tab deleteShoePage;
    @FXML
    private TableView<Object> shoeTable;
    @FXML
    private TextField deleteShoeNickField;
    @FXML
    private TextField deleteShoeUserField;
    @FXML
    private TextField modelShoeField;
    @FXML
    private TextField nameShoeField;
    @FXML
    private TextField nickShoeField;

    @FXML
    private void addShoe() {
    }

    @FXML
    private void deleteShoe() {
    }

}
