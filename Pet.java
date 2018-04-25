public class Pet extends Object {
  private static int petCount = 0;
  private int petId;

  
  /**
   * default constructor.
   */
  public Pet() {
    petId = petCount++;
  }

  /**
   * getter pet_id.
   *
   * @return pet_id
   */
  public int getId() {
    return petId;
  }
}
