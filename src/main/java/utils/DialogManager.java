package utils;

import javafx.scene.control.Alert;

public class DialogManager {
    public static void showErrorDialog(String title, String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeight(150);
        alert.setResizable(true);
        alert.setTitle(title);
        alert.setHeaderText("");
        alert.setContentText(text);
        alert.showAndWait();
    }
}
