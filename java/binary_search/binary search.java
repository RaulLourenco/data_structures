O(log n) Time //Iterative
O(1) Space

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;        
    }
}

O(log n) Time //Recursive
O(1) Space -> O(logN) if the recursive call stack is considered

class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        int mid = left + (right - left)/2;
        if(left <= right) {
             if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                return binarySearch(nums, target, left, mid - 1);
            } else if(nums[mid] < target) {
                return binarySearch(nums, target, mid + 1, right);
            }
        }
        return -1;
    }
}