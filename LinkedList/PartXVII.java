package LinkedList;

import java.sql.SQLOutput;

public class PartXVII {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
        dll.arrToDLL(new Integer[]{1, 2, 3, 3, 4, 4, 5});
        DoublyLinkedList.printDLL(removeDuplicatesII(dll.head));
    }

    public static DLLNode<Integer> removeDuplicates(DLLNode<Integer> head) {
        if (head == null || head.next == null) return head;

        DLLNode<Integer> temp = head;

        while (temp != null && temp.next != null) {
            DLLNode<Integer> nextNode = temp.next;

            while (nextNode != null && nextNode.value.equals(temp.value)) {
                nextNode = nextNode.next;
            }

            temp.next = nextNode;
            if (nextNode != null) nextNode.prev = temp;
            temp = temp.next;
        }

        return head;
    }

    public static DLLNode<Integer> removeDuplicatesII(DLLNode<Integer> head) {
        if (head == null || head.next == null) return head;

        DLLNode<Integer> dummy = new DLLNode<>(0);
        dummy.next = head;
        head.prev = dummy;

        DLLNode<Integer> temp = head;

        while (temp != null) {
            boolean isDuplicate = false;
            DLLNode<Integer> nextNode = temp.next;

            while (nextNode != null && nextNode.value.equals(temp.value)) {
                isDuplicate = true;
                nextNode = nextNode.next;
            }

            if (isDuplicate) {
                // Remove all nodes with this duplicate value
                DLLNode<Integer> prevNode = temp.prev;
                prevNode.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }
            } else temp = temp.next;

            if (isDuplicate) temp = nextNode;
        }

        return dummy.next;
    }

}
