import java.util.*;

public class Food extends Object {
    private static int foodCount = 0;
    private int foodId;
    private int foodSpeed;

    /**
     * default constructor.
     */
    public Food() {
        setY(Constants.SCREEN_TOP);
        Random rand = new Random();
        int a = rand.nextInt(Constants.SCREEN_WIDTH + 1);

        setX((double) a);
        foodCount += 1;
        setId(foodCount);
        setSpeed(Constants.FOOD_MOVEMENT_SPD);

        this.setImage(ImageCollection.food);
    }

    /**
     * default constructor.
     * @param x location x
     */
    public Food(double x) {

        setY(Constants.SCREEN_TOP);
        setX(x);
        
        foodCount += 1;
        setId(foodCount);
        setSpeed(Constants.FOOD_MOVEMENT_SPD);

        this.setImage(ImageCollection.food);
    }

    /**
     * getter foodId.
     * @return foodId
     */
    public int getId() {
        return this.foodId;
    }

    /**
     * setter foodId.
     * @param id input id
     */
    private void setId(int id) {
        this.foodId = id;
    }

    /**
     * getter foodSpeed.
     * @return foodSpeed
     */
    public int getSpeed() {
        return this.foodSpeed;
    }

    /**
     * setter foodSpeed.
     * @param spd input speed
     */
    private void setSpeed(int spd) {
        this.foodSpeed = spd;
    }

    /**
     * move food towards screen bottom.
     */
    public void move() {

        if (getY() <= Constants.SCREEN_BOTTOM) {
            // System.out.println("Food move " + get_x() + "," + get_y());
            setY(getY() + getSpeed());

        }
    }
}
