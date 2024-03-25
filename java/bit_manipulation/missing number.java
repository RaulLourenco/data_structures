//Brute Force O(n log n) Time & O(1) Space
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        if(nums[n - 1] + 1 == n) {
            return n;
        }

        for(int i = 0; i < n + 1; i++) {
            if(i < n && nums[i] != i) {
                return i;
            }
        }

        return 0;
    }
}

//O(n) Time & O(1) Space - where n is the size of nums
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1)/2;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }

        return total - sum;
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;    
        for(int i = 0; i < nums.length; i++) {
            missing += i - nums[i];
        }
        return missing;
    }
}

//Using XOR operation
class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;    
        for(int i = 0; i < nums.length; i++) {
            missing = missing ^ i ^ nums[i];
        }
        return missing;
    }
}

//Using Binary Search
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}