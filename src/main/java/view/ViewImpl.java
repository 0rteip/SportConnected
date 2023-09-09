package view;

import javafx.stage.Stage;
import javafx.stage.Window;
import settings.windowsettings.WindowSettings;
import settings.windowsettings.WindowSettingsImpl;
import view.scenemanager.SceneManager;
import view.scenemanager.SceneManagerImpl;

/**
 * View Impl.
 */
public class ViewImpl implements View {

    private final WindowSettings settings = new WindowSettingsImpl();
    private final SceneManager manager;
    private final Stage stage;

    /**
     * Creates a VIewImpl.
     * 
     * @param stage
     *              stage
     */
    public ViewImpl(final Stage primaryStage) {
        this.stage = primaryStage;
        this.manager = new SceneManagerImpl(primaryStage, this);
    }

    @Override
    public void start() {
        System.out.println("Avvio");
        this.manager.openInitialMenu();
    }

    @Override
    public WindowSettings getWindowSettings() {
        return this.settings;
    }

    @Override
    public SceneManager getSceneManager() {
        return this.manager;
    }

    @Override
    public Window getStage() {
        return stage;
    }

    
}
