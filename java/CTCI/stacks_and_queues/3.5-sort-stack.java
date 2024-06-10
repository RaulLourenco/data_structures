Stack<T> stack = new Stack<>();
Stack<T> sorted = new Stack<>();

//O(n) Time & Space
public void push(int item) {
    if(stack.isEmpty()) {
        stack.push(item);
    } else {
        while(!stack.isEmpty()) {
            int value = stack.peek();
            if(item > value) {
                sorted.push(value);
                stack.pop();
            } else {
                sorted.push(item);
            }
        }
        stack.push(item);
    }
}

//O(n^2) Time & O(n) Space
public void sort(Stack<Integer> stack) {
    Stack<Integer> aux = new Stack<>();

    while(!stack.isEmpty()) {
        int tmp = stack.pop();
        while(!aux.isEmpty() && aux.peek() > tmp) {
            stack.push(aux.pop());
        }
        aux.push(tmp);
    }

    while(!aux.isEmpty()) {
        stack.push(aux.pop());
    }
}