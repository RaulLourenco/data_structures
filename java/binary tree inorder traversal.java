O(N) Time - Iterative
O(N) Space

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null) {
            return result;
        }

        TreeNode current = root;

        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}

O(N) - Time - Recursively
O(N) - Space

class Solution {
    List<Integer> list;

    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
        return list;
    }

    public void inOrder(TreeNode root) {
        if(root == null) return;

        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}