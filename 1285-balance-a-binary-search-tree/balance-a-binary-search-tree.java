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
    List<Integer> lst;
    public TreeNode balanceBST(TreeNode root) {
         lst=new ArrayList<>();
         inorder(root);
         return balance_bst(root,0,lst.size()-1);
    }
    public TreeNode balance_bst(TreeNode root,int l, int r){
        if(l>r)  return null;
        int mid=(l+r)/2;
        TreeNode ans=new TreeNode(lst.get(mid));
        ans.left=balance_bst(root,l,mid-1);
        ans.right=balance_bst(root,mid+1,r);
        return ans;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        lst.add(root.val);
        inorder(root.right);
    }
}