import junit.framework.TestCase;
import org.junit.*;

public class TestSiput extends TestCase {
    int sp = 1;
    private Siput s = new Siput();
    LinkedList<Coin> C = new LinkedList<>();

    @Test
    public void testGetSpeed() {

        assertEquals(Constants.SIPUT_MOVEMENT_SPD, s.getSpeed());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testSetSpeed() {

        s.setSpeed(2);
        assertEquals(2, s.getSpeed());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testMove() {

        Coin c1 = new Coin(10, 10, 10);
        Coin c2 = new Coin(20, 20, 10);
       
        C.add(c1);
        C.add(c2);

        double prevX = s.getX();
        s.move(C);
        double afterX = s.getX();
        assertTrue(prevX != afterX);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testFindCoin() {
        
        Coin c1 = new Coin(10, Constants.SCREEN_BOTTOM, 10);
        Coin c2 = new Coin(20, Constants.SCREEN_BOTTOM, 10);
       
        C.add(c1);
        C.add(c2);

        assertTrue(s.findCoin(C));
        System.out.println(this.getName()  + " >> success");
    }

    @Test
    public void testFindCoinFail() {

        Coin c1 = new Coin(10, Constants.SCREEN_BOTTOM, 10);
        Coin c2 = new Coin(20, Constants.SCREEN_BOTTOM, 10);

        C.add(c1);
        C.add(c2);

        C = new LinkedList<Coin>();
        assertFalse(s.findCoin(C));
        System.out.println(this.getName()  + " >> success");
    }

    @Test
    public void testInRadius() {

        Coin c1 = new Coin(10, Constants.SCREEN_BOTTOM, 10);
        Coin c2 = new Coin(20, Constants.SCREEN_BOTTOM, 10);
       
        C.add(c1);
        C.add(c2);

        s.setX(10);

        assertEquals(1, s.inRadius(C));
        System.out.println(this.getName()  + " >> success");
    }

    @Test
    public void testTakeCoin() {

        Coin c1 = new Coin(10, Constants.SCREEN_BOTTOM, 100);
        Coin c2 = new Coin(20, Constants.SCREEN_BOTTOM, 10);

        C.add(c1);
        C.add(c2);

        s.setX(10);

        assertEquals(100, s.takeCoin(C));
        System.out.println(this.getName()  + " >> success");
    }
}