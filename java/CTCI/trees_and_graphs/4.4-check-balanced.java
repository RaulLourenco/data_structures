//O(n) Time & O(height) Space
boolean isBalanced(TreeNode root) {
    return checkHeight(root) != Integer.MIN_VALUE;
}

int checkHeight(TreeNode root) {
    if(root == null) return -1;

    int leftHeight = checkHeight(root.left);
    if(leftHeight == Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
    }

    int rightHeight = checkHeight(root.right);
    if(rightHeight == Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
    }

    int heightDiff = leftHeight - rightHeight;
    if(Math.abs(heightDiff) > 1) {
        return Integer.MIN_VALUE;
    } else {
        return Math.max(leftHeight, rightHeight) + 1;
    }
}