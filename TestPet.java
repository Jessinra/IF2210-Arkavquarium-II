import junit.framework.TestCase;
import org.junit.*;

public class TestPet extends TestCase {
    Pet p = new Pet();

    @Test
    public void testId() {
        assertEquals(1, p.getId());
        System.out.println(this.getName() + " >> success");
    }
}