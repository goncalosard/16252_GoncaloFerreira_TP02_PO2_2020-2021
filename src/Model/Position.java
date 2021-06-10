package Model;

/**
 * @author Gonçalo Sardinha Alves Ferreira 16252
 * @version 10/06/2021
 */

public class Position {

    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
