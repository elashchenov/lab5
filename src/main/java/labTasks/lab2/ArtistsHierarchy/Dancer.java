package labTasks.lab2.ArtistsHierarchy;

import controllers.ConsoleController;

public class Dancer extends Artist implements Performer {
    public void dance() {
        ConsoleController.println("Dancer | dance");
    }

    @Override
    public void performInConcert() {
        ConsoleController.println("Dancer Performer | performInConcert");
    }
}
