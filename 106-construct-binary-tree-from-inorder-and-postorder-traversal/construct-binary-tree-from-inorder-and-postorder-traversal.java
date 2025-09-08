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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return construct(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    public static TreeNode construct(int[] in, int[] post, int ilo, int ihi, int postlo, int posthi){
        if(ilo> ihi || postlo> posthi)   return null;
        TreeNode node=new TreeNode(post[posthi]);

        int idx=linear_search(in, ilo, ihi, post[posthi]);
        int c=idx-ilo;

        node.right=construct(in, post, idx+1, ihi, postlo+c, posthi-1);
        node.left=construct(in, post, ilo, idx-1, postlo, postlo+c-1);

        return node;
    }

    public static int linear_search(int[] in, int ilo, int ihi, int item){
        for(int i=0; i<=ihi;i++){
            if(in[i]==item)
                return i;
        }
        return 0;
    }
}