package labTasks.lab2;

import controllers.ConsoleController;
import labTasks.lab2.ArtistsHierarchy.*;

public class ArtistManager {
    public static void useArtistsHierarchyMethods() {
        CircusArtist circusArtist = new CircusArtist();
        Dancer dancer = new Dancer();
        circusArtist.performInConcert();
        circusArtist.tour();
        circusArtist.performInCircusArena();
        dancer.dance();
        dancer.workForPublic();

        ConsoleController.println("\n");
        Artist[] artists = {circusArtist, dancer};
        for (Artist artist : artists) {
            artist.workForPublic();
        }
        Performer[] performers = {circusArtist, dancer};
        for (Performer performer : performers) {
            performer.performInConcert();
        }
        circusArtist.performInCircusArena();
        circusArtist.tour();
        dancer.dance();


    }
}
