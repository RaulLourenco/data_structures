public class MyQueue<T> {
    Stack<T> stackNewest, stackOldest;

    public MyQueue() {
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }

    //O(1) Time
    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    //O(1) Time
    public void add(T value) {
        stackNewest.push(value);
    }

    //O(n) Time
    private void shiftStacks() {
        if(stackOldest.isEmpty()) {
            while(!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public T remove() {
        shiftStacks();
        return stackOldest.pop();
    }
}