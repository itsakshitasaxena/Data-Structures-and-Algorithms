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
    public void flatten(TreeNode root) {
        makeLL(root);
    }
    public TreeNode makeLL(TreeNode root){
        if(root==null)    return null;

        if(root.left==null && root.right==null)  //for single node-no child
            return root;

        TreeNode left_tail=makeLL(root.left);
        TreeNode right_tail=makeLL(root.right);

        if(root.left!=null){
            left_tail.right=root.right;
            root.right=root.left;
            root.left=null;
        }

        return right_tail!=null?right_tail:left_tail;
    }
}
