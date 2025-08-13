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
        
// int check = kthLargest(root.right, k); //if kth largest

        int check=kthSmallest(root.left,k);
        if(check>=0)   //if found greater than 0 is the smallest one
            return check; 
        pos++;

        if(pos==k)
            return root.val;
        //inorder tarversal is already sorted, so we used it
        return kthSmallest(root.right, k);

// return kthLargest(root.left, k); ///if kth largest

    }

//For smallest, Left → Root → Right 
// For largest,  Right → Root → Left(reverse of smallest)





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
