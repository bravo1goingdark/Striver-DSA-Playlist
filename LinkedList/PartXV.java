package LinkedList;

public class PartXV {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
        dll.arrToDLL(new Integer[]{10, 4, 10, 3, 5, 20, 10});
        DoublyLinkedList.printDLL(deleteAllOccurrences(dll.head, 10));
    }

    public static DLLNode<Integer> deleteAllOccurrences(DLLNode<Integer> head, int k) {
        if (head == null) return null;

        DLLNode<Integer> temp = head;

        while (temp != null) {
            if (temp.value.equals(k)) {
                DLLNode<Integer> prev = temp.prev;
                DLLNode<Integer> next = temp.next;

                if (temp == head) {
                    head = next;
                    if (head != null) head.prev = null;
                } else {
                    if (prev != null) prev.next = next;
                    if (next != null) next.prev = prev;
                }

                temp = next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

}
