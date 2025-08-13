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
    int camera=0;

    public int minCameraCover(TreeNode root) {
        int cnt=minCamera(root);
        if(cnt==-1)  camera++;

        return camera;
    }

    public int minCamera(TreeNode root){
        if(root==null)   return 0;

        int left=minCamera(root.left);
        int right=minCamera(root.right);

        if(left==-1||right==-1)
        { //this node needs a camera
            camera++;
            return 1; //camera set kra iss node pr 
        }

// inme s 
        else if(left==1||right==1){
            return 0; //covered node
        }
        else{
            return -1; //need a camera
        }
    }
}


//need camera->-1
//has camera->1
//camera->0