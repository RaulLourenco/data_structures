//O(m*n) Time & Space - where m and n are, respectively, the length of 
//String s and p
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        return dfs(s, p, 0, 0, dp);
    }
    private boolean dfs(String s, String p, int i, int j, boolean[][] dp) {
        if(dp[i][j]) return dp[i][j];

        if(i >= s.length() && j >= p.length()) return true;

        if(j >= p.length()) return false;
        
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
            dp[i][j] = (match && dfs(s, p, i + 1, j, dp)) || dfs(s, p, i, j + 2, dp);
        } else {
            dp[i][j] = match && dfs(s, p, i + 1, j + 1, dp);
        }

        return dp[i][j];
    }

}