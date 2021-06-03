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

/**
 * @author Gonçalo Sardinha Alves Ferreira 16252
 * @version 03/06/2021
 */

public class Board extends GridPane {
    public static final int SIZE = 7;
    public static int nRows;
    public static int nCols;
    public static String[][] BoardFromFile;



   // private TicTacToeGame game;
    private AbstractPosition[][] board;

    public Board () {
        createBoard();
    }

    public void createBoard() {
        this.board = new AbstractPosition[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                //if (BoardFromFile[row][col] == "W")
                    Wall wall = new Wall(row, col);
                    //Button button = new Button( col + "," + row);

                    add(wall, wall.getxBoard(), wall.getyBoard());
               // else

            }
        }
    }

}

















