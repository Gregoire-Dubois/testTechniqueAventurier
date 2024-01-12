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
            System.out.println("Entrez la valeur du point de départ (X entre 0 à 19 inclus uniquement)");
            System.out.println("Exemple : 2  -> ");
            int inputX = scannerXPositionStart.nextInt();

            Scanner scannerYPositionStart = new Scanner(System.in);
            System.out.println("Entrez la valeur du point de départ (Y prévue entre 0 à 19 inclus uniquement)");
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

    protected void checkPositionsInMap(ArrayList positions,UseTextFile arrayMaker){
        // ici tester que les coordonées saisies ne tombent pas sur des zones interdites

        int xPosition = (int) positions.get(0);
        int yPosition = (int) positions.get(1);





        System.out.println(xPosition);
        System.out.println(yPosition);

    }
}
