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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        // TreeNode root=new TreeNode(preorder[0]);
        return constructBT(preorder,Integer.MAX_VALUE);
    }
    public TreeNode constructBT(int[] preorder,int bound){
        
        if(i==preorder.length || preorder[i] >bound)     return null;       

        TreeNode node=new TreeNode(preorder[i++]);
        
        node.left=constructBT(preorder,node.val);
        //for left, node is value of that node(all leftie less than node val)
        node.right=constructBT(preorder,bound);
        //for right, max value is bound as all rightie greater than nodeval
        return node;
    }
}