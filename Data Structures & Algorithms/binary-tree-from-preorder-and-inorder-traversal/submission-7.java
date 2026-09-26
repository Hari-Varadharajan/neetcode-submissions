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

class Solution {
    int[] gPreorder;
     int[] gInorder;
     int track = 0;
     HashMap<Integer, Integer> map = new HashMap<>();
    public  TreeNode buildTree(int[] preorder, int[] inorder) {
        gPreorder = preorder;
        gInorder = inorder;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTreeHelper(0, inorder.length-1);
    }

    public  TreeNode buildTreeHelper(int l, int r){
        if(l == r){
            track++;
            return new TreeNode(gInorder[l]);
        }
        else if(l >= r || track >= gPreorder.length) return null;
        TreeNode root = new TreeNode(gPreorder[track++]);
        root.left = buildTreeHelper(l, map.get(root.val) - 1);
        root.right = buildTreeHelper(map.get(root.val) + 1, r);;
        return root;
    }
}
