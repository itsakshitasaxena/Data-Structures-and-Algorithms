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
    TreeNode ans=null; int maxdepth=0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        deepest(root,0);
        return ans;
    }
    public int deepest(TreeNode root, int dep){
        if(root==null){
            maxdepth=Math.max(dep,maxdepth);
            return dep;
        }
        
        int left=deepest(root.left,dep+1);
        int right=deepest(root.right,dep+1);

        if(left==maxdepth&&right==maxdepth)  ans=root;
        return Math.max(left,right);
    }
}