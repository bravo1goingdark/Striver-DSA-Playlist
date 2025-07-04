package LinkedList;


public class PartXX {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        l1.arrToLL(new Integer[]{1, 2, 3, 4, 5});
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        l2.arrToLL(new Integer[]{6, 9, 11, 12});
        LinkedList.printLL(mergeTwoLists(l1.head, l2.head));

    }

    public static LLNode<Integer> mergeTwoLists(LLNode<Integer> list1, LLNode<Integer> list2) {
        if (list1 == null) return list1;
        if (list2 == null) return list2;

        return merge(list1, list2);

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
