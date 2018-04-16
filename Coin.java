public class Coin extends Object implements Moveable {

    public static int coin_amount = 0;
    private int coin_id;
    private int coin_value;
    private int coin_speed;

    /**
     * default constructor
     */
    public Coin() {
        set_x(0);
        set_y(0);
        set_id(0);
        set_value(0);
        set_speed(0);
    }


    /**
     * constructor with parameter
     * @param x
     * @param y
     * @param coin_value
     */
    public Coin(int x, int y, int coin_value) {
        set_x(x);
        set_y(y);

        coin_amount++;

        set_id(coin_amount);
        set_value(coin_value);
        set_speed(Constants.COIN_MOVEMENT_SPD);
    }

    @Override
    public double get_x() {
        return position_x;
    }

    @Override
    public double get_y() {
        return position_y;
    }

    @Override
    public void set_x(double x) {
        position_x = x;
    }

    @Override
    public void set_y(double y) {
        position_y = y;
    }

    @Override
    public void set_dir(String dir) {
        direction = dir;
    }

    @Override
    public String get_dir() {
        return direction;
    }

    /**
     * @return coin_id
     */
    public int get_id() {
        return coin_id;
    }

    public void set_id(int coin_id) {
        this.coin_id = coin_id;
    }

    public int get_value() {
        return coin_value;
    }

    public void set_value(int coin_value) {
        this.coin_value = coin_value;
    }

    public int get_speed() {
        return coin_speed;
    }

    public void set_speed(int coin_speed) {
        this.coin_speed = coin_speed;
    }

    @Override
    public void draw() {
        set_y(2);

    }


    public void move(double sec_since_last) {
        // if coin is not on buttom yet
        if (get_y() <= Constants.SCREEN_BUTTOM) {
            // move coin towards buttom
            set_y(get_y() + (get_speed() * sec_since_last));
        } else {
            set_y(Constants.SCREEN_BUTTOM);
        }
    }
}