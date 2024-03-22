//O(n*m) Time - O(n) Space - where n is the size of string s and
//m is the number of words in wordDict
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for(int i = n - 1; i >= 0; i--) {
            for(String word : wordDict) {
                if((i + word.length()) <= s.length() && s.startsWith(word, i)) {
                    dp[i] = dp[i + word.length()];
                }
                if(dp[i]) break;
            }
        }
        return dp[0];
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for(int i = n - 1; i >= 0; i--) {
            for(String word : wordDict) {
                if((i + word.length()) <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                    dp[i] = dp[i + word.length()];
                }
                if(dp[i]) break;
            }
        }
        return dp[0];
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for(int i = 1; i < n + 1; i++) {
            for(String word : wordDict) {
                if((i - word.length() >= 0) && dp[i - word.length()] && s.substring(i - word.length(), i).equals(word)) {
                    dp[i] = dp[i - word.length()];
                }
                if(dp[i]) break;
            }
        }
        return dp[n];
    }
}