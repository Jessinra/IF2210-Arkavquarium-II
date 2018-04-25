import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;

public class Aquarium extends Object {

  public static int egg = 0;
  public static int money = 20000;

  private LinkedList<Guppy> listGuppy = new LinkedList<>();
  private LinkedList<Piranha> listPiranha = new LinkedList<>();
  private LinkedList<Siput> listSiput = new LinkedList<>();
  private LinkedList<Food> listFood = new LinkedList<>();
  private LinkedList<Coin> listCoin = new LinkedList<>();

  /**
   * default constructor.
   */
  public Aquarium() {
    // frame : where to put the aquarium

    ImageCollection.initImage(); // initialize all BufferedImage object

    Guppy g = new Guppy();
    Guppy g1 = new Guppy();

    this.addGuppy(g);
    this.addGuppy(g1);

    Siput s = new Siput();
    this.addSiput(s);

    setImage(ImageCollection.aquarium);
  }

  /**
   * getter list guppy.
   *
   * @return list_guppy
   */
  public LinkedList<Guppy> getListGuppy() {
    return listGuppy;
  }

  /**
   * getter list piranha.
   *
   * @return list_piranha
   */
  public LinkedList<Piranha> getListPiranha() {
    return listPiranha;
  }

  /**
   * getter list siput.
   *
   * @return list_siput
   */
  public LinkedList<Siput> getListSiput() {
    return listSiput;
  }

  /**
   * getter list food.
   *
   * @return list_food
   */
  public LinkedList<Food> getListFood() {
    return listFood;
  }

  /**
   * getter list coin.
   *
   * @return list_coin
   */
  public LinkedList<Coin> getListCoin() {
    return listCoin;
  }

  /**
   * menambahkan guppy ke dalam list guppy.
   *
   * @param guppy guppy to add
   */
  public void addGuppy(Guppy guppy) {
    listGuppy.add(guppy);
  }

  /**
   * menghapus guppy dari dalam list guppy.
   *
   * @param guppy guppy to remove
   */
  public void removeGuppy(Guppy guppy) {
    listGuppy.remove(guppy);
  }

  /**
   * menambahkan piranha ke dalam list piranha.
   *
   * @param piranha piranha to add
   */
  public void addPiranha(Piranha piranha) {
    listPiranha.add(piranha);
  }

  /**
   * menghapus piranha dari dalam list piranha.
   *
   * @param piranha piranha to remove
   */
  public void removePiranha(Piranha piranha) {
    listPiranha.remove(piranha);
  }

  /**
   * menambahkan siput ke dalam list siput.
   *
   * @param siput siput to add
   */
  public void addSiput(Siput siput) {
    listSiput.add(siput);
  }

  /**
   * menambahkan food ke dalam list food.
   *
   * @param food food to add
   */
  public void addFood(Food food) {
    listFood.add(food);
  }

  /**
   * menghapus food dari dalam list food.
   *
   * @param food food to remove
   */
  public void removeFood(Food food) {
    listFood.remove(food);
  }

  /**
   * menambahkan coin ke dalam list coin.
   *
   * @param coin coin to add
   */
  public void addCoin(Coin coin) {
    listCoin.add(coin);
  }

  /**
   * menghapus coin dari dalam list coin.
   *
   * @param coin coin to remove
   */
  public void removeCoin(Coin coin) {
    listCoin.remove(coin);
  }

  /**
   * membeli guppy.
   * menambah guppy ke dalam list guppy dan mengurangi money.
   */
  public void buyGuppy() {

    // Money sufficient
    if (Aquarium.money >= Constants.GUPPY_PRICE) {

      Guppy g = new Guppy();
      addGuppy(g);

      Aquarium.money -= Constants.GUPPY_PRICE;


    }
  }

  /**
   * membeli piranha.
   * menambah piranha ke dalam list piranha dan mengurangi money.
   */
  public void buyPiranha() {

    // Money sufficient
    if (Aquarium.money >= Constants.PIRANHA_PRICE) {

      Piranha p = new Piranha();
      addPiranha(p);

      Aquarium.money -= Constants.PIRANHA_PRICE;

    }
  }

  /**
   * membeli food.
   * menambah food ke dalam list food dan mengurangi money.
   */
  public void buyFood() {

    // Money sufficient
    if (Aquarium.money >= Constants.FOOD_PRICE) {

      Food f = new Food();
      addFood(f);

      Aquarium.money -= Constants.FOOD_PRICE;
    }
  }

  /**
   * membeli food dengan lokasi parameter x.
   * menambah food ke dalam list food dan mengurangi money.
   *
   * @param x lokasi x food dimunculkan
   */
  public void buyFood(double x) {
    // Money sufficient
    if (Aquarium.money >= Constants.FOOD_PRICE) {

      Food f = new Food(x);
      addFood(f);

      Aquarium.money -= Constants.FOOD_PRICE;
    }
  }

  /**
   * membeli egg.
   * menambah egg jumlah nilai variabel egg dan mengurangi money.
   */
  public void buyEgg() {

    // Money sufficient
    if (Aquarium.money >= Constants.EGG_PRICE) {

      Aquarium.egg++;
      Aquarium.money -= Constants.EGG_PRICE;
    }
  }

  /**
   * membeli siput.
   * menambah siput ke dalam list siput dan mengurangi money.
   */
  public void buySnail() {

    // Money sufficient
    if (Aquarium.money >= Constants.SIPUT_PRICE) {

      Siput s = new Siput();
      addSiput(s);

      Aquarium.money -= Constants.SIPUT_PRICE;
    }

    // ELSE: unsufficient money
    // System.out.println("money not enough");
  }

  /**
   * menghitung euclidean (jarak lurus antar dua titik).
   *
   * @param x lokasi x
   * @param y lokasi y
   * @param c coin to search
   */
  public double euclidean(double x, double y, Coin c) {
    // get euclidean distance to coin

    double xcoin = c.getX();
    double ycoin = c.getY();

    return (sqrt(pow(x - xcoin, 2) + pow(y - ycoin, 2)));
  }

  /**
   * mengecek elemen di dalam radius.
   *
   * @param x lokasi x mouse
   * @param y lokasi y mouse
   */
  public int inRadius(double x, double y) {

    int idx = 1;
    double nearest;
    int radius = 1;

    LinkedList<Coin> listCoin = getListCoin();
    nearest = listCoin.get(idx).getX();

    idx++;
    while (idx <= listCoin.getNBelmt()) {
      if (euclidean(x, y, listCoin.get(idx)) < nearest) {
        nearest = euclidean(x, y, listCoin.get(idx));
        radius = idx;
      } else {
        idx++;
      }
    }

    // return id coin yg di dalam radius
    return radius;
  }

  /**
   * klik coin menggunakan kursor.
   *
   * @param x lokasi x kursor
   * @param y lokasi y kursor
   */
  public int clickCoin(double x, double y) {
    //find coin in radius
    if (getListCoin().getNBelmt() > 0) {

      int idx = inRadius(x, y);
      Coin currentCoin = getListCoin().get(idx);

      if (currentCoin.getX() >= x - 100
              && currentCoin.getX() <= x + 100
              && currentCoin.getY() >= y - 100
              && currentCoin.getY() <= y + 100) {

        int value = currentCoin.getValue();
        //getListCoin().remove(currentCoin);
        removeCoin(currentCoin);
        return value;

      } else {
        return 0;
      }
    } else {
      return 0;
    }
  }
}

