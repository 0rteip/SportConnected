package view.scenecontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * Scene for settings.
 */
public final class MainController extends AbstractSceneController implements SceneInitializer {

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabUtenti;

    @FXML
    private Tab tabScarpe;

    @FXML
    private Tab tabBiciclette;

    @FXML
    private Tab tabAttivita;

    @FXML
    private Tab tabPercorsi;

    @FXML
    private Tab tabSegmenti;

    @FXML
    private Tab tabCommenti;

    @FXML
    private UserTableController userController;

    @FXML
    private ShoeTableController shoeController;

    @FXML
    private BikeTableController bikeController;

    @FXML
    private ActivityTableController activityController;

    @FXML
    private TrackTableController trackController;

    @FXML
    private SegmentTableController segmentController;

    @FXML
    private CommentTableController commentController;

    public void init() {
        
    }

    // @Override
    public void initializeScene() {
        // if (this.getView().isGameRunning()) {
        //     this.getView().startStop();
        // }
        // if (this.gameSpeedComboBox.getItems().isEmpty()) {
        //     this.gameSpeedComboBox.getItems().addAll(this.getView().getGameSettings().getGameSpeeds());
        //     this.gameSpeedComboBox.getSelectionModel()
        //             .select(this.getView().getGameSettings().getGameSpeed());
        //     this.pcs.addPropertyChangeListener(new GameSpeedObserver(this.getView()));
        // }
    }
}
