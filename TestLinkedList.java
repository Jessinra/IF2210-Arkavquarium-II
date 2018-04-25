import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.assertEquals;
import org.junit.assertNull;

public class TestLinkedList extends TestCase {
    LinkedList<int> L = new LinkedList<>();

    @Before
    public testConstructorParam() {
        LinkedList<int> Ltemp = new LinkedList<>(L);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public boolean testIsEmpty() {
        assertNull(L);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testAdd() {
        L.add(5);
        assertEquals(5, L.get(1));
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testRemove() {
        L.remove(5);
        assertNull(L);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public int getNBelmt() {
        L.add(1);
        L.add(3);
        L.add(5);
        L.add(7);
        L.add(9);
        assertEquals(5, L.getNBelmt());
        System.out.println(this.getName() + " >> success");
    }
}