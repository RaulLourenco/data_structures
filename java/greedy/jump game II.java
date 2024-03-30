//O(n) Time & O(1) Space
//Greedy
class Solution {
    public int jump(int[] nums) {
        int jumps = 0, left = 0, right = 0;
        while(right < nums.length - 1) {
            int farthest = 0;
            //iterate through a portion of the array to find the farthest
            //position
            for(int i = left; i < right + 1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right + 1;
            right = farthest;
            jumps++;
        }
        return jumps;
    }
}

//O(n^2) Time & O(n) Space
//DP with Top-Down approach (Memoization)
class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 10001);
        return dfs(nums, dp, 0);
    }
    private int dfs(int[] nums, int[] dp, int index) {
        if(index >= nums.length - 1) return 0;

        if(dp[index] != 10001) return dp[index];

        for(int j = 1; j <= nums[index]; j++) {
            dp[index] = Math.min(dp[index], 1 + dfs(nums, dp, index + j));
        }
        return dp[index];
    }
}

//O(n^2) Time & O(n) Space
//DP with Bottom-Up approach (Tabulation)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 10001);
        dp[n - 1] = 0;

        for(int i = n - 2; i >= 0; i--) {
            for(int j = 1; j <= nums[i]; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[Math.min(n - 1, i + j)]);
            }
        }
        return dp[0];
    }
}