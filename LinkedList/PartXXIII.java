package LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartXXIII {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.arrToLL(new Integer[]{4,2,1,3});

        LinkedList.printLL(sortListOpt(ll.head));
    }
    public static LLNode<Integer> sortList(LLNode<Integer> head) {
        if (head == null || head.next == null) return head;

        LLNode<Integer> temp = head;
        while (temp != null){
            LLNode<Integer> secTemp = temp.next;

            while (secTemp != null){
                if (temp.value > secTemp.value){
                    Integer t = temp.value;
                    temp.value = secTemp.value;
                    secTemp.value = t;
                }
                secTemp = secTemp.next;
            }

            temp = temp.next;
        }
        return head;
    }
    public static LLNode<Integer> sortListBetter(LLNode<Integer> head) {
        if (head == null || head.next == null) return head;

        LLNode<Integer> temp = head;
        List<Integer> l = new ArrayList<>();

        while (temp != null){
           l.add(temp.value);
            temp = temp.next;
        }

        Collections.sort(l);
        temp = head;
        for (Integer e : l){
            temp.value = e;
            temp = temp.next;
        }
        return head;
    }
    public static LLNode<Integer> sortListOpt(LLNode<Integer> head) {
        if (head.next == null) return head;

        LLNode<Integer> f = head;
        LLNode<Integer> s = head;
        LLNode<Integer> prev = null;

        while (f != null && f.next != null){
            prev  = s;
            s = s.next;
            f = f.next.next;
        }
        prev.next = null;

        LLNode<Integer> left = sortListOpt(head);
        LLNode<Integer> right = sortListOpt(s);


        return merge(left , right);
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
