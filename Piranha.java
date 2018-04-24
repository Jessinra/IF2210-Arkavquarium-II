import java.util.*;

public class Piranha extends Fish {

    /**
     * default constructor.
     */
    public Piranha() {
        super(Constants.PIRANHA_PRICE, Constants.PIRANHA_COIN_VAL);
        setSpeed(Constants.PIRANHA_MOVEMENT_SPD);

        this.setImage(ImageCollection.piranhaR);
    }

    /**
     * change image of piranha.
     */
    public void updateImage() {
        if (isHungry()) {
            if (getDir() == "Left") {
                setImage(ImageCollection.piranhaLH);
            } else {
                setImage(ImageCollection.piranhaRH);
            }
        } else {
            if (getDir() == "Left") {
                setImage(ImageCollection.piranhaL);
            } else {
                setImage(ImageCollection.piranhaR);
            }
        }
    }

    /**
     * mencari guppy dalam radius piranha.
     * @param G list of guppy to find
     * @return guppy id yang ada di dalam radius, 1 by default
     */
    public int findGuppy(LinkedList<Guppy> G) {

        int idx = 1;
        int i = 2; //indeks perbandingan mulai dari 2

        while (i <= G.getNBelmt()) {
            Guppy currentGuppy = G.get(i);
            if (currentGuppy.getX() > Constants.SCREEN_TOP &&
                    currentGuppy.getX() < Constants.SCREEN_BOTTOM &&
                    currentGuppy.getX() > Constants.SCREEN_LEFT &&
                    currentGuppy.getX() < Constants.SCREEN_RIGHT &&
                    euclidean(G.get(idx)) > euclidean(currentGuppy)) {
                idx = i;
            } else {
                i++;
            }
        }
        return idx;
    }

    /**
     * memindahkan piranha.
     * @param G list of guppy
     */
    public void move(LinkedList<Guppy> G) {

        if (isHungry() && G.getNBelmt() > 0) {
            //mengejar food pakai tips
            int idx = findGuppy(G);
            if (G.get(idx).getX() < getX()) {
                setDir("Left");
            } else {
                setDir("Right");
            }
            double a = Math.atan2(G.get(idx).getY() - getY(), G.get(idx).getX() - getX());
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
     * @param g guppy to count
     * @return nilai euclidean
     */
    public double euclidean(Guppy g) {

        double XPiranha = getX();
        double YPiranha = getY();
        double XGuppy = g.getX();
        double YGuppy = g.getY();

        return (Math.sqrt(Math.pow(XPiranha - XGuppy, 2)) + (Math.pow(YPiranha - YGuppy, 2)));
    }

    /**
     * mencari guppy yang ada di dalam radius piranha.
     * @param G list of guppy to find
     * @return guppy id dalam radius piranha, -999 jika tidak ada guppy dalam radius
     */
    public int inRadius(LinkedList<Guppy> G) {

        int idx = 1;
        double radius = 70;
        boolean find = false;
        if (G.getNBelmt() > 0) {
            while (!find && idx <= G.getNBelmt()) {
                if ((radius > Math.abs(getX() - G.get(idx).getX())) && (radius > Math.abs(getY() - G.get(idx).getY()))) {
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
     * @param G guppy to eat
     * @return guppy id yang dimakan
     */
    public int eat(LinkedList<Guppy> G) {
        int idx = inRadius(G);
        // found
        if (idx != -999 && isHungry()) {
            // get eaten guppy lvl
            int guppyLv = G.get(idx).getLevel();
            // remove guppy from list
            G.remove(G.get(idx));
            // set hunger to max and state is hungry to false
            fullHunger();
            setHungry(false);
            return guppyLv;
        }
        // not eating anything
        else {
            return -1;
        }
    }
}