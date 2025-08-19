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
    int max_dep=0, ans=0;
    public int findBottomLeftValue(TreeNode root) {
        helper(root,1);
        return ans;
        
    }
    public void helper(TreeNode root, int lvl){
        if(root==null)  return;

        if(max_dep<lvl){
            ans=root.val;
            max_dep++;
        }
        helper(root.left,lvl+1);
        helper(root.right, lvl+1);
    }
}