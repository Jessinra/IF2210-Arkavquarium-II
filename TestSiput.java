import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before;
import org.junit.assertEquals;
import org.junit.assertFalse;

public class TestSiput extends TestCase {
    int sp = 1;
    private Siput s = new Siput();

    @Before
    public testSiput() {
        LinkedList<Coin> C = new LinkedList<>();
        C.add(10);
        C.add(20);
        C.add(30);
        C.add(40);
        C.add(50);
    }

    @Test
    public void testGetSpeed() {
        assertEquals(Constants.SIPUT_MOVEMENT_SPD, s.getSpeed());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testSetSpeed() {
        s.setSpeed(2);
        assertEquals(2,s.getSpeed());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testMove() {
        int speedbefore = s.getSpeed();
        s.move();
        int speedafter = s.getSpeed();
        assertFalse(speedbefore, speedafter);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public boolean testFindCoin() {
        assertEquals(True, s.find_coin(C));
        System.out.println(s.take_coin(C) + " >> success");
    }

    @Test
    public int testInRadius() {
        assertEquals(1, s.inRadius(C));
        System.out.println(s.take_coin(C) + " >> success");
    }

    @Test
    public int testTakeCoin() {
        assertEquals(1, s.take_coin(C));
        System.out.println(s.take_coin(C) + " >> success");
    }
}