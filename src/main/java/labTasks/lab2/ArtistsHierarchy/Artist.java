package labTasks.lab2.ArtistsHierarchy;

import controllers.ConsoleController;

public class Artist {
    public void workForPublic() {
        ConsoleController.println(this.getClass().getSimpleName() + " Artist | workForPublic");
    }
}
