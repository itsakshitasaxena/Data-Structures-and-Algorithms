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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans=new ArrayList<>(); //forest nodes list
        Set<Integer> set=new HashSet<>();
        for(int val:to_delete)   set.add(val);
        root=process(root, set, ans);
        if(root!=null)    ans.add(root); //check if root not null then add it (postporder )
        return ans;

    }
    public TreeNode process(TreeNode root,Set<Integer> set, List<TreeNode> ans){
        if(root==null)    return null;

        root.left=process(root.left, set, ans);
        root.right=process(root.right, set, ans);

        if(set.contains(root.val)){
            if(root.left!=null)    ans.add(root.left);
            if(root.right!=null)   ans.add(root.right);
            return null; //delete that node after adding its child that are not in set
        }
        return root;
    }
}