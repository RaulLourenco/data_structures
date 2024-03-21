//O(n) Time && Space - where n is the size of nums

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        
        int[] dpFirst = new int[n];
        int[] dpSecond = new int[n];

        dpFirst[0] = nums[0];
        dpFirst[1] = Math.max(nums[0], nums[1]);

        dpSecond[0] = 0;
        dpSecond[1] = nums[1];

        for(int i = 2; i < nums.length; i++) {
            dpFirst[i] = Math.max(dpFirst[i-1], dpFirst[i-2] + nums[i]);
            dpSecond[i] = Math.max(dpSecond[i-1], dpSecond[i-2] + nums[i]);
        }

        return Math.max(dpFirst[n-2], dpSecond[n-1]);
    }
}

//O(n) Time - O(1) Space - where n is the size of nums.
//Using helper method to calcute max.
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        return Math.max(robFrom(nums, 0, n - 2), robFrom(nums, 1, n - 1));
    }
    private int robFrom(int[] nums, int start, int end) {
        int first = 0;
        int second = 0;

        for(int i = start; i <= end; i++) {
            int curr = Math.max(second, first + nums[i]);
            first = second;
            second = curr;
        }
        return second;
    }
}