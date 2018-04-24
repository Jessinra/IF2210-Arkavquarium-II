import junit.framework.TestCase;
import org.junit.*;

public class TestFood extends TestCase{

    private Food dummy = new Food();

    @Before
    public void setup(){

        //System.out.print(this.getName());

        try{
            Food dummy = new Food();
            assertNotNull(dummy);
            System.out.println(" >> success");
        }
        catch(Exception e){
            System.out.println(" >> fail");
        }
       
    }

    @Test
    public void testGetSet(){
        
        dummy.set_x(10);
        assertEquals(30, dummy.get_x(), 0.1);

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testGetSet2(){
        
        dummy.set_x(10);
        assertEquals(10, dummy.get_x(), 0.1);

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testGetSet3(){
        
        dummy.set_x(10);
        assertEquals(30, dummy.get_x(), 0.1);

        System.out.println(this.getName() + " >> success");
    }

    // public void testConstructor(){

    // }
    
}