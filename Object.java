import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Object {

    protected double positionX;
    protected double positionY;
    protected String direction;

    protected Dimension size;

    protected BufferedImage image = null;

    /**
     * getter position_x.
     * @return position_x
     */
    public double getX() {
        return positionX;
    }

    /**
     * getter position_y.
     * @return position_y
     */
    public double getY() {
        return positionY;
    }

    /**
     * getter direction.
     * @return direction
     */
    public String getDir() {
        return direction;
    }

    /**
     * setter x.
     * @param x x to set
     */
    public void setX(double x) {
        positionX = x;
    }

    /**
     * setter y.
     * @param y y to set
     */
    public void setY(double y) {
        positionY = y;
    }

    /**
     * setter direction.
     * @param dir direction to set
     */
    public void setDir(String dir) {
        direction = dir;
    }

    /**
     * setter image.
     * @param image image to set
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * getter image.
     * @return image
     */
    public BufferedImage getImage() {
        return image;
    }
}