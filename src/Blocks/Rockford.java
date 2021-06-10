package Blocks;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

/**
 * @author Gonçalo Sardinha Alves Ferreira 16252
 * @version 03/06/2021
 */

public class Rockford extends Button {
    // static variable single_instance of type Singleton
    private static Rockford single_instance = null;


    // variable of type String
    public String s;
    private int xPos;
    private int yPos;

    public static final Image ROCKFORD = new Image("resources/rockford.jpg");

    public void setxPos(int xPos){
        this.xPos = xPos;
    }
    public void setyPos(int yPos){
        this.yPos = yPos;
    }
    public int getxPos(){
        return this.xPos;
    }
    public int getyPos(){
        return this.yPos;
    }

    // private constructor restricted to this class itself
    private Rockford()
    {
        ImageView imageView = new ImageView(ROCKFORD);
        this.setGraphic(imageView);
        s = "Hello I am a string part of Singleton class";
    }

    // static method to create instance of Singleton class
    public static Rockford getInstance()
    {
        if (single_instance == null)
            single_instance = new Rockford();

        return single_instance;
    }

}
