//DP with Bottom-Up approach (Tabulation)
//O(m*n) Time & Space - where m represents the length of text1 and n the
//length of text2.

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}

//Brute Force Solution - TLE for most cases
//O(2^(m+n)) Time - O(m+n) Space
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, 0, 0);
    }
    private int lcs(String text1, String text2, int i, int j) {
        if(i == text1.length() || j == text2.length()) {
            return 0;
        } 
        
        if(text1.charAt(i) == text2.charAt(j)) {
            return 1 + lcs(text1, text2, i + 1, j + 1);
        } else {
            return Math.max(
                lcs(text1, text2, i + 1, j),
                lcs(text1, text2, i, j + 1)
            );
        }
    }
}

//DP with Top-Down approach (Memoization).
//still TLE for edge cases (2 texts with max length)
//O(m*n) Time & Space
class Solution {
    private int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        return lcs(text1, text2, 0, 0);
    }
    private int lcs(String text1, String text2, int i, int j) {
        if(i == text1.length() || j == text2.length()) {
            return 0;
        }
        if(dp[i][j] > 0) {
            return dp[i][j];
        }
        
        if(text1.charAt(i) == text2.charAt(j)) {
           return dp[i][j] = 1 + lcs(text1, text2, i + 1, j + 1);
        } else {
            return dp[i][j] = Math.max(
                lcs(text1, text2, i + 1, j),
                lcs(text1, text2, i, j + 1)
            );
        }
    }
}