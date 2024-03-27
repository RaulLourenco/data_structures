//O(n*m) Time - where n is the amount and m is the length of coins 
//- O(amount * len(coins))
//O(n) Space ~ O(amount) - where n is the amount

//DP with Bottom-Up approach (Tabulation)
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for(int c = 0; c < coins.length; c++) {
            for(int a = 1; a <= amount; a++) {
                if(a >= coins[c]) {
                    dp[a] += dp[a - coins[c]];
                }
            }
        }
        return dp[amount];
    }
}

//O(n*m) Time & Space - where n is the amount and m is the length of coins 
//- O(amount * len(coins))

//DP with Top-Down approach (Memoization)
class Solution {
    public int change(int amount, int[] coins) {
        Map<String, Integer> memo = new HashMap<>();
        return change(amount, coins, 0, 0, memo);
    }
    private int change(int amount, int[] coins, int i, int a, Map<String, Integer> memo) {
        if(i >= coins.length) {
            return 0;
        }
        String key = i + "-" + a;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        if(a == amount) {
            return 1;
        } else if(a > amount) {
            return 0;
        }
        memo.put(key, change(amount, coins, i, a + coins[i], memo) + change(amount, coins, i + 1, a, memo));
        
        return memo.get(key);
    }
}