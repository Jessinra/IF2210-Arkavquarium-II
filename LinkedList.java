/**
 * kelas generik LinkedList
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
     * default constructor
     */
    public LinkedList() {
        this.head = null;
    }

    /**
     * default constructor
     * @param L
     */
    public LinkedList(LinkedList<T> L) {

        // set head
        this.head = new Node<T>();

        // set value
        T val = L.head.getValue();
        this.head.setValue(val);

        Node<T> prec = this.head;
        Node<T> n1 = L.head;

        while (n1.getNext() != null) {
            n1 = n1.getNext();
            Node<T> n = new Node<T>();
            n.setValue(n1.getValue());
            prec.setNext(n);
            prec = n;
        }
    }

    /**
     * assignmet
     * @param L
     * @return list
     */
    public LinkedList<T> assign(LinkedList<T> L) {

        // set head
        this.head = new Node<T>();

        // set value
        T val = L.head.getValue();
        this.head.setValue(val);

        Node<T> prec = this.head;
        Node<T> n1 = L.head;

        while (n1.getNext() != null) {
            n1 = n1.getNext();
            Node<T> n = new Node<T>();
            n.setValue(n1.getValue());
            prec.setNext(n);
            prec = n;
        }

        return this;
    }

    /**
     * mengecek keadaan list
     * @return boolean kosong atau tidaknya
     */
    public Boolean isEmpty() {
        return this.head == null;
    }

    /**
     * menambah elemen ke dalam list
     * @param element
     */
    public void add(T element) {
        if (!isEmpty()) {
            Node<T> i = this.head;

            while (i.getNext() != null) {
                i = i.getNext();
            }

            Node<T> n = new Node<T>();
            n.setValue(element);
            n.setNext(null);

            i.setNext(n);
        } else {
            Node<T> n = new Node<T>();
            n.setValue(element);
            n.setNext(null);

            this.head = n;
        }
    }

    /**
     * menghapus elemen dari dalam list
     * @param element
     */
    public void remove(T element) {
        /** menghapus element dengan identitas demikian yang paling pertama
         */

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
     * mencari elemen di dalam list
     * @param element
     */
    public int find(T element) {
        /** mengembalikan indeks element dengan identitas demikian yang paling pertama. bila tidak ada return -1
         */
        if (!this.isEmpty()) {
            Node<T> del = this.head;
            int idx = 1;

            while (del.getNext() != null && del.getValue() != element) {
                del = del.getNext();
                idx++;
            }

            if (del.getValue() == element) {
                return idx;
            }
        }

        return -1;
    }

    /**
     * mendapatkan elemen dengan indeks tertentu
     * @param idx
     * @return elemen
     */
    public T get(int idx) {
        /** dipastikan ada
         */
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
     * mencetak list ke layar
     */
    public void printList() {
        /** print isi list dengan format [1,2,...,n]
         */
        if (!this.isEmpty()) {
            System.out.print('[');
            Node<T> list = this.head;
            System.out.print(list.getValue());

            while (list.getNext() != null) {
                list = list.getNext();
                System.out.print("," + list.getValue());
            }
            System.out.print(']');
        } else {
            System.out.print("[]");
        }
    }

    /**
     * mendapatkan panjang list
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