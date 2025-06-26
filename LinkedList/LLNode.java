package LinkedList;

public class LLNode<T> {
    public T value;
    public LLNode<T> next;

    public LLNode() {
    }

    public LLNode(T value) {
        this.value = value;
        this.next = null;
    }

    public LLNode(T value, LLNode<T> next) {
        this(value);
        this.next = next;
    }

    public T getValue() {
        return value;
    }

}
