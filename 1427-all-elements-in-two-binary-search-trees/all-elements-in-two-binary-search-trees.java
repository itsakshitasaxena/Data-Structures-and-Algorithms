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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ll=new ArrayList<>();
        // List<Integer> l2=new ArrayList<>();
        inorder(root1, ll);
        inorder(root2, ll);
        Collections.sort(ll);
        return ll;

    }
    public void inorder(TreeNode root, List<Integer> ll){
        if(root==null)   return;

        ll.add(root.val);
        inorder(root.left,ll);
        inorder(root.right,ll);

    }
}