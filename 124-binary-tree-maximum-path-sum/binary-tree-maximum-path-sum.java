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
    int max_sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max_sum;
    }
    public int helper(TreeNode root){
        if(root==null)   return 0;

        int left=Math.max(0,helper(root.left));
        int right=Math.max(0,helper(root.right));

        max_sum=Math.max(max_sum,root.val+left+right);

        return root.val+Math.max(left,right);
    }
}