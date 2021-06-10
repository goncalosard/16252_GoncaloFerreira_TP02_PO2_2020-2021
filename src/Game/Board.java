package Game;

import Blocks.*;
import Model.Game;
import Model.Mark;
import Model.Position;
import Model.View;
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

public class Board extends GridPane implements View {

    public static final int SIZE = 7;
    public static int nRows;
    public static int nCols;
    public static String[][] BoardFromFile;
    private String[][] mapBlock;
    private Integer[] playerPosition;
    private String[] boardSize;
    private Diamond[] diamonds;
    private Rockford player;

    private Game game;



   // private TicTacToeGame game;
    private AbstractPosition[][] board;

    public Board (String[][] mapBlock, Integer[] playerPosition, String[] boardSize, Diamond[] diamonds, Rockford player, Game game) {
        this.game = game;
        this.game.setView(this);
        this.mapBlock = mapBlock;
        this.playerPosition = playerPosition;
        this.boardSize = boardSize;
        this.diamonds = diamonds;
        this.player = player;
        createBoard();


        System.out.println(Arrays.deepToString(this.mapBlock));
        System.out.println((this.mapBlock[1][7]));
    }

    public void createBoard() {
        ButtonHandler handler = new ButtonHandler();
        this.board = new AbstractPosition[Integer.parseInt(boardSize[0])][Integer.parseInt(boardSize[1])];
        for (int row = 0; row < Integer.parseInt(boardSize[0]); row++) {
            for (int col = 0; col < Integer.parseInt(boardSize[1]); col++) {

                if (mapBlock[row][col].equals("W")){
                        Wall wall = new Wall(row, col);
                        add(wall,  wall.getyBoard(), wall.getxBoard());
                        board[row][col] = wall;
                }


                if(mapBlock[row][col].equals("O")){
                    OccupiedTunnel occupiedTunnel = new OccupiedTunnel(row, col);
                    occupiedTunnel.setOnAction(handler);
                    add(occupiedTunnel, occupiedTunnel.getyBoard(), occupiedTunnel.getxBoard());
                    board[row][col] = occupiedTunnel;

                }

                if(mapBlock[row][col].equals("L")){
                    FreeTunnel freeTunnel = new FreeTunnel(row, col);
                    freeTunnel.setOnAction(handler);
                    add(freeTunnel, freeTunnel.getyBoard(), freeTunnel.getxBoard());
                    board[row][col] = freeTunnel;
                }

                for(Diamond d : diamonds){
                    if(d.getxDiamond() == row && d.getyDiamond() == col){
                        d.setOnAction(handler);
                        add(d, d.getyDiamond(), d.getxDiamond());

                    }
                }

                if(player.getxPos() == row && player.getyPos() == col){
                    add(player, player.getyPos(), player.getxPos());
                }


                    //Button button = new Button( col + "," + row);


               // else

            }
        }
    }

    @Override
    public void onBoardMarkChanged(Mark mark, Position position){

        Button btn = board[position.getRow()][position.getCol()];

        switch (mark){

            case WALL:

                break;
            case OCCUPIEDTUNNEL:
                btn.setGraphic(new ImageView("resources/diamond.jpg"));
                break;
            case FREETUNEL:

                break;
            case ROCKFORD:
                btn.setGraphic(new ImageView("resources/rockford.jpg"));
                break;
            case GATE:
                break;
            case DIAMOND:
                break;
        }

    }

    private Position getPosition(Button source) {
        int rowIndex = GridPane.getRowIndex(source);
        int colIndex = GridPane.getColumnIndex(source);

        Position position = new Position(rowIndex, colIndex);
        return position;
    }

    class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Button source = (Button) event.getSource();

            Position position = getPosition(source);

            game.positionSelected(position);

        }

    }




}



