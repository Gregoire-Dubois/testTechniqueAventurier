import java.io.IOException;
import java.util.ArrayList;

public class Coordonnees {

    // constructor by default
    public Coordonnees(){


    }

    protected ArrayList retrieveStartCoordinates() throws IOException {
        // call class Game
        Game game = new Game();

        System.out.println("Coordonnées du point de départ");
        ArrayList startPositions;
        do {
            startPositions = game.inputPositions();
            // Check if start position is OK
            if (!game.checkPositionsInMap(startPositions)) {
                System.out.println("Coordonnées du point de départ");
            }
        } while (!game.checkPositionsInMap(startPositions));

        return startPositions;

    }

    protected ArrayList retrieveEndCorrdinates() throws IOException {
        // call class Game
        Game game = new Game();

        System.out.println("Coordonnées du point d'arrivée");
        ArrayList endPositions;

        do {
            endPositions = game.inputPositions();
            // Check if arrival position is OK
            if (!game.checkPositionsInMap(endPositions)) {
                System.out.println("Coordonnées du point d'arrivée");
            }
        } while (!game.checkPositionsInMap(endPositions));

        return endPositions;
    }

}



/* TODO
* méthodes de tests pour les dépassements de tableaux au lieu d'une gestion par ArrayList)
* */

