//DP with Top-Down approach (Memoization).
//O(n) Time & Space - where n is the prices array
class Solution {
    public int maxProfit(int[] prices) {
        Map<String, Integer> memo = new HashMap<>();
        return max(prices, 0, true, memo);
    }
    private int max(int[] prices, int i, boolean buying, Map<String, Integer> memo) {
        if(i >= prices.length) {
            return 0;
        }

        String key = i + "-" + buying;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        int cooldown = max(prices, i + 1, buying, memo);
        int buyOrSell = 0;

        if(buying) {
            buyOrSell = max(prices, i + 1, !buying, memo) - prices[i];
        } else {
            buyOrSell = max(prices, i + 2, !buying, memo) + prices[i];
            
        }
        memo.put(key, Math.max(buyOrSell, cooldown));

        return memo.get(key);
    }
}

//State Machine
//O(n) Time - O(1) Space - where n is the prices array
class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0, hold = Integer.MIN_VALUE, rest = 0;

        for(int i = 0; i < prices.length; i++) {
            hold = Math.max(hold, rest - prices[i]);
            rest = Math.max(rest, sold);
            sold = hold + prices[i];
        }
        return Math.max(sold, rest);
    }
}

//Instead of using Integer.MIN_VALUE, just calculate the buy operation for
//the first day [0 - prices[0] -> currProfit - priceAtFirstDay]
class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0, hold = 0 - prices[0], rest = 0;

        for(int i = 0; i < prices.length; i++) {
            hold = Math.max(hold, rest - prices[i]);
            rest = Math.max(rest, sold);
            sold = hold + prices[i];
        }
        return Math.max(sold, rest);
    }
}