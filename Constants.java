public final class Constants {

    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;

    public static final int SCREEN_TOP = 80;
    public static final int SCREEN_BOTTOM = SCREEN_HEIGHT - 80;
    public static final int SCREEN_LEFT = 80;
    public static final int SCREEN_RIGHT = SCREEN_WIDTH - 80;

    public static final int GUPPY_PRICE = 50;
    public static final int PIRANHA_PRICE = 250;
    public static final int FOOD_PRICE = 2;
    public static final int EGG_PRICE = 4000;
    public static final int SIPUT_PRICE = 1250;

    public static final int GUPPY_COIN_VAL_01 = 5;
    public static final int GUPPY_COIN_VAL_02 = 15; 
    public static final int GUPPY_COIN_VAL_03 = 25;
    public static final int GUPPY_COIN_VAL_INCREASE_RATE = 10;

    public static final int PIRANHA_COIN_VAL = GUPPY_PRICE;	 //harga ikan 

    public static final double GUPPY_DROP_COIN_TIME = 10;

    public static final double FISH_TIMER_DEC = 0.1;
    public static final double FISH_MAX_HUNGER = 20;
    public static final double FISH_HUNGRY_BORDERLINE = 10; // Fish getting hungry below this point
    public static final double FISH_HUNGER_DECREASE_RATE = 0.01;
    public static final double FISH_MAX_TIMER = 1;

    public static final int GUPPY_MAX_LV = 3;
    public static final int GUPPY_REQ_FOOD_COUNT = 5;		// how many food needed to lvl up
    public static final int GUPPY_HUNGER_INCREASE_RATE = 10;

    public static final int GUPPY_MOVEMENT_SPD = 100;
    public static final int PIRANHA_MOVEMENT_SPD = 150;
    public static final int COIN_MOVEMENT_SPD = 50;
    public static final int SIPUT_MOVEMENT_SPD = 100;
    public static final int FOOD_MOVEMENT_SPD = 50;

    // public static final int SCREEN_TOP = 80;
    // public static final int SCREEN_BOTTOM = SCREEN_HEIGHT - 80;
    // public static final int SCREEN_LEFT = 80;
    // public static final int SCREEN_RIGHT = SCREEN_WIDTH - 80;

    /**** IMAGE ****/

    public static final String FILE_guppy_01_left = "img/guppy_01.png";
    public static final String FILE_guppy_02_left = "img/guppy_02.png";
    public static final String FILE_guppy_03_left = "img/guppy_03.png";

    public static final String FILE_guppy_01_right = "img/guppy_01_r.png";
    public static final String FILE_guppy_02_right = "img/guppy_02_r.png";
    public static final String FILE_guppy_03_right = "img/guppy_03_r.png";

    public static final String FILE_guppy_01_left_hungry = "img/guppy_01_h.png";
    public static final String FILE_guppy_02_left_hungry = "img/guppy_02_h.png";
    public static final String FILE_guppy_03_left_hungry = "img/guppy_03_h.png";

    public static final String FILE_guppy_01_right_hungry = "img/guppy_01_r_h.png";
    public static final String FILE_guppy_02_right_hungry = "img/guppy_02_r_h.png";
    public static final String FILE_guppy_03_right_hungry = "img/guppy_03_r_h.png";

    public static final String FILE_piranha_left = "img/piranha.png";
    public static final String FILE_piranha_right = "img/piranha_r.png";

    public static final String FILE_piranha_left_hungry = "img/piranha_h.png";
    public static final String FILE_piranha_right_hungry = "img/piranha_r_h.png";

    public static final String FILE_siput_left = "img/snail.png";
    public static final String FILE_siput_right = "img/snail_r.png";

    public static final String FILE_coin = "img/coin.png";

    public static final String FILE_food = "img/food.png";

    public static final String FILE_aquarium = "img/Aquarium2.jpg";

    public static final String FILE_main_menu = "img/main.jpg";

    public static final String FILE_win = "img/youwin.png";

    public static final String FILE_lose = "img/gameover.png";

    public static final String FILE_credit = "img/credit.jpeg";

    private Constants() {
        // restrict instantiation
    }
};