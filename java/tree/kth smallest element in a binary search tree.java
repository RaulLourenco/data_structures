O(n) Time - Recursive DFS
O(n) Space

class Solution {
    List<Integer> result = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return result.get(k - 1);
    }
    private void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }
}

O(n) Time - Iterative in-order traversal with a list
O(n) Space

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result.get(k-1);
    }
}

O(n) Time - Iterative in-order traversal with a counter
O(n) Space

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;

        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            count++;
            if(count == k) return curr.val;
            curr = curr.right;
        }
        return count;
    }
}