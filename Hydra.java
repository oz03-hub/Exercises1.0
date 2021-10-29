import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

public class Hydra {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Cut one, grows out two.", JLabel.CENTER);
    ImageIcon dragonImg = new ImageIcon("Cute-Dragon-step_00.png");


    public Hydra() {
        Random rndm = new Random();
        frame.setSize(220, 100);
        frame.setTitle("Hydra");
        frame.setLocation(rndm.nextInt(500), rndm.nextInt(500));
        label.setIcon(dragonImg);
        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                new Hydra();
                new Hydra();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Hydra();
    }
}
