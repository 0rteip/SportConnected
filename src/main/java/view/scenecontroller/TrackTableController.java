package view.scenecontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TrackTableController extends AbstractSceneController {

    @FXML
    private TableView<Object> percTable;
    @FXML
    private Tab addPercPage;
    @FXML
    private TextArea percDescArea;
    @FXML
    private TextField namePercField;
    @FXML
    private Button loadTrackButton;
    @FXML
    private Button addTrackButton;
    @FXML
    private Label trackLabel;

    @FXML
    private void loadTrack() {}

    @FXML
    private void addPerc(){}
}
