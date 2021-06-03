package Blocks;

/**
 * @author Gonçalo Sardinha Alves Ferreira 16252
 * @version 03/06/2021
 */

public class Rockford {
    private static Rockford instance = null;
    protected Rockford() {}

    public static Rockford getInstance() {
        if(instance == null) {
            instance = new Rockford();
        }
        return instance;
    }
}
