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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createtree(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1);
    }

    public TreeNode createtree(int[] in, int[]pre, int ilo, int ihi, int plo, int phi){
        if(ilo>ihi || plo>phi)   return null;

        TreeNode node= new TreeNode(pre[plo]);

        int idx=linear_search(in, ilo, ihi, pre[plo]);
        int c=idx-ilo; //to get count of node

        node.left= createtree(in,pre,ilo,idx-1,plo+1,plo+c);
        node.right=createtree(in,pre,idx+1,ihi,plo+c+1,phi);

        return node;

    }

    public int linear_search(int[] in, int ilo, int ihi, int item){
        for(int i=0;i<=ihi;i++){
            if(in[i]==item)     return i;
        }
        return 0;
    }
    
}



// preorder- root,left,right
//inorder-left,root,right