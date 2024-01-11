import java.util.Scanner;

public class Game {
    // Constructor by default
    public Game(){

    }

    protected void testPositions(){
        Scanner scannerXPositionStart = new Scanner(System.in);
        System.out.println("Entrez la valeur du point de départ (X entre 0 à 19 inclus uniquement)");
        System.out.println("Exemple : 2  -> ");
        int inputX = scannerXPositionStart.nextInt();

        Scanner scannerYPositionStart = new Scanner(System.in);
        System.out.println("Entrez la valeur du point de départ (Y prévue entre 0 à 19 inclus uniquement)");
        System.out.println("Exemple : 10  -> ");
        int inputY = scannerXPositionStart.nextInt();

        // vérifications on input position's datas
        if (inputX >= 0 && inputX <= 19) {
            System.out.println("ok");
        } else {
            System.out.println("valeurs numériques hors tableau");
        }



    }




}
