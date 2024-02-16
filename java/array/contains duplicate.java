O(n) Time
O(n) Space

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> map = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.contains(nums[i])) return true;
            map.add(nums[i]);
        }
        return false;
    }
}

O(n logN) Time
O(1) Space

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) return true;
        }
        return false;
    }
}