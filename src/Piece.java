import java.awt.*;

public class Piece {

    //Informationer om denne Piece
    int id;
    int health = 100;
    int x;
    int y;
    int z;

    //Størrelsen/dimensionen på denne Piece
    int width;
    int height;
    int depth;

    //Kan denne piece rykkes?
    boolean moveable;

    public Piece(int id, int x, int y, int z, int width, int height, int depth, boolean moveable) {
        //Gem værdierne permanent
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.moveable = moveable;

        System.out.println("Piece id: " + id + " created.");
    }

}