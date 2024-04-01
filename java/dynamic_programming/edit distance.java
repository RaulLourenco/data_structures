//O(m*n) Time & Space - where m is word1 length and n is word2 length
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i < m + 1; i++) {
            dp[i][n] = m - i;
        }
        for(int j = 0; j < n + 1; j++) {
            dp[m][j] = n - j;
        }

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
                }
            }
        }
        return dp[0][0];
    }
}

//O(m*n) Time & Space - where m is word1 length and n is word2 length
class Solution {
    public int minDistance(String word1, String word2) {
        int i = word1.length() - 1;
        int j = word2.length() - 1;
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return dfs(word1, word2, i, j, dp);
    }
    private int dfs(String word1, String word2, int i, int j, int[][] dp) {
        if(i + 1 == 0 && j + 1 == 0) return 0;
        if(i + 1 == 0 || j + 1 == 0) return Math.max(i + 1, j + 1);

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = dfs(word1, word2, i - 1, j - 1, dp);
        } else {
            int insert = 1 + dfs(word1, word2, i, j - 1, dp);
            int delete = 1 + dfs(word1, word2, i - 1, j, dp);
            int replace = 1 + dfs(word1, word2, i -1, j - 1, dp);
            return dp[i][j] = Math.min(replace, Math.min(insert, delete));
        }
    }
}