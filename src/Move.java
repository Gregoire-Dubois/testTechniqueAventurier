import java.util.ArrayList;
import java.util.Scanner;

public class Move {
    // Constructor by default
    public Move(){


    }

    protected ArrayList retrieveDirections(){

        ArrayList<Character> listDirections = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Entrez les caps à suivre sous la forme : N S E O (ou 'q' pour quitter) : ");
            String input = scanner.nextLine();
            if (input.equals("q")) {
                break;
            }
            // Vérifier si l'entrée a une longueur d'un seul caractère
            if (input.length() == 1) {
                if ("NSEO".contains(input.toUpperCase())) {
                    listDirections.add(input.toUpperCase().charAt(0));
                } else {
                    System.out.println("Seules les valeurs N, S, E ou O sont admises");
                }
            } else {
                System.out.println("Veuillez entrer une seule lettre pour la direction.");
            }
        }
        return listDirections;
    }

    // réaliser les déplacements du joueur
    protected void movePlayer(ArrayList startPoint, ArrayList endPoint,  ArrayList directions, String map){
        // charger la map aussi en paramètres ?

        // récupération des coordonnées de départ
        int startX = (int) startPoint.get(0);
        int startY = (int) startPoint.get(1);

        // récupération des coordonnées d'arrivées
        int endX = (int) endPoint.get(0);
        int endY = (int) endPoint.get(1);

        for (int i = 0; i< directions.size(); i++){
            Character orientation = (Character) directions.get(i);
            switch (orientation){
                case 'N' :
                    //cap au nord = x actuel, y-1

                    break;
                case 'S' :
                    //cap au sud = x actuel, y+1


                    break;
                case 'E' :
                    //cap à l'est = x+1, y actuel


                    break;
                case 'O' :
                    //cap à l'ouest x-1, y actuel

                    break;
            }
        }
        System.out.println(map);
    }
}

