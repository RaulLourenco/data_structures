//O(n) Time && Space - where n is the size of nums

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
}

//O(n) Time - O(1) Space

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int n = nums.length;
        int first = nums[0];
        int second = Math.max(first, nums[1]);

        for(int i = 2; i < nums.length; i++) {
            int curr = Math.max(second, first + nums[i]);
            first = second;
            second = curr;
        }
        return Math.max(first, second);
    }
}
