package Blocks;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Gonçalo Sardinha Alves Ferreira 16252
 * @version 05/06/2021
 */

public class Diamond extends Button {

    private int xDiamond;
    private int yDiamond;

    public static final Image DIAMOND = new Image("resources/diamond.jpg");

    public Diamond(int xDiamond, int yDiamond) {
        this.xDiamond = xDiamond;
        this.yDiamond = yDiamond;


        ImageView imageView = new ImageView(DIAMOND);
        this.setGraphic(imageView);

    }

    public int getxDiamond() {
        return xDiamond;
    }
    public int getyDiamond() {
        return yDiamond;
    }

}
