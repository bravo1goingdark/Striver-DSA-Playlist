package LinkedList;

public class PartII {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        LinkedList<Integer> l2 = new LinkedList<Integer>();

        l1.arrToLL(new Integer[]{9, 8, 3, 2});  // 2->3->8->9 = 9832
        l2.arrToLL(new Integer[]{4, 6, 7, 8});  // 8->7->6->4 = 8674

        LLNode<Integer> add = addTwoNumbers(l1.head, l2.head);
        LinkedList.printLL(add);  // Should print 3 -> 5 -> 0 -> 1 -> 1 (11063)
    }

    public static LLNode<Integer> addTwoNumbers(LLNode<Integer> l1, LLNode<Integer> l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        LLNode<Integer> dummy = new LLNode<>(-1);
        LLNode<Integer> temp = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.value;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.value;
                l2 = l2.next;
            }

            temp.next = new LLNode<>(sum % 10);
            carry = sum / 10;
            temp = temp.next;
        }

        if (carry != 0) {
            temp.next = new LLNode<>(carry);
        }

        return dummy.next;
    }


}
