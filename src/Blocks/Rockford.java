package Blocks;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Gonçalo Sardinha Alves Ferreira 16252
 * @version 03/06/2021
 */

public class Rockford {
    // static variable single_instance of type Singleton
    private static Rockford single_instance = null;
    private int xRockford;
    private int yRockford;

    // variable of type String
    public String s;


    // private constructor restricted to this class itself
    private Rockford()
    {
        s = "Hello I am a string part of Singleton class";
    }

    public Rockford(int xRockford, int yRockford) {
        this.xRockford = xRockford;
        this.yRockford = yRockford;

    }

    // static method to create instance of Singleton class
    public static Rockford getInstance()
    {
        if (single_instance == null)
            single_instance = new Rockford();

        return single_instance;
    }

}
