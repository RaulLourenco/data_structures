//O(n) Time & Space - where n is the length of heights array
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int start = 0;

        for(int i = 0; i < heights.length; i++) {
            int curr = heights[i];
            start = i;
            while(!stack.isEmpty() && stack.peek().getValue() > curr) {
                Pair<Integer, Integer> pair = stack.pop();
                int index = pair.getKey();
                int height = pair.getValue();
                int width = (i - index);
                maxArea = Math.max(maxArea, height * width);
                start = index;
            }
            stack.push(new Pair(start, curr));
        }

        while(!stack.isEmpty()) {
            Pair<Integer, Integer> pair = stack.pop();
            int index = pair.getKey();
            int height = pair.getValue();
            int width = (heights.length - index);
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
}