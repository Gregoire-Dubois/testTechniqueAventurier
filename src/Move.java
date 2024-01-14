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
    protected void movePlayer(ArrayList startPoint, ArrayList endPoint, ArrayList directions, Character[][] map) {
        // récupération des coordonnées de départ
        int startX = (int) startPoint.get(0);
        int startY = (int) startPoint.get(1);

        // récupération des coordonnées d'arrivées
        int endX = (int) endPoint.get(0);
        int endY = (int) endPoint.get(1);

        // point intermediaire pour faire déplacer de case en case
        int intermediatePointX = startX;
        int intermediatePointY = startY;

        for (int i = 1; i < directions.size(); i++) {

            Character orientation = (Character) directions.get(i);

            switch (orientation) {
                case 'N':
                    //cap au nord = x actuel, y actuel-1
                    intermediatePointX  -= 1;
                    break;

                case 'S':
                    //cap au sud = x actuel, y actuel +1
                    intermediatePointX += 1;
                    break;

                case 'E':
                    //cap à l'est = x actuel +1, y actuel
                    intermediatePointY += 1;
                    break;

                case 'O':
                    //cap à l'ouest x actuel -1, y actuel
                    intermediatePointY -= 1;
                    break;
            }

            //si la position intermédiaire est égale à la position d'arrivée, le joueur a gagné
            if (intermediatePointX == endX && intermediatePointY == endY){
                System.out.println("Gagné :) ");
                break;
            }

            //vérifier si la position intermédiaire est à l'intérieur de la carte
            if (intermediatePointX < 0 || intermediatePointX >= map.length
                    || intermediatePointY < 0 || intermediatePointY >= map.length) {
                //position intermédiaire hors de la carte
                //perdu
                System.out.println("Perdu, votre cap vous a fait sortir de la carte :( ");
                break;
            }

            // Vérifier que le personnage ne passe pas sur des zones interdites
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
