import java.util.*;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Food extends Object implements Moveable {
    private static int food_count = 0;
    private int food_id;
    private int food_speed;
    private JLabel label = new JLabel();
    private Dimension size;

    public static final ImageIcon image_food = new ImageIcon(Constants.FILE_food);

    public Food() {

        set_y(Constants.SCREEN_TOP);
        Random rand = new Random();
        int a = rand.nextInt(Constants.SCREEN_WIDTH + 1);

        set_x((double) a);
        food_count += 1;
        set_id(food_count);
        set_speed(Constants.FOOD_MOVEMENT_SPD);

       
        // set label image
        this.label.setIcon(Food.image_food);
        this.change_position(get_x(), get_y());
        this.size = this.label.getPreferredSize();
    }

    public Food(double x) {
        set_y(Constants.SCREEN_TOP);
        set_x(x);
        food_count += 1;
        set_id(food_count);
        set_speed(Constants.FOOD_MOVEMENT_SPD);

        // set label image
        this.label.setIcon(Food.image_food);
        this.change_position(get_x(), get_y());
        this.size = this.label.getPreferredSize();
    }

    public int get_id() {
        return this.food_id;
    }

    public void set_id(int id) {
        this.food_id = id;
    }

    public int get_speed() {
        return this.food_speed;
    }

    public void set_speed(int spd) {
        this.food_speed = spd;
    }

    public JLabel get_label(){
        return this.label;
    }
    

    // public void draw() {
    //     // draw_image(Constants.FILE_food, super.get_x(), super.get_y());
    // }

    public void move(double sec_since_last) {

        if (get_y() <= Constants.SCREEN_BOTTOM) {
            System.out.println("Food move " + get_x() + "," + get_y());
            set_y(get_y() + (get_speed() * sec_since_last));

            // change label position
            change_position(get_x(), get_y());
        }
    }

    public void change_image(ImageIcon image){

        this.label.setIcon(image);
    }

    public void change_position(double x, double y){

        this.size = this.label.getPreferredSize();
        this.label.setBounds((int) x - this.size.width/2,(int) y - this.size.height/2, this.size.width, this.size.height);
    }
}
