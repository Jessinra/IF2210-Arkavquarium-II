import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Object {

    protected double position_x;
    protected double position_y;
    protected String direction;

    protected JLabel label = new JLabel();
    protected Dimension size;

    protected BufferedImage image = null;

    /**
     * getter position_x
     * @return position_x
     */
    public double get_x() {
        return position_x;
    }

    /**
     * getter position_y
     * @return position_y
     */
    public double get_y() {
        return position_y;
    }

    /**
     * getter direction
     * @return direction
     */
    public String get_dir() {
        return direction;
    }

    /**
     * setter x
     * @param x
     */
    public void set_x(double x) {
        position_x = x;
    }

    /**
     * setter y
     * @param y
     */
    public void set_y(double y) {
        position_y = y;
    }

    /**
     * setter direction
     * @param dir
     */
    public void set_dir(String dir) {
        direction = dir;
    }

    /**
     * getter label
     * @return label
     */
    public JLabel get_label() {
        return this.label;
    }

    /**
     * setter image
     * @param image
     */
    public void set_image(BufferedImage image) {
        this.image = image;
    }

    /**
     * getter image
     * @return image
     */
    public BufferedImage get_image() {
        return image;
    }

    /**
     * mengganti posisi objek
     * @param x
     * @param y
     */
    public void change_position(double x, double y) {

        this.size = this.label.getPreferredSize();
        this.label.setBounds((int) x - this.size.width / 2, (int) y - this.size.height / 2, this.size.width, this.size.height);
    }

    // public abstract void draw();
}