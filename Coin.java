public class Coin extends Object implements Moveable {

    public static int coin_amount = 0;
    private int coin_id;
    private int coin_value;
    private int coin_speed;


    /**
     * default constructor.
     */
    public Coin() {
        set_x(0);
        set_y(0);
        set_id(0);
        set_value(0);
        set_speed(0);

        // set label image
        this.set_image(ImageCollection.coin);
    }


    /**
     * constructor with parameter.
     * @param x location x
     * @param y location y
     * @param coin_value value of coin
     */
    public Coin(double x, double y, int coin_value) {
        set_x(x);
        set_y(y);

        coin_amount++;

        set_id(coin_amount);
        set_value(coin_value);
        set_speed(Constants.COIN_MOVEMENT_SPD);

        // set label image
        this.set_image(ImageCollection.coin);
    }

    /**
     * getter coin_id.
     * @return coin_id
     */
    public int get_id() {
        return coin_id;
    }

    /**
     * setter coin_id.
     * @param coin_id id to set
     */
    public void set_id(int coin_id) {
        this.coin_id = coin_id;
    }

    /**
     * getter coin_value.
     * @return coin_value
     */
    public int get_value() {
        return coin_value;
    }

    /**
     * setter set_value.
     * @param coin_value coin value to set
     */
    public void set_value(int coin_value) {
        this.coin_value = coin_value;
    }

    /**
     * getter coin_speed.
     * @return coin_speed
     */
    public int get_speed() {
        return coin_speed;
    }

    /**
     * setter coin_speed.
     * @param coin_speed coin speed to set
     */
    public void set_speed(int coin_speed) {
        this.coin_speed = coin_speed;
    }

    /**
     * memindahkan coin.
     */
    public void move() {
        // if coin is not on buttom yet
        if (get_y() < Constants.SCREEN_BOTTOM) {
            // move coin towards buttom
            set_y(get_y() + get_speed());
        } else {
            set_y(Constants.SCREEN_BOTTOM);
        }
    }
}