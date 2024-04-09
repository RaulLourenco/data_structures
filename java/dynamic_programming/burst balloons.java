//O(n^3) Time & O(n^2) Space - where n is the size of nums
//O((n^2)*n) - n*2 stands for the number of subarrays and n the traversal
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        return dfs(nums, 0, n - 1, dp);
    }
    private int dfs(int[] nums, int left, int right, int[][] dp) {
        if(left > right) return 0;

        if(dp[left][right] != 0) {
            return dp[left][right];
        }

        for(int i = left; i <= right; i++) {
            int coins = nums[i];

            if(left - 1 >= 0) {
                coins *= nums[left - 1]; 
            }
            if(right + 1 < nums.length) {
                coins *= nums[right + 1];
            }
            coins += dfs(nums, left, i - 1, dp) + dfs(nums, i + 1, right, dp);
            dp[left][right] = Math.max(coins, dp[left][right]);
        }
        return dp[left][right];
    }
}