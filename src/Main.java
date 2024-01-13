import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        // get informations in carte.txt
        UseTextFile useTextFile = new UseTextFile();
        String map = useTextFile.readFileText();

        // ajout des caractères dans un tableau bi-dimensionnel et l'afficher
        // Afficher tous les éléments dans arrayMaker et afficher la carte de jeu
         useTextFile.displayMap(map);

        // retieve start and end position with the user
        Game game = new Game();
        System.out.println("Coordonnées du point de départ");
        ArrayList startPositions;

        do {
            startPositions = game.inputPositions();
            // Vérifier si la position de départ est correcte sur la carte
            if (!game.checkPositionsInMap(startPositions)) {
                System.out.println("Coordonnées du point de départ");
            }
        } while (!game.checkPositionsInMap(startPositions));


        System.out.println("Coordonnées du point d'arrivée");
        ArrayList endPositions;

        do {
            endPositions = game.inputPositions();
            // Vérifier si la position d'arrivée est correcte sur la carte
            if (!game.checkPositionsInMap(endPositions)) {
                System.out.println("Coordonnées du point d'arrivée");
            }
        } while (!game.checkPositionsInMap(endPositions));

        Move move = new Move();
        move.retrieveDirection();
    }
}


/*
* 1) Ouvrir le fichier
* 2) Parcourir le fichier ligne par ligne
* 3) placer chaque caractère issus de chaque ligne du fichier dans un tableau
*   -> tableau à 2 dimensions
* 4) Afficher le tableau à 2 dimensions
* 5) Demander à l'utilisateur de saisir des coordonnés de départ et d'arrivée
*   -> Si coordonnées impossibles ou incorrectes faire une boucle pour demander de nouvelles coordonnées
*   -> Si coordonnées OK
*       -> Demander les coordonnées d'arrivée
*               -> Si coordonées impossibles ou incorrectes boucler pour demander d'autres coordonnées
*                   -> n'accepter que des valeurs numériques entre 0 et 19
*                   -> exclure les autres caractères
*
* 6) Demander les caps à suivre sous forme de 'char' : N S E O
*   -> exclure tout autre type de données entrées
*   -> Chaque char correspond à une case
*       -> Récupérer les caps sous forme de 'STR' exemple : 'NNSSEOSS'
*           -> Parcourir les caps 'char' par 'char'
*           -> N = -1 / S = +1 / E= +1 / O= -1
*
*       Placer chaque cap dans une arraysList
*           -> Pour chaque 'char', appliquer la valeur de déplacement horizontale / verticale
*               -> utilisation d'une boucle for pour appliquer les valeurs de déplacement
*
* Idée : mettre un caractère particulier pour matérialiser le point de départ et le point d'arrivée (si les coordonnées sont valides)
* */