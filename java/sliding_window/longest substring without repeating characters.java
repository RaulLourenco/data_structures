O(n) Time
O(n) Space

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0; //slow pointer
        int right = 0; //fast pointer
        int longest = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                longest = Math.max(longest, set.size());
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return longest;
    }
}

O(n) Time
O(n) Space

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int longest = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < s.length(); right++) {
            if(map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}