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
    int cnt=0;
    public int countNodes(TreeNode root) {
        count(root);
        return cnt;
    }
    public void count(TreeNode root){
        if(root==null)  return ;
        cnt++;
        count(root.left);
        count(root.right);
        
    }
}