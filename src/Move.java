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
    protected void movePlayer(ArrayList directions){

        // ajouter le point de départ et d'arrivée en paramètres ?
        // charger la map aussi en paramètres ?
        for (int i = 0; i< directions.size(); i++){
            Character orientation = (Character) directions.get(i);
            switch (orientation){
                case 'N' :
                    //cap au nord = x0, y-1

                    break;
                case 'S' :
                    //cap au sud = x0, y+1


                    break;
                case 'E' :
                    //cap à l'est = x+1, y0


                    break;
                case 'O' :
                    //cap ç l'ouest x-1, y0

                    break;
            }
        }




    }

}

