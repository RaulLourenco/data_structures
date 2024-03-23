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

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> curr : map.entrySet()) {
            int key = curr.getKey();
            int val = curr.getValue();
            if(val == 1) {
                return key;
            }
        }
        return 0;
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