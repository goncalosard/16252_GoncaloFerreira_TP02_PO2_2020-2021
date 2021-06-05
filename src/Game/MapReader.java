package Game;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.util.*;

public class MapReader {
    private String[][] mapBlocks;
    private Integer[] playerPosition;
    private String[] boardSize;
    private String[] diamondPosition;

    public MapReader(Stage stage){
       mapBlocks = new String[0][];
       playerPosition = new Integer[2];
       boardSize = new String[1];
       ReadFile(stage);
    }

    public String[][] getMapBlocks(){
        return mapBlocks;
    }
    public Integer[] getPlayerPosition(){
        return playerPosition;
    }
    public String[] getboardSize(){
        return boardSize;
    }
    public String[] getDiamondPosition() {return diamondPosition;}


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

             boardSize =  input.nextLine().split(" ");

             mapBlocks = new String[Integer.parseInt(boardSize[0])][Integer.parseInt(boardSize[1])];



            while (input.hasNextLine()) {

                String line = input.nextLine();

                if(counter > 0 && counter < Integer.parseInt(boardSize[0]) + 1) {
                    mapBlocks[counter-1] = line.split("");

                }
                String[] data = line.split(" ");
                if(counter > Integer.parseInt(boardSize[0]) ){

                    if(data[0].equals("J")){
                        playerPosition[0] = Integer.parseInt(data[1]);
                        playerPosition[1] = Integer.parseInt(data[2]);
                    }
                }
                if(counter > Integer.parseInt(boardSize[0])){
                    //diamondPosition = line.split(" ");
                    if(data[0].equals("D")){
                        diamondPosition = data;
                    }
                }



                counter++;
            }
            System.out.println("diamond " + diamondPosition.length);
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
