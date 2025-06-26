package LinkedList;

public class DLLNode<T> {
    public T value;
    public DLLNode<T> next;
    public DLLNode<T> prev;

    public DLLNode() {
    }

    public DLLNode(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public DLLNode(T value, DLLNode<T> next, DLLNode<T> prev) {
        this(value);
        this.next = next;
        this.prev = prev;
    }

    public T getValue() {
        return value;
    }


}
