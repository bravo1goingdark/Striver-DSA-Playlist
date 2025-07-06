package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PartXXII {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        l1.arrToLL(new Integer[]{1, 2, 3, 4, 5});
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        l2.arrToLL(new Integer[]{6, 9, 13, 44, 45});
        LinkedList<Integer> l3 = new LinkedList<Integer>();
        l3.arrToLL(new Integer[]{8, 11});

        LinkedList.printLL(mergeKList(new LLNode[]{l1.head, l2.head, l3.head}));
    }

    public static LLNode<Integer> mergeKLists(LLNode<Integer>[] lists) {

        if (lists.length == 0) return null;

        PriorityQueue<LLNode<Integer>> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.value)
        );

        for (LLNode<Integer> head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        LLNode<Integer> dummy = new LLNode<Integer>(-1);
        dummy.next = null;
        LLNode<Integer> temp = dummy;

        while (!pq.isEmpty()) {
            LLNode<Integer> min = pq.poll();
            temp.next = min;
            temp = temp.next;

            if (min.next != null) {
                pq.offer(min.next);
            }
        }
        return dummy.next;

    }

    public static LLNode<Integer> mergeKList(LLNode<Integer>[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return mergeK(lists, 0, lists.length - 1);
    }

    private static LLNode<Integer> mergeK(LLNode<Integer>[] lists, int s, int e) {
        if (s == e) return lists[s];
        int mid = (s + e) / 2;

        LLNode<Integer> left = mergeK(lists, s, mid);
        LLNode<Integer> right = mergeK(lists, mid + 1, e);

        return merge(left, right);
    }

    private static LLNode<Integer> merge(LLNode<Integer> list1, LLNode<Integer> list2) {
        LLNode<Integer> newList = new LLNode<Integer>(0);
        LLNode<Integer> temp = newList;

        while (list1 != null && list2 != null) {
            if (list1.value >= list2.value) {
                temp.next = list2;
                list2 = list2.next;
            } else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }

        temp.next = list1 != null ? list1 : list2;
        return newList.next;
    }
}
