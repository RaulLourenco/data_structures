O(P + Q) Time
O(h) Space - height of the tree (DFS algo)

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        } else if(p == null || q == null || p.val != q.val) {
            return false;
        }

        return (isSameTree(p.left, q.left) && 
        isSameTree(p.right, q.right));
    }
}

O(P + Q) Time
O(h) Space

class Solution {
    Stack<Integer> stack;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        stack = new Stack<>();
        traversal(p, q);
        return stack.isEmpty();
    }
    public void traversal(TreeNode p, TreeNode q) {
        if(p == null && q != null) {
            stack.push(1);
            return;
        } else if(p != null && q == null) {
            stack.push(3);
            return;
        } else if(p == null && q == null) {
            return;
        }

        traversal(p.left, q.left);
        if(p.val != q.val) {
            stack.push(2);
            return;
        }
        traversal(p.right, q.right);
    }
}

class Solution {
    Stack<Integer> stack;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        stack = new Stack<>();
        traversal(p, q);
        return stack.isEmpty();
    }
    private void traversal(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return;
        }
        if(p == null || q == null || p.val != q.val) {
            stack.push(1);
            return;
        }
        traversal(p.left, q.left);
        traversal(p.right, q.right);
    }
}