//O(n*m) Time & Space - where n is s1 length and m is s2 length
//DP with Bottom-Up approach (Tabulation)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 + n2 != s3.length()) return false;

        boolean[][] dp = new boolean[n1 + 1][n2 + 1];

        dp[n1][n2] = true;

        for(int i = n1; i >= 0; i--) {
            for(int j = n2; j >= 0; j--) {
                if(i < n1 && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if(j < n2 && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }
}

//O(n*m) Time & Space - where n is s1 length and m is s2 length
//DP with Top-Down approach (Memoization)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        Map<String, Boolean> memo = new HashMap<>();
        return dfs(s1, s2, s3, 0, 0, memo);
    }
    private boolean dfs(String s1, String s2, String s3, int i, int j, Map<String, Boolean> memo) {
        if(i == s1.length() && j == s2.length()) return true;

        String key = i + "-" + j;

        if(memo.containsKey(key)) return memo.get(key);

        if(i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dfs(s1, s2, s3, i + 1, j, memo)) {
            return true;
        }
        if(j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dfs(s1, s2, s3, i, j + 1, memo)) {
            return true;
        }

        memo.put(key, false);
        return false;
    }
}