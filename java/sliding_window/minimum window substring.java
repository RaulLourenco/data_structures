//O(n) Time & Space - where n is the length of string S
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freqT = new HashMap<>();

        //counting the char frequency in T to compare with S
        for(char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }

        int have = 0, 
        start = 0, 
        left = 0,
        need = freqT.size(), 
        minLen = s.length() + 1;

        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if(freqT.containsKey(c)) {
                freqT.put(c, freqT.get(c) - 1);
                if(freqT.get(c) == 0) have++;
            }

            while(have == need) {
                //right-left+1 == currentWindow
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                //deleting from left
                char deleted = s.charAt(left++);
                if(freqT.containsKey(deleted)) {
                    if(freqT.get(deleted) == 0) have--;
                    freqT.put(deleted, freqT.get(deleted) + 1);
                }
            }
        }

        return minLen > s.length() ? "" : s.substring(start, start + minLen);
    }
}