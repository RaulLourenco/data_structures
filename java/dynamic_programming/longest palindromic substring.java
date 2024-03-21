//O(n^2) Time && Space - where n is the size of string s
//Dynamic Programming Solution
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        if(n <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[n][n];
        int longestStart = 0;
        int longestEnd = 0;
        int maxLen = 1;

        for(int end = 0; end < n; end++) {
            dp[end][end] = true;
            for(int start = 0; start < end; start++) {
                if(s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                    dp[start][end] = true;
                    int max = end - start + 1;
                    if(maxLen < max) {
                        maxLen = max;
                        longestStart = start;
                        longestEnd = end;
                    }
                }
            }
        }
        return s.substring(longestStart, longestEnd + 1);
    }
}

//O(n^2) Time - O(1) Space - where n is the size of string s
//Expanding around center
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        if(n <= 1) {
            return s;
        }

        String maxString = s.substring(0, 1);

        for(int i = 0; i < n; i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i + 1);

            if(odd.length() > maxString.length()) {
                maxString = odd;
            }
            if(even.length() > maxString.length()) {
                maxString = even;
            }
        }
        return maxString;
    }
    private String expandFromCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}