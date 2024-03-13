O(n) Time - HashSet
O(n) Space

class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            if(!set.add(num)) {
                return num;
            }
        }
        return 0;
    }
}

O(n^2) Time - 2 Loops
O(1) Space

class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }
}


O(nlogn) Time - Sorting
O(1) Space

class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) return nums[i];
        }
        return 0;
    }
}

O(n) Time - Two Pointers
O(1) Space

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        int secondSlow = 0;

        do {
            slow = nums[slow];
            secondSlow = nums[secondSlow];
        } while(slow != secondSlow);

        return secondSlow;
    }
}
        