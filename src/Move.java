import java.util.ArrayList;
import java.util.Scanner;

public class Move {
    // Constructor by default
    public Move(){


    }

    protected ArrayList retrieveDirection(){

        ArrayList<Character> listDirections = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Entrez une direction sous la forme : N S E O (ou 'q' pour quitter) : ");
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

}



