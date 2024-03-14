O(n) Time - BFS
O(n) Space

class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return result;
        bfs(root);
        return result;
    }

    private void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int level = queue.size();
            for(int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if(i == 0) {
                    result.add(node.val);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
    }
}

O(n) Time - DFS
O(h) Space

class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return result;
        dfs(root, 1); //start root as level 1
        return result;
    }

    private void dfs(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if(result.size() < level) { //level should be greater than list size
            result.add(root.val);
        }

        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}

class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return result;
        dfs(root, 0); //start root as level 0
        return result;
    }

    private void dfs(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if(result.size() == level) { //level should be equal than list size
            result.add(root.val);
        }

        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}