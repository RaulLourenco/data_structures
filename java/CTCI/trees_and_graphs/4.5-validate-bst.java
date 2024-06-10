//O(n) Time & O(log(n)) Space
boolean checkBST(TreeNode n) {
    return checkBST(n, null, null);
}

boolean checkBST(TreeNode n, int min, int max) {
    if(n == null) return true;

    if(min != null && n.data <= min || max != null && n.data > max) {
        return false;
    }

    return checkBST(n.left, min, n.data) && checkBST(n.right, n.data, max);
}