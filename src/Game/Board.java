package Game;

import Blocks.*;
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
    private String[] boardSize;
    private Diamond[] diamonds;



   // private TicTacToeGame game;
    private AbstractPosition[][] board;

    public Board (String[][] mapBlock, Integer[] playerPosition, String[] boardSize, Diamond[] diamonds) {
        this.mapBlock = mapBlock;
        this.playerPosition = playerPosition;
        this.boardSize = boardSize;
        this.diamonds = diamonds;
        createBoard();


        System.out.println(Arrays.deepToString(this.mapBlock));
        System.out.println((this.mapBlock[1][7]));
    }

    public void createBoard() {
        this.board = new AbstractPosition[Integer.parseInt(boardSize[0])][Integer.parseInt(boardSize[1])];
        for (int row = 0; row < Integer.parseInt(boardSize[0]); row++) {
            for (int col = 0; col < Integer.parseInt(boardSize[1]); col++) {
                if (mapBlock[row][col].equals("W")){
                    Wall wall = new Wall(row, col);
                    add(wall,  wall.getyBoard(), wall.getxBoard());
                }

                if(playerPosition[0] == row && playerPosition[1] == col){
                    Wall wall = new Wall(row, col);
                    add(wall,  wall.getyBoard(), wall.getxBoard());
                }

                if(mapBlock[row][col].equals("O")){
                    OccupiedTunnel occupiedTunnel = new OccupiedTunnel(row, col);
                    add(occupiedTunnel, occupiedTunnel.getyBoard(), occupiedTunnel.getxBoard());
                }

                if(mapBlock[row][col].equals("L")){
                    FreeTunnel freeTunnel = new FreeTunnel(row, col);
                    add(freeTunnel, freeTunnel.getyBoard(), freeTunnel.getxBoard());
                }

                for(Diamond d : diamonds){
                    if(d.getxDiamond() == row && d.getyDiamond() == col){
                        add(d, d.getyDiamond(), d.getxDiamond());
                    }
                }

                    //Button button = new Button( col + "," + row);


               // else

            }
        }
    }

}

















