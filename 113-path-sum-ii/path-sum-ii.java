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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> lst=new ArrayList<>();
        pathTargetSum(root, ans, lst, targetSum);
        return ans;
    }
    public void pathTargetSum(TreeNode root, List<List<Integer>> ans, List<Integer> lst, int targetSum) {

        if(root==null)    return;

        lst.add(root.val);
        if(root.left==null && root.right==null){
            if(targetSum-root.val==0){
                ans.add(new ArrayList<>(lst));
            }
        }
        else{
            pathTargetSum(root.left,  ans, lst, targetSum-root.val);
            pathTargetSum(root.right, ans, lst, targetSum-root.val);
        }
        lst.remove(lst.size()-1);
    }
}