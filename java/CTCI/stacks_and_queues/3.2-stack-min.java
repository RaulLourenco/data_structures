//O(1) Time & O(n) Space - where n is the number of push operations
class StackWithMin extends Stack<Integer> {
    Stack<Integer> mins;

    public StackWithMin() {
        mins = new Stack<Integer>();
    }

    //O(1) Time
    public void push(int value) {
        if(value <= min()) {
            mins.push(value);
        }
        super.push(value);
    }

    //O(1) Time
    public int pop() {
        int value = super.pop();
        if(value == min()) {
            mins.pop();
        }
        return value;
    }

    //O(1) Time
    public int min() {
        if(mins.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return mins.peek();
        }
    }
}