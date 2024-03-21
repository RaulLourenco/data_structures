//O(n) Time && Space - where n is the size of string s
//Dynamic Programming Solution

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i <= n; i++) {
            int first = Integer.parseInt(s.substring(i-1, i));
            int second = Integer.parseInt(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}

//O(n) Time - O(1) Space - where n is the size of string s
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int twoBack = 1;
        int oneBack = s.charAt(0) == '0' ? 0 : 1;
        int curr = oneBack;

        for(int i = 2; i < n + 1; i++) {
            curr = 0;
            int firstDigit = Integer.parseInt(s.substring(i-1, i));
            int secondDigit = Integer.parseInt(s.substring(i-2, i));
            if(firstDigit >= 1 && firstDigit <= 9) {
                curr += oneBack;
            }
            if(secondDigit >= 10 && secondDigit <= 26) {
                curr += twoBack;
            }
            twoBack = oneBack;
            oneBack = curr;
        }
        return curr;
    }
}