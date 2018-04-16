public class Aquarium extends Object{

    static public int egg = 0;
    static public int money = 20000;

    private LinkedList<Guppy> list_guppy;
	private LinkedList<Piranha> list_piranha;
	private LinkedList<Siput> list_siput;
	private LinkedList<Food> list_food;
	private LinkedList<Coin> list_coin;

    public Aquarium(){
        
        Guppy g = new Guppy();
        Guppy g1 = new Guppy();
        this.list_guppy.add(g);
        this.list_guppy.add(g1);

        Siput s = new Siput();
        this.list_siput.add(s);

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

    public void draw(){
        // might get changed due to using different class for GUI

        // draw_image(FILE_aquarium, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
	
        // for (int i = 1; i <= list_guppy.getNBelmt(); i++){
        //     list_guppy.get(i).draw();
        // }

        // for (int i = 1; i <= list_piranha.getNBelmt(); i++){
        //     list_piranha.get(i).draw();
        // }

        // for (int i = 1; i <= list_siput.getNBelmt(); i++){
        //     list_siput.get(i).draw();
        // }

        // for (int i = 1; i <= list_food.getNBelmt(); i++){
        //     list_food.get(i).draw();
        // }

        // for (int i = 1; i <= list_coin.getNBelmt(); i++){
        //     list_coin.get(i).draw();
        // }
    }
    
    private void add_guppy(Guppy guppy) {
        list_guppy.add(guppy);
    }
 
    private void remove_guppy(Guppy guppy) {
        list_guppy.remove(guppy);
    }
    
    private void add_piranha(Piranha piranha) {
        list_piranha.add(piranha);
    }

    private void remove_piranha(Piranha piranha) {
        list_piranha.remove(piranha);
    }
    
    private void add_siput(Siput siput){
        list_siput.add(siput);
    }
    
    private void remove_siput(Siput siput){
        list_siput.remove(siput);
    }
    
    private void add_food(Food food){
        list_food.add(food);
    }

    private void remove_food(Food food){
        list_food.remove(food);
    }

    private void add_coin(Coin coin){
        list_coin.add(coin);
    }

    private void remove_coin(Coin coin){
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

