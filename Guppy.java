public class Guppy extends Fish {
    
    private int number_eat;
    private int level_grow;
    private double timer;
    private static final int max_level = Constants.GUPPY_MAX_LV;
    
    /**
     * default constructor
     */
    Guppy() {
        super(Constants.GUPPY_PRICE, Constants.GUPPY_COIN_VAL_01);    
        // value from constant.h
        set_speed(Constants.GUPPY_MOVEMENT_SPD);
        set_number_eat(0);
        set_timer(Constants.GUPPY_DROP_COIN_TIME);
        set_level(1);
    }

    /**
     * @return level_grow
     */
    public int get_level() {
        return level_grow;
    }

    public void set_level(int lv) {
        level_grow = lv;
    }

    /**
     * @return number_eat
     */
    public int get_number_eat() {
        return number_eat;
    }

    public void set_number_eat(int number) {
        number_eat = number;
    }

    /**
     * @return timer
     */
    public double get_timer() {
        return timer;
    }

    public void set_timer(double time) {
        timer = time;
    }

    /**
     * @return max_level
     */
    public final int get_max_level() {
        return max_level;
    }

    public boolean isEqual(Guppy g) {
        return get_id() == g.get_id();    
    }

    public boolean isNotEqual(Guppy g) {
        return get_id() != g.get_id();
    }

    public String draw() {
        if (isHungry()) {
                if (level_grow == 1) {
                    if (get_dir() == "Left") {
                        return Constants.FILE_guppy_01_left_hungry;
                    }
                    else {
                       return Constants.FILE_guppy_01_right_hungry;    
                    }
                }
                else if (level_grow == 2) {
                    if (get_dir() == "Left") {
                        return Constants.FILE_guppy_02_left_hungry;
                    }
                    else {
                        return Constants.FILE_guppy_02_right_hungry;    
                    }
                }
                else if (level_grow == 3) {
                    if (get_dir() == "Left") {
                        return Constants.FILE_guppy_03_left_hungry;
                    }
                    else {
                        return Constants.FILE_guppy_03_right_hungry;    
                    }
                }
        }
        else {  
                if (level_grow == 1) {
                    if (get_dir() == "Left") {
                        return Constants.FILE_guppy_01_left;
                    }
                    else {
                        return Constants.FILE_guppy_01_right;    
                    }
                }
                else if (level_grow == 2) {
                    if (get_dir() == "Left") {
                        return Constants.FILE_guppy_02_left;
                    }
                    else {
                        return Constants.FILE_guppy_02_right;    
                    }
                }
                else if (level_grow == 3) {
                    if (get_dir() == "Left") {
                        return Constants.FILE_guppy_03_left;
                    }
                    else {
                        return Constants.FILE_guppy_03_right;    
                    }
                }
        }
    }

    public boolean produce_coin() {
        // check if guppy able to drop coin
        // if yes,
        if(get_timer() <= 0){
            // then set timer to max, and return true
            set_timer(Constants.GUPPY_DROP_COIN_TIME);
            return true;
        }
        else{
            // reduce drop coin time 
            set_timer(get_timer()-Constants.FISH_TIMER_DEC/5);
            return false;
        }
    }  

    public int findFood(LinkedList<Food> F) {
        //ukuran layar
        int SCREEN_RIGHT = 1280 - 80;
        int SCREEN_BOTTOM = 720 - 80;
        int SCREEN_LEFT = 80;
        int SCREEN_TOP = 80;

        //nyari yg terdekat brrti pake iterate dari list Food
        int idx = 1;
        int i = 2; //indeks perbandingan mulai dari 2

        while (i<=F.getNBelmt()) {
            if (F.get(i).get_x() > SCREEN_TOP && F.get(i).get_x() < SCREEN_BOTTOM && F.get(i).get_x() > SCREEN_LEFT && F.get(i).get_x() < SCREEN_RIGHT && euclidean(F.get(idx)) > euclidean(F.get(i))) {
                idx = i;
            }
            else {
                i++;
            }
        }
        return idx;
    }

    public int move(double sec_since_last, LinkedList<Food> F) {
        //ukuran layar
        int SCREEN_RIGHT = 1280 - 80;
        int SCREEN_BOTTOM = 720 - 80;
        int SCREEN_LEFT = 80;
        int SCREEN_TOP = 80;

        if (isHungry() && F.getNBelmt() > 0) {
            //mengejar food pakai tips
            int idx = findFood(F);
            if (F.get(idx).get_x() < get_x()) {
                set_dir("Left");
            }
            else {
                set_dir("Right");
            }

            //double atan2(double y, double x)
            double a = Math.atan2(F.get(idx).get_y()-get_y(), F.get(idx).get_x()-get_x());
            set_x(get_x()+(double)(get_speed()*Math.cos(a)*sec_since_last*1.5));
            set_y(get_y()+(double)(get_speed()*Math.sin(a)*sec_since_last*1.5));
        }
        else {
            //random arahnya
            if (get_time_move() <= 0) {
                set_time_move(Constants.FISH_MAX_TIMER);
                setRandomDirection();
            }
            else {
                set_time_move(get_time_move()-sec_since_last);
            }

            //kalau sampai ujung
            if (get_x() >= SCREEN_RIGHT || get_x() <= SCREEN_LEFT) {
                set_x_move(get_x_move()*(-1));
            }
            if (get_y() <= SCREEN_TOP || get_y() >= SCREEN_BOTTOM) {
                set_y_move(get_y_move()*(-1));
            }

            if (get_x()+get_speed()*sec_since_last*get_x_move() < get_x()) {
                set_dir("Left");
            }
            else if (get_x()+get_speed()*sec_since_last*get_x_move() >= get_x()) {
                set_dir("Right");
            }

            //pindahkan ikan
            set_x(get_x()+get_speed()*sec_since_last*get_x_move());
            set_y(get_y()+get_speed()*sec_since_last*get_y_move());
        }
    } 

    public double euclidean(Food m) {
    // get euclidean distance from guppy to food

    double x_guppy = get_x();
    double y_guppy = get_y();
    double x_food = m.get_x(); 
    double y_food = m.get_y();

    return (Math.sqrt(Math.pow(x_guppy-x_food, 2)) + (Math.pow(y_guppy-y_food, 2)));
    }

    public int inRadius(LinkedList<Food> F) {
    //nyari ikan nya udah diradius itu blm
        int idx = 1;
        double radius = 50;
        boolean find = false;
        if (F.getNBelmt() > 0) {
            while (!find && idx<=F.getNBelmt()) {
                if ((radius > Math.abs(get_x()-F.get(idx).get_x())) && (radius > Math.abs(get_y()-F.get(idx).get_y()))) {
                    find = true;
                }
                else {
                    idx++;
                }
            }
        }
        if (find) {
            return idx;
        }
        else {
            return -999;
        }
    }

    public void eat(LinkedList<Food> F) {
        //eat gak usah pake validasi laper. yg validasi laper itu move.
        //kalau ada ikan diradius itu, eat (itu aja fx nya)

        // search for food 
        int idx = inRadius(F);

        // if found
        if (idx != -999 && isHungry()) {

            // remove food from list 
            F.remove(F.get(idx));

            // set hunger to max and state ishungry to false
            fullHunger();
            set_hungry(false);

            // increase number of food eaten
            set_number_eat(get_number_eat() + 1);
            
            // try to check if fish is able to grow
            grow();
            
        }
    }

    public void grow() {
        if (get_number_eat() == Constants.GUPPY_REQ_FOOD_COUNT && get_level() != Constants.GUPPY_MAX_LV) {
            
            // increase fish lv
            set_level(get_level()+1);
            
            // increase max hunger 
            set_max_hunger(get_max_hunger() + Constants.GUPPY_HUNGER_INCREASE_RATE); //tiap naik level tambah bisa nambah laper
            
            // increase the coin value 
            set_coin_value(get_coin_value() + Constants.GUPPY_COIN_VAL_INCREASE_RATE); //tiap naik level tambah harga coin nya

            // reset the number of food eaten
            set_number_eat(0);
        }
    }
}