//O(n) Time & Space
//Recursive
void createLevelLinkedList(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<>>();
    createLevelLinkedList(root, lists, 0);
    return lists;
}

void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
    if(root == null) return;

    LinkedList list = null;
    if(lists.size() == level) {
        list = new LinkedList<>();
        lists.add(list);
    } else {
        list = lists.get(level);
        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }
}

//O(n) Time & Space
//Iterative
ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<>>();
    LinkedList<TreeNode> current = new LinkedList<>();
    
    if(root != null) {
        current.add(root);
    }

    while(current.size() > 0) {
        result.add(current);
        LinkedList<TreeNode> parents = current;
        current = new LinkedList<>();
        for(TreeNode parent : parents) {
            if(parent.left != null) {
                current.add(parent.left);
            }
            if(parent.right != null) {
                current.add(parent.right);
            }
        }
    }
    return result;
}