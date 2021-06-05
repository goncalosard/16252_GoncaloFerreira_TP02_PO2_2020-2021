package Game;

import Blocks.Diamond;
import Blocks.Rockford;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Gonçalo Sardinha Alves Ferreira 16252
 * @version 21/05/2021
 *Exameple GitHub*/
public class GameStart extends Application {
    private Stage stage;
    private MapReader reader;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        this.stage = stage;

        reader = new MapReader(stage);
        String[][] mapBlock = reader.getMapBlocks();
        Integer[] playerPosition = reader.getPlayerPosition();
        String[] boardSize = reader.getboardSize();
        String[] diamond = reader.getDiamondPosition();
        Diamond[] diamonds = new Diamond[(diamond.length -1) /2];
        for ( int i = 1; i <= (diamond.length -1) /2; i++){
            Diamond diamond1 = new Diamond(Integer.parseInt(diamond[(i*2)-1]),Integer.parseInt(diamond[(i*2)]));
            diamonds[i-1] = diamond1;
        }
        System.out.println("AQUI" + diamonds[1].getyDiamond());


        Board board = new Board(mapBlock, playerPosition, boardSize, diamonds);
        //Rockford rockford = new Rockford(playerPosition);


        Rockford x = Rockford.getInstance();
        System.out.println("String from x is " + x.s);
        Scene scene = new Scene(board);
        stage.setScene(scene);
        stage.show();



    }

}
