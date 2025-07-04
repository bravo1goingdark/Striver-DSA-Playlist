package LinkedList;


public class PartXIX {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.arrToLL(new Integer[]{1,2,3,4,5});
        LinkedList.printLL(rotate(ll.head , 2));
    }
    public static LLNode<Integer> rotate(LLNode<Integer> head, int k) {
        if (head == null || head.next == null) return head;

        int len = 1;
        LLNode<Integer> temp = head;

        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        temp.next = head;

        k = k % len;

        if (k == 0) {
            temp.next = null;
            return head;
        }
        int diff = len - k;
        temp = head;

        while (temp != null && --diff > 0) {
            temp = temp.next;
        }
        LLNode<Integer> nextHead = temp.next;
        temp.next = null;

        return nextHead;
    }
}
