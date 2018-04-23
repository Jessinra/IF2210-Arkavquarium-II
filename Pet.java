public class Pet extends Object {
    private int pet_count = 0;
    private int pet_id = pet_count;

    /**
     * default constructor
     */
    public Pet() {
        pet_count++;
        pet_id = pet_count++;
    }

    /**
     * getter pet_id
     * @return pet_id
     */
    public int get_id() {
        return pet_id;
    }
}
