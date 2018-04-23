import java.util.Random;

public abstract class Fish extends Object {

    private static int fish_count = 0;
    private int fish_id;
    private int fish_price;
    private int coin_value;
    private double hunger;
    private int speed;
    private boolean hungry;
    private int time_move;
    private int x_move;
    private int y_move;
    private double max_hunger = Constants.FISH_MAX_HUNGER;

    /**
     * constructor with parameter
     *
     * @param price
     * @param cvalue
     */
    Fish(int price, int cvalue) {

        Random rand = new Random();
        // set position
        double random_x = rand.nextDouble() * 200;
        double random_y = rand.nextDouble() * 200;

        set_x(Constants.SCREEN_RIGHT / 2 + random_x);
        set_y(Constants.SCREEN_BOTTOM / 2 + random_y);

        fish_count++;

        set_id(fish_count);
        set_price(price);
        set_coin_value(cvalue);
        fullHunger();   //set hunger to max value
        set_hungry(false);
        set_dir("Right");
        time_move = Constants.FISH_MAX_TIMER;
        x_move = 1;
        y_move = 1;
    }

    /**
     * @return fish_id
     */
    public int get_id() {
        return fish_id;
    }

    public void set_id(int id) {
        fish_id = id;
    }

    /**
     * @return fish_price
     */
    public int get_price() {
        return fish_price;
    }

    public void set_price(int price) {
        fish_price = price;
    }

    /**
     * @return coin_value
     */
    public int get_coin_value() {
        return coin_value;
    }

    public void set_coin_value(int cvalue) {
        coin_value = cvalue;
    }

    /**
     * @return hunger
     */
    public double get_hunger() {
        return hunger;
    }

    public void set_hunger(double hunger) {
        this.hunger = hunger;
    }

    /**
     * @return speed
     */
    public int get_speed() {
        return speed;
    }

    public void set_speed(int spd) {
        speed = spd;
    }

    /**
     * @return hungry
     */
    public boolean get_hungry() {
        return hungry;
    }

    public void set_hungry(boolean status) {
        hungry = status;
    }

    /**
     * @return time_move
     */
    public int get_time_move() {
        return time_move;
    }

    public void set_time_move(int t) {
        time_move = t;
    }

    /**
     * @return x_move
     */
    public int get_x_move() {
        return x_move;
    }

    public void set_x_move(int x) {
        x_move = x;
    }

    /**
     * @return y_move
     */
    public int get_y_move() {
        return y_move;
    }

    public void set_y_move(int y) {
        y_move = y;
    }

    /**
     * @return max_hunger
     */
    public double get_max_hunger() {
        return max_hunger;
    }

    public void set_max_hunger(double h) {
        max_hunger = h;
    }

    public void fullHunger() {
        // set hunger to max value 
        set_hunger(get_max_hunger());
    }

    public void makeHunger() {
        // Periodicly make fish hungry 
        set_hunger(get_hunger() - Constants.FISH_HUNGER_DECREASE_RATE);
    }

    public boolean isHungry() {
        // check if fish hunger is below certain point
        if (get_hunger() <= Constants.FISH_HUNGRY_BORDERLINE) {
            set_hungry(true);
            return true;
        } else {
            return false;
        }
    }

    public boolean isDead() {
        // check if fish hunger is below or equal zero
        if (get_hunger() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setRandomDirection() {
        Random rand = new Random();
        int x = rand.nextInt(3);
        int y = rand.nextInt(3);
        if (x == 1) {
            x = -1;
            set_dir("Left");
        } else if (x == 2) {
            x = 0;
        } else {
            x = 1;
            set_dir("Right");
        }
        if (y == 1) {
            y = -1;
        } else if (y == 2) {
            y = 0;
        } else {
            y = 1;
        }
        set_x_move(x);
        set_y_move(y);
    }
}