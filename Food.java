import java.util.*;

public class Food extends Object {
    private static int food_count = 0;
    private int food_id;
    private int food_speed;

    public Food() {
        set_y(Constants.SCREEN_TOP);
        Random rand = new Random();
        int a = rand.nextInt(Constants.SCREEN_WIDTH + 1);

        set_x((double) a);
        food_count += 1;
        set_id(food_count);
        set_speed(Constants.FOOD_MOVEMENT_SPD);

        this.set_image(ImageCollection.food);

        this.change_position(get_x(), get_y());
    }

    public Food(double x) {
        set_y(Constants.SCREEN_TOP);
        set_x(x);
        food_count += 1;
        set_id(food_count);
        set_speed(Constants.FOOD_MOVEMENT_SPD);

        this.set_image(ImageCollection.food);

        this.change_position(get_x(), get_y());
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

    public void move() {

        if (get_y() <= Constants.SCREEN_BOTTOM) {
            // System.out.println("Food move " + get_x() + "," + get_y());
            set_y(get_y() + get_speed());

            // change label position
            change_position(get_x(), get_y());
        }
    }
}
