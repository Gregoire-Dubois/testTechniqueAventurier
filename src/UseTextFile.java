import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

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


    // Method for get caracteres in string and insert all string in CHAR in multidimensional array.
    protected Character[][] mapMaker(String readeDataTextFile){
        Character[][] map = new Character[20][21];

        int index = 0;

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 21; j++) {
                if (index < readeDataTextFile.length()) {
                    map[i][j] = readeDataTextFile.charAt(index++);
                }
            }
        }
        return map;
    }

    // Display the map
    protected void displayMap(String map){
    UseTextFile useTextFile = new UseTextFile();

        for (Character[] row : useTextFile.mapMaker(map)) {
            //System.out.print(" ");
            for (Character ch : row) {
                if (ch != null){
                    System.out.print(ch);
                }
            }
        }
    }
}