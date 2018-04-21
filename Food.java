import java.util.*;
import javax.swing.ImageIcon;


public class Food extends Object implements Moveable {
    private static int food_count = 0;
    private int food_id;
    private int food_speed;
    private JLabel label = new JLabel();
    private Dimension size;

    private static String image_link = Constants.FILE_food;
    private static ImageIcon image_food = new ImageIcon(image_link);

    public Food() {

        set_y(Constant.SCREEN_TOP);
        Random rand = new Random();
        int a = rand.nextInt() % Constant.SCREEN_WIDTH + 1;
        set_x((double) a);
        food_count += 1;
        set_id(food_count);
        set_speed(Constant.FOOD_MOVEMENT_SPD);

        // set label image
        this.label.setIcon(Food.image_food);
        this.size = this.label.getPreferredSize();
    }
    public Food(double x) {
        set_y(SCREEN_TOP);
        set_x(x);
        food_count += 1;
        set_id(food_count);
        set_speed(Constant.FOOD_MOVEMENT_SPD);

        // set label image
        this.label.setIcon(Food.image_food);
        this.size = this.label.getPreferredSize();
    }
    public int get_id() {
        return food_id;
    }
    public void set_id(int id) {
        this.food_id = id;
    }
    public int get_speed() {
        return food_speed;
    }
    public void set_speed(int spd) {
        this.food_speed = spd;
    }

    // public void draw() {
    //     // draw_image(Constant.FILE_food, super.get_x(), super.get_y());
    // }

    public void move(double sec_since_last) {

        if (get_y() <= Constant.SCREEN_BOTTOM) {
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
        this.label.setBounds(x - this.size.width/2, y - this.size.height/2, this.size.width, this.size.height);
    }
}
