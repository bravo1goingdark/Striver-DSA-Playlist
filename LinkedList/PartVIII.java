package LinkedList;

public class PartVIII {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.arrToLL(new Integer[]{1, 2, 3, 4});
        LinkedList.printLL(add1(ll.head));

    }


    public static LLNode<Integer> add1(LLNode<Integer> head){
        int carry = addOneOpt(head);
        if (carry > 0){
            LLNode<Integer> c = new LLNode<Integer>(carry);
            c.next = head;
            head = c;
        }
        return head;
    }

    private static int addOneOpt(LLNode<Integer> head) {
        if (head == null) return 1;

        int carry = addOneOpt(head.next);
        int sum = head.value + carry;

        head.value = sum % 10;
        return sum / 10;
    }

    public static LLNode<Integer> addOne(LLNode<Integer> head) {
        head = reverseListOpt(head);
        LLNode<Integer> temp = head;
        int carry = 1;

        while (temp != null) {
            int sum = temp.value + carry;
            temp.value = sum % 10;
            carry = sum / 10;

            if (carry == 0) break;
            temp = temp.next;
        }

        head = reverseListOpt(head);

        if (carry > 0) {
            LLNode<Integer> c = new LLNode<>(carry);
            c.next = head;
            head = c;
        }

        return head;
    }


    private static LLNode<Integer> reverseListOpt(LLNode<Integer> head) {
        if (head == null || head.next == null) return head;

        LLNode<Integer> temp = head;
        LLNode<Integer> prev = null;

        while (temp != null) {
            LLNode<Integer> front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }
}
