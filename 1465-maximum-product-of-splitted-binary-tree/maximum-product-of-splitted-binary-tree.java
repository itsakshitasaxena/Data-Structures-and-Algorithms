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
    long maxpro, total;
    int mod=1_000_000_007;
    public int maxProduct(TreeNode root) {
        total=sum(root);
        calcpro(root);
        return (int)(maxpro%mod);
    }
    public long calcpro(TreeNode root){
        if(root==null)  return 0;
        long left=calcpro(root.left);
        long right=calcpro(root.right);
        long node_sum=root.val+left+right;
        maxpro=Math.max(maxpro, node_sum*(total-node_sum));
        return node_sum;
    }

    public int sum(TreeNode root){
        if(root==null)  return 0;
        return root.val+sum(root.left)+sum(root.right);
    }
}