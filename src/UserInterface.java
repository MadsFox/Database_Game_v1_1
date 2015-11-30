import javax.swing.*;
import java.awt.*;

public class UserInterface {

    private final String version;

    //JFrame
    JFrame window;
    GameCanvas canvas; //Nedarver JPanel som man kan tegne på

    public UserInterface(String version) {
        this.version = version;
    }

    public void startDrawingLoop() {
        //tegn objekter
    }

    public void createWindow() {
        this.window = new JFrame("UI - " + version);
        this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Vi skal bruge et layout, selvom vi kun vil smide 1 JPanel ind i JFramet
        this.window.setLayout(new BorderLayout());

        //Indsæt canvas med width/height
        this.canvas = new GameCanvas(600,400);

        //Tilføj det i midten af vores JFrame
        this.window.add(canvas, BorderLayout.CENTER);

        //Når vi skriver .pack() vil vores JFrame bruge .getPreferedSize() osv., fra panelet til at lave en størrelse der passer.
        this.window.pack();

        this.window.setVisible(true);
        this.window.setLocationRelativeTo(null); //Sæt JFrame lige på midten af skærmen
    }
}
