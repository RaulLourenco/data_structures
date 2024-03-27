//O(n*m) Time & Space - where n is the target and m is the length of nums 
//- O(target * len(nums))

//DP with Top-Down approach (Memoization)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return find(nums, target, 0, 0, memo);
    }
    private int find(int[] nums, int target, int i, int t, Map<String, Integer> memo) {
        if(i == nums.length) {
            return t == target ? 1 : 0;
        }

        String key = i + "-" + t;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        memo.put(key, find(nums, target, i + 1, t + nums[i], memo) + find(nums, target, i + 1, t - nums[i], memo));

        return memo.get(key);
    }
}

//O(n*m) Time - where n is the target and m is the length of nums 
//- O(target * len(nums))
//O(n) Space - where n is the targetSum

//DP with Bottom-up approach (Tabulation)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int targetSum = 0;
        for(int num : nums) {
            targetSum += num;
        }

        if(targetSum < target 
        || targetSum + target < 0 
        || (targetSum + target) % 2 != 0) {
            return 0;
        }

        targetSum = (targetSum + target) / 2;

        int[] dp = new int[targetSum + 1];
        dp[0] = 1;

        for(int n = 0; n < nums.length; n++) {
            for(int t = targetSum; t >= nums[n]; t--) {
                dp[t] += dp[t - nums[n]];
            }
        }
        return dp[targetSum];
    }
}