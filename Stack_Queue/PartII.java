// https://leetcode.com/problems/implement-queue-using-stacks/
package Stack_Queue;


import java.util.Stack;

public class PartII {
    private final Stack<Integer> first;
    private final Stack<Integer> second;

    public PartII() {
        this.first = new Stack<>();
        this.second = new Stack<>();
    }

    public void push(int x) {
        while (!first.empty()){
            second.push(first.pop());
        }

        first.push(x);

        while (!second.isEmpty()){
            first.push(second.pop());
        }
    }

    public int pop() {
        return first.pop();
    }

    public int peek() {
        return first.peek();
    }

    public boolean empty() {
        return first.empty();
    }

}


