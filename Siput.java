import static java.lang.Math.abs;

public class Siput extends Pet implements AbleToSearch<Coin> {
  private int speed;

  /**
   * default constructor.
   */
  public Siput() {

    setSpeed(Constants.SIPUT_MOVEMENT_SPD);
    setDir("Right");

    setX(Constants.SCREEN_WIDTH / 2);
    setY(Constants.SCREEN_BOTTOM - 30);

    // set label image
    this.setImage(ImageCollection.siputR);

  }

  /**
   * getter speed.
   *
   * @return speed
   */
  public int getSpeed() {
    return this.speed;
  }

  /**
   * mengubah nilai speed.
   *
   * @param speed speed to set
   */
  public void setSpeed(int speed) {
    this.speed = speed;
  }

  /**
   * memindahkan siput.
   *
   * @param c list of coin to chase
   */
  public void move(LinkedList<Coin> c) {
    double xcoin;

    if (c.getNBelmt() > 0) {
      int radius = inRadius(c);

      xcoin = c.get(radius).getX();
      if (abs(xcoin - getX()) > 30) {
        if (xcoin - getX() > 0) {
          setX(getX() + getSpeed());

          setDir("Right");
          setImage(ImageCollection.siputR);

        } else {
          setX(getX() - getSpeed());

          setDir("Left");
          setImage(ImageCollection.siputL);
        }
      }
    }
  }

  /**
   * mencari coin.
   *
   * @param c coin to search
   * @return boolean find
   */
  public boolean findCoin(LinkedList<Coin> c) {
    boolean find = false;
    int i = 1;

    while (i < c.getNBelmt() && !find) {
      if (c.get(i).getY() == Constants.SCREEN_BOTTOM) {
        find = true;
      } else {
        i++;
      }
    }
    return find;
  }

  /**
   * mencari coin yang ada di dalam radius siput.
   *
   * @param c list of coin to find
   * @return idx coin dalam radius, 0 jika tidak ada coin dalam radius
   */
  public int inRadius(LinkedList<Coin> c) {
    int idx = 1;
    int nearest;
    int radius = 1;

    if (findCoin(c)) {
      for (idx = 1; idx <= c.getNBelmt(); idx++) {
        if (c.get(idx).getY() == Constants.SCREEN_BOTTOM) {
          break;
        }
      }
      nearest = (int) abs(c.get(idx).getX() - getX());
      while (idx + 1 < c.getNBelmt()) {
        if (c.get(idx).getY() == Constants.SCREEN_BOTTOM) {
          if (abs(c.get(idx).getX() - getX()) < nearest) {
            nearest = (int) abs(c.get(idx).getX() - getX());
            radius = idx;
          } else {
            idx++;
          }
        } else {
          idx++;
        }
      }
    } else {
      nearest = (int) c.get(idx).getY();
      for (idx = 2; idx <= c.getNBelmt(); idx++) {
        if (c.get(idx).getY() > nearest) {
          radius = idx;
        }
      }
    }
    return radius;
  }

  /**
   * mengambil coin.
   *
   * @param c coin to take
   * @return idx coin yang diambil
   */
  public int takeCoin(LinkedList<Coin> c) {
    if (c.getNBelmt() > 0) {
      int idx = inRadius(c);

      Coin currentCoin = c.get(idx);

      if ((currentCoin.getX() >= getX() - 30)
              && (currentCoin.getX() <= getX() + 30)
              && (currentCoin.getY() >= Constants.SCREEN_BOTTOM)) {
        int value = currentCoin.getValue();
        c.remove(currentCoin);
        return value;

      } else {
        return 0;
      }
    } else {
      return 0;
    }
  }
}
