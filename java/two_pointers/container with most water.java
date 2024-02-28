O(n) Time
O(1) Space

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int mostWater = 0;

        while(left < right) {
            mostWater = Math.max(mostWater, (right - left) * Math.min(height[left], height[right]));
            if(height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return mostWater;
    }
}

(right - left) // width
Math.min(height[left], height[right]) // height