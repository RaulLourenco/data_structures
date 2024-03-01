O(n) Time
O(n) Space

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int j = stack.pop();
                res[j] = i - j;
            }
            stack.push(i);
        }

        return res;
    }
}

Stack Solution using array

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for(int i = 0; i < n; i++) {
            //top > -1 -> !stack.isEmpty()
            while(top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int j = stack[top--]; //stack.pop()
                res[j] = i - j;
            }
            stack[++top] = i;
        }

        return res;
    }
}


Brute Force without using Stack
O(n^2) Time
O(1) Space

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(temperatures[i] > temperatures[j]) continue;
                if(temperatures[i] < temperatures[j]) {
                    res[i] = j - i;
                    break;
                }
            }
        }

        return res;
    }
}

