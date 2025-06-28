package LinkedList;


public class PartIV {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.arrToLL(new Integer[]{0,1,2,0,0,2,1,1});
        LinkedList.printLL(sortListOpt(ll.head));
    }
    public static LLNode<Integer> sortList(LLNode<Integer> head) {
        if (head == null || head.next == null) return head;
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
    public static LLNode<Integer> sortListOpt(LLNode<Integer> head) {
        if (head == null || head.next == null) return head;

        LLNode<Integer> zeroes = new LLNode<>(-1);
        LLNode<Integer> ones = new LLNode<>(-1);
        LLNode<Integer> twos = new LLNode<>(-1);

        LLNode<Integer> tempZero = zeroes;
        LLNode<Integer> tempone = ones;
        LLNode<Integer> temptwo = twos;

        LLNode<Integer> temp = head;

        while (temp != null) {
            if (temp.value == 0) {
                tempZero.next = temp;
                tempZero = tempZero.next;
            } else if (temp.value == 1) {
                tempone.next = temp;
                tempone = tempone.next;
            } else {
                temptwo.next = temp;
                temptwo = temptwo.next;
            }
            temp = temp.next;
        }

        // Break the last node
        temptwo.next = null;

        // Connect 0s → 1s → 2s
        tempZero.next = ones.next != null ? ones.next : twos.next;
        tempone.next = twos.next;

        return zeroes.next;
    }

}
