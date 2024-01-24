import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    // Constructor by default
    public Game(){

    }
    /*Get positions with input
    * If positions are OK continue
    * If int are bigger or smaller than array, make info to user
    * */
    protected ArrayList inputPositions(){

        ArrayList positions = new ArrayList<>();

        try{
            Scanner scannerXPositionStart = new Scanner(System.in);
            System.out.println("Entrez les coordonnées de X situées entre 0 à 19 inclus)");
            System.out.println("Exemple : 2  -> ");
            int inputX = scannerXPositionStart.nextInt();

            Scanner scannerYPositionStart = new Scanner(System.in);
            System.out.println("Entrez les coordonnées de Y situées entre 0 à 19 inclus");
            System.out.println("Exemple : 10  -> ");
            int inputY = scannerYPositionStart.nextInt();

            if (inputX >= 0 && inputX <= 19 && inputY >= 0 && inputY <= 19)  {
                positions.add(inputX);
                positions.add(inputY);

            } else {
                System.out.println("Les valeurs autorisées sont des nombres entiers entre 0 et 19 inclus");
            }

        }catch (InputMismatchException e){
            System.out.println("merci d'indiquer des nombres entiers");
        }
        return positions;
    }

    protected boolean checkPositionsInMap(ArrayList positions) throws IOException {
        // ici tester que les coordonnées saisies ne tombent pas sur des zones interdites
        // récupérer le tableau de données pour vérifier si les coordonnées sont # ou vides
        Boolean responsePosition = true;

        int xPosition = 0;
        int yPosition = 0;

        try{
            xPosition = (int) positions.get(0);
            yPosition = (int) positions.get(1);


        }catch (IndexOutOfBoundsException e){
            System.out.println("Seuls des nombres entiers situés entre 0 et 19 sont admis");
        }

        UseTextFile useTextFile = new UseTextFile();
        String map = useTextFile.readFileText();

        Character[][] topography = new Character[20][21];
        topography = useTextFile.mapMaker(map);

        // vérifier si la case est égale à # ou vide
        //System.out.println(topography[xPosition][yPosition]);

        if (topography[xPosition][yPosition] == '#'){
            System.out.println("===============================================================");
            System.out.println("Coordonnées impossibles, vous êtes dans la forêt impénétrable !");
            System.out.println("===============================================================");
            System.out.println();
            responsePosition = false;
        }
        return responsePosition;
    }
}
