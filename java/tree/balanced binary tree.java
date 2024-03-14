O(N) Time - DFS calcuting height for each current node
O(h) Space - height of the tree for DFS algo

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return height(root) != -1;      
    }
    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}

O(n) Time - bottom up approach
O(n) Space

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }
}