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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)  return 0;
        int paths=count_path(root,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
        return paths;
    }
    public int count_path(TreeNode root, long targetSum){
        if(root==null)  return 0;
        int cnt=0;
        if(root.val==targetSum)   cnt++;
        cnt+=count_path(root.left,targetSum-root.val);
        cnt+=count_path(root.right,targetSum-root.val);
        return cnt;
    }
}