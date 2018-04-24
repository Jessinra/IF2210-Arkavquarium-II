import junit.framework.TestCase;
import org.junit.*;
public class TestFish extends TestCase{
    private Guppy dummy =  new Guppy();

    @Test
    public void testId(){

        assertEquals(4, dummy.getId());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testCoinvalue(){

        assertEquals(5, dummy.getCoinValue());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testPrice(){

        assertEquals(50, dummy.getPrice());
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
    public void testHungry(){

        dummy.setHungry(true);
        assertTrue(dummy.getHungry());
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
    public void testIsDead(){
        dummy.setHunger(-5);
        assertTrue(dummy.isDead());

        dummy.setHunger(15);
        assertFalse(dummy.isDead());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testRandom(){
        dummy.setRandomDirection();
        assertNotNull(dummy.getXMove());
        assertNotNull(dummy.getYMove());
        System.out.println(this.getName() + " >> success");
    }
}