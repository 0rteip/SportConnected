package view.scenemanager;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import  model.message.Message;
import  view.utilities.SceneStyle;
import  view.View;
import  view.sceneloader.SceneLoader;
import  view.sceneloader.SceneLoaderImpl;
import javafx.stage.Stage;

/**
 * Class that manage the scene changing.
 */
public final class SceneManagerImpl implements SceneManager {

    private final SceneLoader sceneLoader;
    private final Stage stage;

    /**
     * Constructor that load menu scenes.
     * 
     * @param stage
     * @param view
     * 
     */
    // @formatter:off
    @SuppressFBWarnings(
        value = "EI_EXPOSE_REP2",
        justification = "We need to use the correct instance of The Stage the open the Scene in the correct way"
    )
    // @formatter:on
    public SceneManagerImpl(final Stage stage, final View view) {
        this.stage = stage;
        this.sceneLoader = new SceneLoaderImpl(view);
    }

    @Override
    public void openInitialMenu() {
        this.openScene(SceneStyle.INITIALMENU);
    }

    private void openScene(final SceneStyle sceneStyle) {
        this.sceneLoader.loadScene(sceneStyle, this.stage);
    }

    @Override
    public void openMessage(final Message message) {
        this.sceneLoader.openDialog(this.stage, message);
    }
}
