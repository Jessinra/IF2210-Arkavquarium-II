import junit.framework.TestCase;
import org.junit.*;

public class TestCoin extends TestCase{
    private Coin dummy =  new Coin();

    @Test
    public void testConstructorParam(){

        Coin dummy = new Coin(10, 20, 30);

        assertNotNull(dummy);
        assertEquals(10, dummy.getX(), 0.01);
        assertEquals(20, dummy.getY(), 0.01);
        assertEquals(30, dummy.getValue());

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testId(){

        assertEquals(0, dummy.getId());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testSpeed(){

        assertEquals(0, dummy.getSpeed());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testValue(){

        assertEquals(0, dummy.getValue());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testGetSet(){
        
        dummy.setX(10);
        dummy.setY(20);
        dummy.setSpeed(30);
        dummy.setValue(40);
        dummy.setId(1);

        assertEquals(10, dummy.getX(), 0.01);
        assertEquals(20, dummy.getY(), 0.01);
        assertEquals(30, dummy.getSpeed());
        assertEquals(40, dummy.getValue());
        assertEquals(1, dummy.getId());

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testMove(){

        dummy.setY(50);
        dummy.setSpeed(1);
        dummy.move();
        assertEquals(51, dummy.getY(), 0.01);

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testMoveFail(){

        dummy.setY(650);
        dummy.setSpeed(1);
        dummy.move();
        assertEquals(640, dummy.getY(), 0.01);

        System.out.println(this.getName() + " >> success");
    }
    
}