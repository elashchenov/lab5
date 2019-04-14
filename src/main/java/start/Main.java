package start;

import controllers.TaskSelectionMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import labTasks.lab1.MoneyDoublingCounter;
import labTasks.lab2.ArtistManager;
import labTasks.lab3.FibonacciPairGenerator;
import labTasks.lab4.Conveyor;
import utils.Task;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TaskSelectionMenu.fxml"));
        Parent root = loader.load();
        TaskSelectionMenuController controller = loader.getController();
        controller.initialize(getTasks());
        primaryStage.setResizable(false);
        primaryStage.setTitle("Выбор задания");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private List<Task> getTasks() {
        Task task1 = new Task(
                "Подсчет денег в банке",
                Arrays.asList("Начальная сумма", "Процент"),
                (args) -> MoneyDoublingCounter.calculate(
                        Double.parseDouble(args.get(0)),
                        Double.parseDouble(args.get(1))
                )
        );
        Task task2 = new Task(
                "Демонстрация иерархии классов",
                null,
                (args) -> ArtistManager.useArtistsHierarchyMethods()
        );
        Task task3 = new Task(
                "Генерация чисел Фибоначчи",
                Collections.singletonList("Количество повторений"),
                (args) -> new FibonacciPairGenerator().generate(
                        Integer.parseUnsignedInt(args.get(0))
                )
        );
        Task task4 = new Task(
                "Конвейер",
                Arrays.asList("Количество рабочих", "Количество деталей"),
                (args) -> new Conveyor(
                        Integer.parseUnsignedInt(args.get(0)),
                        Integer.parseUnsignedInt(args.get(1))
                ).run()
        );
        return Arrays.asList(task1, task2, task3, task4);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.exit(0);
    }
}
