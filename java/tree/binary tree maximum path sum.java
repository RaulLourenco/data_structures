//O(n) Time & O(height) Space - where n is the number of nodes in the tree
class Solution {
    int result;
    public int maxPathSum(TreeNode root) {
        result = root.val;
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;

        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));

        result = Math.max(result, root.val + leftMax + rightMax);

        return root.val + Math.max(leftMax, rightMax);
    }
}