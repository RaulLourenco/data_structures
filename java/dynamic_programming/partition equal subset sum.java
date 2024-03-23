//O(n * m) Time - O(m) Space - where n is the size of nums and
//m is the target. ~ O(n*target) Time - O(target) Space
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if(sum % 2 != 0) {
            return false;
        }

        int target = sum/2;
        boolean[] dp = new boolean[target];
        dp[0] = true;
        
        for(int num = 0; num < n; num++) {
            for(int t = target; t >= nums[num]; t--) {
                if(dp[t - nums[num]]) {
                    if(t == target) return true;
                    dp[t] = true;
                }
            }
        }
        return false;
    }
}