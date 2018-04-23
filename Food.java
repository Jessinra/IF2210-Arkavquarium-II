import java.util.*;

public class Food extends Object {
    private static int food_count = 0;
    private int food_id;
    private int food_speed;

    /**
     * default constructor
     */
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

    /**
     * default constructor
     * @param x
     */
    public Food(double x) {
        set_y(Constants.SCREEN_TOP);
        set_x(x);
        food_count += 1;
        set_id(food_count);
        set_speed(Constants.FOOD_MOVEMENT_SPD);

        this.set_image(ImageCollection.food);

        this.change_position(get_x(), get_y());
    }

    /**
     * getter food_id
     * @return food_id
     */
    public int get_id() {
        return this.food_id;
    }

    /**
     * setter food_id
     * @param id
     */
    public void set_id(int id) {
        this.food_id = id;
    }

    /**
     * getter food_speed
     * @return food_speed
     */
    public int get_speed() {
        return this.food_speed;
    }

    /**
     * setter food_speed
     * @param spd
     */
    public void set_speed(int spd) {
        this.food_speed = spd;
    }

    /**
     * memindahkan food
     */
    public void move() {

        if (get_y() <= Constants.SCREEN_BOTTOM) {
            // System.out.println("Food move " + get_x() + "," + get_y());
            set_y(get_y() + get_speed());

            // change label position
            change_position(get_x(), get_y());
        }
    }
}
