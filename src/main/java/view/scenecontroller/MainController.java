package view.scenecontroller;

import java.util.Objects;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import model.ConnectionProvider;

/**
 * Scene for settings.
 */
public final class MainController extends AbstractSceneController implements SceneInitializer {

    @FXML
    private TabPane tabPane;

    @FXML
    private UserTableController tabUtentiController;

    @FXML
    private ShoeTableController tabScarpeController;

    @FXML
    private BikeTableController tabBicicletteController;

    @FXML
    private ActivityTableController tabAttivitaController;

    @FXML
    private TrackTableController tabPercorsiController;

    @FXML
    private SegmentTableController tabSegmentiController;

    @FXML
    private CommentTableController tabCommentiController;

    final static String username = "root";
    final static String password = "password";
    final static String dbName = "SportConnected";
    
    final static ConnectionProvider conn = new ConnectionProvider(username, password, dbName);

    @FXML
    public void initialize() {
        Objects.requireNonNull(conn.getMySQLConnection());
        
        this.tabUtentiController.init(conn.getMySQLConnection());
        this.tabAttivitaController.init(conn.getMySQLConnection());
        this.tabScarpeController.init(conn.getMySQLConnection());
        this.tabBicicletteController.init(conn.getMySQLConnection());
        this.tabPercorsiController.init(conn.getMySQLConnection());
        this.tabSegmentiController.init(conn.getMySQLConnection());
        this.tabCommentiController.init(conn.getMySQLConnection());
    }

    public void init() {};
}
