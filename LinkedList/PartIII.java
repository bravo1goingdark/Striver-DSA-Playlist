package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class PartIII {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.arrToLL(new Integer[]{2, 1, 3, 5, 6, 4, 7});

        System.out.println(ll);

        LinkedList.printLL(oddEvenListOpt(ll.head));

    }

    public static LLNode<Integer> oddEvenList(LLNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        List<Integer> list = new ArrayList<>();

        LLNode<Integer> odd = head;
        LLNode<Integer> even = head.next;

        while (odd != null && odd.next != null) {
            list.add(odd.value);
            odd = odd.next.next;
        }
        if (odd != null) list.add(odd.value);

        while (even != null && even.next != null) {
            list.add(even.value);
            even = even.next.next;
        }
        if (even != null) list.add(even.value);

        LLNode<Integer> temp = head;

        int index = 0;
        while (temp != null) {
            temp.value = list.get(index);
            index++;
            temp = temp.next;
        }

        return head;
    }

    public static LLNode<Integer> oddEvenListOpt(LLNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        LLNode<Integer> odd = head;
        LLNode<Integer> even = head.next;
        LLNode<Integer> evenHead = head.next;
        // 2, 1, 3, 5, 6, 4, 7
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

}
