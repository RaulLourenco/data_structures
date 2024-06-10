class SetOfStacks {
    List<Stack> stacks = new ArrayList<>();
    int capacity;

    //O(n) Space - push operations
    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    //O(1) Time
    public Stack getLastStack() {
        if(stacks.size() == 0) return null;
        return stacks.get(stacks.size() - 1);
    }

    //O(1) Time
    public void push(int v) {
        Stack last = getLastStack();
        if(last != null && !last.isFull()) {
            last.push(v);
        } else {
            Stack stack = new Stack(capacity);
            stack.push(v);
            stacks.add(stack);
        }
    }

    //O(1) Time
    public int pop() {
        Stack last = getLastStack();
        if(last == null) throw new EmptyStackException();
        int value = last.pop();
        if(last.size() == 0) stacks.remove(stacks.size() - 1);
        return value;
    }

    //O(1) Time
    public boolean isEmpty() {
        Stack last = getLastStack();
        return last == null || last.isEmpty();
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    //O(n) Time & Space
    public int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int removedItem;
        if(removeTop) removedItem = stack.pop();
        else removedItem = stack.removeBottom();

        if(stack.isEmpty()) {
            stacks.remove(index);
        } else if(stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return removedItem;
    }
    
    public class Stack { //there are more methods to implement here
        public Node bottom;
        public int size = 0;

        //O(1) Time
        public int removeBottom() {
            Node b = bottom;
            bottom = bottom.above;
            if(bottom != null) bottom.below = null;
            size--;
            return b.value;
        }
    }
}

