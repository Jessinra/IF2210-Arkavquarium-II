import junit.framework.TestCase;
import org.junit.Test;
import org.junit.assertEquals;

public class TestPet extends TestCase {

    Pet p = new Pet();

    @Test
    public testPet() {
        p.pet_id = 10;
    }

    @Test
    public testId() {
        assetEquals(10, p.getId());
        System.out.println(this.getName() + " >> success");
    }
}