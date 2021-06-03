package Blocks;

import javafx.scene.control.Button;

import java.awt.*;

/**
 * @author Gonçalo Sardinha Alves Ferreira 16252
 * @version 03/06/2021
 */

public abstract class AbstractPosition extends Button {
    private int xBoard;
    private int yBoard;


    public AbstractPosition(int xBoard, int yBoard) {
        this.xBoard= xBoard;
        this.yBoard= yBoard;

    }


    public int getxBoard() {
        return xBoard;
    }
    public int getyBoard() {
        return yBoard;
    }

    public void setxBoard(int x) {
        this.xBoard=x;
    }
    public void setyBoard(int y) {
        this.yBoard=y;
    }



}
