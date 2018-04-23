import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;

public class Aquarium extends Object{

    static public int egg = 0;
    static public int money = 20000;

    private LinkedList<Guppy> list_guppy = new LinkedList<>();
	private LinkedList<Piranha> list_piranha = new LinkedList<>();
	private LinkedList<Siput> list_siput = new LinkedList<>();
	private LinkedList<Food> list_food = new LinkedList<>();
    private LinkedList<Coin> list_coin = new LinkedList<>();

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
        // set panel
//        this.panel = (JPanel) frame.getContentPane();
//        this.panel.setLayout(null);
//
//        this.change_image(Aquarium.image_aquarium);
//        this.change_position(0, 0);
//        this.size = this.label.getPreferredSize();

    }

    public LinkedList<Guppy> get_list_guppy(){
        return list_guppy;
    }
    
    public LinkedList<Piranha> get_list_piranha(){
        return list_piranha;
    }
    
    public LinkedList<Siput> get_list_siput(){
        return list_siput;
    }
    
    public LinkedList<Food> get_list_food(){
        return list_food;
    }
    
    public LinkedList<Coin> get_list_coin(){
        return list_coin;
    }
    
    public void add_guppy(Guppy guppy) {
        list_guppy.add(guppy);
    }

    public void remove_guppy(Guppy guppy) {
        list_guppy.remove(guppy);
    }

    public void add_piranha(Piranha piranha) {
        list_piranha.add(piranha);
    }

    public void remove_piranha(Piranha piranha) {
        list_piranha.remove(piranha);
    }

    public void add_siput(Siput siput){
        list_siput.add(siput);
    }

    public void remove_siput(Siput siput){
        list_siput.remove(siput);
    }

    public void add_food(Food food){
        list_food.add(food);
    }

    public void remove_food(Food food){
        list_food.remove(food);
    }

    public void add_coin(Coin coin){
        list_coin.add(coin);
    }

    public void remove_coin(Coin coin){
        list_coin.remove(coin);
    }

    public void buy_guppy(){

        // Money sufficient 
        if (Aquarium.money >= Constants.GUPPY_PRICE){
    
            Guppy g = new Guppy();
            add_guppy(g);
    
            Aquarium.money -= Constants.GUPPY_PRICE;
            
    
        }

        // unsufficient money
        else{
            // System.out.println("money not enough");
        }
    }

    public void buy_piranha() {
    
        // Money sufficient 
        if (Aquarium.money >= Constants.PIRANHA_PRICE){
    
            Piranha p = new Piranha();
            add_piranha(p);
    
            Aquarium.money -= Constants.PIRANHA_PRICE;
    
        }
    
        // unsufficient money
        else{
            // System.out.println("money not enough");
        }
    }

    public void buy_food(){
    
        // Money sufficient 
        if (Aquarium.money >= Constants.FOOD_PRICE){
            
            Food f = new Food();
            add_food(f);
    
            Aquarium.money -= Constants.FOOD_PRICE;
        }
    
        // unsufficient money
        else{
            // System.out.println("money not enough");
        }
    }
    
    public void buy_food(double x) {
        // Money sufficient 
        if (Aquarium.money >= Constants.FOOD_PRICE){
            
            Food f = new Food(x);
            add_food(f);
    
            Aquarium.money -= Constants.FOOD_PRICE;
        }
    
        // unsufficient money
        else{
            // System.out.println("money not enough");
        }
    }

    public void buy_egg(){
    
        // Money sufficient 
        if (Aquarium.money >= Constants.EGG_PRICE){
            
            Aquarium.egg++;
            Aquarium.money -= Constants.EGG_PRICE;
        }
    
        // unsufficient money
        else{
            // System.out.println("money not enough");
        }
    
    
    }
    
    public void buy_snail(){
    
        // Money sufficient 
        if (Aquarium.money >= Constants.SIPUT_PRICE){
    
            Siput s = new Siput();
            add_siput(s);
    
            Aquarium.money -= Constants.SIPUT_PRICE;
        }
    
        // unsufficient money
        else{
            // System.out.println("money not enough");
        }
    }

    public double euclidean(double x, double y, Coin c) {
        // get euclidean distance to coin

        double x_coin = c.get_x();
        double y_coin = c.get_y();

        return (sqrt(pow(x-x_coin, 2)) + (pow(y-y_coin, 2)));
    }


    public int inRadius(double x, double y) {

        int idx = 1;
        double nearest;
        int radius = 1;

        nearest = get_list_coin().get(idx).get_x();
        while (idx+1 < get_list_coin().getNBelmt()) {
            if (euclidean(x,y,get_list_coin().get(idx)) < nearest) {
                nearest = euclidean(x,y,get_list_coin().get(idx));
                radius = idx;
            }
            else {
                idx++;
            }
        }

        // return id coin yg di dalam radius
        return radius;
    }

    public int click_coin(double x, double y) {
        //find coin in radius
        if (get_list_coin().getNBelmt() > 0) {
            int idx = inRadius(x,y);
            if (get_list_coin().get(idx).get_x() >= x - 30 && get_list_coin().get(idx).get_x() <= x + 30 && get_list_coin().get(idx).get_y() >= y-30 && get_list_coin().get(idx).get_y() <= y+30) {
                int value = get_list_coin().get(idx).get_value();
                get_list_coin().remove(get_list_coin().get(idx));
                return value;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}

