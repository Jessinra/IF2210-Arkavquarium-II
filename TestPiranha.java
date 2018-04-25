import junit.framework.TestCase;
import org.junit.*;

public class TestPiranha extends TestCase{
    private Piranha dummy =  new Piranha();


    @Test
    public void testId(){

        assertEquals(35, dummy.getId());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testCoinvalue(){

        assertEquals(50, dummy.getCoinValue());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testHunger(){

        assertEquals(20, dummy.getHunger(), 0.01);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testSpeed(){

        assertEquals(3, dummy.getSpeed());
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
    public void testFindGuppy(){

        LinkedList<Guppy> g = new LinkedList<Guppy>();
        Guppy guppy_1 = new Guppy();
        Guppy guppy_2 = new Guppy();

        g.add(guppy_1);
        g.add(guppy_2);

        assertEquals(1, dummy.findGuppy(g));
        System.out.println(this.getName() + " >> success");

    }

    @Test
    public void testFindGuppyFail(){

        LinkedList<Guppy> g = new LinkedList<Guppy>();

        assertEquals(1, dummy.findGuppy(g));
        System.out.println(this.getName() + " >> success");

    }

    @Test
    public void testEuclidean(){
        
        dummy.setX(10);
        dummy.setY(20);

        Guppy guppy = new Guppy();
        guppy.setX(13);
        guppy.setY(24);

        assertEquals(5, dummy.euclidean(guppy), 0.01);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testMoveHungry(){

        LinkedList<Guppy> g = new LinkedList<Guppy>();
        Guppy guppy_1 = new Guppy();
        Guppy guppy_2 = new Guppy();

        guppy_2.setX(100);
        guppy_2.setY(100);

        g.add(guppy_1);
        g.add(guppy_2);

        dummy.setX(105);
        dummy.setY(105);
        dummy.setHunger(5);
 
        dummy.move(g);

        assertEquals(102, dummy.getX(), 1);
        assertEquals(102, dummy.getY(), 1);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testMoveNotHungry(){

        LinkedList<Guppy> g = new LinkedList<Guppy>();

        dummy.setHunger(5);

        double posX = dummy.getX();
        double posY = dummy.getY();

        dummy.move(g);

        assertTrue(dummy.getX() - posX >= 0.01);
        assertTrue(dummy.getY() - posY >= 0.01);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testInRadiusFound(){

        LinkedList<Guppy> g = new LinkedList<Guppy>();
        Guppy guppy_1 = new Guppy();

        guppy_1.setX(100);
        guppy_1.setY(100);

        g.add(guppy_1);

        dummy.setX(105);
        dummy.setY(105);

        assertEquals(1, dummy.inRadius(g));
        System.out.println(this.getName() + " >> success");
    
    }

    @Test
    public void testInRadiusNotFound(){

        LinkedList<Guppy> g = new LinkedList<Guppy>();

        assertEquals(-999, dummy.inRadius(g));
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testEat(){

        LinkedList<Guppy> g = new LinkedList<Guppy>();
        Guppy guppy_1 = new Guppy();

        guppy_1.setX(100);
        guppy_1.setY(100);

        g.add(guppy_1);

        dummy.setX(105);
        dummy.setY(105);
        dummy.setHunger(5);

        dummy.eat(g);

        assertTrue(dummy.getHunger() > 10);

        System.out.println(this.getName() + " >> success");
    }
}