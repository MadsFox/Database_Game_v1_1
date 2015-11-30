
public class Main {

    String version = "v1.1";

    //Vores hovedklasser.
    UserInterface userInterface; //UI layer
    GameController gameController; //Domain layer
    Database database; //Technical Layer

    public Main() {
        //Opret databasse
        this.database = createDatabase();

        //Tjek om vores database blev oprettet korrekt
        if(database != null) {

            //Opret vores UI-klasse
            this.userInterface = new UserInterface(version); //Smid version over i, så vi kan vise det vinduets titel

            //Opret GameController og smid vores database samt UI ind i den, så GameController kan tage data fra
            //databasen og smide det over i UI. (Jf. GRASP controller og creater princip)
            this.gameController = new GameController(database);

            //Alle vores 3 hoved-klasser er oprettet. Kør derfor startGame(), som udfylder dens board.
            this.gameController.startGame();

            //Start User Interface
            this.userInterface.createWindow();

            //Start Tegne-Loop
            this.userInterface.startDrawingLoop(); //Vi skal finde en måde vi kan sende Board over i UserInterface

        }
        else {
            log("Kunne ikke starte spil pga. manglende database objekt.");
        }
    }

    private void log(String logMessage) {
        System.out.println(logMessage);
    }

    public Database createDatabase() {
        //Her vil vi returnere et database objekt.
        Database db = new Database("localhost", "3306", "DatabaseTest", "root", "");
        if(db.isValid()) {
            return db;
        }
        else {
            //Hvis der er exceptions ved oprettelse af databasen, returnerer vi null
            return null;
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
