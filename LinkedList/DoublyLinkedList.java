package LinkedList;

public class DoublyLinkedList<T> {
    public DLLNode<T> head;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    public void addFirst(T value) {
        DLLNode<T> node = new DLLNode<>(value);

        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        size++;
    }

    public void addLast(T value) {
        if (head == null) {
            addFirst(value);
            return;
        }

        DLLNode<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        DLLNode<T> node = new DLLNode<>(value);
        temp.next = node;
        node.prev = temp;
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

        DLLNode<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        DLLNode<T> front = temp.next;
        DLLNode<T> node = new DLLNode<>(value);

        temp.next = node;
        node.prev = temp;

        node.next = front;
        if (front != null) front.prev = node;

        size++;
    }

    public DLLNode<T> deleteFirst() {
        if (head == null) return null;

        DLLNode<T> temp = head;
        head = head.next;

        if (head != null) head.prev = null;

        temp.next = null;
        size--;
        return temp;
    }

    public DLLNode<T> deleteLast() {
        if (head == null) return null;

        if (head.next == null) {
            DLLNode<T> temp = head;
            head = null;
            size--;
            return temp;
        }

        DLLNode<T> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        DLLNode<T> del = temp.next;
        temp.next = null;
        del.prev = null;

        size--;
        return del;
    }

    public DLLNode<T> deleteAtIndex(int index) {
        if (index < 0 || index >= size) return null;

        if (index == 0) return deleteFirst();
        if (index == size - 1) return deleteLast();

        DLLNode<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        DLLNode<T> del = temp.next;
        DLLNode<T> front = del.next;

        temp.next = front;
        if (front != null) front.prev = temp;

        del.prev = null;
        del.next = null;

        size--;
        return del;
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
        DLLNode<T> temp = this.head;

        while (temp != null) {
            sb.append(temp.value);
            if (temp.next != null) sb.append(" <--> ");
            temp = temp.next;
        }

        return sb.toString();
    }
}
