package Game;

import Blocks.Diamond;
import Blocks.Rockford;
import Model.Game;
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

        Game game = new Game();

        this.stage = stage;

        reader = new MapReader(stage);
        String[][] mapBlock = reader.getMapBlocks();
        Integer[] playerPosition = reader.getPlayerPosition();
        String[] boardSize = reader.getboardSize();
        String[] diamond = reader.getDiamondPosition();
        Diamond[] diamonds = new Diamond[(diamond.length -1) /2];
        for ( int i = 1; i <= (diamond.length -1) /2; i++){
            int x = Integer.parseInt(diamond[(i*2)-1]);
            int y = Integer.parseInt(diamond[(i*2)]);
            Diamond diamond1 = new Diamond(x,y);
            diamonds[i-1] = diamond1;
            mapBlock[x][y] = "diamond";
        }
        System.out.println("AQUI" + diamonds[1].getyDiamond());

        Rockford player = Rockford.getInstance();
        player.setxPos(playerPosition[0]);
        player.setyPos(playerPosition[1]);


       // mapBlock[player.getxPos()][player.getyPos()] = "null";



        Board board = new Board(mapBlock, playerPosition, boardSize, diamonds, player, game);
        //Rockford rockford = new Rockford(playerPosition);


        Scene scene = new Scene(board);
        stage.setScene(scene);
        stage.show();



    }

}
