package Game;


import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.util.*;

public class MapReader {
    private String[][] mapBlocks;
    private Integer[] playerPosition;

    public MapReader(Stage stage){
       mapBlocks = new String[0][];
       playerPosition = new Integer[2];
       ReadFile(stage);
    }

    public String[][] getMapBlocks(){
        return mapBlocks;
    }
    public Integer[] getPlayerPosition(){
        return playerPosition;
    }

    public void ReadFile(Stage stage) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Escolha o ficheiro com as previsões");
        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Ficheiros de texto", "*.txt"));
        File initialDirectory = new File(".");
        chooser.setInitialDirectory(initialDirectory);
        File db = chooser.showOpenDialog(stage);

        try {

            Scanner input = new Scanner(db.getAbsolutePath());

            File file = new File(input.nextLine());

            input = new Scanner(file);
            int counter = 1;

            String[] boardSize =  input.nextLine().split(" ");

             mapBlocks = new String[Integer.parseInt(boardSize[0])][Integer.parseInt(boardSize[1])];

            while (input.hasNextLine()) {

                String line = input.nextLine();

                if(counter > 0 && counter < Integer.parseInt(boardSize[0]) + 1) {
                    mapBlocks[counter-1] = line.split("");

                }
                if(counter > Integer.parseInt(boardSize[0]) ){
                    String[] data = line.split(" ");
                    if(data[0].equals("J")){
                        playerPosition[0] = Integer.parseInt(data[1]);
                        playerPosition[1] = Integer.parseInt(data[2]);
                    }
                }
                counter++;
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
