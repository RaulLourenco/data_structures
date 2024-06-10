//O(n) Time & O(log(n)) Space
TreeNode createMinBST(int[] array) {
    return createMinBST(array, 0, array.length - 1);
}

TreeNode createMinBST(int[] array, int start, int end) {
    if(end < start) return null;
    
    int mid = (start + end) / 2;
    TreeNode n = new TreeNode(array[mid]);
    n.left = createMinBST(array, start, mid - 1);
    n.right = createMinBST(array, mid + 1, end);
    return n;
}