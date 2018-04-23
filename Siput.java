import java.util.*;

import com.sun.prism.Image;

import static java.lang.Math.abs;

public class Siput extends Pet {
    private double distance_to_coin;
    private int speed;

    public Siput() {
        distance_to_coin = 0;
        set_speed(Constants.SIPUT_MOVEMENT_SPD);
        set_dir("Right");
        set_x(Constants.SCREEN_WIDTH/2);
        set_y(Constants.SCREEN_BOTTOM-30);

        // set label image
        this.set_image(ImageCollection.siput_right);

        this.change_position(get_x(), get_y());
        this.size = this.label.getPreferredSize();
    }

    public int get_speed() {
        return this.speed;
    }

    public void set_speed(int speed) {
        this.speed = speed;
    }

    public void move(LinkedList<Coin> C) {
        double x_coin;

        if (C.getNBelmt() > 0) {
            int radius = inRadius(C);

            x_coin = C.get(radius).get_x();
            if (abs(x_coin - get_x()) > 30) {
                if (x_coin - get_x() > 0) {
                    set_x(get_x() + get_speed());

                    set_dir("Right");
                    set_image(ImageCollection.siput_right);

                } else {
                    set_x(get_x() - get_speed());
                    
                    set_dir("Left");
                    set_image(ImageCollection.siput_left);
                }
            }

            change_position(get_x(), get_y());
        }   
    }

    // public double euclidean() {}

    public boolean find_coin(LinkedList<Coin> C) {
        boolean find = false;
        int i = 1;

        while (i < C.getNBelmt() && !find) {
            if (C.get(i).get_y() == Constants.SCREEN_BOTTOM) {
                find = true;
            } else {
                i++;
            }
        }
        return find;
    }

    public int inRadius(LinkedList<Coin> C) {
        int idx = 1;
        int nearest;
        int radius = 1;
        boolean find = false;

        if (find_coin(C)) {
            for (idx=1; idx<=C.getNBelmt(); idx++) {
                if (C.get(idx).get_y() == Constants.SCREEN_BOTTOM) {
                    break;
                }
            }
            nearest = (int) abs(C.get(idx).get_x() - get_x());
            while (idx+1 < C.getNBelmt()) {
                if (C.get(idx).get_y() == Constants.SCREEN_BOTTOM) {
                    if (abs(C.get(idx).get_x() - get_x()) < nearest) {
                        nearest = (int) abs(C.get(idx).get_x() - get_x());
                        radius = idx;
                    } else {
                        idx++;
                    }
                } else {
                    idx++;
                }
            }
        } else {
            nearest = (int) C.get(idx).get_y();
            for (idx=2; idx<=C.getNBelmt(); idx++) {
                if (C.get(idx).get_y() > nearest) {
                    radius = idx;
                }
            }
        }
        return radius;
    }

    public int take_coin(LinkedList<Coin> C) {
        if (C.getNBelmt() > 0) {
            int idx = inRadius(C);

            Coin current_coin = C.get(idx);

            if ((current_coin.get_x() >= get_x() - 30) && (current_coin.get_x() <= get_x() + 30) && (current_coin.get_y() >= Constants.SCREEN_BOTTOM)) {
                int value = current_coin.get_value();
                C.remove(current_coin);
                return value;
                
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
