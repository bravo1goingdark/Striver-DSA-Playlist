package LinkedList;


public class PartXVIII {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.arrToLL(new Integer[]{1,2,3,4,4});
        LinkedList.printLL(reverseKGroup(ll.head,2));
    }
    public static LLNode<Integer> reverseKGroup(LLNode<Integer> head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        LLNode<Integer> temp = head;
        LLNode<Integer> prev = null;

        while (temp != null) {
            LLNode<Integer> kthNode = getKthNode(temp, k);
            if (kthNode == null) {
                // connect remainder if less than k nodes left
                if (prev != null) prev.next = temp;
                break;
            }

            LLNode<Integer> nextNode = kthNode.next;
            kthNode.next = null;

            LLNode<Integer> reversedHead = reverseListOpt(temp);

            if (temp == head) head = reversedHead;
            else prev.next = reversedHead;

            // temp becomes the tail of the reversed group
            prev = temp;
            temp = nextNode;
        }

        return head;
    }

    private static LLNode<Integer> getKthNode(LLNode<Integer> head, int k) {
        LLNode<Integer> temp = head;
        while (--k > 0 && temp != null) {
            temp = temp.next;
        }
        return temp;
    }

    private static LLNode<Integer> reverseListOpt(LLNode<Integer> head) {
        LLNode<Integer> prev = null;
        while (head != null) {
            LLNode<Integer> next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
