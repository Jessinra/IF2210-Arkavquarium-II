public class Guppy extends Fish implements AbleToSearch<Food> {

  private int numberEat;
  private int levelGrow;
  private double timer;

  /**
   * default constructor.
   */
  Guppy() {
    super(Constants.GUPPY_COIN_VAL_01);
    // value from constant.h
    setSpeed(Constants.GUPPY_MOVEMENT_SPD);
    setNumberEat(0);
    setTimer(Constants.GUPPY_DROP_COIN_TIME);
    setLevel(1);

    this.setImage(ImageCollection.guppy01L);
  }

  /**
   * getter level_grow.
   *
   * @return level_grow
   */
  public int getLevel() {
    return levelGrow;
  }

  /**
   * setter level_grow.
   *
   * @param lv level to set
   */
  public void setLevel(int lv) {
    levelGrow = lv;
  }

  /**
   * getter number_eat.
   *
   * @return number_eat
   */
  public int getNumberEat() {
    return numberEat;
  }

  /**
   * setter number_eat.
   *
   * @param number number of eaten food to set
   */
  public void setNumberEat(int number) {
    numberEat = number;
  }

  /**
   * getter timer.
   *
   * @return timer
   */
  public double getTimer() {
    return timer;
  }

  /**
   * setter timer.
   *
   * @param time time to set
   */
  public void setTimer(double time) {
    timer = time;
  }

  /**
   * update guppy image.
   */
  public void updateImage() {
    if (isHungry()) {
      if (levelGrow == 1) {
        if (getDir().equals("Left")) {
          setImage(ImageCollection.guppy01LH);
        } else {
          setImage(ImageCollection.guppy01RH);
        }
      } else if (levelGrow == 2) {
        if (getDir().equals("Left")) {
          setImage(ImageCollection.guppy02LH);
        } else {
          setImage(ImageCollection.guppy02RH);
        }
      } else if (levelGrow == 3) {
        if (getDir().equals("Left")) {
          setImage(ImageCollection.guppy03LH);
        } else {
          setImage(ImageCollection.guppy03RH);
        }
      }
    } else {
      if (levelGrow == 1) {
        if (getDir().equals("Left")) {
          setImage(ImageCollection.guppy01L);
        } else {
          setImage(ImageCollection.guppy01R);
        }
      } else if (levelGrow == 2) {
        if (getDir().equals("Left")) {
          setImage(ImageCollection.guppy02L);
        } else {
          setImage(ImageCollection.guppy02R);
        }
      } else if (levelGrow == 3) {
        if (getDir().equals("Left")) {
          setImage(ImageCollection.guppy03L);
        } else {
          setImage(ImageCollection.guppy03R);
        }
      }
    }
  }

  /**
   * guppy menghasilkan coin.
   *
   * @return true for success producing coin
   */
  public boolean produceCoin() {
    // check if guppy able to drop coin
    // if yes,
    if (getTimer() <= 0) {
      // then set timer to max, and return true
      setTimer(Constants.GUPPY_DROP_COIN_TIME);
      return true;
    } else {
      // reduce drop coin time
      setTimer(getTimer() - Constants.FISH_TIMER_DEC);
      return false;
    }
  }

  /**
   * mencari food.
   *
   * @param f list of food to search
   * @return food id in radius
   */
  public int findFood(LinkedList<Food> f) {

    //nyari yg terdekat brrti pake iterate dari list Food
    int idx = 1;
    int i = 2; //indeks perbandingan mulai dari 2

    while (i <= f.getNBelmt()) {
      Food currentFood = f.get(i);
      if (currentFood.getX() > Constants.SCREEN_TOP
              && currentFood.getX() < Constants.SCREEN_BOTTOM
              && currentFood.getX() > Constants.SCREEN_LEFT
              && currentFood.getX() < Constants.SCREEN_RIGHT
              && euclidean(f.get(idx)) > euclidean(currentFood)) {
        idx = i;
      } else {
        i++;
      }
    }
    return idx;
  }

  /**
   * memindahkan guppy.
   *
   * @param f list of food
   */
  public void move(LinkedList<Food> f) {

    if (isHungry() && f.getNBelmt() > 0) {
      // mengejar food pakai tips
      int idx = findFood(f);
      if (f.get(idx).getX() < getX()) {
        setDir("Left");
      } else {
        setDir("Right");
      }

      //double atan2(double y, double x)
      double a = Math.atan2(f.get(idx).getY() - getY(), f.get(idx).getX() - getX());
      setX(getX() + (getSpeed() * Math.cos(a) * 1.5));
      setY(getY() + (getSpeed() * Math.sin(a) * 1.5));

    } else {
      //random arahnya
      if (getTimeMove() <= 0) {
        setTimeMove(Constants.FISH_MAX_TIMER);
        setRandomDirection();
      } else {
        setTimeMove(getTimeMove() - Constants.FISH_TIMER_DEC);
      }

      //kalau sampai ujung
      if (getX() >= Constants.SCREEN_RIGHT || getX() <= Constants.SCREEN_LEFT) {
        setXMove(getXMove() * (-1));
      }
      if (getY() <= Constants.SCREEN_TOP || getY() >= Constants.SCREEN_BOTTOM) {
        setYMove(getYMove() * (-1));
      }

      if (getX() + getSpeed() * getXMove() < getX()) {
        setDir("Left");
      } else if (getX() + getSpeed() * getXMove() >= getX()) {
        setDir("Right");
      }

      //pindahkan ikan
      setX(getX() + getSpeed() * getXMove());
      setY(getY() + getSpeed() * getYMove());
    }

    updateImage();
  }

  /**
   * euclidean antara food dan guppy.
   *
   * @param m food to count
   * @return nilai euclidean
   */
  public double euclidean(Food m) {
    // get euclidean distance from guppy to food

    double xguppy = getX();
    double yguppy = getY();
    double xfood = m.getX();
    double yfood = m.getY();

    return (Math.sqrt(Math.pow(xguppy - xfood, 2)) + (Math.pow(yguppy - yfood, 2)));
  }

  /**
   * mencari food dalam radius guppy.
   *
   * @param f list of food to search
   * @return food id in radius, 0 if there's none
   */
  public int inRadius(LinkedList<Food> f) {
    //nyari ikan nya udah diradius itu blm
    int idx = 1;
    double radius = 50;
    boolean find = false;
    if (f.getNBelmt() > 0) {
      while (!find && idx <= f.getNBelmt()) {
        if ((radius > Math.abs(getX() - f.get(idx).getX()))
                && (radius > Math.abs(getY() - f.get(idx).getY()))) {
          find = true;
        } else {
          idx++;
        }
      }
    }
    if (find) {
      return idx;
    } else {
      return -999;
    }
  }

  /**
   * guppy makan.
   *
   * @param f food to eat
   */
  public void eat(LinkedList<Food> f) {
    //eat gak usah pake validasi laper. yg validasi laper itu move.
    //kalau ada ikan diradius itu, eat (itu aja fx nya)

    // search for food
    int idx = inRadius(f);

    // if found
    if (idx != -999 && isHungry()) {

      // remove food from list
      f.remove(f.get(idx));

      // set hunger to max and state ishungry to false
      fullHunger();

      // increase number of food eaten
      setNumberEat(getNumberEat() + 1);

      // try to check if fish is able to grow
      grow();

    }
  }

  /**
   * guppy tumbuh.
   */
  public void grow() {
    if (getNumberEat() == Constants.GUPPY_REQ_FOOD_COUNT && getLevel() != Constants.GUPPY_MAX_LV) {

      // increase fish lv
      setLevel(getLevel() + 1);

      // increase max hunger
      //tiap naik level tambah bisa nambah laper
      setMaxHunger(getMaxHunger() + Constants.GUPPY_HUNGER_INCREASE_RATE);

      // increase the coin value
      //tiap naik level tambah harga coin nya
      setCoinValue(getCoinValue() + Constants.GUPPY_COIN_VAL_INCREASE_RATE);

      // reset the number of food eaten
      setNumberEat(0);
    }
  }
}