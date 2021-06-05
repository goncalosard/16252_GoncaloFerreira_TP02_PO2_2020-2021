package Blocks;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Gonçalo Sardinha Alves Ferreira 16252
 * @version 03/06/2021
 */

public class OccupiedTunnel extends AbstractPosition {

    public static final Image OCCUPIED_TUNNEL = new Image("resources/occupiedTunnel.jpg");
    private final ImageView imageView;
    public OccupiedTunnel(int xBoard, int yBoard) {
        super(xBoard, yBoard);
        this.imageView = new ImageView(OCCUPIED_TUNNEL);
        this.setGraphic(this.imageView);
    }

}
