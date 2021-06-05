package Blocks;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Gonçalo Sardinha Alves Ferreira 16252
 * @version 03/06/2021
 */

public class FreeTunnel extends AbstractPosition {


    public static final Image FREE_TUNEL = new Image("resources/unoccu.jpg");
    private final ImageView imageView;
    public FreeTunnel(int xBoard, int yBoard) {
        super(xBoard, yBoard);
        this.imageView = new ImageView(FREE_TUNEL);
        this.setGraphic(this.imageView);
    }
}
