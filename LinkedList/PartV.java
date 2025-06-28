package LinkedList;

public class PartV {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.arrToLL(new Integer[]{1,2,3,4,5});
        LinkedList.printLL(removeNthFromEndOpt(ll.head , 2));
    }


    public static LLNode<Integer> removeNthFromEnd(LLNode<Integer> head, int n) {
        int length = len(head);

        if (n == length) {
            return head.next;
        }

        LLNode<Integer> temp = head;
        for (int i = 0; i < length - n - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }

    public static int len(LLNode<Integer> head) {
        int len = 0;
        LLNode<Integer> temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }
    public static LLNode<Integer> removeNthFromEndOpt(LLNode<Integer> head, int n) {
        if (head == null) return null;
        LLNode<Integer> fast = head;
        LLNode<Integer> slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // when length == n i.e FAST becomes null, and we are req to delete first node
        if (fast == null) return head.next;

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }




}
