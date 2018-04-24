public class Coin extends Object implements Moveable {

    public static int coinAmount = 0;
    private int coinId;
    private int coinValue;
    private int coinSpeed;


    /**
     * default constructor
     */
    public Coin() {
        setX(0);
        setY(0);

        setId(0);
        setValue(0);
        setSpeed(0);

        // set label image
        this.setImage(ImageCollection.coin);

    }

    /**
     * constructor with parameter
     *
     * @param x
     * @param y
     * @param coinValue
     */
    public Coin(double x, double y, int coinValue) {
        setX(x);
        setY(y);

        coinAmount++;

        setId(coinAmount);
        setValue(coinValue);
        setSpeed(Constants.COIN_MOVEMENT_SPD);

        // set label image
        this.setImage(ImageCollection.coin);
    }

    /**
     * getter coin_id
     * @return coin_id
     */
    public int getId() {
        return coinId;
    }

    /**
     * setter coin_id
     * @param coinId
     */
    public void setId(int coinId) {
        this.coinId = coinId;
    }

    /**
     * getter coin_value
     * @return coin_value
     */
    public int getValue() {
        return coinValue;
    }

    /**
     * setter set_value
     * @param coinValue
     */
    public void setValue(int coinValue) {
        this.coinValue = coinValue;
    }

    /**
     * getter coin_speed
     * @return coin_speed
     */
    public int getSpeed() {
        return coinSpeed;
    }

    /**
     * setter coin_speed
     * @param coinSpeed
     */
    public void setSpeed(int coinSpeed) {
        this.coinSpeed = coinSpeed;
    }

    /**
     * memindahkan coin
     */
    public void move() {
        // if coin is not on buttom yet
        if (getY() < Constants.SCREEN_BOTTOM) {
            // move coin towards buttom
            setY(getY() + getSpeed());
        } else {
            setY(Constants.SCREEN_BOTTOM);
        }
    }
}