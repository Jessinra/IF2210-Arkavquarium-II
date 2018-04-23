/*  
LIST OF ANNOTATION

@Test
@Before : before every test
@After :  
@BeforeClass : first method to run
@AfterClass
@Ignore

*/

/* List of assert 

void assertEquals(boolean expected, boolean actual)
void assertTrue(boolean condition)
void assertFalse(boolean condition)
void assertNotNull(Object object)
void assertNull(Object object)
void assertSame(object1, object2)
void assertNotSame(object1, object2)
void assertArrayEquals(expectedArray, resultArray);

*/

import junit.framework.TestCase;
import org.junit.*;

public class TestTemplate{

    /**
     * Create preparation that will be runned BEFORE every @Test
     */
    @Before
    public void setUp(){

    }

    /**
     * Test method to test ....
     */
    @Test
    public void testDummy_1(){

    }

    /**
     * Test method to test ....
     */
    @Test
    public void testDummy_2(){

    }

    /**
     * Test method to test ....
     */
    @Test
    public void testDummy_3(){

    }

    // @Test
    // public void testConstructor(){ 

    //     ImageCollection.init_image();

    //     Food specimen = new Food();
    //     Food specimen2 = new Food(50);

    //     assertTrue(specimen.get_x() > 0);
    //     assertEquals(50, specimen2.get_x(), 0.1);

    //     assertEquals(1, specimen.get_id());
    //     assertEquals(2, specimen2.get_id());

    //     //assertNull(specimen.get_image());

        

    //     assertNotNull(specimen.get_image());
    // }

}