package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class PartXII {

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
        node7.next = node1; // cycle here

        System.out.println("Cycle length: " + lengthOfLLOpt(node1)); // Should print 5
    }

    public static int lengthOfLL(LLNode<Integer> head) {
        if (head == null || head.next == null) return 0;

        Map<LLNode<Integer>, Integer> map = new HashMap<>();
        LLNode<Integer> temp = head;
        int count = 0;

        while (temp != null) {
            if (map.containsKey(temp)) {
                return count - map.get(temp);
            }
            map.put(temp, count);
            temp = temp.next;
            count++;
        }
        return 0;
    }

    public static int lengthOfLLOpt(LLNode<Integer> head) {
        if (head == null || head.next == null) return 0;

        LLNode<Integer> slow = head;
        LLNode<Integer> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return len(slow, fast);
            }
        }
        return 0;
    }

    private static int len(LLNode<Integer> slow, LLNode<Integer> fast) {
        int count = 1;
        fast = fast.next;

        while (slow != fast){
            count++;
            fast = fast.next;
        }
        return count;
    }
}
