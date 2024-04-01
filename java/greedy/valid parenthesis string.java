//O(n) Time & O(1) Space
class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                leftMin++;
                leftMax++;
            } else if(s.charAt(i) == ')') {
                leftMin--;
                leftMax--;
            } else { //wildcard char
                leftMin--;
                leftMax++;
            }
            if(leftMax < 0) return false;
            if(leftMin < 0) leftMin = 0;
        }
        return leftMin == 0;
    }
}

//O(n^2) Time & O(n) Space
//DP with Top-Down approach (Memoization)
class Solution {
    public boolean checkValidString(String s) {
        Map<String, Boolean> memo = new HashMap<>();
        return dfs(s, 0, 0, memo);
    }
    private boolean dfs(String s, int i, int left, Map<String, Boolean> memo) {
        if(i == s.length() || left < 0) {
            return left == 0;
        } 

        String key = i + "-" + left;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        if(s.charAt(i) == '(') {
            memo.put(key, dfs(s, i + 1, left + 1, memo));
        } else if(s.charAt(i) == ')') {
            memo.put(key, dfs(s, i + 1, left - 1, memo));
        } else {
            boolean wildcard = dfs(s, i + 1, left + 1, memo) ||
                               dfs(s, i + 1, left - 1, memo) ||
                               dfs(s, i + 1, left, memo);
            memo.put(key, wildcard);
        }
        return memo.get(key);
    }
}