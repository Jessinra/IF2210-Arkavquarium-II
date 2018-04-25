import junit.framework.TestCase;
import org.junit.*;

public class TestLinkedList extends TestCase {
    LinkedList<Integer> L = new LinkedList<>();

    @Before
    public void testConstructorParam() {
        LinkedList<Integer> Ltemp = new LinkedList<>();

        assertNotNull(Ltemp);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testIsEmpty() {
        assertEquals(0, L.getNBelmt());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testAdd() {
        L.add(5);
        assertEquals(5, L.get(1), 0.01);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testRemove() {

        L.add(5);
        L.remove(5);

        assertEquals(0, L.getNBelmt());
        assertNotNull(L);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void getNBelmt() {
        L.add(1);
        L.add(3);
        L.add(5);
        L.add(7);
        L.add(9);
        assertEquals(5, L.getNBelmt());
        System.out.println(this.getName() + " >> success");
    }
}