import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Aquarium extends Object{

    static public int egg = 0;
    static public int money = 20000;

    public static final ImageIcon image_aquarium = new ImageIcon(Constants.FILE_aquarium);

    private LinkedList<Guppy> list_guppy;
	private LinkedList<Piranha> list_piranha;
	private LinkedList<Siput> list_siput;
	private LinkedList<Food> list_food;
    private LinkedList<Coin> list_coin;
    
    private JPanel panel;

    public Aquarium(JFrame frame){
        // frame : where to put the aquarium
        
        Guppy g = new Guppy();
        Guppy g1 = new Guppy();

        this.add_guppy(g);
        this.add_guppy(g1);

        Siput s = new Siput();
        this.add_siput(s);

        // set panel
        this.panel = (JPanel) frame.getContentPane();
        this.panel.setLayout(null);

        this.change_image(Aquarium.image_aquarium);
        this.change_position(0, 0);
        this.size = this.label.getPreferredSize();

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

    // public void draw(){
    //     might get changed due to using different class for GUI

    //     draw_image(FILE_aquarium, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
	
    //     for (int i = 1; i <= list_guppy.getNBelmt(); i++){
    //         list_guppy.get(i).draw();
    //     }

    //     for (int i = 1; i <= list_piranha.getNBelmt(); i++){
    //         list_piranha.get(i).draw();
    //     }

    //     for (int i = 1; i <= list_siput.getNBelmt(); i++){
    //         list_siput.get(i).draw();
    //     }

    //     for (int i = 1; i <= list_food.getNBelmt(); i++){
    //         list_food.get(i).draw();
    //     }

    //     for (int i = 1; i <= list_coin.getNBelmt(); i++){
    //         list_coin.get(i).draw();
    //     }
    // }
    
    private void add_guppy(Guppy guppy) {
        list_guppy.add(guppy);
        this.panel.add(guppy.get_label());
    }
 
    private void remove_guppy(Guppy guppy) {
        list_guppy.remove(guppy);
        this.panel.remove(guppy.get_label());
    }
    
    private void add_piranha(Piranha piranha) {
        list_piranha.add(piranha);
        this.panel.add(piranha.get_label());
    }

    private void remove_piranha(Piranha piranha) {
        list_piranha.remove(piranha);
        this.panel.remove(piranha.get_label());
    }
    
    private void add_siput(Siput siput){
        list_siput.add(siput);
        this.panel.add(siput.get_label());
    }
    
    private void remove_siput(Siput siput){
        list_siput.remove(siput);
        this.panel.remove(siput.get_label());
    }
    
    private void add_food(Food food){
        list_food.add(food);
        this.panel.add(food.get_label());
    }

    private void remove_food(Food food){
        list_food.remove(food);
        this.panel.remove(food.get_label());
    }

    private void add_coin(Coin coin){
        list_coin.add(coin);
        this.panel.add(coin.get_label());
    }

    private void remove_coin(Coin coin){
        list_coin.remove(coin);
        this.panel.remove(coin.get_label());
    }

    public JPanel get_panel(){
        return this.panel;
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

    public void buy_piranha(){
    
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
}

