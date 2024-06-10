//O(log(n)) Time in a balanced binary tree ~ O(D) -> where D is the max depth of the tree
class Tree {
    TreeNode root = null;

    public int size() { return root == null ? 0 : root.size(); }

    public TreeNode getRandomNode() {
        if(root == null) return null;

        Random r = new Random();
        int i = r.nextInt(size());
        return root.getIthNode(i);
    }

    public void insertInOrder(int value) {
        if(root == null) {
            root = new TreeNode(value);
        } else {
            root.insertInOrder(value);
        }
    }
}

class TreeNode {
    private int data;
    public TreeNode left;
    public TreeNode right;
    private int size = 0;

    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    public TreeNode getIthNode(int i) {
        int leftSize = (left == null) ? 0 : left.size();
        if(i < leftSize) {
            return left.getIthNode(i);
        } else if(i == leftSize) {
            return this;
        } else {
            return right.getIthNode(i - (leftSize + 1));
        }
    }

    public void insertInOrder(int d) {
        if(d <= data) {
            if(left == null) {
                left = new TreeNode(d);
            } else {
                left.insertInOrder(d);
            }
        } else {
            if(right == null) {
                right = new TreeNode(d);
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public TreeNode find(int d) {
        if(d == data) {
            return this;
        } else if(d <= data) {
            return left != null ? left.find(d) : null;
        } else if(d > data) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }
}