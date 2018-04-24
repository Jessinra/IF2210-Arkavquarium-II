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
  //public static final int GUPPY_COIN_VAL_02 = 15;
  //public static final int GUPPY_COIN_VAL_03 = 25;
  public static final int GUPPY_COIN_VAL_INCREASE_RATE = 10;

  public static final int PIRANHA_COIN_VAL = GUPPY_PRICE;     // harga ikan

  public static final double GUPPY_DROP_COIN_TIME = 150;

  public static final int FISH_TIMER_DEC = 1;
  public static final double FISH_MAX_HUNGER = 20;
  public static final double FISH_HUNGRY_BORDERLINE = 10; // Fish getting hungry below this point
  public static final double FISH_HUNGER_DECREASE_RATE = 0.01;
  public static final int FISH_MAX_TIMER = 30;

  public static final int GUPPY_MAX_LV = 3;
  public static final int GUPPY_REQ_FOOD_COUNT = 5;        // how many food needed to lvl up
  public static final int GUPPY_HUNGER_INCREASE_RATE = 10;

  public static final int GUPPY_MOVEMENT_SPD = 2;
  public static final int PIRANHA_MOVEMENT_SPD = 3;
  public static final int COIN_MOVEMENT_SPD = 1;
  public static final int SIPUT_MOVEMENT_SPD = 2;
  public static final int FOOD_MOVEMENT_SPD = 1;

  public static final int TIME_DELAY = 15;

  private Constants() {
    // restrict instantiation
  }
}