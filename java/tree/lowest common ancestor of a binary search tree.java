O(h) Time - where h is the height of BST - Iterative
O(1) Space

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       int left = Math.min(p.val, q.val); 
       int right = Math.max(p.val, q.val);

        while(root != null) {
                if(root.val > right) {
                    root = root.left;
                } else if(root.val < left) {
                    root = root.right;
                } else { //LCA - root == left == right
                    return root;
                }
        }
        return null;
    }
}

O(n) Time - Recursive
O(h) Space - where h is the height of BST

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
       } else if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
       } else {
            return root;
       }
    }
}