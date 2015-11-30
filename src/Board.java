import java.util.ArrayList;
import java.util.Hashtable;

public class Board {

    int id;
    String name;
    int width;
    int height;
    int depth;

    ArrayList<Piece> pieceList = new ArrayList<>();

    public Board(Hashtable boardData) {
        System.out.println("Opretter nyt board med data: " + boardData);
        this.id = (int) boardData.get("id");
        this.name = (String) boardData.get("name");
        this.width = (int) boardData.get("width");
        this.height = (int) boardData.get("height");
        this.depth = (int) boardData.get("depth");
    }

    public void addPiece(int id, Hashtable pieceData) {
        System.out.println("Board modtog følgende data fra Piece " + id + ": " + pieceData);

        //Vi har id i constructor
        int x = (int) pieceData.get("x");
        int y = (int) pieceData.get("y");
        int z = (int) pieceData.get("z");
        int width = (int) pieceData.get("width");
        int height = (int) pieceData.get("height");
        int depth = (int) pieceData.get("depth");
        int moveable = (int) pieceData.get("moveable");

        //I databasen bruger man 1/0 til booleans, hvor 1=true og 0=false. Den er java ikke med på, så vi laver den selv om til en boolean med true/false
        boolean moveableToBoolean = false;
        if(moveable == 1) {
            moveableToBoolean = true;
        }

        pieceList.add(new Piece(id, x, y, z, width, height, depth, moveableToBoolean));

    }

}
