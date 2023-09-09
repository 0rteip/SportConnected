package view.scenecontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UserTableController extends AbstractSceneController {

    @FXML
    private TextField userIdTotalActivityField;
    @FXML
    private TextField userIdFollowField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField provField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField heightField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField deleteField;
    @FXML
    private TextField deleteUserField;
    @FXML
    private TextField cityField;
    @FXML
    private TextArea bioArea;
    @FXML
    private TableView<Object> userTable;
    @FXML
    private Tab operationPage;
    @FXML
    private Tab deleteUserPage;
    @FXML
    private Tab addUserPage;
    @FXML
    private Label photoLabel;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button visualizeTotalDiistanceButton;
    @FXML
    private Button visualizeFollowActivitiesButton;
    @FXML
    private Button loadPhotoButton;
    @FXML
    private Button deleteUser;
    @FXML
    private Button addUserButton;

    @FXML
    private void loadPhoto(){}

    @FXML
    private void deleteUser(){}

    @FXML
    private void visualizeActivities(){}

    @FXML
    private void addUser(){}

    @FXML
    private void visualizeTotalDistance(){}

    public void init() {

    }
}
