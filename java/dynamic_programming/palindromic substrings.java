//O(n^2) Time - O(1) Space - where n is the size of string s
//Expand around center
class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        for(int i = 0; i <  s.length(); i++) {
           expandFromCenter(s, i, i);
           expandFromCenter(s, i, i + 1);
        }
        return count;
    }
    private void expandFromCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
    }
}