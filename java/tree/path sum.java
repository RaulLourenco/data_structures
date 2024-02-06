O(N) Time
Space complexity for a recursive call stack
O(h) - overall
O(N) - worst case
O(logN) -  in a balanced tree

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode root, int result, int targetSum) {
        if(root == null) return false;
        
        result += root.val;

        if(root.left == null && root.right == null) return result == targetSum;
        
        return dfs(root.left, result, targetSum) 
            || dfs(root.right, result, targetSum);
    }
}