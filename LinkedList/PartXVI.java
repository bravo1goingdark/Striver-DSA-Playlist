package LinkedList;

import java.lang.reflect.Array;
import java.util.*;

public class PartXVI {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
        dll.arrToDLL(new Integer[]{1, 2, 3, 4, 9});

        for (Integer[] e : findPairOpt(dll.head, 5)) {
            System.out.println(Arrays.toString(e));
        }
    }

    public static List<Integer[]> findPair(DLLNode<Integer> head, int k) {
        DLLNode<Integer> temp = head;
        List<Integer[]> ans = new ArrayList<>();

        while (temp != null) {
            DLLNode<Integer> s = temp.next;

            while (s != null && temp.value + s.value <= k) {
                if (temp.value + s.value == k) {
                    ans.add(new Integer[]{temp.value, s.value});
                }
                s = s.next;
            }
            temp = temp.next;
        }
        return ans;
    }

    public static List<Integer[]> findPairBetter(DLLNode<Integer> head, int k) {
        DLLNode<Integer> temp = head;
        Map<Integer, DLLNode<Integer>> map = new HashMap<>();
        List<Integer[]> ans = new ArrayList<>();

        while (temp != null) {
            Integer target = k - temp.value;

            if (map.containsKey(target)) {
                ans.add(new Integer[]{temp.value, target});
            }
            map.put(temp.value, temp);
            temp = temp.next;
        }
        return ans;
    }
    public static List<Integer[]> findPairOpt(DLLNode<Integer> head, int k) {
        DLLNode<Integer> start = head;
        DLLNode<Integer> end = head;
        List<Integer[]> ans = new ArrayList<>();

        while (end.next != null) end = end.next;

        while (start.value < end.value) {
            int sum = start.value + end.value;

            if (sum == k){
                ans.add(new Integer[]{start.value , end.value});
                start = start.next;
                end = end.prev;
            }
            else if (sum > k){
                end = end.prev;
            }
            else start = start.next;
        }
        return ans;
    }
}
