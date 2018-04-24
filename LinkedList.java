/**
 * kelas generik LinkedList.
 * indeks dimulai dari 1
 */

public class LinkedList<T> {

  private Node<T> head;

  // public Node<T> getHead(){
  //     return this.head;
  // }

  // public void setHead(Node<T> node){
  //     this.head = node;
  // }

  /**
   * default constructor.
   */
  public LinkedList() {
    this.head = null;
  }

  /**
   * default constructor.
   *
   * @param l to be copied to new LinkedList
   */
  public LinkedList(LinkedList<T> l) {

    // set head
    this.head = new Node<>();

    // set value
    T val = l.head.getValue();
    this.head.setValue(val);

    Node<T> prec = this.head;
    Node<T> n1 = l.head;

    while (n1.getNext() != null) {
      n1 = n1.getNext();
      Node<T> n = new Node<>();
      n.setValue(n1.getValue());
      prec.setNext(n);
      prec = n;
    }
  }

  /**
   * mengecek keadaan list.
   *
   * @return boolean kosong atau tidaknya
   */
  public Boolean isEmpty() {
    return this.head == null;
  }

  /**
   * menambah elemen ke dalam list.
   *
   * @param element value yang akan dimasukkan ke dalam T
   */
  public void add(T element) {
    if (!isEmpty()) {
      Node<T> i = this.head;

      while (i.getNext() != null) {
        i = i.getNext();
      }

      Node<T> n = new Node<>();
      n.setValue(element);
      n.setNext(null);

      i.setNext(n);
    } else {
      Node<T> n = new Node<>();
      n.setValue(element);
      n.setNext(null);

      this.head = n;
    }
  }

  /**
   * menghapus elemen dari dalam list.
   *
   * @param element value yang akan diremove dari T
   */
  public void remove(T element) {
    // menghapus element dengan identitas demikian yang paling pertama

    if (head.getValue() == element) {
      Node<T> temp = this.head;
      this.head = temp.getNext();

    } else {
      Node<T> prec = this.head;
      Node<T> del = head.getNext();

      while (del.getNext() != null && del.getValue() != element) {
        prec = del;
        del = del.getNext();
      }
      prec.setNext(del.getNext());

    }
  }

  /**
   * mendapatkan elemen dengan indeks tertentu.
   *
   * @param idx indeks ke-idx dari T yang akan direturn
   * @return elemen
   */
  public T get(int idx) {
    // dipastikan ada
    if (!this.isEmpty()) {
      int i = 1;
      Node<T> n = this.head;

      while (n.getNext() != null && i != idx) {
        n = n.getNext();
        i++;
      }

      if (i == idx) {
        return n.getValue();
      }
    }

    return null;
  }

  /**
   * mendapatkan panjang list.
   *
   * @return panjang list
   */
  public int getNBelmt() {
    // get number of element in list
    if (!this.isEmpty()) {
      int i = 1;
      Node<T> list = this.head;
      while (list.getNext() != null) {
        list = list.getNext();
        i++;
      }
      return i;
    } else {
      return 0;
    }
  }
}