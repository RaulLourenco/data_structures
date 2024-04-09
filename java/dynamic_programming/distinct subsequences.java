//DP with Top-Down approach (Memoization).
//O(m*n) Time & Space - where m and n are, respectively, the length of 
//String s and t
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return dfs(s, t, 0, 0, dp);
    }
    private int dfs(String s, String t, int i, int j, int[][] dp) {
        if(j == t.length()) {
            return 1;
        }
        if(i == s.length()) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = dfs(s, t, i + 1, j + 1, dp) + dfs(s, t, i + 1, j, dp);
        } else {
            return dp[i][j] = dfs(s, t, i + 1, j, dp);
        }
    }
}