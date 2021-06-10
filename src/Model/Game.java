package Model;

import Game.Board;
import javafx.geometry.Pos;

/**
 * @author Gonçalo Sardinha Alves Ferreira 16252
 * @version 10/06/2021
 */

public class Game {

    public static int ROW = 6;
    public static int COL = 13;

    private View view;

    private Mark[][] board;


    public Game() {
        createBoard();
    }

    public void setView(View view) {
        this.view = view;
    }

    private void createBoard() {
        this.board = new Mark[ROW][COL];

        for (int i = 0; i < board.length; i++) {
            Mark[] marks = board[i];

            for (int j = 0; j < marks.length; j++) {
                marks[j] = Mark.OCCUPIEDTUNNEL;

            }
        }
    }

    public void positionSelected(Position positionSelected){
        Player player = getCurrentPlayer();
        Mark playerMark = player.getMark();

        Mark markAtPosition = getMarkAtPosition(positionSelected);

        if(markAtPosition == Mark.OCCUPIEDTUNNEL){
            setMark(positionSelected, playerMark);
        }
    }

    private void setMark(Position positionSelected, Mark playerMark) {
        board[positionSelected.getRow()][positionSelected.getCol()] = playerMark;
        view.onBoardMarkChanged(playerMark, positionSelected);
    }

    private Mark getMarkAtPosition(Position positionSelected) {
        return board[positionSelected.getRow()][positionSelected.getCol()];
    }

    public Player getCurrentPlayer(){
        return Player.ROCKFORD;
    }

}
