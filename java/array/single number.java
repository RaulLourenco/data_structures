Brute Force
O(n)
O(n)

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                map.put(nums[i], ++count);
            } else {
                map.put(nums[i], 1);
            }
        }
        return Collections.min(map.entrySet(), Comparator.comparing(Map.Entry::getValue)).getKey();
    }
}

Bitwise XOR
O(N) Time
O(1) Space

class Solution {
    public int singleNumber(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            nums[i + 1] ^= nums[i];
        }
        return nums[nums.length - 1];
    }
}