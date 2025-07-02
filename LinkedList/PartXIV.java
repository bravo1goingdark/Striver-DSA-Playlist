package LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PartXIV {
    public static void main(String[] args) {
        // Create nodes
        LLNode<Integer> node1 = new LLNode<>(1);
        LLNode<Integer> node2 = new LLNode<>(2);
        LLNode<Integer> node3 = new LLNode<>(3);
        LLNode<Integer> node4 = new LLNode<>(4);
        LLNode<Integer> node5 = new LLNode<>(5);
        LLNode<Integer> node6 = new LLNode<>(6);
        LLNode<Integer> node7 = new LLNode<>(7);

        // Link them
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node3; // cycle here

        System.out.println("start of the cycle : " + startOfCycleOpt(node1).getValue()); // Should print 5
    }


    public static LLNode<Integer> startOfCycle(LLNode<Integer> head) {
        if (head == null || head.next == null) return head;

        Set<LLNode<Integer>> set = new HashSet<>();
        LLNode<Integer> temp = head;

        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }

    public static LLNode<Integer> startOfCycleOpt(LLNode<Integer> head){
        if (head == null || head.next == null) return head;

        LLNode<Integer> slow = head;
        LLNode<Integer> fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) break;
        }

        fast = head;

        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
