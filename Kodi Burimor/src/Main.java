import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;

/**
 * Klasa Main,
 * bënë ekzekutimin e programit
 */
public class Main {

    public static void main(String[] args)
    {

        JFrame frame = new WarGameGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setMinimumSize(new Dimension(900,750));
        frame.validate();
        frame.setVisible(true);

    }

}