package LinkedList;

import java.util.Stack;

public class PartVI {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.arrToLL(new Integer[]{1, 2, 3, 4});
        LinkedList.printLL(reverseListOptRecur(ll.head,null));
    }

    public static LLNode<Integer> reverseList(LLNode<Integer> head) {

        if (head == null || head.next == null) return head;

        LLNode<Integer> temp = head;
        Stack<Integer> stack = new Stack<>();

        while (temp != null) {
            stack.push(temp.value);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            temp.value = stack.pop();
            temp = temp.next;
        }

        return head;
    }

    public static LLNode<Integer> reverseListOpt(LLNode<Integer> head) {
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

    public static LLNode<Integer> reverseListOptRecur(LLNode<Integer> temp, LLNode<Integer> prev) {
        if (temp == null) {
            return prev;
        }

        LLNode<Integer> front = temp.next;
        temp.next = prev;

        return reverseListOptRecur(front, temp);
    }
}
