package view;

import javafx.stage.Window;
import settings.windowsettings.WindowSettings;
import view.scenemanager.SceneManager;

/**
 * interface View.
 */
public interface View {

    /**
     * Start the application.
     * 
     */
    void start();

    /**
     * Returns the {@link WindowSettings}.
     * 
     * @return
     *         WindowSettings
     */
    WindowSettings getWindowSettings();


    /**
     * Returns the {@link SceneManager}.
     * 
     * @return
     *         SceneManager
     */
    SceneManager getSceneManager();

    Window getStage();

}
