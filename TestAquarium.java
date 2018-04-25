import junit.framework.TestCase;
import org.junit.*;

public class TestAquarium extends TestCase{
    Aquarium aquarium = new Aquarium();

    @Test
    public void testConstruct(){
        Aquarium aquarium_ = new Aquarium();

        assertEquals(2, aquarium_.getListGuppy().getNBelmt());
        assertEquals(1, aquarium_.getListSiput().getNBelmt());
        assertNotNull(aquarium_);

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testAddRmGuppy(){
        
        Guppy dummy = new Guppy();

        aquarium.addGuppy(dummy);
        assertEquals(3, aquarium.getListGuppy().getNBelmt());

        aquarium.removeGuppy(dummy);
        assertEquals(2, aquarium.getListGuppy().getNBelmt());

        System.out.println(this.getName() + " >> success");
    }
   
    @Test
    public void testAddRmPiranha(){

        Piranha dummy = new Piranha();

        aquarium.addPiranha(dummy);
        assertEquals(1, aquarium.getListPiranha().getNBelmt());

        aquarium.removePiranha(dummy);
        assertEquals(0, aquarium.getListPiranha().getNBelmt());

        System.out.println(this.getName() + " >> success");
    }
    
    @Test
    public void testAddRmSiput(){

        Siput dummy = new Siput();

        aquarium.addSiput(dummy);
        assertEquals(2, aquarium.getListSiput().getNBelmt());

        System.out.println(this.getName() + " >> success");
    }
    
    @Test
    public void testAddRmFood(){

        Food dummy = new Food();

        aquarium.addFood(dummy);
        assertEquals(1, aquarium.getListFood().getNBelmt());

        aquarium.removeFood(dummy);
        assertEquals(0, aquarium.getListFood().getNBelmt());

        System.out.println(this.getName() + " >> success");
    }
    
    @Test
    public void testAddRmCoin(){
    
        Coin dummy = new Coin(10, 10, 10);

        aquarium.addCoin(dummy);
        assertEquals(1, aquarium.getListCoin().getNBelmt());

        aquarium.removeCoin(dummy);
        assertEquals(0, aquarium.getListCoin().getNBelmt());

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testBuyGuppy(){

        Aquarium.money = 10000;

        assertEquals(2, aquarium.getListGuppy().getNBelmt());
        aquarium.buyGuppy();
        assertEquals(3, aquarium.getListGuppy().getNBelmt());

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testBuyGuppyFail(){

        Aquarium.money = 0;

        assertEquals(2, aquarium.getListGuppy().getNBelmt());
        aquarium.buyGuppy();
        assertEquals(2, aquarium.getListGuppy().getNBelmt());

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testBuyPiranha(){

        Aquarium.money = 10000;

        assertEquals(0, aquarium.getListPiranha().getNBelmt());
        aquarium.buyPiranha();
        assertEquals(1, aquarium.getListPiranha().getNBelmt());

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testBuyPiranhaFail(){

        Aquarium.money = 0;

        assertEquals(0, aquarium.getListPiranha().getNBelmt());
        aquarium.buyPiranha();
        assertEquals(0, aquarium.getListPiranha().getNBelmt());

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testBuyFood(){

        Aquarium.money = 10000;

        assertEquals(0, aquarium.getListFood().getNBelmt());
        aquarium.buyFood();
        assertEquals(1, aquarium.getListFood().getNBelmt());

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testBuyFoodFail(){

        Aquarium.money = 0;

        assertEquals(0, aquarium.getListFood().getNBelmt());
        aquarium.buyFood();
        assertEquals(0, aquarium.getListFood().getNBelmt());

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testBuyEgg(){

        Aquarium.money = 10000;

        assertEquals(0, Aquarium.egg);
        aquarium.buyEgg();
        assertEquals(1, Aquarium.egg);

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testBuyEggFail(){

        Aquarium.money = 0;

        assertEquals(0, Aquarium.egg);
        aquarium.buyEgg();
        assertEquals(0, Aquarium.egg);

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testBuySiput(){

        Aquarium.money = 10000;

        assertEquals(1, aquarium.getListSiput().getNBelmt());
        aquarium.buySnail();
        assertEquals(2, aquarium.getListSiput().getNBelmt());

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testBuySiputFail(){

        Aquarium.money = 0;

        assertEquals(1, aquarium.getListSiput().getNBelmt());
        aquarium.buySnail();
        assertEquals(1, aquarium.getListSiput().getNBelmt());

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testEuclidean(){

        Coin dummy = new Coin(10, 10, 10);

        assertEquals(5, aquarium.euclidean(13, 14, dummy), 0.01);
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testInRadius(){

        Coin dummy = new Coin(10, 10, 10);
        Coin dummy2 = new Coin(100, 100, 10);
        Coin dummy3 = new Coin(50, 50, 10);

        aquarium.addCoin(dummy);
        aquarium.addCoin(dummy2);
        aquarium.addCoin(dummy3);

        assertEquals(1, aquarium.inRadius(10, 10));
        assertEquals(2, aquarium.inRadius(100, 100));
        assertEquals(3, aquarium.inRadius(50, 50));

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testClickCoin(){

        Coin dummy = new Coin(10, 10, 10);
        aquarium.addCoin(dummy);

        assertEquals(1, aquarium.getListCoin().getNBelmt());
        aquarium.clickCoin(10, 10);
        assertEquals(0, aquarium.getListCoin().getNBelmt());

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testClickCoinFail(){

        Coin dummy = new Coin(10, 10, 10);
        aquarium.addCoin(dummy);

        assertEquals(1, aquarium.getListCoin().getNBelmt());
        aquarium.clickCoin(50, 50);
        assertEquals(0, aquarium.getListCoin().getNBelmt());

        System.out.println(this.getName() + " >> success");
    }
}
