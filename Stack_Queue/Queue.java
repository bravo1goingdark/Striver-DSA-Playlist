package Stack_Queue;

public class Queue<T> {
    private T[] data;
    private static final int DEFAULT_SIZE = 16;
    private int front;
    private int back;

    @SuppressWarnings("unchecked")
    public Queue(int size) {
        this.data = (T[]) new Object[size];
        this.front = -1;
        this.back = -1;
    }
    public Queue(){
        this(DEFAULT_SIZE);
    }

    public void enqueue(T value) {
        if (isEmpty()) {
            front = 0;
            back = 0;
            data[back] = value;
            return;
        }

        back++;
        data[back] = value;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty");
        }

        T removed = data[front++];
        if (front > back) {
            clear();
        }
        return removed;
    }

    public T peek(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is Empty");
        }
        return this.data[front];
    }

    public void clear(){
        this.front = -1;
        this.back = -1;
    }

    public boolean isEmpty(){
        return front == -1 && back == -1;
    }
    public int size(){
        return back - front + 1;
    }
}
