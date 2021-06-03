package Game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Gonçalo Sardinha Alves Ferreira 16252
 * @version 21/05/2021
 *Exameple GitHub*/
public class GameStart extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Board board = new Board();
        Scene scene = new Scene(board);
        stage.setScene(scene);
        stage.show();
    }
}
