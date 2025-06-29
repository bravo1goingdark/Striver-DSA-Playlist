package LinkedList;

import java.util.Objects;
import java.util.Stack;

public class PartVII {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.arrToLL(new Integer[]{1, 2, 3, 2});
        System.out.println(isPalindromeOpt(ll.head));
    }

    public static boolean isPalindrome(LLNode<Integer> head) {
        Stack<Integer> stack = new Stack<>();
        LLNode<Integer> temp = head;

        while (temp != null) {
            stack.push(temp.value);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            if (!Objects.equals(temp.value, stack.pop())) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }

    public static boolean isPalindromeOpt(LLNode<Integer> head) {
        LLNode<Integer> mid = getMid(head);
        LLNode<Integer> r = reverseListOpt(mid);

        LLNode<Integer> f = head;
        LLNode<Integer> s = r;

        while (s != null) {
            if (!f.value.equals(s.value)) {
                reverseListOpt(r);  // restore original list
                return false;
            }

            f = f.next;
            s = s.next;
        }
        reverseListOpt(r);  // restore original list
        return true;
    }

    private static LLNode<Integer> getMid(LLNode<Integer> head) {
        if (head == null || head.next == null) return head;

        LLNode<Integer> slow = head;
        LLNode<Integer> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
