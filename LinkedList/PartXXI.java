package LinkedList;

import java.util.*;

public class PartXXI {
    public static void main(String[] args) {
        // Level 0
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(19);
        head.next.next.next = new Node(28);

        // Level 1
        head.child = new Node(7);
        head.child.child = new Node(8);
        head.child.child.child = new Node(30);

        head.next.child = new Node(20);

        head.next.next.child = new Node(22);
        head.next.next.child.child = new Node(50);

        head.next.next.next.child = new Node(35);
        head.next.next.next.child.child = new Node(40);
        head.next.next.next.child.child.child = new Node(45);

        Node flat = flattenLinkedListOpt(head);
        printList(flat);
    }

    public static Node flattenLinkedListOpt(Node head) {
        if (head == null || head.next == null){
            return head;
        }
        Node mergedHead = flattenLinkedListOpt(head.next);
        head.next = null; // break the horizontal chain

        return merge(head , mergedHead);
    }
    private static Node merge(Node list1, Node list2) {
        Node dummy = new Node(0);
        Node temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                temp.child = list1;
                list1 = list1.child;
            } else {
                temp.child = list2;
                list2 = list2.child;
            }
            temp = temp.child;
        }

        temp.child = (list1 != null) ? list1 : list2;

        return dummy.child;
    }

    public static Node flattenLinkedList(Node head) {
        if (head == null || (head.next == null && head.child == null)) {
            return head;
        }

        Node temp = head;
        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            Node childTemp = temp;

            while (childTemp != null) {
                list.add(childTemp.data);
                childTemp = childTemp.child;
            }
            temp = temp.next;
        }
        Collections.sort(list);
        return convert(list);
    }

    private static Node convert(List<Integer> ls) {
        if (ls.isEmpty()) return null;

        Node dummy = new Node(-1);
        Node temp = dummy;

        for (int e : ls) {
            temp.next = new Node(e);
            temp = temp.next;
        }
        return dummy.next;
    }

    private static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.child;
        }
        System.out.println("null");
    }

    private static class Node {
        public int data;
        public Node next;
        public Node child;

        Node() {
            this.data = 0;
            this.next = null;
            this.child = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }

        Node(int data, Node next, Node child) {
            this.data = data;
            this.next = next;
            this.child = child;
        }
    }
}
