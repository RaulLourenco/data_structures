//O(n) Time & Space - where n is the length of height array
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        int[] min = new int[n];
        int max = height[0];
        int result = 0;

        for(int i = 0; i < n; i++) {
            maxLeft[i] = Math.max(max, height[i]);
            max = maxLeft[i];
        }
        
        max = height[n - 1];
        for(int i = n - 1; i >= 0; i--) {
            maxRight[i] = Math.max(max, height[i]);
            max = maxRight[i];
        }

        for(int i = 0; i < n; i++) {
            result += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return result;
    }
}

//O(n) Time & O(1) Space - where n is the length of height array
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        int res = 0;

        while(left < right) {
            if(maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                res += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                res += maxRight - height[right];
            }
        }
        return res;
    }
}