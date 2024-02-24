O(n^2) Time
O(n) Space

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums) {
            set.add(n);
        }

        int longest = 0;
        for(int num : nums) {
            if(!set.contains(num - 1)) {
                int nextNumber = num + 1;
                while(set.contains(nextNumber)) {
                    nextNumber++;
                }
                longest = Math.max(longest, nextNumber - num);
            }
        }
        return longest;
    }
}

O(n) Time
O(n) Space

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums) {
            set.add(n);
        }

        int longest = 0;
        for(int num : nums) {
            int left = num - 1;
            int right = num + 1;
            while(set.remove(left)) left--;
            while(set.remove(right)) right++;
            longest = Math.max(longest, right - left - 1);
            if(set.isEmpty()) return longest;
        }
        return longest;
    }
}

O(n) Time
O(n) Space

class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;

        for(int num : nums) {
            if(!map.containsKey(num)) {
                int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
                int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
                int sum = left + right + 1;
                
                map.put(num, sum);

                longest = Math.max(longest, sum);

                map.put(num - left, sum);
                map.put(num + right, sum);
            }
        }
        return longest;
    }
}