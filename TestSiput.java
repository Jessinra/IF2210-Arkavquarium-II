import junit.framework.TestCase;
import org.junit.*;

public class TestSiput extends TestCase {
    int sp = 1;
    private Siput s = new Siput();

    @Test
    public void testSpeed() {
        assertEquals(Constants.SIPUT_MOVEMENT_SPD, s.getSpeed());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testGetSet() {
        s.setSpeed(2);
        assertEquals(2,s.getSpeed());
        System.out.println(this.getName() + " >> success");
    }

    // @Test
    // public void test_move(LinkedList<Coin> C) {
    //     s.set_speed(3);
    //     s.move();
    //     assertEquals(3, s.get_speed());
    //     System.out.println("success");
    // }

    // @Test
    // public boolean test_find_coin(LinkedList<Coin> C) {
    //     assertEquals(True, s.find_coin(C));
    //     if (s.find_coin(C)) {
    //         System.out.println("True");
    //     } else {
    //         System.out.println("False");
    //     }
    // }

    // @Test
    // public int test_inRadius(LinkedList<Coin> C) {
    //     assertEquals(1, s.inRadius(C));
    // }

    // @Test
    // public int test_take_coin(LinkedList<Coin> C) {
    //     assertEquals(1, s.take_coin(C));
    //     System.out.println(s.take_coin(C));
    // }
}