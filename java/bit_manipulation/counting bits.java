//O(n logn) Time - O(1) Space - where n is the input number
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            int count = countingOnes(i);
            res[i] = count;
        }
        return res;
    }
    private int countingOnes(int n) {
        int count = 0;
        while(n != 0) {
            n &= (n-1);
            count++;
        }
        return count;
    }
}

//Dynamic Programming
class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            dp[i] = 1 + (dp[i & (i - 1)]);
        }
        return dp;
    }
}

class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            res[i] = res[i>>1] + (i & 1);
        }
        return res;
    }
}