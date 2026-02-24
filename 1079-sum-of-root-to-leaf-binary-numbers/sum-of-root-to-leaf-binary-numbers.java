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
    public int sumRootToLeaf(TreeNode root) {
        return rootToleaf(root,0);
    }
    public int rootToleaf(TreeNode root, int sum){
        if(root==null)  return 0;
        sum=sum*2+root.val; // binary no. to int by *2
        if(root.left==null && root.right==null)
            return sum;
        int leftsum=rootToleaf(root.left,sum);
        int rightsum=rootToleaf(root.right,sum);
        return leftsum+rightsum;
    }
}