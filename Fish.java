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
     * getter fish_id
     * @return fish_id
     */
    public int get_id() {
        return fish_id;
    }

    /**
     * setter fish_id
     * @param id
     */
    public void set_id(int id) {
        fish_id = id;
    }

    /**
     * getter fish_price
     * @return fish_price
     */
    public int get_price() {
        return fish_price;
    }

    /**
     * setter fish_price
     * @param price
     */
    public void set_price(int price) {
        fish_price = price;
    }

    /**
     * getter coin_value
     * @return coin_value
     */
    public int get_coin_value() {
        return coin_value;
    }

    /**
     * setter coin_value
     * @param cvalue
     */
    public void set_coin_value(int cvalue) {
        coin_value = cvalue;
    }

    /**
     * getter hunger
     * @return hunger
     */
    public double get_hunger() {
        return hunger;
    }

    /**
     * setter hunger
     * @param hunger
     */
    public void set_hunger(double hunger) {
        this.hunger = hunger;
    }

    /**
     * getter speed
     * @return speed
     */
    public int get_speed() {
        return speed;
    }

    /**
     * setter speed
     * @param spd
     */
    public void set_speed(int spd) {
        speed = spd;
    }

    /**
     * getter hungry
     * @return hungry
     */
    public boolean get_hungry() {
        return hungry;
    }

    /**
     * setter hungry
     * @param status
     */
    public void set_hungry(boolean status) {
        hungry = status;
    }

    /**
     * getter time_move
     * @return time_move
     */
    public int get_time_move() {
        return time_move;
    }

    /**
     * setter time_move
     * @param t
     */
    public void set_time_move(int t) {
        time_move = t;
    }

    /**
     * getter x_move
     * @return x_move
     */
    public int get_x_move() {
        return x_move;
    }

    /**
     * setter x_move
     * @param x
     */
    public void set_x_move(int x) {
        x_move = x;
    }

    /**
     * getter y_move
     * @return y_move
     */
    public int get_y_move() {
        return y_move;
    }

    /**
     * setter y_move
     * @param y
     */
    public void set_y_move(int y) {
        y_move = y;
    }

    /**
     * getter max_hunger
     * @return max_hunger
     */
    public double get_max_hunger() {
        return max_hunger;
    }

    /**
     * setter max_hunger
     * @param h
     */
    public void set_max_hunger(double h) {
        max_hunger = h;
    }

    /**
     * set hunger to max value
     */
    public void fullHunger() {
        set_hunger(get_max_hunger());
    }

    /**
     * membuat fish lapar secara periodik
     */
    public void makeHunger() {
        set_hunger(get_hunger() - Constants.FISH_HUNGER_DECREASE_RATE);
    }

    /**
     * cek tingkat kelaparan fish
     * @return boolean hungry
     */
    public boolean isHungry() {
        // check if fish hunger is below certain point
        if (get_hunger() <= Constants.FISH_HUNGRY_BORDERLINE) {
            set_hungry(true);
            return true;
        } else {
            return false;
        }
    }

    /**
     * cek status fish
     * @return boolean dead
     */
    public boolean isDead() {
        // check if fish hunger is below or equal zero
        if (get_hunger() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * mengatur arah perpindahan fish
     */
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