package Model;

/**
 * @author Gonçalo Sardinha Alves Ferreira 16252
 * @version 10/06/2021
 */

public enum Player {
    ROCKFORD(Mark.ROCKFORD), FREETUNEL(Mark.FREETUNEL), WALL(Mark.WALL);

    private Mark mark;

    Player(Mark mark) {
        this.mark = mark;
    }

    public Mark getMark() {
        return mark;
    }
}
