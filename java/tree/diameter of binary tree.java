/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

O(n) Time
O(n) Space

class Solution {
    int result = -1;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }
    private int dfs(TreeNode curr) {
        if(curr == null) return -1;

        int left = 1 + dfs(curr.left); //left height
        int right = 1 + dfs(curr.right); // right height
        result = Math.max(result, left + right); //diameter
        return Math.max(left, right); //max height between left and right
    }
}