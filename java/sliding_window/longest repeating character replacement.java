O(n) Time
O(26) Space

class Solution {
    public int characterReplacement(String s, int k) {
        int[] array = new int[26];
        int res = 0;
        int left = 0;
        int maxFreq = 0;

        for(int right = 0; right < s.length(); right++) {
            array[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq,  array[s.charAt(right) - 'A']);

            if((right - left + 1) - maxFreq > k) {
                array[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}