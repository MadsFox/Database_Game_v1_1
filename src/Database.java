import java.sql.*;
import java.util.Hashtable;

public class Database {

    //Oplysninger om forbindelse
    private boolean valid = false; //Sættes kun til true, hvis vi kommer igennem alle vores try/catch
    Connection connection;

    //Tabel-navne
    private String boardTable = "boards";
    private String pieceTable = "pieces";

    public Database(String host, String port, String database, String username, String password) {
        //Brug klasse fra JDBC-driver
        try {
            //Brug klasse fra JDBC-driver .jar-filen
            Class.forName("com.mysql.jdbc.Driver");
            log("JDBC-driver OK!");

            try {
                this.connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
                //this.connection = DriverManager.getConnection("jdbc:mysql://wits:3306/gandsoe?user=gandsoe&password=password");

                this.valid = true;
                log("Forbindelse oprettet");
            } catch (SQLException e) {
                log("Kunne ikke oprettee forbindelse til databasen: " + e);
            }

        } catch (ClassNotFoundException e) {
            log("Kunne ikke finde JDBC-driver: " + e);
        }

    }

    private void log(String logMessage) {
        System.out.println(logMessage);
    }

    public boolean isValid() {
        return valid;
    }

    public Hashtable<String, Integer> getBoard(int id) {
        //Vi laver et nyt statement
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM " + boardTable + " WHERE id = " + id;

            try {
                ResultSet boardData = statement.executeQuery(SQL);
                while(boardData.next()) {
                    int boardId = boardData.getInt("id");
                    String boardName = boardData.getString("name");
                    int boardWidth = boardData.getInt("width");
                    int boardHeight = boardData.getInt("height");
                    int boardDepth = boardData.getInt("depth");

                    Hashtable data = new Hashtable<>();
                    data.put("id", boardId);
                    data.put("name", boardName);
                    data.put("width", boardWidth);
                    data.put("height", boardHeight);
                    data.put("depth", boardDepth);


                    return data;
                }
            }
            catch (SQLException e) {
                log("Kunne ikke hente data ud fra dette statement: " + e);
            }
        }
        catch (SQLException e) {
            log("Kunne ikke oprette Statement");
        }

        return null;
    }

    public Hashtable getAllPieces(int id) {
            //Vi laver et nyt statement
            try {
                Statement statement = connection.createStatement();
                String SQL = "SELECT * FROM " + pieceTable + " WHERE boardId = " + id;

                try {
                    ResultSet pieceRow = statement.executeQuery(SQL);
                    Hashtable data = new Hashtable();

                    while(pieceRow.next()) {
                        int pieceId = pieceRow.getInt("id");
                        int pieceX = pieceRow.getInt("x");
                        int pieceY = pieceRow.getInt("y");
                        int pieceZ = pieceRow.getInt("z");
                        int pieceWidth = pieceRow.getInt("width");
                        int pieceHeight = pieceRow.getInt("height");
                        int pieceDepth = pieceRow.getInt("depth");
                        int pieceMoveable = pieceRow.getInt("moveable");

                        Hashtable row = new Hashtable<>();
                        row.put("x", pieceX);
                        row.put("y", pieceY);
                        row.put("z", pieceZ);
                        row.put("width", pieceWidth);
                        row.put("height", pieceHeight);
                        row.put("depth", pieceDepth);
                        row.put("moveable", pieceMoveable);

                        data.put(pieceId, row);
                    }
                    return data;
                }
                catch (SQLException e) {
                    log("Kunne ikke hente data ud fra dette statement: " + e);
                }
            }
            catch (SQLException e) {
                log("Kunne ikke oprette Statement");
            }

            return null;
        }
}