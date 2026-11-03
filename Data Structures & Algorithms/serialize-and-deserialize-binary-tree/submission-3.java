/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

   // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> arr = new ArrayList<>();
        dfsSerialize(root, arr);
        return String.join(",", arr);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] ind = {0};
        String[] strArr = data.split(",");
        return dfsDeserialize(strArr, ind);
    }

    public void dfsSerialize(TreeNode node, ArrayList<String> arr){
        if(node == null){
            arr.add("N");
            return;
        }
        arr.add(node.val+"");
        dfsSerialize(node.left, arr);
        dfsSerialize(node.right, arr);
    }

    public TreeNode dfsDeserialize(String[] strArr, int[] ind){
        if("N".equals(strArr[ind[0]])){
            ind[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strArr[ind[0]]));
        ind[0]++;
        node.left = dfsDeserialize(strArr, ind);
        node.right = dfsDeserialize(strArr, ind);
        return node;
    }
}
