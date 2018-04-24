import java.util.Random;

public abstract class Fish extends Object {

    private static int fishCount = 0;
    private int fishId;
    private int fishPrice;
    private int coinValue;
    private double hunger;
    private int speed;
    private boolean hungry;
    private int timeMove;
    private int xMove;
    private int yMove;
    private double maxHunger = Constants.FISH_MAX_HUNGER;

    /**
     * constructor with parameter
     *
     * @param price
     * @param cvalue
     */
    Fish(int price, int cvalue) {

        Random rand = new Random();
        // set position
        double randomX = rand.nextDouble() * 200;
        double randomY = rand.nextDouble() * 200;

        setX(Constants.SCREEN_RIGHT / 2 + randomX);
        setY(Constants.SCREEN_BOTTOM / 2 + randomY);

        fishCount++;

        setId(fishCount);
        setPrice(price);
        setCoinValue(cvalue);
        fullHunger();   //set hunger to max value
        setHungry(false);
        setDir("Right");
        timeMove = Constants.FISH_MAX_TIMER;
        xMove = 1;
        yMove = 1;
    }

    /**
     * getter fish_id
     * @return fish_id
     */
    public int getId() {
        return fishId;
    }

    /**
     * setter fish_id
     * @param id
     */
    public void setId(int id) {
        fishId = id;
    }

    /**
     * getter fish_price
     * @return fish_price
     */
    public int getPrice() {
        return fishPrice;
    }

    /**
     * setter fish_price
     * @param price
     */
    public void setPrice(int price) {
        fishPrice = price;
    }

    /**
     * getter coin_value
     * @return coin_value
     */
    public int getCoinValue() {
        return coinValue;
    }

    /**
     * setter coin_value
     * @param cvalue
     */
    public void setCoinValue(int cvalue) {
        coinValue = cvalue;
    }

    /**
     * getter hunger
     * @return hunger
     */
    public double getHunger() {
        return hunger;
    }

    /**
     * setter hunger
     * @param hunger
     */
    public void setHunger(double hunger) {
        this.hunger = hunger;
    }

    /**
     * getter speed
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * setter speed
     * @param spd
     */
    public void setSpeed(int spd) {
        speed = spd;
    }

    /**
     * getter hungry
     * @return hungry
     */
    public boolean getHungry() {
        return hungry;
    }

    /**
     * setter hungry
     * @param status
     */
    public void setHungry(boolean status) {
        hungry = status;
    }

    /**
     * getter time_move
     * @return time_move
     */
    public int getTimeMove() {
        return timeMove;
    }

    /**
     * setter time_move
     * @param t
     */
    public void setTimeMove(int t) {
        timeMove = t;
    }

    /**
     * getter x_move
     * @return x_move
     */
    public int getXMove() {
        return xMove;
    }

    /**
     * setter x_move
     * @param x
     */
    public void setXMove(int x) {
        xMove = x;
    }

    /**
     * getter y_move
     * @return y_move
     */
    public int getYMove() {
        return yMove;
    }

    /**
     * setter y_move
     * @param y
     */
    public void setYMove(int y) {
        yMove = y;
    }

    /**
     * getter max_hunger
     * @return max_hunger
     */
    public double getMaxHunger() {
        return maxHunger;
    }

    /**
     * setter max_hunger
     * @param h
     */
    public void setMaxHunger(double h) {
        maxHunger = h;
    }

    /**
     * set hunger to max value
     */
    public void fullHunger() {
        setHunger(getMaxHunger());
    }

    /**
     * membuat fish lapar secara periodik
     */
    public void makeHunger() {
        setHunger(getHunger() - Constants.FISH_HUNGER_DECREASE_RATE);
    }

    /**
     * cek tingkat kelaparan fish
     * @return boolean hungry
     */
    public boolean isHungry() {
        // check if fish hunger is below certain point
        if (getHunger() <= Constants.FISH_HUNGRY_BORDERLINE) {
            setHungry(true);
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
        if (getHunger() <= 0) {
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
            setDir("Left");
        } else if (x == 2) {
            x = 0;
        } else {
            x = 1;
            setDir("Right");
        }
        if (y == 1) {
            y = -1;
        } else if (y == 2) {
            y = 0;
        } else {
            y = 1;
        }
        setXMove(x);
        setYMove(y);
    }
}