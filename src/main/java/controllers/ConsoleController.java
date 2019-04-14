package controllers;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import lombok.Getter;

public class ConsoleController {
    @FXML
    private TextArea resultTextArea;
    @Getter
    private static StringProperty buf = new SimpleStringProperty("");

    @FXML
    private void initialize() {
        resultTextArea.textProperty().bind(buf);
    }

    @FXML
    public void clearConsole() {
        buf.set("");
    }

    public static void println(String string) {
        Platform.runLater(() -> buf.setValue(buf.getValue() + string + '\n'));
    }
}
