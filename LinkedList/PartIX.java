package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class PartIX {
    public static void main(String[] args) {
        // Shared part of the list
        LLNode<Integer> c1 = new LLNode<>(8);
        LLNode<Integer> c2 = new LLNode<>(10);
        c1.next = c2;

        // First list: 3 -> 7 -> 8 -> 10
        LLNode<Integer> a1 = new LLNode<>(3);
        LLNode<Integer> a2 = new LLNode<>(7);
        a1.next = a2;
        a2.next = c1;

        // Second list: 99 -> 1 -> 8 -> 10
        LLNode<Integer> b1 = new LLNode<>(99);
        LLNode<Integer> b2 = new LLNode<>(1);
        b1.next = b2;
        b2.next = c1;

        System.out.print("List A: ");
        LinkedList.printLL(a1);

        System.out.print("List B: ");
        LinkedList.printLL(b1);

        System.out.println(interOpt(a1,b1).value);
    }

    public static LLNode<Integer> getIntersectionNode(LLNode<Integer> headA, LLNode<Integer> headB) {
        Set<LLNode<Integer>> set = new HashSet<>();
        LLNode<Integer> ll = headA;

        while (ll != null) {
            set.add(ll);
            ll = ll.next;
        }
        LLNode<Integer> temp = headB;

        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    public static LLNode<Integer> getInter(LLNode<Integer> a, LLNode<Integer> b) {
        if (a == null || b == null) return null;
        int lenOfA = getLen(a);
        int lenOfB = getLen(b);

        if (lenOfA > lenOfB) {
            int diff = lenOfA - lenOfB;
            while (diff-- > 0) a = a.next;
        } else {
            int diff = lenOfB - lenOfA;
            while (diff-- > 0) b = b.next;
        }
        return intersection(a, b);
    }
    private static LLNode<Integer> intersection(LLNode<Integer> f, LLNode<Integer> s) {

        while (f != null && s != null) {
            if (f == s) {
                return f;
            }
            f = f.next;
            s = s.next;
        }
        return null;
    }

    private static int getLen(LLNode<Integer> head) {
        int len = 0;

        LLNode<Integer> temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        return len;
    }

    public static LLNode<Integer> interOpt(LLNode<Integer> a , LLNode<Integer> b){
        if (a == null || b == null) return null;
        LLNode<Integer> f = a;
        LLNode<Integer> s = b;

        while (f != s){
            f = f == null ? b : f.next;
            s = s == null ? a : s.next;
        }

        return f;
    }
}
