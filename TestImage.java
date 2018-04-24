import junit.framework.TestCase;
import org.junit.*;

public class TestImage extends TestCase{

    @BeforeClass
    public void setUp() {

        ImageCollection.initImage();
    }

    @Test
    public void testImageAquarium(){

        assertNotNull(ImageCollection.aquarium);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testImageCoin(){

        assertNotNull(ImageCollection.coin);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testImageFood(){

        assertNotNull(ImageCollection.food);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testImageGuppy(){

        assertNotNull(ImageCollection.guppy01L);
        assertNotNull(ImageCollection.guppy01R);
        assertNotNull(ImageCollection.guppy01LH);
        assertNotNull(ImageCollection.guppy01RH);

        assertNotNull(ImageCollection.guppy02L);
        assertNotNull(ImageCollection.guppy02R);
        assertNotNull(ImageCollection.guppy02LH);
        assertNotNull(ImageCollection.guppy02RH);

        assertNotNull(ImageCollection.guppy03L);
        assertNotNull(ImageCollection.guppy03R);
        assertNotNull(ImageCollection.guppy03LH);
        assertNotNull(ImageCollection.guppy03RH);

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testImagePiranha(){

        assertNotNull(ImageCollection.piranhaL);
        assertNotNull(ImageCollection.piranhaR);
        assertNotNull(ImageCollection.piranhaLH);
        assertNotNull(ImageCollection.piranhaRH);

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testImageSiput(){

        assertNotNull(ImageCollection.siputL);
        assertNotNull(ImageCollection.siputR);

        System.out.println(this.getName() + " >> success");
    }
    
    @Test
    public void testImageEtc(){

        assertNotNull(ImageCollection.mainMenu);
        assertNotNull(ImageCollection.win);
        assertNotNull(ImageCollection.lose);
        assertNotNull(ImageCollection.credit);

        System.out.println(this.getName() + " >> success");
    }
}