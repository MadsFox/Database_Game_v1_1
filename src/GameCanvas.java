import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    private final int canvasWidth;
    private final int canvasHeight;

    public GameCanvas(int canvasWidth, int canvasHeight) {

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        this.setBackground(Color.red);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.fillRect(1,5,50,100);
        g.drawString("test", 20, 20);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(canvasWidth, canvasHeight);
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

}
