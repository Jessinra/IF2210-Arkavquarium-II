import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Gameplay extends JPanel implements ActionListener {
    private boolean play = true;

    private Timer timer;
    private int delay = 8;

    private Food food = new Food(300);

    public Gameplay() {
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        // background
        g.setColor(Color.BLACK);
        g.fillRect(1,1,692,592);

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(Constants.FILE_food));
        } catch (IOException e) {

        }

        g.drawImage(img, (int)food.get_x(), (int)food.get_y(), this);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (play) {
            food.move();
        }
        repaint();
    }
}
