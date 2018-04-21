import java.util.*;


public class Pet extends Object {
    private int pet_count = 0;
    private int pet_id = pet_count;

    public Pet() {
        pet_count++;
        pet_id = pet_count++;
    }

    public int get_id() { 
        return pet_id; 
    }
}
