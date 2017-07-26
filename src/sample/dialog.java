package sample;

/**
 * Created by ahmed on 7/26/2017.
 */

import javafx.scene.control.Alert;

/**
 * @author programmer
 */
public class dialog {

    public dialog(Alert.AlertType type, String title, String content) {

        Alert dialog = new Alert(type);
        dialog.setResizable(false);

        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(content);
        dialog.showAndWait();
    }
}
