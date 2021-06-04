package Game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Gonçalo Sardinha Alves Ferreira 16252
 * @version 21/05/2021
 *Exameple GitHub*/
public class GameStart extends Application {
    private Stage stage;
    private MapReader reader;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        this.stage = stage;

        reader = new MapReader(stage);
        String[][] mapBlock = reader.getMapBlocks();
        Integer[] playerPosition = reader.getPlayerPosition();
        Board board = new Board(mapBlock, playerPosition);
        Scene scene = new Scene(board);
        stage.setScene(scene);
        stage.show();



    }

}
