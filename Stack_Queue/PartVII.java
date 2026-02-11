package Stack_Queue;

public class PartVII {
    private final Stack<int[]> stack;

    public PartVII() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            int min = stack.peek()[1];
            stack.push(new int[]{val, Math.min(val, min)});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
