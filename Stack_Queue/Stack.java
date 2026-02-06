package Stack_Queue;

public class Stack<T> {
    private T[] data;
    private int pointer;
    private static final int DEFAULT_SIZE = 16;

    public Stack(){
        this(DEFAULT_SIZE);
    }
    @SuppressWarnings("unchecked")
    public Stack(int size){
        this.data =  (T[]) new Object[size];
        this.pointer = -1;
    }

    public void push(T value){
        if (isFull()){
            resize();
        }

        this.data[++this.pointer] = value;
    }
    public T pop(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is Empty");
        }

        return this.data[this.pointer--];
    }
    public T peek() {
        if (isEmpty()){
            throw new IllegalStateException("Stack is Empty");
        };
        return this.data[this.pointer];

    }

    public boolean isEmpty(){
        return pointer == -1;
    }
    public boolean isFull(){
        return this.pointer == data.length - 1;
    }

    public void clear(){
        this.pointer = -1;
    }
    public int size(){
        return this.pointer + 1;
    }

    @SuppressWarnings("unchecked")
    public void resize(){
        T[] resize = (T[]) new Object[this.data.length * 2];
        System.arraycopy(this.data,0,resize,0,data.length);
        this.data = resize;
    }
}
