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
    int cam=0;
    public int minCameraCover(TreeNode root) {
        return count_cam(root)==-1? ++cam : cam;
    }
//need camera->-1
//has camera->1
//camera->0
    public int count_cam(TreeNode root){
        if(root==null)  return 0;

        int left=count_cam(root.left);
        int right=count_cam(root.right);
        if(left==-1 || right==-1){
            cam++;
            return 1;
        }
        if(left==1|| right==1)  return 0;
        else return -1;
    }
}