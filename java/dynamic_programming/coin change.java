//O(n*m) Time - where n is the amount and m is the size of coins 
//- O(amount * len(coins))
//O(n) Space - where n is the amount

//Dynamic Programming Solution - bottom-up
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 1; i < dp.length; i++) {
            dp[i] = amount + 1;
        }

        dp[0] = 0;

        for(int a = 1; a <= amount; a++) {
            for(int coin = 0; coin < coins.length; coin++) {
                if(a - coins[coin] >= 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - coins[coin]]);
                }
            }
        }
        
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}