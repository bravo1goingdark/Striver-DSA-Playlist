package LinkedList;


import java.awt.event.ItemEvent;
import java.util.Stack;

public class PartI {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
        int[] arr = new int[]{1, 2, 3, 4};
        for (int e : arr) dll.addLast(e);
        System.out.println(dll);
        DLLNode<Integer> temp = reverseDLLOpt(dll.head);
        DoublyLinkedList.printDLL(temp);
    }

    // time comp -> O(2N)
    // space comp -> O(N)
    public static DLLNode<Integer> reverseDLL(DLLNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Stack<Integer> stack = new Stack<>();
        DLLNode<Integer> temp = head;

        while (temp != null) {
            stack.push(temp.value);
            temp = temp.next;
        }
        temp = head;

        while (!stack.isEmpty()) {
            temp.value = stack.pop();
            temp = temp.next;
        }

        return head;
    }
    public static DLLNode<Integer> reverseDLLOpt(DLLNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        DLLNode<Integer> last = null;
        DLLNode<Integer> curr = head;

        while (curr != null){
          last = curr.prev;
          curr.prev = curr.next;
          curr.next = last;

          curr = curr.prev;

        }
        head = last.prev;

        return head;
    }

}
