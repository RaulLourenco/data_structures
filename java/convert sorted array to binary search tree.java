O(N) Time - Recursive
O(log N) Space - the height of the tree

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(0, nums.length - 1, nums);
    }
    private TreeNode buildTree(int left, int right, int[] nums) {
        if(left > right) {
            return null;
        }
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(left, mid - 1, nums);
        root.right = buildTree(mid + 1, right, nums);
        return root;
    }
}