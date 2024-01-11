import java.io.*;
public class UseTextFile {

    // Constructor by default
    public UseTextFile(){


    }

    // method to read file text
    protected String readFileText() throws IOException {
        File map = new File("src/carte.txt");
        BufferedReader br = new BufferedReader(new FileReader(map));
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }

        br.close();
        return stringBuilder.toString();
    }


    // méthode pour récupérer chaque caractère de la string pour la placer dans un char dans un tableau à 2 dimensions
    protected Character[][] arrayMaker(String readeDataTextFile){
        Character[][] car = new Character[20][21];

        int index = 0;

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 21; j++) {
                if (index < readeDataTextFile.length()) {
                    car[i][j] = readeDataTextFile.charAt(index++);
                }
            }
        }

        return car;
    }
}