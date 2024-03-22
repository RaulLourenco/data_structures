//O(n) Time - O(1) Space - where n is the size of nums
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int max = 1;
        int min = 1;
        int res = 0;

        for(int i = 0; i < n; i++) {
            int temp = max;
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(temp * nums[i], min * nums[i]));
            res = Math.max(res, max);
        }
        return res;
    }
}
//Kadane's algorithm
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = 1;
        int res = nums[0];

        for(int i = 0; i < n; i++) {
            left = (left == 0) ? 1 : left;
            right = (right == 0) ? 1 : right;

            left *= nums[i]; //prefix product
            right *= nums[n - 1 - i]; //suffix product

            res = Math.max(res, Math.max(left, right));
        }
        return res;
    }
}