package LinkedList;


public class BrowserHistory {
    private Node dll;
    public BrowserHistory(String homepage) {
        this.dll = new Node(homepage);
    }

    public void visit(String url) {
        Node node = new Node(url);
        dll.next = node;
        node.prev = dll;
        dll = node;
    }

    public String back(int steps) {

        while (steps > 0){
            if (dll.prev != null) dll = dll.prev;
            else break;
            steps--;
        }

        return dll.url;
    }

    public String forward(int steps) {

        while (steps > 0){
            if (dll.next != null) dll = dll.next;
            else break;
            steps--;
        }
        return dll.url;

    }
    private class Node {
        public String url;
        public Node next;
        public Node prev;

        public Node(String url){
            this.url = url;
            this.next = null;
            this.prev = null;
        }
    }
}
