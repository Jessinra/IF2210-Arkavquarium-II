import java.util.*;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Siput extends Pet {
    private double distance_to_coin;
    private int speed;
    private JLabel label = new JLabel();
    private Dimension size;

    public static final ImageIcon image_siput_left = new ImageIcon(Constants.FILE_siput_left);
    public static final ImageIcon image_siput_right = new ImageIcon(Constants.FILE_siput_right);

    public Siput() {
        distance_to_coin = 0;
        set_speed(Constants.SIPUT_MOVEMENT_SPD);
        set_dir("Right");
        set_x(Constants.SCREEN_WIDTH/2);
        set_y(Constants.SCREEN_BOTTOM);

        // set label image
        this.label.setIcon(Siput.image_siput_right);
        this.change_position(get_x(), get_y());
        this.size = this.label.getPreferredSize();

    }

    public int get_speed() {
        return this.speed;
    }

    public void set_speed(int speed) {
        this.speed = speed;
    }

    public void move(double sec_since_last, LinkedList<Coin> C) {
        int x_coin;

        if (C.getNBelmt() > 0) {
            int radius = inRadius(C);

            System.out.println("Siput move " + get_x() + "," + get_y());

            x_coin = C.get(radius).get_x();
            if (abs(x_coin - get_x()) > 30) {
                if (x_coin - get_x() > 0) {
                    set_x(get_x() + sec_since_last * get_speed());
                    set_dir("Right");
                } else {
                    set_x(get_x() - sec_since_last * get_speed());
                    set_dir("Left");
                }
            }
        }
    }

    public double euclidean() {}

    public boolean find_coin(LinkedList<Coin> C) {
        boolean find = false;
        int i = 1;

        while (i < C.getNBelmt() && !find) {
            if (C.get(i).get_y() == Constant.SCREEN_BOTTOM) {
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
        double radius = 1;
        boolean find = false;

        if (find_coin(C)) {
            for (idx=1; idx<=C.getNBelmt(); idx++) {
                if (C.get(idx).get_y() == Constant.SCREEN_BOTTOM) {
                    break;
                }
            }
            nearest = abs(C.get(idx).get_x() - get_x());
            while (idx+1 < C.getNBelmt()) {
                if (C.get(idx).get_y() == Constant.SCREEN_BOTTOM) {
                    if (abs(C.get(idx).get_x() - get_x()) < nearest) {
                        nearest = abs(C.get(idx).get_x() - get_x());
                        radius = idx;
                    } else {
                        idx++;
                    }
                } else {
                    idx++;
                }
            }
        } else {
            nearest = C.get(idx).get_y();
            for (idx=2; idx<=C.getNBelmt(); idx++) {
                if (C.get(idx).get_y() > nearest) {
                    radius = idx;
                }
            }
        }
        return radius;
    }

    public int take_coin() {
        if (C.getNBelmt() > 0) {
            int idx = inRadius(C);
            if (C.get(idx).get_x() >= get_x() - 30 && C.get(idx).get_x() + 30 && C.get(idx).get_y() >= Constant.SCREEN_BOTTOM) {
                int value = C.get(idx).get_value();
                C.remove(C.get(idx));
                return value;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
