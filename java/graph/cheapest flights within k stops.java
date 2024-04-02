//O(n*k) Time & O(n) Space - where n is the number of edges
//Bellman-Ford Algo
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        //price from source to source is always 0
        prices[src] = 0;

        for(int i = 0; i < k + 1; i++) {
            int[] tempPrices = new int[n];
            tempPrices = Arrays.copyOf(prices, prices.length);
            for(int j = 0; j < flights.length; j++) {
                int source = flights[j][0]; //from
                int destination = flights[j][1]; //to
                int price = flights[j][2]; //price
                
                if(prices[source] == Integer.MAX_VALUE) continue;

                if(prices[source] + price < tempPrices[destination]) {
                    tempPrices[destination] = prices[source] + price;
                }
            }
            prices = tempPrices;
        }
        return prices[dst] != Integer.MAX_VALUE ? prices[dst] : -1;
    }
}