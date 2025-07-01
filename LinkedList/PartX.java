package LinkedList;


public class PartX {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.arrToLL(new Integer[]{1,2,3,4,5});
        System.out.println(middleNode(ll.head).getValue());
    }
    public static LLNode<Integer> middleNode(LLNode<Integer> head) {

        if (head == null || head.next == null) return head;

        LLNode<Integer> fast = head;
        LLNode<Integer> slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
