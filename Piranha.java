public class Piranha extends Fish implements AbleToSearch<Guppy> {

  /**
   * default constructor.
   */
  public Piranha() {
    super(Constants.PIRANHA_COIN_VAL);
    setSpeed(Constants.PIRANHA_MOVEMENT_SPD);

    this.setImage(ImageCollection.piranhaR);
  }

  /**
   * change image of piranha.
   */
  public void updateImage() {
    if (isHungry()) {
      if (getDir().equals("Left")) {
        setImage(ImageCollection.piranhaLH);
      } else {
        setImage(ImageCollection.piranhaRH);
      }
    } else {
      if (getDir().equals("Left")) {
        setImage(ImageCollection.piranhaL);
      } else {
        setImage(ImageCollection.piranhaR);
      }
    }
  }

  /**
   * mencari guppy dalam radius piranha.
   *
   * @param g list of guppy to find
   * @return guppy id yang ada di dalam radius, 1 by default
   */
  public int findGuppy(LinkedList<Guppy> g) {

    int idx = 1;
    int i = 2; //indeks perbandingan mulai dari 2

    while (i <= g.getNBelmt()) {
      Guppy currentGuppy = g.get(i);
      if (currentGuppy.getX() > Constants.SCREEN_TOP
              && currentGuppy.getX() < Constants.SCREEN_BOTTOM
              && currentGuppy.getX() > Constants.SCREEN_LEFT
              && currentGuppy.getX() < Constants.SCREEN_RIGHT
              && euclidean(g.get(idx)) > euclidean(currentGuppy)) {
        idx = i;
      } else {
        i++;
      }
    }
    return idx;
  }

  /**
   * memindahkan piranha.
   *
   * @param g list of guppy
   */
  public void move(LinkedList<Guppy> g) {

    if (isHungry() && g.getNBelmt() > 0) {
      //mengejar food pakai tips
      int idx = findGuppy(g);
      if (g.get(idx).getX() < getX()) {
        setDir("Left");
      } else {
        setDir("Right");
      }
      double a = Math.atan2(g.get(idx).getY() - getY(), g.get(idx).getX() - getX());
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
   * euclidean antara piranha dan guppy.
   *
   * @param g guppy to count
   * @return nilai euclidean
   */
  public double euclidean(Guppy g) {

    double xpiranha = getX();
    double ypiranha = getY();
    double xguppy = g.getX();
    double yguppy = g.getY();

    return (Math.sqrt(Math.pow(xpiranha - xguppy, 2) + Math.pow(ypiranha - yguppy, 2)));
  }

  /**
   * mencari guppy yang ada di dalam radius piranha.
   *
   * @param g list of guppy to find
   * @return guppy id dalam radius piranha, -999 jika tidak ada guppy dalam radius
   */
  public int inRadius(LinkedList<Guppy> g) {

    int idx = 1;
    double radius = 70;
    boolean find = false;
    if (g.getNBelmt() > 0) {
      while (!find && idx <= g.getNBelmt()) {
        if ((radius > Math.abs(getX() - g.get(idx).getX()))
                && (radius > Math.abs(getY() - g.get(idx).getY()))) {
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
   * piranha makan.
   *
   * @param g guppy to eat
   * @return guppy id yang dimakan
   */
  public int eat(LinkedList<Guppy> g) {
    int idx = inRadius(g);
    // found
    if (idx != -999 && isHungry()) {
      // get eaten guppy lvl
      int guppyLv = g.get(idx).getLevel();
      fullHunger();
      // remove guppy from list
      g.remove(g.get(idx));
      return guppyLv;
    } else {
      // not eating anything
      return -1;
    }
  }
}