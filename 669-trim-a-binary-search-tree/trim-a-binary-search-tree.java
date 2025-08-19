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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        
        if(root==null)  return null;

        //if root value is less than low avoid left side and move to right subtree
        if(root.val<low){
            return trimBST(root.right,low,high);
        }

        //if root value is greater than high avoid right side and move to left subtree
        if(root.val>high){
            return trimBST(root.left,low,high);
        }

        //otheriwse-  root value is in range then  trim both sides
        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);

        return root;
    }
}