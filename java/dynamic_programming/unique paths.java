//O(m*n) Time & Space
class Solution {
    public int uniquePaths(int m, int n) {
       int[][] dp = new int[m][n];

       for(int col = 0; col < n; col++) {
        dp[m - 1][col] = 1;
       }

       for(int row = 0; row < m; row++) {
        dp[row][n-1] = 1;
       }
        
        for(int row = m - 2; row >= 0; row--) {
            for(int col = n - 2; col >= 0; col--) {
                dp[row][col] = dp[row][col + 1] + dp[row + 1][col];
            }
        }

       return dp[0][0];
    }
}

//O(m*n) Time - O(n) Space
class Solution {
    public int uniquePaths(int m, int n) {
       int[] dp = new int[n];

       for(int i = 0; i < n; i++) {
            dp[i] = 1;
       }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

       return dp[n-1];
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        m--;
        n--;

        if(m < n) {
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;

       for(int i = m + 1; i <= m + n; i++, j++) {
            res = (res * i) / j;
       }

       return (int) res;
    }
}

//O(min(m,n)) Time - O(1) Space - Optimal Solution using Math Combinatorics
class Solution {
    public int uniquePaths(int m, int n) {
       long res = 1;
       int j = 1;

       for(int i = m + n - 2; i >= Math.max(m, n); --i, j++) {
            res = (res * i) / j;
       }

       return (int) res;
    }
}