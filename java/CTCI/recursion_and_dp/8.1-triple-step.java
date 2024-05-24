//O(3^n) Time & Space - where n is the input number
//Brute Force
int countWays(int n) {
    if(n < 0) {
        return 0;
    } else if(n == 0) {
        return 1;
    } else {
        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }
}

//O(n) Time & Space
//Memoization
int countWays(int n) {
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    return countWays(n, memo);
}

int countWays(int n, int[] memo) {
    if(n < 0) {
        return 0;
    } else if(n == 0) {
        return 1;
    }

    if(memo[n] > -1) return memo[n];
    
    memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
    return memo[n];
}