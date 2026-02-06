// https://leetcode.com/problems/implement-stack-using-queues/description/

package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class PartI {

    private final Queue<Integer> queue;

    public PartI() {
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);

        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.peek() == null ? -1 : queue.poll();
    }

    public int top() {
        return queue.peek() == null ? -1 : queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
