O(n) Time
O(h) Space

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, -10000);
    }
    private int dfs(TreeNode root, int max) {
        if(root == null) return 0;

        int result = root.val >= max ? 1 : 0; //root.val >= max -> good node

        result += dfs(root.left, Math.max(root.val, max));
        result += dfs(root.right, Math.max(root.val, max));

        return result; 
    }
}