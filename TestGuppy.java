import junit.framework.TestCase;
import org.junit.*;

public class TestGuppy extends TestCase{
    private Guppy dummy =  new Guppy();

    @Test
    public void testId(){

        assertEquals(16, dummy.getId());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testCoinvalue(){

        assertEquals(5, dummy.getCoinValue());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testHunger(){

        assertEquals(20, dummy.getHunger(), 0.01);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testSpeed(){

        assertEquals(2, dummy.getSpeed());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testTimeMove(){

        dummy.setTimeMove(3);
        assertEquals(3, dummy.getTimeMove());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testMakeHungry(){

        dummy.makeHunger();
        assertEquals(19.99, dummy.getHunger(), 0.01);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testIsHungry(){
        dummy.setHunger(5);
        assertTrue(dummy.isHungry());

        dummy.setHunger(15);
        assertFalse(dummy.isHungry());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testRandom(){
        dummy.setRandomDirection();
        assertNotNull(dummy.getXMove());
        assertNotNull(dummy.getYMove());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testNumberEat(){

        assertEquals(0, dummy.getNumberEat());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testLevel(){

        assertEquals(1, dummy.getLevel());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testTimer(){

        assertEquals(Constants.GUPPY_DROP_COIN_TIME, dummy.getTimer());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testProduceCoin(){

        dummy.setTimer(-1);
        assertTrue(dummy.produceCoin());
        assertEquals(Constants.GUPPY_DROP_COIN_TIME, dummy.getTimer());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testProduceCoinFail(){

        dummy.setTimer(10);
        assertFalse(dummy.produceCoin());
        assertEquals(10 - Constants.FISH_TIMER_DEC, dummy.getTimer(), 0.01);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testFindFood(){

        LinkedList<Food> f = new LinkedList<Food>();
        Food food_1 = new Food(1000);
        Food food_2 = new Food(50);
        f.add(food_1);
        f.add(food_2);

        assertEquals(1, dummy.findFood(f));
        System.out.println(this.getName() + " >> success");

    }

    @Test
    public void testFindFoodFail(){

        LinkedList<Food> f = new LinkedList<Food>();

        assertEquals(1, dummy.findFood(f));
        System.out.println(this.getName() + " >> success");

    }

    @Test
    public void testEuclidean(){
        
        dummy.setX(10);
        dummy.setY(20);

        Food f = new Food();
        f.setX(13);
        f.setY(24);

        assertEquals(5, dummy.euclidean(f), 0.01);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testMoveHungry(){

        LinkedList<Food> f = new LinkedList<Food>();
        Food food_1 = new Food();
        Food food_2 = new Food();

        food_2.setX(100);
        food_2.setY(100);

        f.add(food_1);
        f.add(food_2);

        dummy.setX(105);
        dummy.setY(105);
        dummy.setHunger(5);
 
        dummy.move(f);

        assertEquals(102, dummy.getX(), 1);
        assertEquals(102, dummy.getY(), 1);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testMoveNotHungry(){

        LinkedList<Food> f = new LinkedList<Food>();

        dummy.setHunger(5);

        double posX = dummy.getX();
        double posY = dummy.getY();

        dummy.move(f);

        assertTrue(dummy.getX() - posX >= 0.01);
        assertTrue(dummy.getY() - posY >= 0.01);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testInRadiusFound(){

        LinkedList<Food> f = new LinkedList<Food>();
        Food food_1 = new Food();

        food_1.setX(100);
        food_1.setY(100);

        dummy.setX(105);
        dummy.setY(105);

        f.add(food_1);

        assertEquals(1, dummy.inRadius(f));
        System.out.println(this.getName() + " >> success");
    
    }

    @Test
    public void testInRadiusNotFound(){

        LinkedList<Food> f = new LinkedList<Food>();

        assertEquals(-999, dummy.inRadius(f));
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testEat(){

        LinkedList<Food> f = new LinkedList<Food>();
        Food food_1 = new Food();

        food_1.setX(100);
        food_1.setY(100);
        f.add(food_1);

        dummy.setX(105);
        dummy.setY(105);
        dummy.setHunger(5);
        dummy.setNumberEat(2);

        dummy.eat(f);

        assertEquals(3, dummy.getNumberEat());
        assertTrue(dummy.getHunger() > 10);

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testGrow(){

        dummy.setNumberEat(Constants.GUPPY_REQ_FOOD_COUNT);
        dummy.setLevel(1);

        double maxHunger = dummy.getMaxHunger() + Constants.GUPPY_HUNGER_INCREASE_RATE;
        int coinVal = dummy.getCoinValue() + Constants.GUPPY_COIN_VAL_INCREASE_RATE;
        
        dummy.grow();

        assertEquals(2, dummy.getLevel());
        assertEquals(maxHunger, dummy.getMaxHunger());
        assertEquals(coinVal, dummy.getCoinValue());
        assertEquals(0, dummy.getNumberEat());
    }
}