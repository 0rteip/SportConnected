package view;

import controller.Controller;
import settings.windowsettings.WindowSettings;
import view.scenemanager.SceneManager;

/**
 * interface View.
 */
public interface View {

    /**
     * Start the application.
     * 
     * @param controller
     */
    void start(Controller controller);

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

}
