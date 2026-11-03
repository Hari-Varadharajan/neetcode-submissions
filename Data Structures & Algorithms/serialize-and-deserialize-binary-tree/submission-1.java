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

    int ind;
    ArrayList<String> arr = new ArrayList<>();
    String[] strArr;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ind = 0;
        dfsSerialize(root);
        return String.join(",", arr);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        strArr = data.split(",");
        return dfsDeserialize(strArr[ind]);
    }

    public void dfsSerialize(TreeNode node){
        if(node == null){
            arr.add("N");
            return;
        }
        arr.add(node.val+"");
        dfsSerialize(node.left);
        dfsSerialize(node.right);
    }

    public TreeNode dfsDeserialize(String str){
        if("N".equals(str)){
            ind++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strArr[ind]));
        ind++;
        node.left = dfsDeserialize(strArr[ind]);
        node.right = dfsDeserialize(strArr[ind]);
        return node;
    }
}
