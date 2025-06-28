package LinkedList;

public class PartIV {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.arrToLL(new Integer[]{0,1,2,0,0,2,1,1});
        LinkedList.printLL(sortList(ll.head));
    }
    public static LLNode<Integer> sortList(LLNode<Integer> head) {
        int count0 = 0;
        int coun1 = 0;
        int count2 = 0;

        LLNode<Integer> temp = head;

        while (temp != null){
            if (temp.value == 0) count0++;
            else if (temp.value == 1) coun1++;
            else  count2++;

            temp = temp.next;
        }

        temp = head;

        while (temp != null){
            if (count0 != 0) {
                temp.value = 0;
                count0--;
            } else if (coun1 != 0) {
                temp.value = 1;
                coun1--;
            }else {
                temp.value = 2;
                count2--;
            }
            temp = temp.next;
        }
        return head;
    }
}
