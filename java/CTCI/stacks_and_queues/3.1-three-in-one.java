//O(1) Time & Space
class FixedMultiStack {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    //O(1) Time
    public void push(int stackNum, int value) throws FullStackException {
        if(isFull(stackNum)) throw new FullStackException();

        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    //O(1) Time
    public int pop(int stackNum) {
        if(isEmpty(stackNum)) throw new EmptyStackException();

        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    //O(1) Time
    public int peek(int stackNum) {
        if(isEmpty(stackNum)) throw new EmptyStackException();

        return values[indexOfTop(stackNum)];
    }

    //O(1) Time
    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    //O(1) Time
    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    //O(1) Time
    public int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}