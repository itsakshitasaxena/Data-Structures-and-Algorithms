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
    public int maxSumBST(TreeNode root) {
        return ValidBst(root).ans;
    }
    public Bstpair ValidBst(TreeNode root){
        if(root==null)   return new Bstpair();

        Bstpair lbp=ValidBst(root.left);
        Bstpair rbp=ValidBst(root.right);
        Bstpair sbp=new Bstpair();
        sbp.min=Math.min(lbp.min,(Math.min(rbp.min,root.val)));
        sbp.max=Math.max(lbp.max,(Math.max(rbp.max,root.val)));
        sbp.sum=lbp.sum+rbp.sum+root.val;
        sbp.isbst=lbp.isbst&&rbp.isbst&&lbp.max<root.val&&rbp.min>root.val;
        if(sbp.isbst){
            sbp.ans=Math.max(lbp.ans,Math.max(rbp.ans,sbp.sum));
        }
        else{
            sbp.ans=Math.max(lbp.ans,rbp.ans);
        }
        return sbp;
    }
    class Bstpair{
        long min=Long.MAX_VALUE;
        long max=Long.MIN_VALUE;
        int sum=0;
        int ans=0;
        boolean isbst=true;
    }
}