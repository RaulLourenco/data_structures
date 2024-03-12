O(logN) Time
O(1) Space

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while(left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int rotation = left; //left == index of minimum value (rotation point)
        left = 0; right = n - 1;
        
        while(left <= right) {
            int mid = left + (right - left) /2;
            int realMid = (rotation + mid) % n;
            if(nums[realMid] == target) {
                return realMid;
            } else if(nums[realMid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left) /2;
            if(nums[mid] == target) {
                return mid;
            }
            //left sorted
            if(nums[left] <= nums[mid]) {
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { //right sorted
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}