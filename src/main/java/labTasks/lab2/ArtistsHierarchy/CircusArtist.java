package labTasks.lab2.ArtistsHierarchy;

import controllers.ConsoleController;

public class CircusArtist extends Artist implements GuestPerformer {
    public void performInCircusArena() {
        ConsoleController.println("CircusArtist | performInCircusArena");
    }

    @Override
    public void tour() {
        ConsoleController.println("CircusArtist GuestPerformer | tour");
    }

    @Override
    public void performInConcert() {
        ConsoleController.println("CircusArtist Performer | performInConcert");
    }
}
