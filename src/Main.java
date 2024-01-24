import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        // get informations in carte.txt
        UseTextFile useTextFile = new UseTextFile();
        String map = useTextFile.readFileText();

        // Add caracteres in multimensional array and display
        // Display map
        useTextFile.displayMap(map);

        // retrieve start and end position with the user
        Coordonnees coordonnees = new Coordonnees();
        ArrayList startPositions = coordonnees.retrieveStartCoordinates();
        ArrayList endPositions = coordonnees.retrieveEndCoordinates();

        // make move player
        Move move = new Move();
        ArrayList directions = move.retrieveDirections();
        move.movePlayer(startPositions, endPositions, directions, useTextFile.mapMaker(map));
    }
}

/*

Pseudo Code
* 1) Ouvrir le fichier
* 2) Parcourir le fichier ligne par ligne
* 3) placer chaque caractère issus de chaque ligne du fichier dans un tableau
*   -> tableau à 2 dimensions
* 4) Afficher le tableau à 2 dimensions
* 5) Demander à l'utilisateur de saisir des coordonnés de départ et d'arrivée
*   -> Si coordonnées impossibles ou incorrectes faire une boucle pour demander de nouvelles coordonnées
*   -> Si coordonnées OK
*       -> Demander les coordonnées d'arrivée
*               -> Si coordonnées impossibles ou incorrectes boucler pour demander d'autres coordonnées
*                   -> n'accepter que des valeurs numériques entre 0 et 19
*                   -> exclure les autres caractères
*
* 6) Demander les caps à suivre sous forme de 'char' : N S E O
*   -> exclure tout autre type de données entrées
*   -> Chaque char correspond à une case
*       -> Récupérer les caps sous forme de 'STR' exemple : 'NNSSEOSS'
*           -> Parcourir les caps 'char' par 'char'
*
**       Placer chaque cap dans une arraysList
*           -> Pour chaque 'char', appliquer la valeur de déplacement horizontale / verticale
*               -> utilisation d'une boucle for pour appliquer les valeurs de déplacement
*
* */