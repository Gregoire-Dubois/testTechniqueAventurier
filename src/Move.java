import java.util.ArrayList;
import java.util.Scanner;

public class Move {
    // Constructor by default
    public Move() {


    }

    protected ArrayList retrieveDirections() {

        ArrayList<Character> listDirections = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Entrez les caps à suivre sous la forme : N S E O (ou 'q' pour quitter) : ");
            String input = scanner.nextLine();
            if (input.equals("q")) {
                break;
            }
            // Check if input is 1 character
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

    // to move player
    protected void movePlayer(ArrayList startPoint, ArrayList endPoint, ArrayList directions, Character[][] map) {
        // Get start positionnate
        int startX = (int) startPoint.get(0);
        int startY = (int) startPoint.get(1);

        // get end position
        int endX = (int) endPoint.get(0);
        int endY = (int) endPoint.get(1);

        // Intermediate point to move player box by box
        int intermediatePointX = startX;
        int intermediatePointY = startY;

        for (int i = 1; i < directions.size(); i++) {

            Character orientation = (Character) directions.get(i);

            switch (orientation) {
                case 'N':
                    // nord = x actuel, y actuel-1
                    intermediatePointX  -= 1;
                    break;

                case 'S':
                    // sud = x actuel, y actuel +1
                    intermediatePointX += 1;
                    break;

                case 'E':
                    //l'est = x actuel +1, y actuel
                    intermediatePointY += 1;
                    break;

                case 'O':
                    //l'ouest = x actuel -1, y actuel
                    intermediatePointY -= 1;
                    break;
            }

            // If intermediate position equal arrival position -> It's win
            if (intermediatePointX == endX && intermediatePointY == endY){
                System.out.println("Gagné :) ");
                break;
            }

            // Check if intermediate position is in map
            if (intermediatePointX < 0 || intermediatePointX >= map.length
                    || intermediatePointY < 0 || intermediatePointY >= map.length) {
                // intermediate position out of map => game over
                System.out.println("Perdu, votre cap vous a fait sortir de la carte :( ");
                break;
            }

            // Check if player go in forbiden area
            Character[][] forest = new Character[20][21];
            forest = map;
            char tree = '#';
            if (forest[intermediatePointX][intermediatePointY] == tree){
                System.out.println("Perdu, votre parcours traverse la forêt impénétrable :( ");
                break;
            }
        }
    }
}
