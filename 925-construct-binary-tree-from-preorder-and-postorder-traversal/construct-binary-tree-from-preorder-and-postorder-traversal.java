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
    int preind=0, postind=0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return bintree(preorder, postorder);
    }
    public TreeNode bintree(int[] pre, int[]post){
        TreeNode root=new TreeNode(pre[preind++]);
        if(root.val!=post[postind]){
            root.left=bintree(pre,post);
        }
        if(root.val!=post[postind]){
            root.right=bintree(pre,post);
        }
        postind++;
        return root;
    }
}