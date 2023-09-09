package view.scenecontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Controller for activityTab.
 */
public class ActivityTableController extends AbstractSceneController {

    @FXML
    private TextField velMeanActivityField;
    @FXML
    private TextField titleActivityField;
    @FXML
    private TextField positiveActivityField;
    @FXML
    private TextField negativeActivityField;
    @FXML
    private TextField distanceActivityField;
    @FXML
    private TextField minSwimField;
    @FXML
    private TextField maxAltField;
    @FXML
    private TextField kalActivityField;
    @FXML
    private TextField deleteActivitySportField;
    @FXML
    private TextField deleteActivityActField;
    @FXML
    private TextField timeActivityField;
    @FXML
    private TableView<Object> activityTable;
    @FXML
    private Tab deleteActivityPage;
    @FXML
    private Tab addActivityPage;
    @FXML
    private Tab activityOperationPage;
    @FXML
    private DatePicker choiceToDate;
    @FXML
    private DatePicker choiceFromDate;
    @FXML
    private ChoiceBox<Integer> choiceTrackBox;
    @FXML
    private ChoiceBox<String> choiceSportBox;
    @FXML
    private ChoiceBox<String> activityChoiceBox;
    @FXML
    private CheckBox privateCheckBox;
    @FXML
    private Button visualizeActivityButton;
    @FXML
    private Button deleteActivityButton;

    @FXML
    private Button addActivity;

    @FXML
    private void deleteActivity() {
    }

    @FXML
    private void addShoe() {
    }

    @FXML
    private void visualizeActivity() {
    }

}
