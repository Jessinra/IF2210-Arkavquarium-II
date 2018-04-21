public class Piranha extends Fish {
    
    /**
     * default constructor
     */
    public Piranha() {
        super(Constants.PIRANHA_PRICE, Constants.PIRANHA_COIN_VAL);
        set_speed(Constants.PIRANHA_MOVEMENT_SPD);
    }

    public boolean isEqual(Piranha p) {
        return get_id() == p.get_id();    
    }

    public boolean isNotEqual(Piranha p) {
        return get_id() != p.get_id();
    }

    public String draw() {
        if (isHungry()) {
            if (get_dir() == "Left") {
                return Constants.FILE_piranha_left_hungry; 
            }
            else {
                return Constants.FILE_piranha_right_hungry;    
            }
        }
        else {
            if (get_dir() == "Left") {
                return Constants.FILE_piranha_left; 
            }
            else {
                return Constants.FILE_piranha_right;    
            }
        }
    }

    public int findGuppy(LinkedList<Guppy> G) {
        //ukuran layar
        int SCREEN_RIGHT = 1280 - 80;
        int SCREEN_BOTTOM = 720 - 80;
        int SCREEN_LEFT = 80;
        int SCREEN_TOP = 80;
        int idx = 1;
        int i = 2; //indeks perbandingan mulai dari 2

        while (i<=G.getNBelmt()) {
            if (G.get(i).get_x() > SCREEN_TOP && G.get(i).get_x() < SCREEN_BOTTOM && G.get(i).get_x() > SCREEN_LEFT && G.get(i).get_x() < SCREEN_RIGHT && euclidean(G.get(idx)) > euclidean(G.get(i))) {
                idx = i;
            }
            else {
                i++;
            }
        }
        return idx;
    }

    public void move(double sec_since_last,LinkedList<Guppy> G) {
        //ukuran layar
        int SCREEN_RIGHT = 1280 - 80;
        int SCREEN_BOTTOM = 720 - 80;
        int SCREEN_LEFT = 80;
        int SCREEN_TOP = 80;

        if (isHungry() && G.getNBelmt() > 0) {
            //mengejar food pakai tips
            int idx = findGuppy(G);
            if (G.get(idx).get_x() < get_x()) {
                set_dir("Left");
            }
            else {
                set_dir("Right");
            }
            double a = Math.atan2(G.get(idx).get_y()-get_y(), G.get(idx).get_x()-get_x());
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

    public double euclidean(Guppy g) {

        double x_piranha = get_x();
        double y_piranha = get_y();
        double x_guppy = g.get_x(); 
        double y_guppy = g.get_y();

        return (Math.sqrt(Math.pow(x_piranha-x_guppy, 2)) + (Math.pow(y_piranha-y_guppy, 2)));
    }

    public int inRadius(LinkedList<Guppy> G) {

        int idx = 1;
        double radius = 70;
        boolean find = false;
        if (G.getNBelmt() > 0) {
            while (!find && idx<=G.getNBelmt()) {
                if ((radius > Math.abs(get_x()-G.get(idx).get_x())) && (radius > Math.abs(get_y()-G.get(idx).get_y()))) {
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

    public int eat(LinkedList<Guppy> G) {
        int idx = inRadius(G);
        // found
        if (idx != -999 && isHungry()) {
            // get eaten guppy lvl
            int guppy_lv = G.get(idx).get_level();
            // remove guppy from list
            G.remove(G.get(idx));
            // set hunger to max and state is hungry to false
            fullHunger();
            set_hungry(false);
            return guppy_lv;
        }
        // not eating anything
        else {
            return -1;
        }
    }
}