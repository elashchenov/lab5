package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.DialogManager;
import utils.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskSelectionMenuController {
    @FXML
    private ChoiceBox<Task> tasksChoiceBox;
    @FXML
    private VBox initialParametersVBox;
    private List<String> programArguments = new ArrayList<>();
    private Stage console = null;


    public void initialize(List<Task> taskList) {
        initConsole();
        for (Task task : taskList) {
            tasksChoiceBox.getItems().add(task);
        }
        tasksChoiceBox.getSelectionModel().selectedItemProperty().addListener(observable -> selectTask());
        Platform.runLater(() -> tasksChoiceBox.getSelectionModel().select(0));
    }

    private void initConsole() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Console.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Stage stage = new Stage();
        stage.setTitle("Вывод");
        stage.setScene(new Scene(root));
        console = stage;
    }

    private void selectTask() {
        initialParametersVBox.getChildren().clear();
        programArguments.clear();
        Task selectedTask = tasksChoiceBox.getSelectionModel().getSelectedItem();
        if (selectedTask.getParameterTitles() == null) {
            initialParametersVBox.getChildren().add(new Label("Параметры отсутсвуют"));
            return;
        }
        for (String argTitle : selectedTask.getParameterTitles()) {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    getClass().getResource("/fxml/InitialParameterField.fxml")
            );
            AnchorPane root;
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            InitialParameterFieldController consoleController = fxmlLoader.getController();
            programArguments.add("");
            consoleController.initialize(argTitle, programArguments);
            initialParametersVBox.getChildren().add(root);
        }
    }

    @FXML
    private void runTask() {
        for (String string : programArguments) {
            if (string.isEmpty()) {
                DialogManager.showErrorDialog("Ошибка ввода", "Введите все начальные параметры");
                return;
            }
        }
        if (!ConsoleController.getBuf().getValue().isEmpty()) {
            ConsoleController.println("----------------------------------------------");
        }
        try {
            tasksChoiceBox.getSelectionModel().getSelectedItem().run(programArguments);
            console.show();
        } catch (NumberFormatException ex) {
            DialogManager.showErrorDialog("Ошибка ввода", "Начальные параметры введены неверно");
        }

    }
}
