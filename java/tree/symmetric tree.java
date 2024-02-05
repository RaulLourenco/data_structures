O(N) Time - number of nodes
O(h) Space - height of the tree (DFS algo)

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }
    private boolean dfs(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        
        return (left.val == right.val && 
        dfs(left.left, right.right) && 
        dfs(left.right, right.left));
    }
}