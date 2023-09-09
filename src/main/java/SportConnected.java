import controller.Controller;
import controller.ControllerImpl;
import javafx.application.Application;
import javafx.stage.Stage;
import view.View;
import view.ViewImpl;

/**
 * Application.
 */
public class SportConnected extends Application {

    @Override
    public final void start(final Stage primaryStage) throws Exception {
        final View view = new ViewImpl(primaryStage);
        final Controller controller = new ControllerImpl(view);
        view.start(controller);
    }

    /**
     * Entry point for the App.
     * 
     * @param args
     *             passed to launch
     */
    public static void main(final String[] args) {
        launch(args);
    }
}
