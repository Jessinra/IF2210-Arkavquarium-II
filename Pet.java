public class Pet extends Object {
    private int petCount = 0;
    private int petId = petCount;

    /**
     * default constructor.
     */
    public Pet() {
        petCount++;
        petId = petCount++;
    }

    /**
     * getter pet_id.
     * @return pet_id
     */
    public int getId() {
        return petId;
    }
}
