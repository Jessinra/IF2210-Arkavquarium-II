public class Coin extends Object implements Moveable {

  public static int coinAmount = 0;
  private int coinId;
  private int coinValue;
  private int coinSpeed;

  /**
   * constructor with parameter.
   *
   * @param x         location x
   * @param y         location y
   * @param coinValue value of coin
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
   * getter coinId.
   *
   * @return coinId
   */
  public int getId() {
    return coinId;
  }

  /**
   * setter coinId.
   *
   * @param coinId the id of coin to set to
   */
  public void setId(int coinId) {
    this.coinId = coinId;
  }

  /**
   * getter coinValue.
   *
   * @return coinValue
   */
  public int getValue() {
    return coinValue;
  }

  /**
   * setter setValue.
   *
   * @param coinValue the value of coin to set to
   */
  public void setValue(int coinValue) {
    this.coinValue = coinValue;
  }

  /**
   * getter coinSpeed.
   *
   * @return coinSpeed
   */
  public int getSpeed() {
    return coinSpeed;
  }

  /**
   * setter coinSpeed.
   *
   * @param coinSpeed the speed of coin to set to
   */
  public void setSpeed(int coinSpeed) {
    this.coinSpeed = coinSpeed;
  }

  /**
   * memindahkan coin.
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