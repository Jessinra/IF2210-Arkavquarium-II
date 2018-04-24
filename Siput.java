import java.util.*;

import com.sun.prism.Image;

import static java.lang.Math.abs;

public class Siput extends Pet {

    private int speed;

    /**
     * default constructor
     */
    public Siput() {

        setSpeed(Constants.SIPUT_MOVEMENT_SPD);
        setDir("Right");

        setX(Constants.SCREEN_WIDTH / 2);
        setY(Constants.SCREEN_BOTTOM - 30);

        // set label image
        this.setImage(ImageCollection.siput_right);

    }

    /**
     * getter speed
     * @return speed
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * mengubah nilai speed
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * memindahkan siput
     * @param C
     */
    public void move(LinkedList<Coin> C) {
        double xCoin;

        if (C.getNBelmt() > 0) {
            int radius = inRadius(C);

            xCoin = C.get(radius).getX();
            if (abs(xCoin - getX()) > 30) {
                if (xCoin - getX() > 0) {
                    setX(getX() + getSpeed());

                    setDir("Right");
                    setImage(ImageCollection.siput_right);

                } else {
                    setX(getX() - getSpeed());

                    setDir("Left");
                    setImage(ImageCollection.siput_left);
                }
            }
        }
    }

    // public double euclidean() {}

    /**
     * mencari coin
     * @param C
     * @return boolean find
     */
    public boolean findCoin(LinkedList<Coin> C) {
        boolean find = false;
        int i = 1;

        while (i < C.getNBelmt() && !find) {
            if (C.get(i).getY() == Constants.SCREEN_BOTTOM) {
                find = true;
            } else {
                i++;
            }
        }
        return find;
    }

    /**
     * mencari coin yang ada di dalam radius siput
     * @param C
     * @return idx coin dalam radius, 0 jika tidak ada coin dalam radius
     */
    public int inRadius(LinkedList<Coin> C) {
        int idx = 1;
        int nearest;
        int radius = 1;

        if (findCoin(C)) {
            for (idx = 1; idx <= C.getNBelmt(); idx++) {
                if (C.get(idx).getY() == Constants.SCREEN_BOTTOM) {
                    break;
                }
            }
            nearest = (int) abs(C.get(idx).getX() - getX());
            while (idx + 1 < C.getNBelmt()) {
                if (C.get(idx).getY() == Constants.SCREEN_BOTTOM) {
                    if (abs(C.get(idx).getX() - getX()) < nearest) {
                        nearest = (int) abs(C.get(idx).getX() - getX());
                        radius = idx;
                    } else {
                        idx++;
                    }
                } else {
                    idx++;
                }
            }
        } else {
            nearest = (int) C.get(idx).getY();
            for (idx = 2; idx <= C.getNBelmt(); idx++) {
                if (C.get(idx).getY() > nearest) {
                    radius = idx;
                }
            }
        }
        return radius;
    }

    /**
     * mengambil coin
     * @param C
     * @return idx coin yang diambil
     */
    public int takeCoin(LinkedList<Coin> C) {
        if (C.getNBelmt() > 0) {
            int idx = inRadius(C);

            Coin currentCoin = C.get(idx);

            if ((currentCoin.getX() >= getX() - 30) && (currentCoin.getX() <= getX() + 30) && (currentCoin.getY() >= Constants.SCREEN_BOTTOM)) {
                int value = currentCoin.getValue();
                C.remove(currentCoin);
                return value;

            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
