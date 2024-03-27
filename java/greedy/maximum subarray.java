// O(n^2) Time & O(1) Space - where n is the length of nums
//Brute Force
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];

        for(int i = 0; i < n; i++) {
            int sum = 0;
           for(int j = i; j < n; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
           }
        }
        return max;
    }
}

// O(n) Time & Space - where n is the length of nums
//DP Solution (Tabulation)
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < n; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

// O(n) Time & O(1) Space - where n is the length of nums
//Kadane's Algo
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currMax = 0;
        
        for(int i = 0; i < nums.length; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            max = Math.max(max, currMax);
        }
        return max;
    }
}

// O(n) Time & O(1) Space - where n is the length of nums
//Similar to Kadane's, but instead of process the currMax adding the curr
//number, just sum up and compare to the max. That way, only one Math.max()
//is necessary
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}