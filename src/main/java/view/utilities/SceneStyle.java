package view.utilities;

/**
 * Enumeration of scenes.
 */
public enum SceneStyle {

    /**
     * Initial menu scene.
     */
    INITIALMENU("Initial Menu", "layouts/sportConnected.fxml"),;

    private final String fxmlFile;
    private final String title;

    SceneStyle(final String title, final String fxmlFile) {
        this.title = title;
        this.fxmlFile = fxmlFile;
    }

    /**
     * @return the fxml file of the scene
     */
    public String getFxmlFile() {
        return this.fxmlFile;
    }

    /**
     * @return the fxml path of the scene
     */
    public String getTitle() {
        return this.title;
    }
}
