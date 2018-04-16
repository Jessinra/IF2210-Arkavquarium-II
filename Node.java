public class Node<T>{
    private T value;
    private Node<T> next;

    public Node() {
        this.value = null;
        this.next = null;
    }

    public T getValue(){
        return this.value;
    }

    public void setValue(T val){
        this.value = val;
    }

    public Node<T> getNext(){
        return this.next;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }
}