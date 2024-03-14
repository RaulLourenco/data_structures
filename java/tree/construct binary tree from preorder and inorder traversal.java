O(n) Time - using hashmap to store inorder index
O(n) Space - due to recursive calls

class Solution {
    Map<Integer, Integer> inorderPositions = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length < 1 || inorder.length < 1) return null;

        for(int i = 0; i < inorder.length; i++) {
            inorderPositions.put(inorder[i], i);
        }
        
        return builder(preorder, 0, 0, inorder.length - 1);
    }
    private TreeNode builder(int[] preorder, int preorderIndex, int inorderLeft, int inorderRight) {
        if(preorderIndex > preorder.length - 1 || inorderLeft > inorderRight) return null;

        int currentVal = preorder[preorderIndex];
        TreeNode node = new TreeNode(currentVal);
        int mid = inorderPositions.get(currentVal);

        node.left = builder(preorder, preorderIndex + 1, inorderLeft, mid - 1);
        //mid - inorderLeft -> size of left subtree
        node.right = builder(preorder, preorderIndex + (mid - inorderLeft) + 1, mid + 1, inorderRight);

        return node;
    }
}

O(n^2) Time - because of the search of each value of preorder in inorder array
O(n) Space - due to recursive calls

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;

        TreeNode node = new TreeNode(preorder[0]);
        int mid = 0;
        
        for(int i = 0; i < inorder.length; i++) {
           if(preorder[0] == inorder[i]) mid = i;
        }

        node.left = buildTree(
            Arrays.copyOfRange(preorder, 1, mid + 1), 
            Arrays.copyOfRange(inorder, 0, mid));
        node.right = buildTree(
            Arrays.copyOfRange(preorder, mid + 1, preorder.length), 
            Arrays.copyOfRange(inorder, mid + 1, inorder.length));
        
        return node;
    }
}