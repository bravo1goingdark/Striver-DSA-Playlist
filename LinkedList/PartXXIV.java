package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class PartXXIV {
    public static void main(String[] args) {
        // Create original nodes
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        // Setup next pointers
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        // Setup random pointers
        node1.random = null;  // 1 → 3
        node2.random = node1;  // 2 → 1
        node3.random = node5;  // 3 → 2
        node4.random = node3;
        node5.random = node1;

        // Deep copy the list
        Node copiedHead = copyRandomListOpt(node1);

        // Print the copied list
        Node curr = copiedHead;
        while (curr != null) {
            System.out.print("Node Val: " + curr.val);
            if (curr.random != null) {
                System.out.println(", Random Val: " + curr.random.val);
            } else {
                System.out.println(", Random Val: null");
            }
            curr = curr.next;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node temp = head;

        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            Node copy = map.get(temp);
            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }

    public static Node copyRandomListOpt(Node head) {
        if (head == null) return null;

        Node temp = head;

        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }

        temp = head;
        while (temp != null) {
            Node copy = temp.next;
            copy.random = temp.random != null ? temp.random.next : null;
            temp = temp.next.next;

        }

        Node dummy = new Node(0);
        Node res = dummy;
        temp = head;

        while (temp != null) {
            res.next = temp.next;
            res = res.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummy.next;
    }


    // Definition for a Node.
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
