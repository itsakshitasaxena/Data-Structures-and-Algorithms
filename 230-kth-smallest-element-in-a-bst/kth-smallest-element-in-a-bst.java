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
    int pos=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        
        int min=kthSmallest(root.left,k);
        if(min>=0)   //if found greater than 0 is the smallest one
            return min; 
        pos++;

        if(pos==k)
            return root.val;
        //inorder tarversal is already sorted, so we used it
        return kthSmallest(root.right, k);
    }



    //     List<Integer> lst=new ArrayList<>();
    //     inorder(lst, root, k);
    //     return lst.get(k-1);
    // }

    // public void inorder(List<Integer> lst, TreeNode root, int k){
    //     if(root==null)  return;

    //     inorder(lst, root.left,k);
    //     lst.add(root.val);
    //     inorder(lst,root.right,k);
    // }
}
