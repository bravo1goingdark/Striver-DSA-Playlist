package LinkedList;

public class PartXIII {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.arrToLL(new Integer[]{1,2,3,4});
        LinkedList.printLL(deleteMiddle(ll.head));
    }
    public static LLNode<Integer> deleteMiddle(LLNode<Integer> head) {
        if (head == null || head.next == null) return head;

        LLNode<Integer> prev = null;
        LLNode<Integer> slow = head;
        LLNode<Integer> fast = head;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}
