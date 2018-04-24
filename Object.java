import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Object {

    protected double position_x;
    protected double position_y;
    protected String direction;

    protected Dimension size;

    protected BufferedImage image = null;

    /**
     * getter position_x.
     * @return position_x
     */
    public double get_x() {
        return position_x;
    }

    /**
     * getter position_y.
     * @return position_y
     */
    public double get_y() {
        return position_y;
    }

    /**
     * getter direction.
     * @return direction
     */
    public String get_dir() {
        return direction;
    }

    /**
     * setter x.
     * @param x x to set
     */
    public void set_x(double x) {
        position_x = x;
    }

    /**
     * setter y.
     * @param y y to set
     */
    public void set_y(double y) {
        position_y = y;
    }

    /**
     * setter direction.
     * @param dir direction to set
     */
    public void set_dir(String dir) {
        direction = dir;
    }

    /**
     * setter image.
     * @param image image to set
     */
    public void set_image(BufferedImage image) {
        this.image = image;
    }

    /**
     * getter image.
     * @return image
     */
    public BufferedImage get_image() {
        return image;
    }
}