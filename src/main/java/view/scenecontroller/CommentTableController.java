package view.scenecontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CommentTableController extends AbstractSceneController {

    @FXML
    private Button addCommentButton;
    @FXML
    private Button deleteCommentButton;
    @FXML
    private Tab addCommPage;
    @FXML
    private Tab deleteCOmmPage;
    @FXML
    private TableView<Object> commentTable;
    @FXML
    private TextArea textCommArea;
    @FXML
    private TextField anctivityCOmmField;
    @FXML
    private TextField deleteCommActivityField;
    @FXML
    private TextField deleteCommSportField;
    @FXML
    private TextField sportCommField;
    @FXML
    private TextField userIdCommField;

    @FXML
    private void addComment() {}
    @FXML
    private void deleteComment() {}
    
    
    
}
