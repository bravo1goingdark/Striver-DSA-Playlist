package LinkedList;

public class LinkedList<T> {

    public LLNode<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void arrToLL(T[] arr) {
        for (T e : arr) addLast(e);
    }

    public void addFirst(T value) {
        LLNode<T> node = new LLNode<>(value);
        node.next = head;
        head = node;
        size++;
    }

    public void addLast(T value) {
        if (head == null) {
            addFirst(value);
            return;
        }

        LLNode<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new LLNode<>(value);
        size++;
    }

    public void insertAtIndex(int index, T value) {
        if (index < 0 || index > size) return;

        if (index == 0) {
            addFirst(value);
            return;
        }

        if (index == size) {
            addLast(value);
            return;
        }

        LLNode<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        LLNode<T> node = new LLNode<>(value);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public LLNode<T> deleteFirst() {
        if (head == null) return null;

        LLNode<T> temp = head;
        head = head.next;
        size--;
        return temp;
    }

    public LLNode<T> deleteLast() {
        if (head == null) return null;

        if (head.next == null) {
            LLNode<T> temp = head;
            head = null;
            size--;
            return temp;
        }

        LLNode<T> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        LLNode<T> del = temp.next;
        temp.next = null;
        size--;
        return del;
    }

    public LLNode<T> deleteAtIndex(int index) {
        if (index < 0 || index >= size) return null;

        if (index == 0) return deleteFirst();
        if (index == size - 1) return deleteLast();

        LLNode<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        LLNode<T> del = temp.next;
        temp.next = del.next;
        size--;
        return del;
    }

    public LLNode<T> search(T value) {
        LLNode<T> temp = this.head;
        while (temp != null) {
            if (temp.value.equals(value)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) return "Empty Linked List";

        StringBuilder sb = new StringBuilder();
        LLNode<T> temp = this.head;

        while (temp != null) {
            sb.append(temp.value);
            if (temp.next != null) sb.append(" -> ");
            temp = temp.next;
        }

        return sb.toString();
    }
    public static void printLL(LLNode<Integer> head) {
        while (head != null) {
            System.out.print(head.value);
            System.out.print(" -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
