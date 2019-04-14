package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class InitialParameterFieldController {
    @FXML
    private Label titleLabel;
    @FXML
    private TextField textField;

    void initialize(String title, List<String> programArgument) {
        titleLabel.setText(title);
        int argIdx = programArgument.size() - 1;
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                programArgument.set(argIdx, newValue);
            }
        });
    }
}
