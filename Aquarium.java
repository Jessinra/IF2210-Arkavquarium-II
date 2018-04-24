import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;

public class Aquarium extends Object {

    static public int egg = 0;
    static public int money = 20000;

    private LinkedList<Guppy> list_guppy = new LinkedList<>();
    private LinkedList<Piranha> list_piranha = new LinkedList<>();
    private LinkedList<Siput> list_siput = new LinkedList<>();
    private LinkedList<Food> list_food = new LinkedList<>();
    private LinkedList<Coin> list_coin = new LinkedList<>();

    /**
     * default constructor.
     */
    public Aquarium() {
        // frame : where to put the aquarium

        ImageCollection.init_image(); // initialize all BufferedImage object

        Guppy g = new Guppy();
        Guppy g1 = new Guppy();

        this.add_guppy(g);
        this.add_guppy(g1);

        Siput s = new Siput();
        this.add_siput(s);

        set_image(ImageCollection.aquarium);
    }

    /**
     * getter list guppy.
     * @return list_guppy
     */
    public LinkedList<Guppy> getList_guppy() {
        return list_guppy;
    }

    /**
     * getter list piranha.
     * @return list_piranha
     */
    public LinkedList<Piranha> getList_piranha() {
        return list_piranha;
    }

    /**
     * getter list siput.
     * @return list_siput
     */
    public LinkedList<Siput> getList_siput() {
        return list_siput;
    }

    /**
     * getter list food.
     * @return list_food
     */
    public LinkedList<Food> getList_food() {
        return list_food;
    }

    /**
     * getter list coin.
     * @return list_coin
     */
    public LinkedList<Coin> getList_coin() {
        return list_coin;
    }

    /**
     * menambahkan guppy ke dalam list guppy.
     * @param guppy guppy to add
     */
    public void add_guppy(Guppy guppy) {
        list_guppy.add(guppy);
    }

    /**
     * menghapus guppy dari dalam list guppy.
     * @param guppy guppy to remove
     */
    public void remove_guppy(Guppy guppy) {
        list_guppy.remove(guppy);
    }

    /**
     * menambahkan piranha ke dalam list piranha.
     * @param piranha piranha to add
     */
    public void add_piranha(Piranha piranha) {
        list_piranha.add(piranha);
    }

    /**
     * menghapus piranha dari dalam list piranha.
     * @param piranha piranha to remove
     */
    public void remove_piranha(Piranha piranha) {
        list_piranha.remove(piranha);
    }

    /**
     * menambahkan siput ke dalam list siput.
     * @param siput siput to add
     */
    public void add_siput(Siput siput) {
        list_siput.add(siput);
    }

    /**
     * menghapus siput dari dalam list siput.
     * @param siput siput to remove
     */
    public void remove_siput(Siput siput) {
        list_siput.remove(siput);
    }

    /**
     * menambahkan food ke dalam list food.
     * @param food food to add
     */
    public void add_food(Food food) {
        list_food.add(food);
    }

    /**
     * menghapus food dari dalam list food.
     * @param food food to remove
     */
    public void remove_food(Food food) {
        list_food.remove(food);
    }

    /**
     * menambahkan coin ke dalam list coin.
     * @param coin coin to add
     */
    public void add_coin(Coin coin) {
        list_coin.add(coin);
    }

    /**
     * menghapus coin dari dalam list coin.
     * @param coin coin to remove
     */
    public void remove_coin(Coin coin) {
        list_coin.remove(coin);
    }

    /**
     * membeli guppy.
     * menambah guppy ke dalam list guppy dan mengurangi money.
     */
    public void buy_guppy() {

        // Money sufficient 
        if (Aquarium.money >= Constants.GUPPY_PRICE) {

            Guppy g = new Guppy();
            add_guppy(g);

            Aquarium.money -= Constants.GUPPY_PRICE;


        }
    }

    /**
     * membeli piranha.
     * menambah piranha ke dalam list piranha dan mengurangi money.
     */
    public void buy_piranha() {

        // Money sufficient 
        if (Aquarium.money >= Constants.PIRANHA_PRICE) {

            Piranha p = new Piranha();
            add_piranha(p);

            Aquarium.money -= Constants.PIRANHA_PRICE;

        }
    }

    /**
     * membeli food.
     * menambah food ke dalam list food dan mengurangi money.
     */
    public void buy_food() {

        // Money sufficient 
        if (Aquarium.money >= Constants.FOOD_PRICE) {

            Food f = new Food();
            add_food(f);

            Aquarium.money -= Constants.FOOD_PRICE;
        }
    }

    /**
     * membeli food dengan lokasi parameter x.
     * menambah food ke dalam list food dan mengurangi money.
     * @param x lokasi x food dimunculkan
     */
    public void buy_food(double x) {
        // Money sufficient 
        if (Aquarium.money >= Constants.FOOD_PRICE) {

            Food f = new Food(x);
            add_food(f);

            Aquarium.money -= Constants.FOOD_PRICE;
        }
    }

    /**
     * membeli egg.
     * menambah egg jumlah nilai variabel egg dan mengurangi money.
     */
    public void buy_egg() {

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
    public void buy_snail() {

        // Money sufficient 
        if (Aquarium.money >= Constants.SIPUT_PRICE) {

            Siput s = new Siput();
            add_siput(s);

            Aquarium.money -= Constants.SIPUT_PRICE;
        }

        // unsufficient money
        else {
            // System.out.println("money not enough");
        }
    }

    /**
     * menghitung euclidean (jarak lurus antar dua titik).
     * @param x lokasi x
     * @param y lokasi y
     * @param c coin to search
     */
    public double euclidean(double x, double y, Coin c) {
        // get euclidean distance to coin

        double x_coin = c.get_x();
        double y_coin = c.get_y();

        return (sqrt(pow(x - x_coin, 2)) + (pow(y - y_coin, 2)));
    }

    /**
     * mengecek elemen di dalam radius.
     * @param x lokasi x mouse
     * @param y lokasi y mouse
     */
    public int inRadius(double x, double y) {

        int idx = 1;
        double nearest;
        int radius = 1;

        nearest = getList_coin().get(idx).get_x();
        while (idx + 1 < getList_coin().getNBelmt()) {
            if (euclidean(x, y, getList_coin().get(idx)) < nearest) {
                nearest = euclidean(x, y, getList_coin().get(idx));
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
     * @param x lokasi x kursor
     * @param y lokasi y kursor
     */
    public int click_coin(double x, double y) {
        //find coin in radius
        if (getList_coin().getNBelmt() > 0) {
            int idx = inRadius(x, y);
            if (getList_coin().get(idx).get_x() >= x - 30 && getList_coin().get(idx).get_x() <= x + 30 && getList_coin().get(idx).get_y() >= y - 30 && getList_coin().get(idx).get_y() <= y + 30) {
                int value = getList_coin().get(idx).get_value();
                getList_coin().remove(getList_coin().get(idx));
                return value;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}

