import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // get informations in carte.txt
        UseTextFile useTextFile = new UseTextFile();
        String map = useTextFile.readFileText();

        // Add all characteres bi dimensional array and Display map
        // afficher tous les éléments dans arrayMaker
        for (Character[] row : useTextFile.arrayMaker(map)) {
            System.out.print(" ");
            for (Character ch : row) {
                System.out.print(ch);
            }
        }
    }
}


/*
* 1) Ouvrir le fichier
* 2) Parcourir le fichier ligne par ligne
* 3) placer chque caractères issus de chque ligne du fichier dans un tableau
*   -> tableau à 2 dimensions
* 4) Afficher le tableau à 2 dimensions
* 5) Demander à l'utilisateur de saisir des coordonnés de départ
*   -> Si coordonnées impossibles ou incorrectes faire une boucle pour demander de nouvelles coordonnées
*   -> Si coordonnées OK
*       -> Demander les coordonnées d'arrivée
*               -> Si coordonées impossibles ou incorrectes boucler pour demander d'autres coordonnées
* 6) Demander les caps à suivre sous forme de 'char' : N S E O
*   -> Chaque char correspond à une case
*       -> Récupérer les caps sous forme de 'STR'   exemple : NNSSEESS
*           -> Parcourir les caps 'char' par 'char'
*           -> N = +1 / S = -1 / E= -1 / O= +1
*
*       Placer chaque cap dans une arraysList
*           -> Pour chque 'char', appliquer la valeur de déplacement horizontale / verticale
*               -> utilisation d'une boucle for pour appliquer les valeurs de déplacement
*
* Idée : mettre un caractère particulier pour matériler le point de départ et le point d'arrivée (si les coordonnées sont valides)
*
*
*
* */