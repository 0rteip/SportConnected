package view.messagedialog;

import model.message.Message;
import view.View;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Utility classes for message dialogs.
 */
public final class MessageDialog {

    private static final int MARGIN = 6;

    private MessageDialog() {
    }

    /**
     * Create a MessageDialog.
     * 
     * @param owner
     *                stageOwner
     * @param message
     *                Message
     * @param view
     *                view
     */
    public static void showMessageDialog(final Stage owner, final Message message, final View view) {
        final Stage s = new Stage();
        s.initOwner(owner);
        s.initModality(Modality.APPLICATION_MODAL);

        final Label label = new Label(message.toString());
        final Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> {
            s.close();
        });

        final BorderPane root = new BorderPane();
        root.setCenter(label);
        root.setBottom(closeButton);
        BorderPane.setMargin(closeButton, new Insets(MARGIN));
        BorderPane.setMargin(label, new Insets(MARGIN));
        BorderPane.setAlignment(closeButton, Pos.BOTTOM_CENTER);

        final Scene scene = new Scene(root);
        s.setScene(scene);
        s.setTitle(message.getType().getTitle());
        s.show();
    }
}
