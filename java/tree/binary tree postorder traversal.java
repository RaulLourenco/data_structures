O(n) Time -> Recursively
O(n) Space -> recursive stack memory

class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return result;
    }
    private void postOrder(TreeNode root) {
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        result.add(root.val);
    }
}

O(n) Time -> Iterative
O(height) Space -> if its balanced O(logN) if it isnt O(n)

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode last = null;

        while(root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.peek();
                if(node.right != null && last != node.right) {
                    root = node.right;
                } else {
                    result.add(node.val);
                    last = node;
                    stack.pop();
                }
            }
        }
        return result;
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        if(root == null) return result;

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if(curr.left != null) stack.push(curr.left);
            if(curr.right != null) stack.push(curr.right);
        }
        Collections.reverse(result);
        return result;
    }
}