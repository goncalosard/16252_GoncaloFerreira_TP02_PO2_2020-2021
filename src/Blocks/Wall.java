package Blocks;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Gonçalo Sardinha Alves Ferreira 16252
 * @version 03/06/2021
 */

public class Wall extends AbstractPosition {

    public static final Image WALL = new Image("resources/wall.jpg");
    private final ImageView imageView;
    public Wall(int xBoard, int yBoard) {
        super(xBoard, yBoard);
        this.imageView = new ImageView(WALL);
        this.setGraphic(this.imageView);
    }
}
