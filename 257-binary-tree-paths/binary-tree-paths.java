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
    List<String> ans=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root,"");
        return ans;
    }
    public void helper(TreeNode root, String st){
        if(root==null)  return;

        if(root.left==null && root.right==null){
            ans.add(st+root.val);
            return;
        }

        helper(root.left, st+root.val+"->");
        helper(root.right,st+ root.val+"->");

    }
}