//O(n) Time & Space - where n is the total number of nodes in the binary tree
public class Codec {
    int i = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDFS(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        return deserializeDFS(values);
    }

    private void serializeDFS(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("N").append(",");
            return;
        }
        sb.append(String.valueOf(root.val)).append(",");
        serializeDFS(root.left, sb);
        serializeDFS(root.right, sb);
    }

    private TreeNode deserializeDFS(String[] values) {
        if(values[this.i].equals("N")) {
            this.i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(values[this.i]));
        this.i++;
        node.left = deserializeDFS(values);
        node.right = deserializeDFS(values);
        return node;
    }
}


public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDFS(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        //passing an int array to persist the index value throughout the
        //recursive calls. That way, I'll have index value correct in
        //both left and right trees
        return deserializeDFS(new int[]{0}, values);
    }

    private void serializeDFS(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("N").append(",");
            return;
        }
        sb.append(String.valueOf(root.val)).append(",");
        serializeDFS(root.left, sb);
        serializeDFS(root.right, sb);
    }

    private TreeNode deserializeDFS(int[] index, String[] values) {
        String val = values[index[0]];
        if(val.equals("N")) {
            //incrementing my pointer
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        index[0]++;
        node.left = deserializeDFS(index, values);
        node.right = deserializeDFS(index, values);
        return node;
    }
}