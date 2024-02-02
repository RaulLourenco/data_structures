
O(N*M) Time
O(1) Space

class Solution {
    public int strStr(String haystack, String needle) {
        int count = 0;
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(count)) {
                count++;
            } else {
                i = i - count;
                count = 0;
            }
            if(count == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }
}