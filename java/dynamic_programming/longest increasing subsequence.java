//O(n^2) Time - O(n) Space - where n is the size of nums
class Solution {
    public int lengthOfLIS(int[] nums) {
       int n = nums.length;
       int[] dp = new int[n];
       int max = 1;
       Arrays.fill(dp, 1);

       for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++)  {
                if(nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
       }

        return max;
    }
}

//O(n logn) Time - O(1) Space - where n is the size of nums
//Binary Search
class Solution {
    public int lengthOfLIS(int[] nums) {
       int n = nums.length;
       int max = 0;
       int[] tails = new int[n];

       for(int i = 0; i < n; i++) {
            int left = 0;
            int right = max;
            while(left != right) {
                int mid = left + (right - left)/2;
                if(tails[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = nums[i];
            if(left == max) {
                ++max;
            }
       }

        return max;
    }
}