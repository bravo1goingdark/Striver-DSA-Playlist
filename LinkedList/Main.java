package LinkedList;

public class Main {
    public static void main(String[] args) {
//        LinkedList<Integer> ll = new LinkedList<Integer>();
//        ll.addFirst(3);
//        ll.addFirst(4);
//        ll.addFirst(5);
//        ll.arrToLL(new Integer[]{1,2,3,4});
//        System.out.println(ll);
//
//        ll.addLast(5);
//        System.out.println(ll);
//        System.out.println(ll.size());
//        System.out.println(ll.isEmpty());
//
//        System.out.println(ll.search(5).value);
//
//        ll.insertAtIndex(8,10);
//        System.out.println(ll.deleteLast());
//        System.out.println(ll.deleteFirst().value);
//        System.out.println(ll.deleteLast().value);
//        System.out.println(ll);
//        System.out.println(ll.size());
//        System.out.println(ll.deleteAtIndex(3).value);
//        System.out.println(ll);

        DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
        dll.addFirst(7);
        dll.addFirst(8);
        dll.addFirst(9);
        dll.addFirst(10);
        dll.addLast(1);
        dll.addLast(8);
        dll.insertAtIndex(3,20);
        System.out.println(dll);
        dll.deleteFirst();
        dll.deleteLast();

        System.out.println(dll);
        dll.deleteAtIndex(2);
        System.out.println(dll);
    }
}
