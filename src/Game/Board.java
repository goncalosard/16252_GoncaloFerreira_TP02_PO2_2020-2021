package Game;

import Blocks.AbstractPosition;
import Blocks.Wall;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.Arrays;

/**
 * @author Gonçalo Sardinha Alves Ferreira 16252
 * @version 03/06/2021
 */

public class Board extends GridPane {
    public static final int SIZE = 7;
    public static int nRows;
    public static int nCols;
    public static String[][] BoardFromFile;
    private String[][] mapBlock;
    private Integer[] playerPosition;

   // private TicTacToeGame game;
    private AbstractPosition[][] board;

    public Board (String[][] mapBlock, Integer[] playerPosition) {
        this.mapBlock = mapBlock;
        this.playerPosition = playerPosition;
        createBoard();


        System.out.println(Arrays.deepToString(this.mapBlock));
        System.out.println((this.mapBlock[1][7]));
    }

    public void createBoard() {
        this.board = new AbstractPosition[4][13];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 13; col++) {
                if (mapBlock[row][col].equals("W")){
                    Wall wall = new Wall(row, col);
                    add(wall,  wall.getyBoard(), wall.getxBoard());
                }

                if(playerPosition[0] == row && playerPosition[1] == col){
                    Wall wall = new Wall(row, col);
                    add(wall,  wall.getyBoard(), wall.getxBoard());
                }

                    //Button button = new Button( col + "," + row);


               // else

            }
        }
    }

}

















