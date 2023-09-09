package view.sceneloader;

import  model.message.Message;
import  view.utilities.SceneStyle;
import javafx.stage.Stage;

/**
 * An interface for loading scene.
 */
public interface SceneLoader {

    /**
     * @param sceneStyle
     *                   the scene to be loaded
     * @param stage
     *                   current stage
     */
    void loadScene(SceneStyle sceneStyle, Stage stage);

    /**
     * Open a dialog.
     * 
     * @param stage
     *                stage
     * @param message
     *                message
     * @param latch
     *                CountDownLatch
     */
    void openDialog(Stage stage, Message message);
}
