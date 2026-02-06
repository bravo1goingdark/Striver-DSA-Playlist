package Stack_Queue;


public class Main {

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.println(stack.peek());


        Queue<Integer> que = new Queue<>();
        que.enqueue(10);
        que.enqueue(20);
        que.enqueue(30);

        System.out.println(que.dequeue());
        System.out.println(que.size());
        System.out.println(que.peek());


    }
}
