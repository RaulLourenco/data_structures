O(N) Time - recursive DFS POSTORDER (bottom-up)
O(h) Space - height of the tree for DFS algo

class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(left == 0 || right == 0) {
            return 1 + left + right;
        } else {
            return 1 + Math.min(left, right);
        }
    }
}

class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(root.left == null && root.right == null) return 1;
        if(root.left == null) return 1 + right;
        if(root.right == null) return 1 + left;

        return 1 + Math.min(left, right);
    }
}