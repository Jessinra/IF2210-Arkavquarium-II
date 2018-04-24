import junit.framework.TestCase;

import java.beans.Transient;

import javax.accessibility.AccessibleAttributeSequence;

import org.junit.*;

import jdk.nashorn.internal.AssertsEnabled;

public class TestFood extends TestCase{
    private Food dummy =  new Food();

    @Test
    public void testConstructorParam(){

        Food dummy = new Food(15);

        assertNotNull(dummy);
        assertEquals(15, dummy.getX(), 0.01);

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testId(){

        assertEquals(4, dummy.getId());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testSpeed(){

        assertEquals(Constants.FOOD_MOVEMENT_SPD, dummy.getSpeed());
        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testGetSet(){
        
        dummy.setX(10);
        assertEquals(10, dummy.getX(), 0.01);

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testMove(){

        dummy.setY(50);
        dummy.move();
        assertEquals(51, dummy.getY(), 0.01);

        System.out.println(this.getName() + " >> success");
    }

    @Test
    public void testMoveFail(){

        dummy.setY(1250);
        dummy.move();
        assertEquals(1250, dummy.getY(), 0.01);

        System.out.println(this.getName() + " >> success");
    }
    
}