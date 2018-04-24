public class Node<T> {
  private T value;
  private Node<T> next;

  /**
     * default constructor.
     */
  public Node() {
    this.value = null;
    this.next = null;
  }

  /**
     * getter value.
     * @return value
     */
  public T getValue() {
    return this.value;
  }

  /**
     * setter value.
     * @param val set param val to value
     */
  public void setValue(T val) {
    this.value = val;
  }

  /**
     * getter next.
     * @return next
     */
  public Node<T> getNext() {
    return this.next;
  }

  /**
     * setter next.
     * @param next set param next to next
     */
  public void setNext(Node<T> next) {
    this.next = next;
  }
}