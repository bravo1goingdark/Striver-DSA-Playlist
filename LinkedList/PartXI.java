package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class PartXI {


    public static boolean containsCycle(LLNode<Integer> head) {
        if (head == null || head.next == null) return false;

        Set<LLNode<Integer>> set = new HashSet<>();
        LLNode<Integer> temp = head;

        while (temp != null) {
            if (set.contains(temp)) return true;
            else set.add(temp);
            temp = temp.next;
        }
        return false;
    }
    public static boolean containsCycleOpt(LLNode<Integer> head) {
        if (head == null || head.next == null) return false;

        LLNode<Integer> slow = head;
        LLNode<Integer> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }
}
