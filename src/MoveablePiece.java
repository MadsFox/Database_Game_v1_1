public class MoveablePiece extends Piece {

    int weight;
    int speed;
    int acceleration;

    public MoveablePiece(int id, int x, int y, int z, int width, int height, int depth, boolean moveable, int weigth, int speed, int acceleration) {
        //Gem data i parrent (Altså Piece)
        super(id, x, y, z, width, height, depth, moveable);

        //Udover at gemme de nødvendige informationer, skal vi specielt for Moveable klasser, også gemme weight, speed, acceleration
        this.weight = weigth;
        this.speed = speed;
        this.acceleration = acceleration;

    }
}