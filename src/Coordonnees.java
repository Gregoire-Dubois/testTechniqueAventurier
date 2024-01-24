import java.io.IOException;
import java.util.ArrayList;

public class Coordonnees {

    // constructor by default
    public Coordonnees(){


    }

    protected ArrayList retrieveStartCoordinates() throws IOException {
        // call class Game
        Game game = new Game();
        ArrayList startPositions;
        boolean invalidStartCoordinates;

        do {
            System.out.println("Coordonnées du point de départ");
            startPositions = game.inputPositions();
            invalidStartCoordinates = !game.checkPositionsInMap(startPositions);

        } while (invalidStartCoordinates);

        return startPositions;
    }

    protected ArrayList retrieveEndCoordinates() throws IOException {
        // call class Game
        Game game = new Game();
        ArrayList endPositions;
        boolean invalidEndCoordinates;

        do {
            System.out.println("Coordonnées du point d'arrivée");
            endPositions = game.inputPositions();
            invalidEndCoordinates = !game.checkPositionsInMap(endPositions);

        } while (invalidEndCoordinates);

        return endPositions;
    }
}


