import java.util.Enumeration;
import java.util.Hashtable;

public class GameController {

    //Klasser vi gerne vil kommunikere med
    private final Database database;

    //Vores spil-elementer, der skal oprettes/rettes/slettes og sendes til userinterface
    public Board board;

    public GameController(Database database) {
        this.database = database;
    }

    public void startGame() {
        /*
        Med udgangspunkt i vores sekvensdiagram https://www.draw.io/?state=%7B%22ids%22:%5B%220B5LmWKTB0EkbdWQzMWVpbzRwYUE%22%5D,%22action%22:%22open%22,%22userId%22:%22116135893691346509650%22%7D#G0B5LmWKTB0EkbdWQzMWVpbzRwYUE
        Vil vi gerne:
            1. Hente board-informationer fra databasen via vores Connection-objekt
            2. Oprette Board som objekt i controlleren / Som felt
            3. Hente alle Piece's
            4. For hver række vi får fra databasen, sender vi dataen til board's .addPiece(), som opretter objektet og gemmer det i dens ArrayList<Piece> pieceList
        */

        //1. og 2.
        this.board = new Board(database.getBoard(1));

        //3. Hent alle Piece's. Vi henter moveablepiece først og derefter nonmoveable
        Hashtable pieceList = database.getAllPieces(1);

        //Loop igennem alle Piece's (http://www.java2s.com/Code/Java/Collections-Data-Structure/IteratethroughkeysofJavaHashtable.htm)
        Enumeration e = pieceList.keys();

        while (e.hasMoreElements()){
            int id = (int) e.nextElement();
            Hashtable pieceData = (Hashtable) pieceList.get(id);
            board.addPiece(pieceData);
        }
    }
}
