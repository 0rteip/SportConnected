package view.scenecontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SegmentTableController extends AbstractSceneController {

    @FXML
    private Button addSegmentButton;
    @FXML
    private Button loadSegmentButton;
    @FXML
    private Button visualizeTopOnSegmentButton;
    @FXML
    private Button visualizeTopSegmentButton;
    @FXML
    private CheckBox privateSegmCheck;
    @FXML
    private ChoiceBox<Integer> choiceIdSport;
    @FXML
    private ChoiceBox<Integer> choiceIdSegment;
    @FXML
    private Label segmentLabel;
    @FXML
    private Tab addSegmentTab;
    @FXML
    private Tab operationSegmentTab;
    @FXML
    private TableView<Object> segmentTable;
    @FXML
    private TextField nameSegmentField;
    @FXML
    private TextField userIdSegmenField;
    @FXML
    private TextField userIdTopField;

    @FXML
    private void loadSegment() {
    }

    @FXML
    private void addSegment() {
    }

    @FXML
    private void visualizeTopSegment() {
    }

    @FXML
    private void visualizeTopOnSegment() {
    }

}
